package com.jankotek.fx.customcontrols.mybanner;

import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SkinBase;

import java.util.Map;
import java.util.logging.Logger;

public class MyBannerSkin extends SkinBase<MyBanner> {

    private final static Logger LOGGER = Logger.getLogger(MyBannerSkin.class.getName());

    private static final Map<MyBannerApi.ScaleType, PseudoClass> SCALE_PSEUDOCLASS_STATE = Map.of(
            MyBannerApi.ScaleType.SCALE_65, PseudoClass.getPseudoClass("scale_65"),
            MyBannerApi.ScaleType.SCALE_85, PseudoClass.getPseudoClass("scale_85"),
            MyBannerApi.ScaleType.SCALE_100, PseudoClass.getPseudoClass("scale_100"),
            MyBannerApi.ScaleType.SCALE_125, PseudoClass.getPseudoClass("scale_125"),
            MyBannerApi.ScaleType.SCALE_150, PseudoClass.getPseudoClass("scale_150"),
            MyBannerApi.ScaleType.SCALE_175, PseudoClass.getPseudoClass("scale_175"),
            MyBannerApi.ScaleType.SCALE_200, PseudoClass.getPseudoClass("scale_200")
    );

    private final MyBannerView view;
    private final MyBanner myBannerControl;
    private final MyBannerModel model;

    public MyBannerSkin(MyBanner control) {
        super(control);

        myBannerControl = getSkinnable();
        model = myBannerControl.getModel();
        registerPseudoClass(model.scaleTypeProperty.get());

        view = new MyBannerView(MyBannerView.IconFactory.IconType.INFO);
        view.labelStringProperty().setValue(model.labelStringProperty.getValue());
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
        model.disableMessageBooleanProperty.bind(view.disableMessageBooleanProperty());
    }

    private void registerControllerListener() {
        model.scaleTypeProperty.addListener((observable, oldValue, newValue) -> {
                    unregisterPseudoClass(oldValue);
                    registerPseudoClass(newValue);
                }
        );
    }

    private void registerPseudoClass(MyBannerApi.ScaleType newValue) {
        PseudoClass newPseudoclass = SCALE_PSEUDOCLASS_STATE.get(newValue);
        if (newPseudoclass != null) {
            LOGGER.finest("Activating CSS pseudoclass " + newValue);
            pseudoClassStateChanged(newPseudoclass, true);
        }
    }

    private void unregisterPseudoClass(MyBannerApi.ScaleType oldValue) {
        PseudoClass oldPseudoclass = SCALE_PSEUDOCLASS_STATE.get(oldValue);
        if (oldValue != null) {
            LOGGER.finest("Deactivating CSS pseudoclass " + oldValue);
            pseudoClassStateChanged(oldPseudoclass, false);
        }
    }

    @Override
    public void dispose() {
        //TODO:jako dispose all listeners
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

}
