package com.jankotek.fx.customcontrols;

import com.jankotek.fx.customcontrols.mybanner.MyBanner;
import com.jankotek.fx.customcontrols.mybanner.MyBannerApi;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class DemoControllerBoard extends VBox {

    private final TextField textField;
    private final MessageTypeSelector messageTypeSelector;
    private final BannerScaleBar bannerScaleBar;
    private final BannerThemeBar bannerThemeBar;
    private final Button createButton;
    private final TextArea logginPane;
    private final List<String> disabledMessages = new ArrayList<>();

    public DemoControllerBoard() {
        super.setSpacing(20);

        textField = new TextField("Enter some text...");
        messageTypeSelector = new MessageTypeSelector();
        createButton = new Button("Create Banner");
        HBox createBannerGroup = new HBox(textField, messageTypeSelector, createButton);
        createBannerGroup.setStyle("-fx-border-color: green");

        bannerScaleBar = new BannerScaleBar();
        bannerThemeBar = new BannerThemeBar();
        HBox genericSettingsGroup = new HBox(40, bannerScaleBar, bannerThemeBar);

        VBox appLogs = new VBox();
        logginPane = new TextArea();
        appLogs.getChildren().addAll(new Label("Disabled Messages (mocked back-end service)"), logginPane);
        appLogs.setStyle("-fx-border-color: green");

        super.getChildren().addAll(createBannerGroup, genericSettingsGroup, appLogs);
    }

    boolean isInfoMessage() {
        return messageTypeSelector.isInfoMessageSelected();
    }

    boolean isContrastScheme() {
        return bannerThemeBar.isContrastSchemeSelected();
    }


    MyBannerApi.ScaleType getScale() {
        return bannerScaleBar.getSelectedScale();
    }

    public String getBannerMesage() {
        return textField.getText();
    }

    public void addThemeChangeListener(Consumer<Boolean> booleanConsumer) {
        bannerThemeBar.addThemeSelectionChangeListener(booleanConsumer);
    }

    public void addScaleChangeListener(Consumer<MyBannerApi.ScaleType> scaleTypeConsumer) {
        bannerScaleBar.addScaleSelectionChangeListener(scaleTypeConsumer);
    }

    void addOnCreateButtonPressedEventListener(EventHandler<ActionEvent> button_pressed) {
        createButton.setOnAction(button_pressed);
    }

    private StringProperty getLogingPaneStringProperty() {
        return this.logginPane.textProperty();
    }

    ChangeListener<Boolean> mockedDisableMessageListener(MyBanner newBanner) {
        return (observable, oldValue, newValue) -> {
            if (newValue) {
                disabledMessages.add(newBanner.getMessage());
            } else {
                disabledMessages.remove(newBanner.getMessage());
            }
            logginPane.setText(String.join("\n", disabledMessages));
        };
    }

    static class MessageTypeSelector extends VBox {

        private final ToggleGroup toggleGroup;

        public MessageTypeSelector() {
            RadioButton isInfoRBtn = new RadioButton("info");
            isInfoRBtn.setUserData(Boolean.TRUE);
            RadioButton isConfirmRBtn = new RadioButton("success");
            isInfoRBtn.setUserData(Boolean.FALSE);

            toggleGroup = new ToggleGroup();
            isInfoRBtn.setToggleGroup(toggleGroup);
            isConfirmRBtn.setToggleGroup(toggleGroup);

            isInfoRBtn.setSelected(true); // default value

            super.getChildren().addAll(isInfoRBtn, isConfirmRBtn);
        }

        public boolean isInfoMessageSelected() {
            return Boolean.TRUE == toggleGroup.getSelectedToggle().getUserData();
        }
    }

    static class BannerScaleBar extends VBox {

        private final ToggleGroup toggleGroup;

        public BannerScaleBar() {
            Label label = new Label("Select scale");
            RadioButton scale_65_rBtn = new RadioButton("65%");
            scale_65_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_65);
            RadioButton scale_85_rBtn = new RadioButton("85%");
            scale_85_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_85);
            RadioButton scale_100_rBtn = new RadioButton("100%");
            scale_100_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_100);
            RadioButton scale_125_rBtn = new RadioButton("125%");
            scale_125_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_125);
            RadioButton scale_150_rBtn = new RadioButton("150%");
            scale_150_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_150);
            RadioButton scale_175_rBtn = new RadioButton("175%");
            scale_175_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_175);
            RadioButton scale_200_rBtn = new RadioButton("200%");
            scale_200_rBtn.setUserData(MyBannerApi.ScaleType.SCALE_200);

            super.getChildren().addAll(label, scale_65_rBtn, scale_85_rBtn, scale_100_rBtn, scale_125_rBtn,
                    scale_150_rBtn, scale_175_rBtn, scale_200_rBtn);

            scale_100_rBtn.setSelected(true); // default selection

            toggleGroup = new ToggleGroup();
            scale_65_rBtn.setToggleGroup(toggleGroup);
            scale_85_rBtn.setToggleGroup(toggleGroup);
            scale_100_rBtn.setToggleGroup(toggleGroup);
            scale_125_rBtn.setToggleGroup(toggleGroup);
            scale_150_rBtn.setToggleGroup(toggleGroup);
            scale_175_rBtn.setToggleGroup(toggleGroup);
            scale_200_rBtn.setToggleGroup(toggleGroup);
        }

        public MyBannerApi.ScaleType getSelectedScale() {
            MyBannerApi.ScaleType userData = (MyBannerApi.ScaleType) toggleGroup.getSelectedToggle().getUserData();
            return userData;
        }

        public void addScaleSelectionChangeListener(Consumer<MyBannerApi.ScaleType> scaleChangeListener) {
            toggleGroup.selectedToggleProperty().addListener((ov, oldScaleSelection, newScaleSelection) -> {
                Object selectedObject = newScaleSelection.getUserData();
                if (selectedObject instanceof MyBannerApi.ScaleType) {
                    scaleChangeListener.accept((MyBannerApi.ScaleType) selectedObject);
                }
            });
        }
    }

    static class BannerThemeBar extends VBox {

        private final CheckBox checkBox;

        public BannerThemeBar() {
            Label label = new Label("Use contrast theme?");

            checkBox = new CheckBox();
            checkBox.setSelected(false);

            super.getChildren().addAll(label, checkBox);
        }

        public boolean isContrastSchemeSelected() {
            return checkBox.isSelected();
        }

        public void addThemeSelectionChangeListener(Consumer<Boolean> consumer) {
            checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> consumer.accept(newValue));
        }
    }
}
