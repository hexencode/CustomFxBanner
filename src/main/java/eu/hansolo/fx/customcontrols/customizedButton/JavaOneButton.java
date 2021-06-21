package eu.hansolo.fx.customcontrols.customizedButton;

import javafx.scene.control.Button;

public class JavaOneButton extends Button {

    public JavaOneButton(String text) {
        super(text);
        getStyleClass().add("javaone-button");
    }

    @Override
    public String getUserAgentStylesheet() {
        return JavaOneButton.class.getResource("JavaOneButton.css").toExternalForm();
    }
}
