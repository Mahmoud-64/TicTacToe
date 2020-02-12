/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static javafxapplication4.AppManager.createORJoinGame;
import static javafxapplication4.AppManager.onlineMultiPlayerMenu;
import static javafxapplication4.AppManager.onlinemultiplayerGameplayPane;

/**
 *
 * @author Admin
 */
public class JavaFXApplication4 extends Application  {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        root.getChildren().add(AppManager.startMenu);
        root.getChildren().add(AppManager.singlePlayerMenu);
        root.getChildren().add(AppManager.multiPlayerMenu);
        root.getChildren().add(AppManager.singlePlayerGameplayPane3);
        root.getChildren().add(AppManager.multiplayerGameplayPane);
        root.getChildren().add(AppManager.onlineMultiPlayerMenu);
        root.getChildren().add(AppManager.onlinemultiplayerGameplayPane);
        root.getChildren().add(AppManager.createORJoinGame);
        root.getChildren().add(AppManager.looser);
        root.getChildren().add(AppManager.winner);
        
        AppManager.viewPane(AppManager.startMenu);
        Scene scene = new Scene(root, 450, 490);
        //primaryStage.setWidth(100);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toString());
        primaryStage.setTitle("Donuts");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
