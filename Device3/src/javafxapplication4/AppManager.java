package javafxapplication4;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


/**
 *
 * @author Admin
 */
public class AppManager {
    
    static StartMenu startMenu = new StartMenu();
    static SinglePlayerMenu singlePlayerMenu = new SinglePlayerMenu();
    static MultiPlayerMenu multiPlayerMenu = new MultiPlayerMenu();
    static OnlineMultiPlayerMenu onlineMultiPlayerMenu = new OnlineMultiPlayerMenu();
    static SinglePlayerGameplayPane3 singlePlayerGameplayPane3 = new SinglePlayerGameplayPane3();
    static MultiplayerGameplayPane multiplayerGameplayPane = new MultiplayerGameplayPane();
    static OnlineMultiplayerGameplayPane onlinemultiplayerGameplayPane = new OnlineMultiplayerGameplayPane();
    static CreateORJoinGame createORJoinGame = new CreateORJoinGame();
    static looserFxmlBase looser =new looserFxmlBase();
    static winnerFxmlBase winner =new winnerFxmlBase();
    
    
    public static void viewPane(Pane pane)
    {
        startMenu.setVisible(false);
        singlePlayerMenu.setVisible(false);
        multiPlayerMenu.setVisible(false);
        singlePlayerGameplayPane3.setVisible(false);
        multiplayerGameplayPane.setVisible(false);
        onlineMultiPlayerMenu.setVisible(false);
        onlinemultiplayerGameplayPane.setVisible(false);
        createORJoinGame.setVisible(false);
        looser.setVisible(false);
        winner.setVisible(false);
        pane.setVisible(true);
    }
}
