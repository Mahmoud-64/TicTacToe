package javafxapplication4;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public abstract class testBase extends AnchorPane {

    protected final ToggleButton toggleButton;

    public testBase() {

        toggleButton = new ToggleButton();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        toggleButton.setLayoutX(148.0);
        toggleButton.setLayoutY(120.0);
        toggleButton.setMnemonicParsing(false);
        toggleButton.setText("ToggleButton");

        getChildren().add(toggleButton);

    }
}
