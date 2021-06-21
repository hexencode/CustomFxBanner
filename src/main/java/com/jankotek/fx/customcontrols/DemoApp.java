package com.jankotek.fx.customcontrols;

import com.jankotek.fx.customcontrols.mybanner.MyBanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * Control panel for demonstration purposes. I did not focus on the code quality in this class as it serves only to demoing.
 */
public class DemoApp extends Application {

    private final static Logger LOGGER = Logger.getLogger(DemoApp.class.getName());

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demo panel for the custom MyBanner component");

        // stage for displaying of MyWidget components
        Stage secondaryStage = new Stage();

        DemoControllerBoard controlBoard = new DemoControllerBoard();
        DemoBannerBoard bannerBoard = new DemoBannerBoard(secondaryStage);

        // ... default theme otherwise. TODO replace with enum
        // ... success message otherwise. TODO replace with enum
        controlBoard.addOnCreateButtonPressedEventListener(
                event -> {
                    MyBanner newBanner = new MyBanner();
                    newBanner.setMessage(controlBoard.getBannerMesage());
                    newBanner.setScaleType(controlBoard.getScale());
                    newBanner.isContrastTheme(controlBoard.isContrastScheme()); // ... default theme otherwise. TODO replace with enum
                    newBanner.isInfoMessage(controlBoard.isInfoMessage()); // ... success message otherwise. TODO replace with enum

                    bannerBoard.addBanner(newBanner);
                    newBanner.disableMessageBooleanProperty().addListener(controlBoard.mockedDisableMessageListener(newBanner));
                }
        );

        controlBoard.addScaleChangeListener(bannerBoard.addOnScaleSelectionChangeListener());
        controlBoard.addThemeChangeListener(bannerBoard.addOnThemeSelectionChangeListener());

        Scene scene = new Scene(controlBoard, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
