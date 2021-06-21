package eu.hansolo.fx.customcontrols.customizedBanner.mybanner;

import javafx.beans.property.*;

final class MyBannerModel {

    final StringProperty labelStringProperty = new SimpleStringProperty(this, "label text");
    final ObjectProperty<MyBannerApi.ScaleType> scaleTypeProperty = new SimpleObjectProperty<>(this, "scale", MyBannerApi.ScaleType.SCALE_100);
    final BooleanProperty isInformationTypeBooleanProperty = new SimpleBooleanProperty(this, "is info type?");
    final BooleanProperty isContrastThemeBooleanProperty = new SimpleBooleanProperty(this, "is contrast scheme?");
    final BooleanProperty disableMessageBooleanProperty = new SimpleBooleanProperty(this, "hide the banner?");
}
