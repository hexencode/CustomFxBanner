package eu.hansolo.fx.customcontrols.customizedButton3;

import javafx.css.PseudoClass;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseEvent;

public class JavaOneButton3Skin extends SkinBase<JavaOneButton3Control> {
    private static final PseudoClass ARMED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("armed");

    private Label textLabel;

    public JavaOneButton3Skin(JavaOneButton3Control control) {
        super(control);

        initGraphics();
        registerViewListeners();
        registerControllerListener();
    }

    private void initGraphics() {
        textLabel = new Label();
        getChildren().add(textLabel);
    }

    private void registerViewListeners() {
        textLabel.textProperty().bind(getSkinnable().textProperty());
    }

    private void registerControllerListener() {

        getSkinnable().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, true);
            getSkinnable().requestFocus();
        });

        getSkinnable().addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, false);
        });
    }

    /* Skin rendering */
    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return textLabel.minWidth(height);
    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return textLabel.minHeight(width);
    }

    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return textLabel.prefWidth(height) + leftInset + rightInset;
    }

    @Override
    protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return textLabel.prefHeight(width) + topInset + bottomInset;
    }

    @Override
    protected double computeMaxWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
    }

    @Override
    protected double computeMaxHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefHeight(width, topInset, rightInset, bottomInset, leftInset);
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        textLabel.resizeRelocate(contentX, contentY, contentWidth, contentHeight);
    }
}
