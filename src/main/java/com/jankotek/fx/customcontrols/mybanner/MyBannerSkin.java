package com.jankotek.fx.customcontrols.mybanner;

import javafx.beans.value.ChangeListener;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SkinBase;

import java.util.Map;

public class MyBannerSkin extends SkinBase<MyBanner> {

    private final MyBannerView view;
    private final MyBannerModel model;

    /* Listeners */
    private ChangeListener<MyBannerApi.ScaleType> scaleTypeChangeListener;
    private ChangeListener<Boolean> isContrastThemeBooleanChangeListener;

    public MyBannerSkin(MyBanner control) {
        super(control);

        model = getSkinnable().getModel();

        getSkinnable().getStyleClass().add("my-banner");
        getSkinnable().setFocusTraversable(true);

        pseudoClassStateChanged(CssPseudoClassFactory.getScalePseudoClass(model.scaleTypeProperty().get()), true);
        pseudoClassStateChanged(CssPseudoClassFactory.getThemePseudoClass(model.isContrastThemeBooleanProperty().getValue()), true);

        view = new MyBannerView(MyBannerView.IconFactory.IconType.INFO);
        view.labelStringProperty().setValue(model.labelStringProperty().getValue());
        view.addOnExitEventListener(event -> {
            Node source = (Node) event.getSource();
            Parent parent = source.getParent();
            getChildren().removeAll(parent);
        });
        getChildren().add(view.getRoot());

        registerViewListeners();
        registerControllerListener();
    }

    private void registerViewListeners() {
        model.disableMessageBooleanProperty().bind(view.disableMessageBooleanProperty());
    }

    private void registerControllerListener() {
        scaleTypeChangeListener = (observable, oldValue, newValue) -> {
            pseudoClassStateChanged(CssPseudoClassFactory.getScalePseudoClass(oldValue), false);
            pseudoClassStateChanged(CssPseudoClassFactory.getScalePseudoClass(newValue), true);
        };
        model.scaleTypeProperty().addListener(scaleTypeChangeListener);

        isContrastThemeBooleanChangeListener = (observable, oldValue, newValue) -> {
            pseudoClassStateChanged(CssPseudoClassFactory.getThemePseudoClass(oldValue), false);
            pseudoClassStateChanged(CssPseudoClassFactory.getThemePseudoClass(newValue), true);
        };
        model.isContrastThemeBooleanProperty().addListener(isContrastThemeBooleanChangeListener);
    }

    @Override
    public void dispose() {
        getSkinnable().getStyleClass().removeAll();
        pseudoClassStateChanged(CssPseudoClassFactory.getScalePseudoClass(model.scaleTypeProperty().get()), false);
        pseudoClassStateChanged(CssPseudoClassFactory.getThemePseudoClass(model.isContrastThemeBooleanProperty().getValue()), false);

        model.scaleTypeProperty().removeListener(scaleTypeChangeListener);
        model.isContrastThemeBooleanProperty().removeListener(isContrastThemeBooleanChangeListener);
        model.disableMessageBooleanProperty().unbind();
        super.dispose();
    }

    /* Skin rendering */
    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRoot().minWidth(height);
    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRoot().minHeight(width);
    }

    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRoot().prefWidth(height) + leftInset + rightInset;
    }

    @Override
    protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return view.getRoot().prefHeight(width) + topInset + bottomInset;
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
        view.getRoot().resizeRelocate(contentX, contentY, contentWidth, contentHeight);
    }

    private static class CssPseudoClassFactory {

        private static final Map<MyBannerApi.ScaleType, PseudoClass> SCALE_PSEUDOCLASS_STATE = Map.of(
                MyBannerApi.ScaleType.SCALE_65, PseudoClass.getPseudoClass("scale_65"),
                MyBannerApi.ScaleType.SCALE_85, PseudoClass.getPseudoClass("scale_85"),
                MyBannerApi.ScaleType.SCALE_100, PseudoClass.getPseudoClass("scale_100"),
                MyBannerApi.ScaleType.SCALE_125, PseudoClass.getPseudoClass("scale_125"),
                MyBannerApi.ScaleType.SCALE_150, PseudoClass.getPseudoClass("scale_150"),
                MyBannerApi.ScaleType.SCALE_175, PseudoClass.getPseudoClass("scale_175"),
                MyBannerApi.ScaleType.SCALE_200, PseudoClass.getPseudoClass("scale_200")
        );

        private static PseudoClass getScalePseudoClass(MyBannerApi.ScaleType newValue) {
            return SCALE_PSEUDOCLASS_STATE.get(newValue);
        }

        public static PseudoClass getThemePseudoClass(Boolean isContrastTheme) {
            return isContrastTheme
                    ? PseudoClass.getPseudoClass("theme_contrast")
                    : PseudoClass.getPseudoClass("theme_default");
        }
    }


}
