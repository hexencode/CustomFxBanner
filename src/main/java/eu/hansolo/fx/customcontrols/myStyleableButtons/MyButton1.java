package eu.hansolo.fx.customcontrols.myStyleableButtons;

import javafx.beans.property.BooleanProperty;
import javafx.css.*;
import javafx.scene.control.Button;
import javafx.scene.control.Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyButton1 extends Button {

    public BooleanProperty fooProperty() {
        return (BooleanProperty) foo;
    }

    private StyleableProperty<Boolean> foo =
            new SimpleStyleableBooleanProperty(fooMetaData);

    private static final CssMetaData<MyButton1, Boolean> fooMetaData =
            new CssMetaData<>("-my-foo", StyleConverter.getBooleanConverter()) {
                @Override
                public boolean isSettable(MyButton1 node) {
                    return !node.fooProperty().isBound();
                }

                @Override
                public StyleableProperty<Boolean> getStyleableProperty(MyButton1 node) {
                    return node.foo;
                }
            };

    static final List<CssMetaData<? extends Styleable, ?>> cssMetaData;

    static {
        List<CssMetaData<? extends Styleable, ?>> temp =
                new ArrayList<>(Control.getClassCssMetaData());
        temp.addAll(Arrays.asList(fooMetaData));
        cssMetaData = Collections.unmodifiableList(temp);
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return cssMetaData;
    }
}