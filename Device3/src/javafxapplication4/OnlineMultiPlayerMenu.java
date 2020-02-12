package javafxapplication4;

import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static javafxapplication4.AppManager.onlinemultiplayerGameplayPane;

public  class OnlineMultiPlayerMenu extends Pane {
    protected static database db=null;
    protected final Label label;
    protected final BoxBlur boxBlur;
    protected final Label label0;
    protected final TextField textField;
    protected final Button next;
    protected final Button back;
    protected final ToggleButton record;

    public OnlineMultiPlayerMenu() {

        label = new Label();
        boxBlur = new BoxBlur();
        label0 = new Label();
        textField = new TextField();
        next = new Button();
        back = new Button();
        record =new ToggleButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(490.0);
        setPrefWidth(450.0);
        setStyle("-fx-background-color: #fff;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(108.0);
        label.setLayoutY(30.0);
        label.setPrefHeight(63.0);
        label.setPrefWidth(238.0);
        label.setText("TIC TAC TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4705"));
        label.setFont(new Font("System Bold", 37.0));
        label.getStyleClass().add("title-label");

        label.setEffect(boxBlur);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label0.setLayoutX(118.0);
        label0.setLayoutY(75.0);
        label0.setPrefHeight(101.0);
        label0.setPrefWidth(200.0);
        label0.setText("What is your name ?");
        label0.setFont(new Font("System Bold", 15.0));

        textField.setLayoutX(120.0);
        textField.setLayoutY(140.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(212.0);

        next.setLayoutX(124.0);
        next.setLayoutY(203.0);
        next.setMnemonicParsing(false);
        next.setPrefHeight(32.0);
        next.setPrefWidth(87.0);
        next.setText("Next");
        next.getStyleClass().add("Button-Class");

        back.setLayoutX(240.0);
        back.setLayoutY(203.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(32.0);
        back.setPrefWidth(87.0);
        back.setText("Back");
        back.getStyleClass().add("Button-Class");
        
        record.setLayoutX(170.0);
        record.setLayoutY(260.0);
        record.setMnemonicParsing(false);
        record.setText("Record Game");
        record.getStyleClass().add("toggle-button1");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(textField);
        getChildren().add(next);
        getChildren().add(back);
        getChildren().add(record);
        
        back.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.createORJoinGame);
           if(CreateORJoinGame.cl!=null)
           {
                CreateORJoinGame.cl.stopClient();
                CreateORJoinGame.cl.terminateConn();
           }
           else if(CreateORJoinGame.serv!=null)
           {
               CreateORJoinGame.serv.stopServer();
               CreateORJoinGame.serv.terminateConn();
           }
        });
        
        next.setOnAction((Action) -> {
            if(textField.getText().equals("")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("enter your name please");
                a.show();
             }
            else
            {
                AppManager.viewPane(AppManager.onlinemultiplayerGameplayPane);
                if(CreateORJoinGame.cl!=null)
                {
                    if(CreateORJoinGame.cl.connected==true)
                    {
                        System.out.println("connection");
                        CreateORJoinGame.cl.sName = textField.getText();
                        CreateORJoinGame.cl.writeServer("Name2:"+CreateORJoinGame.cl.sName);
                        System.out.println("fname = "+CreateORJoinGame.cl.fName);
                        System.out.println("sname = "+CreateORJoinGame.cl.sName);
//                        OnlineMultiplayerGameplayPane.textField.setText(CreateORJoinGame.cl.fName);
                        OnlineMultiplayerGameplayPane.textField1.setText(CreateORJoinGame.cl.sName);
                        if(db!=null)
                        {
                            if(!CreateORJoinGame.cl.fName.equals("-"))
                            {
                                try
                                {
                                    System.out.println("getting into database");
                                    db.insertGame(CreateORJoinGame.cl.fName, CreateORJoinGame.cl.sName);
                                } 
                                catch (SQLException ex) {
                                    ex.printStackTrace();
                                    db.terminateConn();
                                }
                            }
                        }
                    }
                    
                }
                else if(CreateORJoinGame.serv!=null)
                {
                    if(CreateORJoinGame.serv.connected==true)
                    {
                        System.out.println("connection");
                        CreateORJoinGame.serv.fName = textField.getText();
                        CreateORJoinGame.serv.writeClient("Name1:"+CreateORJoinGame.serv.fName);
                        System.out.println("fname = "+CreateORJoinGame.serv.fName);
                        System.out.println("sname = "+CreateORJoinGame.serv.sName);
                        OnlineMultiplayerGameplayPane.textField.setText(CreateORJoinGame.serv.fName);
//                        OnlineMultiplayerGameplayPane.textField1.setText(CreateORJoinGame.serv.sName);
                        if(db!=null)
                        {
                            if(!CreateORJoinGame.serv.sName.equals("-"))
                            {
                                try
                                {
                                    System.out.println("getting into database");
                                    db.insertGame(CreateORJoinGame.serv.fName, CreateORJoinGame.serv.sName);
                                } 
                                catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.out.println("database terminated");
                                    db.terminateConn();
                                }
                            }
                        }
                    }
                }
            }
        });
        
        
        record.setOnAction(evt -> {
        if (record.isSelected()) {
            System.out.println("pressed"); //this method is performed when the toggle button is in pressed state
            db = new database();
        } else {
            System.out.println("not pressed"); //this method is performed when the toggle button is in unpressed state
        }
    });
               

    }
}
