package javafxapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author hagar
 */
public final class ClientPart implements Runnable
{
    Socket client;
    BufferedReader input;
    PrintStream output;
    Thread th;
    boolean connected = false;
    String read;
    String fName="-";
    String sName="-";
//    database db;
    private volatile boolean cExit = false;
        
    public ClientPart()
    {
        try
        {
            /*client = new Socket(InetAddress.getLocalHost(), 5005);
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new PrintStream(client.getOutputStream());*/
            th = new Thread(this);
	    client = searchForServer();
            System.out.println("Connection Started");
            th.start();
        }
        catch(IOException e)
        {
            System.out.println("server is down!!");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Socket searchForServer() throws IOException
    {
        
        byte[] ip = null;
        try
        {
            ip = InetAddress.getLocalHost().getAddress();
		System.out.println("My IP: "+ InetAddress.getByAddress(ip));
        } 
	catch (Exception e) 
	{
            e.printStackTrace();
        }
    
        for(int i=1;i<=254;i++) 
        {
            final int j = i;  // i as non-final variable cannot be referenced from inner class
                    try 
                    {
                        ip[3] = (byte)j;
                        InetAddress address = InetAddress.getByAddress(ip);
                        String str = address.toString().substring(1);
                        String start;
                        if (address.isReachable(100)) 
                        {
                            System.out.println(str + " is on the network");
                            client = new Socket(address, 5005);
                            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            output = new PrintStream(client.getOutputStream());
                            output.println("Ready");
                            start = readServer();
                            if("Ready".equals(start))
                            {
                                connected = true;
                                return client;
                            }
                            else
                            {
                                input.close();
                                output.close();
                                client.close();
                            }
                        }
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Not The One");
//                        e.printStackTrace();
                    }
        }
	return null;
        
    }
    
    public String readServer()
    {
        String str = null;
        try
        {
                str = input.readLine();
        }
        catch(IOException e)
        {
//                e.printStackTrace();
            System.out.println("The Other Closed");
        }
        return str;
    }
    
    @Override
    public void run()
    {
        do
        {
//            Read Other Opponent Name
            read = readServer();
            if(read==null)
            {
//            Close Connection If The Server Closed Before Entering The Other Opponent Name
                break;
            }
        }while(!read.substring(0, 6).equals("Name1:"));
        
//        If Reading Opponent's Name Done Successfully
        if(read!=null)
        {
            fName = read.substring(6);
            System.out.println("Name= "+fName);
            OnlineMultiplayerGameplayPane.textField.setText(fName);
            read="";

            while(!cExit)
            {
//                Read Other Opponent Move
                read = readServer();
//                If Connection Closed During Playing
                if(read==null)
                {
                    break;
                }
                if(Pattern.matches("[xo] wins",read))
                {
                    System.out.println(CreateORJoinGame.cl.read);
                    if(Pattern.matches("o wins",read))
                        AppManager.viewPane(AppManager.winner);     //winner
                    else
                        AppManager.viewPane(AppManager.looser);     //looser
                }
                else if(read.equals("try again"))
                {
                    OnlineMultiplayerGameplayPane.freeCells();
                }
                else
                {
//                Update Pane of The Game After Opponent's Play
                    OnlineMultiplayerGameplayPane.updateButton(read);
                }
                
            }
        }
        System.out.println("The Other Opponent Closed");
        terminateConn();
    }
    
    public void writeServer(String str)
    {
        output.println(str);
    }

    public void stopClient()
    {
        cExit = true;
    }
        
    public void terminateConn()
    {
        try {
            output.close();
            input.close();
            client.close();
            System.out.println("Connection Terminated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
