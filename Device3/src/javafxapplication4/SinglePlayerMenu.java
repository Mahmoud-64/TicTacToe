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

public  class SinglePlayerMenu extends Pane {

    protected final Label label;
    protected final BoxBlur boxBlur;
    protected final Label label0;
    protected final TextField textField;
    protected final Button next;
    protected final Button back;
    protected final ImageView imageView;
    protected final ToggleButton record3;        
    public SinglePlayerMenu() {

        label = new Label();
        boxBlur = new BoxBlur();
        label0 = new Label();
        textField = new TextField();
        next = new Button();
        back = new Button();
        imageView = new ImageView();
        record3 =new ToggleButton();
        //setMaxHeight(USE_PREF_SIZE);
       // setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(490.0);
        setPrefWidth(450.0);
        setStyle("-fx-background-color: WHITE;");
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
        label0.setLayoutX(120.0);
        label0.setLayoutY(115.0);
        label0.setPrefHeight(32.0);
        label0.setPrefWidth(212.0);
        label0.setText("Enter Your Name:");
        label0.setFont(new Font("System Bold", 18.0));
        
        textField.setLayoutX(120.0);
        textField.setLayoutY(150.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(212.0);

        next.setLayoutX(124.0);
        next.setLayoutY(207.0);
        next.setMnemonicParsing(false);
        next.setPrefHeight(32.0);
        next.setPrefWidth(87.0);
        next.setText("Next");
        next.getStyleClass().add("Button-Class");

        back.setLayoutX(240.0);
        back.setLayoutY(207.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(32.0);
        back.setPrefWidth(87.0);
        back.setText("Back");
        back.getStyleClass().add("Button-Class");

        
        record3.setLayoutX(170.0);
        record3.setLayoutY(260.0);
        record3.setMnemonicParsing(false);
        record3.setText("Record Game");
        record3.getStyleClass().add("toggle-button1");
    
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(textField);
        getChildren().add(next);
        getChildren().add(back);
        getChildren().add(record3);    
        
        back.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.startMenu);
        });
        
        next.setOnAction((Action) -> {
             if(textField.getText().equals("")){
                  setStyle("-fx-background-color: WHITE;");
                 
                  imageView.setFitHeight(700.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(0.0);
        imageView.setLayoutY(0.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        imageView.setImage(new Image(getClass().getResource("pool.png").toExternalForm()));
        
                 Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Please Enter Your Name");
            a.show();
             }else {AppManager.viewPane(AppManager.singlePlayerGameplayPane3);}
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
