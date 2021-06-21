package com.jankotek.fx.customcontrols.mybanner;

import javafx.beans.property.*;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class MyBanner extends Control implements MyBannerApi {

    private final MyBannerModel model;

    public MyBanner() {
        this.model = new MyBannerModel();

        // set defaults
        this.setMessage("no text set...");
        this.setScaleType(ScaleType.SCALE_100);
        this.setIsInfoMessage(true);
        this.setIsContrastScheme(true);

        getStyleClass().add("my-banner");
        setFocusTraversable(true);
    }

    public MyBanner(String text) {
        this();
        this.setMessage(text);
    }

    /* API */
    @Override
    public StringProperty messageStringProperty() {
        return model.labelStringProperty;
    }

    @Override
    public ObjectProperty<ScaleType> scaleTypeProperty() {
        return model.scaleTypeProperty;
    }

    @Override
    public boolean isInfoType() {
        return model.isInformationTypeBooleanProperty.get();
    }

    @Override
    public void isInfoMessage(boolean isInfoType) {
        model.isInformationTypeBooleanProperty.set(isInfoType);
    }

    @Override
    public BooleanProperty isInfoTypeBooleanProperty() {
        return model.isInformationTypeBooleanProperty;
    }

    @Override
    public boolean isContrastTheme() {
        return model.isContrastThemeBooleanProperty.get();
    }

    @Override
    public void isContrastTheme(Boolean isContrastTheme) {
        model.isContrastThemeBooleanProperty.set(isContrastTheme);
    }

    @Override
    public BooleanProperty isContrastThemeBooleanProperty() {
        return model.isContrastThemeBooleanProperty;
    }

    @Override
    public boolean disableMessage() {
        return model.disableMessageBooleanProperty.get();
    }

    @Override
    public BooleanProperty disableMessageBooleanProperty() {
        return model.disableMessageBooleanProperty;
    }

    @Override
    public void disableMessage(Boolean hideBanner) {
        model.disableMessageBooleanProperty.set(hideBanner);
    }

    @Override
    public String getMessage() {
        return model.labelStringProperty.get();
    }

    @Override
    public void setMessage(String labelText) {
        model.labelStringProperty.set(labelText);
    }

    @Override
    public ScaleType getScaleType() {
        return model.scaleTypeProperty.get();
    }

    @Override
    public void setScaleType(ScaleType scale) {
        model.scaleTypeProperty.set(scale);
    }

    @Override
    public void setIsInfoMessage(Boolean isInfoMessage) {
        model.isInformationTypeBooleanProperty.set(isInfoMessage);
    }

    @Override
    public void setIsContrastScheme(Boolean isContrastTheme) {
        model.isContrastThemeBooleanProperty.set(isContrastTheme);
    }

    /* Override Control methods */
    @Override
    public String getUserAgentStylesheet() {
        return MyBanner.class.getResource("css/my-banner.css").toExternalForm();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new MyBannerSkin(this);
    }

    MyBannerModel getModel() {
        return model;
    }

}
