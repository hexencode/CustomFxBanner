package eu.hansolo.fx.customcontrols.customizedButton2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.PseudoClass;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

public class JavaOneButton2 extends Region {

    private static final PseudoClass ARMED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("armed");


    private final Label textLabel;

    private StringProperty textProperty = new SimpleStringProperty(this, "text");

    public JavaOneButton2(String text) {

        getStyleClass().add("javaone-button");
        setFocusTraversable(true);

        textLabel = new Label();
        textLabel.textProperty().bind(textProperty);
        setText(text);
        getChildren().add(textLabel);

        addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, true);
            requestFocus();
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, false);
        });
    }

    @Override
    public String getUserAgentStylesheet() {
        return JavaOneButton2.class.getResource("JavaOneButton2.css").toExternalForm();
    }

    @Override
    protected double computeMinWidth(double height) {
        return super.computeMinWidth(height);
    }

    @Override
    protected double computeMinHeight(double width) {
        return super.computeMinHeight(width);
    }

    @Override
    protected double computeMaxWidth(double height) {
        return super.computePrefWidth(height);
    }

    @Override
    protected double computeMaxHeight(double width) {
        return super.computePrefHeight(width);
    }

    @Override
    protected double computePrefWidth(double height) {
        return textLabel.prefWidth(height) + snappedLeftInset() + snappedRightInset();
    }

    @Override
    protected double computePrefHeight(double width) {
        return textLabel.prefHeight(width) + snappedTopInset() + snappedBottomInset();
    }

    @Override
    protected void layoutChildren() {
        double x = snappedLeftInset();
        double y = snappedTopInset();

        double w = getWidth() - (snappedLeftInset() + snappedRightInset());
        double h = getHeight() - (snappedTopInset() + snappedBottomInset());

        textLabel.resizeRelocate(x, y, w, h);
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
