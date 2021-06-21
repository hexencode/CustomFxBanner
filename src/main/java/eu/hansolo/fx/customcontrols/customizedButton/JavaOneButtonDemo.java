package eu.hansolo.fx.customcontrols.customizedButton;

import eu.hansolo.fx.customcontrols.combined.CombinedControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaOneButtonDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        JavaOneButton helloButton = new JavaOneButton("Hello");
        helloButton.setLayoutX(200);
        helloButton.setLayoutY(200);

        Pane root = new AnchorPane();
        root.getChildren().add(helloButton);

        Scene scene = new Scene(root);

        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
