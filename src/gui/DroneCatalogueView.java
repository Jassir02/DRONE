package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DroneCatalogueView {

    private GridPane view;

    public DroneCatalogueView() {
        view = new GridPane();
        view.setPadding(new Insets(10));
        view.setHgap(10);
        view.setVgap(10);
        view.setAlignment(Pos.CENTER);

        // This is where you would fetch and display the drone data from the API
        // For now, it's an empty grid ready to be populated
    }

    private VBox createDroneBox(int id, String manufacturer, String type, int weight, String carriageType) {
        VBox box = new VBox(5);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-border-color: black; -fx-background-color: lightgray;");
        box.setAlignment(Pos.CENTER);

        Label idLabel = new Label("ID: " + id);
        Label manufacturerLabel = new Label("Manufacturer: " + manufacturer);
        Label typeLabel = new Label("Type: " + type);
        Label weightLabel = new Label("Weight: " + weight);
        Label carriageTypeLabel = new Label("Carriage Type: " + carriageType);

        box.getChildren().addAll(idLabel, manufacturerLabel, typeLabel, weightLabel, carriageTypeLabel);
        return box;
    }

    public GridPane getView() {
        return view;
    }
}
