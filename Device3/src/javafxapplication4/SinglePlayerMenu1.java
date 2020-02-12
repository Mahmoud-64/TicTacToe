package javafxapplication4;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.control.ToggleButton;


public  class SinglePlayerMenu1 extends Pane {

    protected final Button singlePlayer;
    protected final Button multiPlayer;
    protected final Button about;
    protected final Button exit;
    protected final Label label;
    protected final BoxBlur boxBlur;
    protected final ToggleButton record3;


    public SinglePlayerMenu1() {

        singlePlayer = new Button();
        multiPlayer = new Button();
        about = new Button();
        exit = new Button();
        label = new Label();
        boxBlur = new BoxBlur();
        record3 =new ToggleButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1500);
        setPrefWidth(300.0);
              
        setStyle("-fx-background-color: #3333;");

        singlePlayer.setLayoutX(82.0);
        singlePlayer.setLayoutY(101.0);
        singlePlayer.setMnemonicParsing(false);
        //singlePlayer.setOnAction(this::singlePlayerPressed);
        singlePlayer.setPrefHeight(40.0);
        singlePlayer.setPrefWidth(137.0);
        singlePlayer.setText("Single Player");
        singlePlayer.setFont(new Font("System Bold", 16.0));

        multiPlayer.setLayoutX(82.0);
        multiPlayer.setLayoutY(168.0);
        multiPlayer.setMnemonicParsing(false);
       // multiPlayer.setOnAction(this::multiPlayerPressed);
        multiPlayer.setPrefHeight(40.0);
        multiPlayer.setPrefWidth(137.0);
        multiPlayer.setText("Multiplayer");
        multiPlayer.setFont(new Font("System Bold", 16.0));

        about.setLayoutX(82.0);
        about.setLayoutY(239.0);
        about.setMnemonicParsing(false);
        //about.setOnAction(this::aboutPressed);
        about.setPrefHeight(40.0);
        about.setPrefWidth(137.0);
        about.setText("About");
        about.setFont(new Font("System Bold", 16.0));

        exit.setLayoutX(82.0);
        exit.setLayoutY(307.0);
        exit.setMnemonicParsing(false);
        //exit.setOnAction(this::exitPressed);
        exit.setPrefHeight(40.0);
        exit.setPrefWidth(137.0);
        exit.setText("Exit");
        exit.setFont(new Font("System Bold", 16.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(32.0);
        label.setLayoutY(20.0);
        label.setPrefHeight(63.0);
        label.setPrefWidth(238.0);
        label.setText("TIC TAC TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4705"));
        label.setFont(new Font("System Bold", 37.0));
        label.setEffect(boxBlur);
        
        record3.setLayoutX(170.0);
        record3.setLayoutY(260.0);
        record3.setMnemonicParsing(false);
        record3.setText("Record Game");
        record3.getStyleClass().add("toggle-button1");
        
        getChildren().add(singlePlayer);
        getChildren().add(multiPlayer);
        getChildren().add(about);
        getChildren().add(exit);
        getChildren().add(label);
        getChildren().add(record3);
        
        singlePlayer.setOnAction((Action) -> {
            System.out.println("hello mahmoud");
        });
        
        exit.setOnAction((Action) -> {
            System.exit(0);
        });
        
         record3.setOnAction(evt -> {
        if (record3.isSelected()) {
            System.out.println("pressed"); //this method is performed when the toggle button is in pressed state
        } else {
            System.out.println("not pressed"); //this method is performed when the toggle button is in unpressed state
        }
    });
          

    }

}
