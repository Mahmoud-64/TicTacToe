package javafxapplication4;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public  class OnlineMultiplayerGameplayPane extends Pane {

    protected final ImageView imageView;
    protected final Button mainMenu;
    protected final Button tryAgain;
    protected final Label label;
    protected static TextField textField;
    protected final Label label0;
    protected final TextField textField0;
    protected final Label label1;
    protected static TextField textField1;
    protected final Label label2;
    protected final TextField textField2;
    protected static Button b0;
    protected static Button b1;
    protected static Button b2;
    protected static Button b3;
    protected static Button b4;
    protected static Button b5;
    protected static Button b6;
    protected static Button b7;
    protected static Button b8;
    
    protected static Button[] allButtons = new Button[9];
    ArrayList<Integer> allMoves = new ArrayList();

    public OnlineMultiplayerGameplayPane() {

        imageView = new ImageView();
        mainMenu = new Button();
        tryAgain = new Button();
        label = new Label();
        textField = new TextField();
        label0 = new Label();
        textField0 = new TextField();
        label1 = new Label();
        textField1 = new TextField();
        label2 = new Label();
        textField2 = new TextField();
        b0 = new Button();
        b1 = new Button();
        b2 = new Button();
        b3 = new Button();
        b4 = new Button();
        b5 = new Button();
        b6 = new Button();
        b7 = new Button();
        b8 = new Button();
        
        allButtons[0]=b0;
        allButtons[1]=b1;
        allButtons[2]=b2;
        allButtons[3]=b3;
        allButtons[4]=b4;
        allButtons[5]=b5;
        allButtons[6]=b6;
        allButtons[7]=b7;
        allButtons[8]=b8;

        setMaxHeight(1000.0);
        setMaxWidth(1000.0);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(567.0);
        setPrefWidth(626.0);

        imageView.setFitHeight(356.0);
        imageView.setFitWidth(500.0);
        imageView.setLayoutX(110.0);
        imageView.setLayoutY(60.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("board.jpg").toExternalForm()));
          setStyle("-fx-background-color: WHITE;");
          
        mainMenu.setLayoutX(29.0);
        mainMenu.setLayoutY(14.0);
        mainMenu.setMnemonicParsing(false);
        mainMenu.setPrefHeight(34.0);
        mainMenu.setPrefWidth(111.0);
        mainMenu.setText("Main Menu");
        mainMenu.getStyleClass().add("Button-Class");

        tryAgain.setLayoutX(305.0);
        tryAgain.setLayoutY(14.0);
        tryAgain.setMnemonicParsing(false);
        tryAgain.setPrefHeight(34.0);
        tryAgain.setPrefWidth(111.0);
        tryAgain.setText("Try Again");
        tryAgain.getStyleClass().add("Button-Class");

        label.setLayoutX(20.0);
        label.setLayoutY(417.0);
        label.setPrefHeight(27.0);
        label.setPrefWidth(64.0);
        label.setText("Player1:");
        label.setFont(new Font(14.0));

        textField.setLayoutX(84.0);
        textField.setLayoutY(418.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(100.0);
        textField.setCursor(Cursor.DEFAULT);

        label0.setLayoutX(20.0);
        label0.setLayoutY(448.0);
        label0.setPrefHeight(27.0);
        label0.setPrefWidth(64.0);
        label0.setText("Score:");
        label0.setFont(new Font("System Bold", 14.0));

        textField0.setLayoutX(84.0);
        textField0.setLayoutY(449.0);
        textField0.setPrefHeight(25.0);
        textField0.setPrefWidth(37.0);
        textField0.setCursor(Cursor.DEFAULT);

        label1.setLayoutX(279.0);
        label1.setLayoutY(420.0);
        label1.setPrefHeight(27.0);
        label1.setPrefWidth(64.0);
        label1.setText("Player2:");
        label1.setFont(new Font(14.0));

        textField1.setLayoutX(343.0);
        textField1.setLayoutY(421.0);
        textField1.setPrefHeight(25.0);
        textField1.setPrefWidth(100.0);
        textField1.setCursor(Cursor.DEFAULT);

        label2.setLayoutX(279.0);
        label2.setLayoutY(451.0);
        label2.setPrefHeight(27.0);
        label2.setPrefWidth(64.0);
        label2.setText("Score:");
        label2.setFont(new Font("System Bold", 14.0));

        textField2.setLayoutX(343.0);
        textField2.setLayoutY(452.0);
        textField2.setPrefHeight(25.0);
        textField2.setPrefWidth(37.0);
        textField2.setCursor(Cursor.DEFAULT);
        
        b0.setLayoutX(122.0);
        b0.setLayoutY(145.0);

        b1.setLayoutX(205.0);
        b1.setLayoutY(145.0);

        b2.setLayoutX(285.0);
        b2.setLayoutY(145.0);

        b3.setLayoutX(122.0);
        b3.setLayoutY(230.0);

        b4.setLayoutX(205.0);
        b4.setLayoutY(230.0);

        b5.setLayoutX(285.0);
        b5.setLayoutY(230.0);

        b6.setLayoutX(122.0);
        b6.setLayoutY(315.0);

        b7.setLayoutX(205.0);
        b7.setLayoutY(315.0);

        b8.setLayoutX(285.0);
        b8.setLayoutY(315.0);
        
        for(int i=0; i<9; i++)
        {
            allButtons[i].setMnemonicParsing(false);
            allButtons[i].setPrefHeight(64.0);
            allButtons[i].setPrefWidth(64.0);
            allButtons[i].getStyleClass().add("freeCell-Class");
        }

        textField.setDisable(true);
        textField1.setDisable(true);
        tryAgain.setDisable(true);
        
        getChildren().add(imageView);
        getChildren().add(mainMenu);
        getChildren().add(tryAgain);
        getChildren().add(label);
        getChildren().add(textField);
        //getChildren().add(label0);
        //getChildren().add(textField0);
        getChildren().add(label1);
        getChildren().add(textField1);
        //getChildren().add(label2);
        //getChildren().add(textField2);
        for(int i=0; i<9; i++)
        {
            getChildren().add(allButtons[i]);
        }
        
//        Set Action of All Buttons
        for(int i=0; i<9; i++)
        {
            int j = i;
            allButtons[i].setOnAction((Action) -> {
                affectButton(j);
            });
        }
        
        mainMenu.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.startMenu);
            freeCells();
            if(CreateORJoinGame.cl!=null)
            {
                CreateORJoinGame.cl.stopClient();
                CreateORJoinGame.cl.terminateConn();
                CreateORJoinGame.cl= null;
            }
            else if(CreateORJoinGame.serv!=null)
            {
                CreateORJoinGame.serv.stopServer();
                CreateORJoinGame.serv.terminateConn();
                CreateORJoinGame.serv= null;
            }
            OnlineMultiplayerGameplayPane.textField.setText("");
            OnlineMultiplayerGameplayPane.textField1.setText("");
        });
        
        tryAgain.setOnAction((Action) -> {
            freeCells();
            if(CreateORJoinGame.cl != null)
            {
                CreateORJoinGame.cl.writeServer("try again");
            }
            else if(CreateORJoinGame.serv != null)
            {
                CreateORJoinGame.serv.writeClient("try again");
                CreateORJoinGame.serv.game = new gameLogic();
            }
        });

    }
    
    static void freeCells()
    {
        for(int i=0; i<9; i++)
        {
            allButtons[i].getStyleClass().add("freeCell-Class");
            allButtons[i].getStyleClass().remove("o-Class");
            allButtons[i].getStyleClass().remove("x-Class");
        }
    }
    
    void affectButton(int pos)
    {
        if(CreateORJoinGame.cl!=null)
        {
            if(CreateORJoinGame.cl.read!=null)
            {
                if(CreateORJoinGame.cl.read.equals("client"))
                {
                    CreateORJoinGame.cl.read="none";
//                    System.out.println("client");
                    CreateORJoinGame.cl.writeServer(Integer.toString(pos));
                    while(!CreateORJoinGame.cl.read.equals("none"));
                    if(CreateORJoinGame.cl.read.equals("false"))
                        System.out.println("enter another place");
                    else
                    {
                        allButtons[pos].getStyleClass().remove("freeCell-Class"); 
                        allButtons[pos].getStyleClass().add("o-Class");
                        if(OnlineMultiPlayerMenu.db!=null)
                        {
                            allMoves.add(pos);
//                            try {
//                                OnlineMultiPlayerMenu.db.insertMove(pos);
//                            } catch (SQLException ex) {
//                                ex.printStackTrace();
//                            }
                        }
                    }
                }
            }
        }
        else if(CreateORJoinGame.serv != null)
        {
            if(CreateORJoinGame.serv.read!=null)
            {
                if(CreateORJoinGame.serv.game.currentPlayerMark=='x')
                {
                    CreateORJoinGame.serv.writeClient("server");
                    boolean status = CreateORJoinGame.serv.game.updateGame(pos);
                    if(status==false)
                        System.out.println("enter another place");
                    else
                    {
                          allButtons[pos].getStyleClass().remove("freeCell-Class"); 
                          allButtons[pos].getStyleClass().add("x-Class");
                          CreateORJoinGame.serv.writeClient(Integer.toString(pos));
                          if(CreateORJoinGame.serv.game.winner=='-')
                          {
                              CreateORJoinGame.serv.writeClient("client");
                          }
                          else
                          {
                              AppManager.viewPane(AppManager.winner);   //winner
                              CreateORJoinGame.serv.writeClient(CreateORJoinGame.serv.game.winner+" wins");
                              System.out.println(CreateORJoinGame.serv.game.winner+" wins");
                          }
                        if(OnlineMultiPlayerMenu.db!=null)
                        {
                            allMoves.add(pos);
//                            try {
//                                OnlineMultiPlayerMenu.db.insertMove(pos);
//                            } catch (SQLException ex) {
//                                ex.printStackTrace();
//                            }
                        }
                    }
                }
            }
        } 
    }

    static void updateButton(String pos)
    {
        if(pos.matches("\\d+"))
        {
            int posInt = Integer.parseInt(pos);
            
            if(CreateORJoinGame.serv != null)
            {
                allButtons[posInt].getStyleClass().remove("freeCell-Class"); 
                allButtons[posInt].getStyleClass().add("o-Class");
            }            
            else if(CreateORJoinGame.cl != null)
            {
                allButtons[posInt].getStyleClass().remove("freeCell-Class"); 
                allButtons[posInt].getStyleClass().add("x-Class");
            }
//            if(OnlineMultiPlayerMenu.db!=null)
//            {
//                try {
//                    OnlineMultiPlayerMenu.db.insertMove(posInt);
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
        }
    }
    
    
    
    
}
