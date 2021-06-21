package eu.hansolo.fx.customcontrols.customizedButton4;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.util.List;

public class JavaOneButton4View implements Visual {

    private final Label textLabel;

    public JavaOneButton4View(JavaOneButton4Model model) {

        textLabel = new Label();
        textLabel.textProperty().bind(model.textProperty());
    }

    @Override
    public Node getRootNode() {
        return textLabel;
    }

    @Override
    public void dispose() {

    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return null;
    }
}
