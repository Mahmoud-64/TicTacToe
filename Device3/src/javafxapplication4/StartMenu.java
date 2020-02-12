package javafxapplication4;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public  class StartMenu extends Pane {

    protected final ImageView imageView;
    protected final Button singlePlayer;
    protected final Button multiPlayer;
    protected final Button onlineMultiPlayer;
    protected final Button about;
    protected final Button exit;
    protected final Label label;
    protected final BoxBlur boxBlur;

    public StartMenu() {
        
         imageView = new ImageView();
         imageView.setFitHeight(700.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(0.0);
        imageView.setLayoutY(0.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        imageView.setImage(new Image(getClass().getResource("pool.png").toExternalForm()));
          setStyle("-fx-background-color: WHITE;");


        singlePlayer = new Button();
        multiPlayer = new Button();
        onlineMultiPlayer = new Button();
        about = new Button();
        exit = new Button();
        label = new Label();
        boxBlur = new BoxBlur();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(490);
        setPrefWidth(450.0);
              
        setStyle("-fx-background-color: WHITE;");

        singlePlayer.setLayoutX(141.0);
        singlePlayer.setLayoutY(105.0);
        singlePlayer.setMnemonicParsing(false);
        //singlePlayer.setOnAction(this::singlePlayerPressed);
        singlePlayer.setPrefHeight(40.0);
        singlePlayer.setPrefWidth(180.0);
        singlePlayer.setText("Single Player");
        singlePlayer.setFont(new Font("System Bold", 16.0));
        singlePlayer.getStyleClass().add("Button-Class");

        multiPlayer.setLayoutX(141.0);
        multiPlayer.setLayoutY(172.0);
        multiPlayer.setMnemonicParsing(false);
       // multiPlayer.setOnAction(this::multiPlayerPressed);
        multiPlayer.setPrefHeight(40.0);
        multiPlayer.setPrefWidth(180.0);
        multiPlayer.setText("Multiplayer");
        multiPlayer.setFont(new Font("System Bold", 16.0));
        multiPlayer.getStyleClass().add("Button-Class");
        
        onlineMultiPlayer.setLayoutX(141.0);
        onlineMultiPlayer.setLayoutY(236.0);
        onlineMultiPlayer.setMnemonicParsing(false);
       //onlineMultiPlayer.setOnAction(this::multiPlayerPressed);
        onlineMultiPlayer.setPrefHeight(40.0);
        onlineMultiPlayer.setPrefWidth(180.0);
        onlineMultiPlayer.setText("Online Multiplayer");
        onlineMultiPlayer.setFont(new Font("System Bold", 16.0));
        onlineMultiPlayer.getStyleClass().add("Button-Class");
        

        about.setLayoutX(141.0);
        about.setLayoutY(296.0);
        about.setMnemonicParsing(false);
        //about.setOnAction(this::aboutPressed);
        about.setPrefHeight(40.0);
        about.setPrefWidth(180.0);
        about.setText("About");
        about.setFont(new Font("System Bold", 16.0));
        about.getStyleClass().add("Button-Class");

        exit.setLayoutX(141.0);
        exit.setLayoutY(360.0);
        exit.setMnemonicParsing(false);
        //exit.setOnAction(this::exitPressed);
        exit.setPrefHeight(40.0);
        exit.setPrefWidth(180.0);
        exit.setText("Exit");
        exit.setFont(new Font("System Bold", 16.0));
        exit.getStyleClass().add("Button-Class");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(100.0);
        label.setLayoutY(32.0);
        label.setPrefHeight(63.0);
        label.setPrefWidth(238.0);
        label.setText("TIC TAC TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4705"));
        label.setFont(new Font("System Bold", 37.0));
        label.getStyleClass().add("title-label");

        //label.setEffect(boxBlur);
        getChildren().add(imageView);
        getChildren().add(singlePlayer);
        getChildren().add(multiPlayer);
        getChildren().add(onlineMultiPlayer);
        getChildren().add(about);
        getChildren().add(exit);
        getChildren().add(label);
        
        singlePlayer.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.singlePlayerMenu);
        });
        
        multiPlayer.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.multiPlayerMenu);
        });
        
        onlineMultiPlayer.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.createORJoinGame);
        });
        
        exit.setOnAction((Action) -> {
            System.exit(0);
        });
        
        about.setOnAction((Action) -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("///////////////////////////////\n"
                    + "//////////////////////////////////////\n"
                    + "//////////////////////////////////////\n"
                    + "/////////////////////////////////////\n"
                    + "write some text here");
            a.show();
        });

    }

}
