package com.jankotek.fx.customcontrols.mybanner;

import javafx.beans.property.*;

final class MyBannerModel {

    private final StringProperty labelStringProperty = new SimpleStringProperty(this, "label text");

    private final ObjectProperty<MyBannerApi.ScaleType> scaleTypeProperty = new SimpleObjectProperty<>(this, "scale", MyBannerApi.ScaleType.SCALE_100);

    private final BooleanProperty isInformationTypeBooleanProperty = new SimpleBooleanProperty(this, "is info type?");

    private final BooleanProperty isContrastThemeBooleanProperty = new SimpleBooleanProperty(this, "is contrast scheme?");

    private final BooleanProperty disableMessageBooleanProperty = new SimpleBooleanProperty(this, "hide the banner?");

    public StringProperty labelStringProperty() {
        return labelStringProperty;
    }

    public ObjectProperty<MyBannerApi.ScaleType> scaleTypeProperty() {
        return scaleTypeProperty;
    }

    public BooleanProperty isInformationTypeBooleanProperty() {
        return isInformationTypeBooleanProperty;
    }

    public BooleanProperty isContrastThemeBooleanProperty() {
        return isContrastThemeBooleanProperty;
    }

    public BooleanProperty disableMessageBooleanProperty() {
        return disableMessageBooleanProperty;
    }
}
