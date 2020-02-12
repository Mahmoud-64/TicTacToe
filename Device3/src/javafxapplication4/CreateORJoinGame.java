package javafxapplication4;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.control.ToggleButton;

public  class CreateORJoinGame extends Pane {
    protected static ServerPart serv=null;
    protected static ClientPart cl=null;

    protected final Label label;
    protected final BoxBlur boxBlur;
    protected final Label label0;
    protected final Button create;
    protected final Button join;
    protected final Button mainMenu;
    protected final ImageView imageView;
    public CreateORJoinGame() {

        label = new Label();
        boxBlur = new BoxBlur();
        label0 = new Label();
        create = new Button();
        join = new Button();
        mainMenu=new Button();
        imageView = new ImageView();
        //setMaxHeight(USE_PREF_SIZE);
       // setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(490.0);
        setPrefWidth(450.0);
        setStyle("-fx-joinground-color: WHITE;");
         imageView.setFitHeight(700.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(0.0);
        imageView.setLayoutY(0.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        imageView.setImage(new Image(getClass().getResource("pool.png").toExternalForm()));
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(108.0);
        label.setLayoutY(20.0);
        label.setPrefHeight(63.0);
        label.setPrefWidth(238.0);
        label.setText("TIC TAC TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4705"));
        label.setFont(new Font("System Bold", 37.0));
        label.getStyleClass().add("title-label");

        

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label0.setLayoutX(20.0);
        label0.setLayoutY(115.0);
        label0.setPrefHeight(32.0);
        label0.setPrefWidth(400.0);
        label0.setText("PLease choose create or join new game");
        label0.setFont(new Font("System Bold", 18.0));
        
        
        create.setLayoutX(124.0);
        create.setLayoutY(207.0);
        create.setMnemonicParsing(false);
        create.setPrefHeight(32.0);
        create.setPrefWidth(87.0);
        create.setText("Create");
        create.getStyleClass().add("Button-Class");

        join.setLayoutX(240.0);
        join.setLayoutY(207.0);
        join.setMnemonicParsing(false);
        join.setPrefHeight(32.0);
        join.setPrefWidth(87.0);
        join.setText("join");
        join.getStyleClass().add("Button-Class");

        mainMenu.setLayoutX(165);
        mainMenu.setLayoutY(260);
        mainMenu.setMnemonicParsing(false);
        mainMenu.setPrefHeight(32.0);
        mainMenu.setPrefWidth(120);
        mainMenu.setText("Main Menu");
        mainMenu.getStyleClass().add("Button-Class");
        
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(create);
        getChildren().add(join);
        getChildren().add(mainMenu);
      
        
        join.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.onlineMultiPlayerMenu);
           cl = new ClientPart(); 
        });
        
        create.setOnAction((Action) -> {
             AppManager.viewPane(AppManager.onlineMultiPlayerMenu);
             serv = new ServerPart();
        });
        
        mainMenu.setOnAction((Action) -> {
             {AppManager.viewPane(AppManager.startMenu);}
        });
        

    }
}
