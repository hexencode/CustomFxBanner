package eu.hansolo.fx.customcontrols.customizedButton3;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class JavaOneButton3Control extends Control {

    private StringProperty textProperty = new SimpleStringProperty(this, "text");

    public JavaOneButton3Control(String text) {
        getStyleClass().add("javaone-button");
        setFocusTraversable(true);

        setText(text);
    }

    @Override
    public String getUserAgentStylesheet() {
        return JavaOneButton3Control.class.getResource("JavaOneButton3.css").toExternalForm();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new JavaOneButton3Skin(this);
    }


    public String getText() {
        return textProperty.get();
    }

    public StringProperty textProperty() {
        return textProperty;
    }

    public void setText(String textProperty) {
        this.textProperty.set(textProperty);
    }
}
