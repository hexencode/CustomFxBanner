package com.jankotek.fx.customcontrols;

import com.jankotek.fx.customcontrols.mybanner.MyBanner;
import com.jankotek.fx.customcontrols.mybanner.MyBannerApi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * Control panel for demonstration purposes. I did not focus on the code quality in this class as it serves only to demoing.
 */
public class DemoApp extends Application {

    private DemoBannerBoard bannerBoard;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demo panel for the custom MyBanner component");

        // stage for displaying of MyWidget components
        Stage secondaryStage = new Stage();

        DemoControllerBoard controlBoard = new DemoControllerBoard();
        bannerBoard = new DemoBannerBoard(secondaryStage);

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

        controlBoard.addScaleChangeListener(addOnScaleSelectionChangeListener());
        controlBoard.addThemeChangeListener(addOnThemeSelectionChangeListener());

        Scene scene = new Scene(controlBoard, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Consumer<MyBannerApi.ScaleType> addOnScaleSelectionChangeListener() {
        return (MyBannerApi.ScaleType newScaleSelection) -> bannerBoard.getBanners()
                .stream()
                .filter(node -> node instanceof MyBanner)
                .forEach(myBanner -> ((MyBanner) myBanner).setScaleType(newScaleSelection));
    }

    Consumer<Boolean> addOnThemeSelectionChangeListener() {
        return isContrastThemeSelected -> {
            bannerBoard.getBanners().stream()
                    .filter(node -> node instanceof MyBanner)
                    .forEach(myBannerApi -> ((MyBanner) myBannerApi).setIsContrastScheme(isContrastThemeSelected));
        };
    }
}
