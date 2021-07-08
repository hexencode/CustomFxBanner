package com.jankotek.fx.customcontrols;

import com.jankotek.fx.customcontrols.mybanner.MyBanner;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class DemoBannerBoard extends VBox {

    private final Stage stage;
    private final ObservableList<Node> banners;

    public DemoBannerBoard(Stage stage) {
        this.stage = stage;
        Scene scene = new Scene(this, 900, 400);
        this.stage.setScene(scene);
        this.stage.setX(this.stage.getX() + 300);
        banners = this.getChildren();
    }

    public void addBanner(MyBanner newBanner) {
        if (!stage.isShowing()) {
            stage.show();
        }
//            newBanner.setTranslateX(200); // TODO hack to move element toward center. I had no time to calculate position by observing layout properties of the parent container
        super.fillWidthProperty();
        super.setSpacing(20);
        super.setAlignment(Pos.CENTER);
        banners.add(newBanner);
    }

    public ObservableList<Node> getBanners() {
        return banners;
    }
}
