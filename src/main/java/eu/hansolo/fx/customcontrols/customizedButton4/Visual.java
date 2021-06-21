package eu.hansolo.fx.customcontrols.customizedButton4;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.Node;

import java.util.List;

public interface Visual {
    Node getRootNode();

    void dispose();

    List<CssMetaData<? extends Styleable, ?>> getCssMetaData();
}
