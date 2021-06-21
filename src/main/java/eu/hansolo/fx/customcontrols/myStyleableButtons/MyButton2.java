package eu.hansolo.fx.customcontrols.myStyleableButtons;

import javafx.beans.property.BooleanProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.scene.control.Button;

import java.util.List;

public class MyButton2 extends Button {

    private static final StyleablePropertyFactory<MyButton2> FACTORY = new StyleablePropertyFactory<>(Button.getClassCssMetaData());

    public BooleanProperty fooProperty() {
        return (BooleanProperty) foo;
    }

    private StyleableProperty<Boolean> foo = FACTORY.createStyleableBooleanProperty(this, "foo", "-my-foo");

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return FACTORY.getCssMetaData();
    }

    @Override
    public String getUserAgentStylesheet() {
        return MyButton2.class.getResource("MyButton2.css").toExternalForm();
    }
}
