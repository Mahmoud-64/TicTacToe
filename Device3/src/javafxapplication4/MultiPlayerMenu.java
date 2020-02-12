package javafxapplication4;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.control.ToggleButton;
import static javafxapplication4.AppManager.multiplayerGameplayPane;

public  class MultiPlayerMenu extends Pane {

    protected final Label label;
    protected final BoxBlur boxBlur;
    protected final Label label0;
    protected final TextField firstPlayerName;
    protected final Button next;
    protected final Button back;
    protected final Label label1;
    protected final TextField secondPlayerName;
    protected final ToggleButton record2;

    public MultiPlayerMenu() {

        label = new Label();
        boxBlur = new BoxBlur();
        label0 = new Label();
        firstPlayerName = new TextField();
        next = new Button();
        back = new Button();
        label1 = new Label();
        secondPlayerName = new TextField();
        record2 =new ToggleButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(490);
        setPrefWidth(450);
        setStyle("-fx-background-color: WHITE;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(108.0);
        label.setLayoutY(30.0);
        label.setPrefHeight(63.0);
        label.setPrefWidth(238.0);
        label.setText("TIC TAC TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4705"));
        //label.setFont(new Font("System Bold", 37.0));
        label.getStyleClass().add("title-label");

        label.setEffect(boxBlur);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label0.setLayoutX(101.0);
        label0.setLayoutY(98.0);
        label0.setPrefHeight(32.0);
        label0.setPrefWidth(249.0);
        label0.setText("Player X");
        label0.setFont(new Font("System Bold", 15.0));

        firstPlayerName.setLayoutX(120.0);
        firstPlayerName.setLayoutY(140.0);
        firstPlayerName.setPrefHeight(25.0);
        firstPlayerName.setPrefWidth(212.0);

        next.setLayoutX(124.0);
        next.setLayoutY(294.0);
        next.setMnemonicParsing(false);
        next.setPrefHeight(32.0);
        next.setPrefWidth(87.0);
        next.setText("Next");
        next.getStyleClass().add("Button-Class");

        back.setLayoutX(240.0);
        back.setLayoutY(294.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(32.0);
        back.setPrefWidth(87.0);
        back.setText("Back");
        back.getStyleClass().add("Button-Class");

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label1.setLayoutX(115.0);
        label1.setLayoutY(190.0);
        label1.setPrefHeight(32.0);
        label1.setPrefWidth(212.0);
        label1.setText("Player O");
        label1.setFont(new Font("System Bold", 15.0));

        secondPlayerName.setLayoutX(122.0);
        secondPlayerName.setLayoutY(232.0);
        secondPlayerName.setPrefHeight(25.0);
        secondPlayerName.setPrefWidth(212.0);
        
        
        record2.setLayoutX(170.0);
        record2.setLayoutY(345.0);
        record2.setMnemonicParsing(false);
        record2.setText("Record Game");
        record2.getStyleClass().add("toggle-button1");

        
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(firstPlayerName);
        getChildren().add(next);
        getChildren().add(back);
        getChildren().add(label1);
        getChildren().add(secondPlayerName);
        getChildren().add(record2);
       

        back.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.startMenu);
        });
        
        next.setOnAction((Action) -> {
            if(firstPlayerName.getText().equals("")||secondPlayerName.getText().equals("")){
                 Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Enter Your Name please:");
            a.show();
             }else {AppManager.viewPane(AppManager.multiplayerGameplayPane);}
        });
        
        
        record2.setOnAction(evt -> {
        if (record2.isSelected()) {
            System.out.println("pressed"); //this method is performed when the toggle button is in pressed state
        } else {
            System.out.println("not pressed"); //this method is performed when the toggle button is in unpressed state
        }
    });
    }
}
