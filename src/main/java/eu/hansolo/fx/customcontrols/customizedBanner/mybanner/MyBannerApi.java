package eu.hansolo.fx.customcontrols.customizedBanner.mybanner;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public interface MyBannerApi {

    String getMessage();

    void setMessage(String message);

    StringProperty messageStringProperty();

    ScaleType getScaleType();

    void setScaleType(ScaleType scale);

    ObjectProperty<ScaleType> scaleTypeProperty();

    boolean isInfoType();

    void isInfoMessage(boolean isInfoType);

    BooleanProperty isInfoTypeBooleanProperty();

    boolean isContrastTheme();

    void isContrastTheme(Boolean isContrastTheme);

    BooleanProperty isContrastThemeBooleanProperty();

    boolean disableMessage();

    BooleanProperty disableMessageBooleanProperty();

    void disableMessage(Boolean disableMessage);

    void setIsInfoMessage(Boolean isInfoMessage);

    void setIsContrastScheme(Boolean b);

    enum ScaleType {
        SCALE_65, SCALE_85, SCALE_100, SCALE_125, SCALE_150, SCALE_175, SCALE_200;
    }

}
