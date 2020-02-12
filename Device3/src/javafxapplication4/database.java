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
import java.sql.* ;
import java.util.ArrayList;


public class database {
    String queryString;
    ResultSet rs;
    Connection con;
    PreparedStatement stmt;
    public database()
    {
        try
        {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            con = DriverManager.getConnection("jdbc:sqlite:TicTacToe.db");
//            stmt = con.createStatement();

//            createDatabase();
//            getAll();
            System.out.println("\t*******************************");
            //=============CLOSE==============
//            terminateConn();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    void createDatabase()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Game ("+
                               "game_id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
                               "playerName1	TEXT NOT NULL,"+
                               "playerName2	TEXT NOT NULL,"+
                               "winner	INTEGER DEFAULT null);"+
                
                       "CREATE TABLE IF NOT EXISTS Move ("+
                               "game_id	INTEGER NOT NULL,"+
                               "position	INTEGER NOT NULL,"+
                               "FOREIGN KEY(game_id) REFERENCES game(game_id));";
                
       try 
       {
           stmt = con.prepareStatement(sql);
           stmt.executeUpdate();
       } 
       catch (SQLException ex) 
       {
           ex.printStackTrace();
       }
    }
    public ArrayList<Integer> getAll() throws SQLException
    {
        ArrayList<Integer> moves = new ArrayList();
        String sql = new String("select * from Move where game_id=34;");
        Statement stmt0 = con.createStatement();
//        stmt.setInt(1, getGameId()-1);
        rs = stmt0.executeQuery(sql);
        System.out.println("1- get data from database");
        while(rs.next())
        {
            moves.add(rs.getInt("position"));
        }
        System.out.println("2- get data from database");
        moves.forEach((n) -> System.out.println(n)); 
        rs.close();
        return moves;
    }
    
    public void insertGame(String name1, String name2) throws SQLException
    {
        String sql = "INSERT INTO Game (playerName1, playerName2) VALUES (?, ?);"; 
        stmt = con.prepareStatement(sql);
//        stmt.setInt(1, getGameId());
        stmt.setString(1, name1);
        stmt.setString(2, name2);
        stmt.executeUpdate();
    }
    
    public void insertMove(int pos) throws SQLException
    {
//        int gameNum = getGameId();
        String sql = "INSERT INTO Move (position, game_id) VALUES ("+pos+", (select MAX(game_id) from Game));)"; 
        try (Statement stmt0 = con.createStatement()) {
            int x = (getGameId()-1);
//        System.out.println("x= "+x);
//        System.out.println("pos= "+pos);
//        stmt.setInt(1, x);
//        stmt.setInt(1, 3);
//        stmt.executeUpdate();
stmt0.executeUpdate(sql);
        }

    }
    
    public int getGameId() throws SQLException
    {
        String sql = "select max(game_id) from Game;";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        int gameNum;
        gameNum = rs.getInt("max(game_id)");
        System.out.println(gameNum);
        rs.close();
        return gameNum+1;
    }
    
    void terminateConn()
    {
        try {
            stmt.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
//    public void gotoRecord(int row) throws SQLException
//    {
//        getAll();
//        for(int i=0; i<row; i++)
//        {
//            rs.next();
//        }
//    }

}
