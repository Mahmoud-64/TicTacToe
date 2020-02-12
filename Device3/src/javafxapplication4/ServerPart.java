package javafxapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hagar
 */
import java.net.*;
import java.io.*;

public class ServerPart implements Runnable
{
    ServerSocket server;
    BufferedReader input;
    PrintStream output;
    Socket s;
    Thread th;
    boolean connected = false;
    String read;
    gameLogic game;
    String fName="-";
    String sName="-";
    private volatile boolean sExit = false;
//        database db;
//        String fName, sName;

    public ServerPart()
    {
        try
        {
            server = new ServerSocket(5005);
            th = new Thread(this);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
//                boolean flag;
            do
            {
                s = server.accept();
                connected = ClientPlayer(s);
                game = new gameLogic();
            }
            while(connected!=true);
//                db = new database();
            th.start();
        }
        catch(IOException e)
        {
                e.printStackTrace();
        }
    }


    public boolean ClientPlayer(Socket sc)
    {
        try
        {
            input = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            output = new PrintStream(sc.getOutputStream());

            String start = readClient();
            if("Ready".equals(start))
            {
                output.println("Ready");
                System.out.println("Connection Started");
                return true;
            }
            else
            {
                input.close();
                output.close();
                sc.close();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }



    public String readClient()
    {
        String str = null;
        try
        {
            str = input.readLine();
        }catch(IOException e){
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
//          Read Other Opponent Name
            read = readClient();
            if(read==null)
            {
//          Close Connection If The Client Closed Before Entering The Other Opponent Name
                break;
            }
        }while(!read.substring(0, 6).equals("Name2:"));
        
//        If Reading Opponent's Name Done Successfully
        if(read!=null)
        {
            sName = read.substring(6);
            System.out.println("Name= "+sName);
            OnlineMultiplayerGameplayPane.textField1.setText(sName);
            read="";
//            read = readClient();

            while(!sExit)
            {
//                Read Other Opponent Move
                read = readClient();
//                If Connection Closed During Playing
                if(read!=null)
                {
                    if(read.equals("try again"))
                    {
                        OnlineMultiplayerGameplayPane.freeCells();
                        game = new gameLogic();
                    }
//                    Check Moves of The Opponent
                    else if(game.currentPlayerMark=='o')
                    {
                        boolean flag = game.updateGame(Integer.parseInt(read));
                        if(flag==true)
                        {
                            writeClient("true");
//                            Update Pane of The Game After Opponent's Play
                            OnlineMultiplayerGameplayPane.updateButton(read);
                            
                            if(game.winner!='-')
                            {
                                AppManager.viewPane(AppManager.looser);     //looser
                                System.out.println(game.winner+" wins");
                                writeClient(game.winner+" wins");
                            }
                        }
                        else
                        {
                            writeClient("false");
                            writeClient("client");
                        }
                    }
                }
                else
                {
                    break;
                }
            }
        }
        System.out.println("The Other Opponent Closed");
        terminateConn();
    }

    public void writeClient(String str)
    {
        output.println(str);
    }
    
    public void stopServer()
    {
        sExit = true;
    }

    public void terminateConn()
    {
        try {
            output.close();
            input.close();
            s.close();
            server.close();
            System.out.println("Connection Terminated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}