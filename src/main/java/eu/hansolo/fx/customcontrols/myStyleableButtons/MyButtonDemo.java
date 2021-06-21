package eu.hansolo.fx.customcontrols.myStyleableButtons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyButtonDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MyButton1 myButton1 = new MyButton1();
        myButton1.setLayoutX(200);
        myButton1.setLayoutY(200);

        MyButton2 myButton2 = new MyButton2();
        myButton2.setLayoutX(400);
        myButton2.setLayoutY(200);
        myButton2.getStyleClass().add("mybutton2");

        Pane root = new AnchorPane();
        root.getChildren().addAll(myButton1, myButton2);

        Scene scene = new Scene(root);

        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
