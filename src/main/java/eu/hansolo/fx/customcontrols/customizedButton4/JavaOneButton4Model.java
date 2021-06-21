package eu.hansolo.fx.customcontrols.customizedButton4;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JavaOneButton4Model {

    private final StringProperty textProperty = new SimpleStringProperty(this, "text");

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
