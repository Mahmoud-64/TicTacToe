package javafxapplication4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class winnerFxmlBase extends Pane {

    protected final ImageView imageView;

    public winnerFxmlBase() {

        imageView = new ImageView();

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
        imageView.setImage(new Image(getClass().getResourceAsStream("winner.gif")));
          setStyle("-fx-background-color: WHITE;");

        getChildren().add(imageView);

    }
}
