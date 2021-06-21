package com.jankotek.fx.customcontrols;

import com.jankotek.fx.customcontrols.mybanner.MyBanner;
import com.jankotek.fx.customcontrols.mybanner.MyBannerApi;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class DemoBannerBoard extends VBox {

    private final List<MyBannerApi> displayedBanners = new ArrayList<>();
    private final Stage stage;

    public DemoBannerBoard(Stage stage) {
        this.stage = stage;
        Scene scene = new Scene(this, 1100, 500);
        this.stage.setScene(scene);
        this.stage.setX(this.stage.getX() + 300);
    }

    public void addBanner(MyBanner newBanner) {
        if (!stage.isShowing()) {
            stage.show();
        }
//            newBanner.setTranslateX(200); // TODO hack to move element toward center. I had no time to calculate position by observing layout properties of the parent container
        super.fillWidthProperty();
        super.setSpacing(20);
        super.setAlignment(Pos.CENTER);
        super.getChildren().add(newBanner);
        displayedBanners.add(newBanner);
    }

    Consumer<MyBannerApi.ScaleType> addOnScaleSelectionChangeListener() {
        return (MyBannerApi.ScaleType newScaleSelection) -> displayedBanners.forEach(
                myBanner -> myBanner.setScaleType(newScaleSelection)
        );
    }

    Consumer<Boolean> addOnThemeSelectionChangeListener() {
        return isContrastThemeSelected -> {
            displayedBanners.forEach(myBannerApi -> myBannerApi.setIsContrastScheme(isContrastThemeSelected));
        };
    }
}
