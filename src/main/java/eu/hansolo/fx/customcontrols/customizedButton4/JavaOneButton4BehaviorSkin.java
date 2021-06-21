package eu.hansolo.fx.customcontrols.customizedButton4;

import javafx.css.CssMetaData;
import javafx.css.PseudoClass;
import javafx.css.Styleable;
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class JavaOneButton4BehaviorSkin extends SkinBase<JavaOneButton4> {

    private static final PseudoClass ARMED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("armed");

    private final JavaOneButton4View view;
    private final JavaOneButton4Model model;

    public JavaOneButton4BehaviorSkin(JavaOneButton4 control, JavaOneButton4View view) {
        super(control);
        this.view = view;
        this.model = control.getModel();
        JavaOneButton4 control1 = super.getSkinnable();

        getChildren().add(this.view.getRootNode());

        control.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, true);
            control.requestFocus();
        });

        control.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, false);
        });
    }

    @Override
    public void dispose() {
        getChildren().remove(view.getRootNode());
        view.dispose();
    }


    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return view.getCssMetaData();
    }

    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRootNode().minWidth(height);
    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRootNode().minHeight(width);
    }

    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRootNode().prefWidth(height) + leftInset + rightInset;
    }

    @Override
    protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRootNode().prefHeight(width) + topInset + bottomInset;
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        view.getRootNode().resizeRelocate(contentX, contentY, contentWidth, contentHeight);
    }

    @Override
    protected double computeMaxWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
    }

    @Override
    protected double computeMaxHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefHeight(width, topInset, rightInset, bottomInset, leftInset);
    }
}