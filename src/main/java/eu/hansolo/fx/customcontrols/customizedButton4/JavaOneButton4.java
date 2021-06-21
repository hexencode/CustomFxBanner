package eu.hansolo.fx.customcontrols.customizedButton4;

import javafx.scene.control.Control;

public class JavaOneButton4 extends Control {

    private final JavaOneButton4Model model;

    public JavaOneButton4() {
        model = new JavaOneButton4Model();

        getStyleClass().add("javaone-button");
        setFocusTraversable(true);
    }

    public JavaOneButton4(String text) {
        this();
        model.setText(text);
    }

    @Override
    public String getUserAgentStylesheet() {
        return JavaOneButton4.class.getResource("JavaOneButton4.css").toExternalForm();
    }

    @Override
    protected JavaOneButton4BehaviorSkin createDefaultSkin() {
        JavaOneButton4View view = new JavaOneButton4View(model);
        return new JavaOneButton4BehaviorSkin(this, view);
    }

    public JavaOneButton4Model getModel() {
        return model;
    }
}
