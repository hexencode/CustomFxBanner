package eu.hansolo.fx.customcontrols.customizedBanner.mybanner;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

final class MyBannerView {

    private final GridPane gridPane;
    private final Label textField;
    private final CheckBox disableCheckbox;
    private final ImageView exitIcon;

    MyBannerView(IconFactory.IconType info) {
        this.gridPane = new GridPane();
        gridPane.getColumnConstraints().addAll(
                new ColumnConstraints(30, 30, 30, Priority.NEVER, HPos.LEFT, false),
                new ColumnConstraints(200, 400, 600, Priority.NEVER, HPos.LEFT, false),
                new ColumnConstraints(200, 200, 200, Priority.NEVER, HPos.LEFT, false),
                new ColumnConstraints(30, 30, 30, Priority.NEVER, HPos.RIGHT, false)
        );

        gridPane.getRowConstraints().add(new RowConstraints(10, 25, 40, Priority.NEVER, VPos.CENTER, false));

        ImageView leftIcon = IconFactory.create(info);
        textField = new Label();
        textField.setWrapText(true);
        disableCheckbox = new CheckBox();
        HBox disableBlock = new HBox(10, disableCheckbox, new Label("Meldung nicht mehr anzeigen"));
        disableBlock.setAlignment(Pos.CENTER);
        exitIcon = IconFactory.create(IconFactory.IconType.EXIT);


        this.gridPane.addColumn(0, leftIcon);
        this.gridPane.addColumn(1, textField);
        this.gridPane.addColumn(2, disableBlock);
        this.gridPane.addColumn(3, exitIcon);
    }

    void addOnExitEventListener(EventHandler<MouseEvent> mouseEventEventHandler) {
        exitIcon.setOnMouseClicked(mouseEventEventHandler);
    }

    Node getRoot() {
        return gridPane;
    }

    /* Getters/Setters for UI components */
    StringProperty labelStringProperty() {
        return textField.textProperty();
    }

    BooleanProperty disableMessageBooleanProperty() {
        return disableCheckbox.selectedProperty();
    }

    static final class IconFactory {

        public static ImageView create(IconType iconType) {
            ImageView icon = new ImageView();
            icon.setId(switch (iconType) {
                case INFO -> "infoIcon";
                case EXIT -> "exitIcon";
                case CONFIRM -> "confirmIcon";
            });
            return icon;
        }

        public enum IconType {
            INFO, CONFIRM, EXIT;
        }
    }
}
