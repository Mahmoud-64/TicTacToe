package javafxapplication4;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class looserFxmlBase extends Pane {

    protected final ImageView imageView;
    protected static Button back;

    public looserFxmlBase() {

        imageView = new ImageView();
        back = new Button();
        
        back.setLayoutX(305.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(34.0);
        back.setPrefWidth(111.0);
        back.setText("Back");
        back.getStyleClass().add("Button-Class");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(489.0);
        setPrefWidth(450.0);

        imageView.setFitHeight(489.0);
        imageView.setFitWidth(450.0);
        imageView.setLayoutY(1.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResourceAsStream("loser.gif")));
          setStyle("-fx-background-color: WHITE;");

        back.setOnAction((Action) -> {
                AppManager.viewPane(AppManager.onlinemultiplayerGameplayPane);
            });
          
        getChildren().add(imageView);

    }
}
