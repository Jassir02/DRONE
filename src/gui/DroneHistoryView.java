package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DroneHistoryView {

    private VBox view;

    public DroneHistoryView() {
        view = new VBox(10);
        view.setPadding(new Insets(10));
        view.setAlignment(Pos.CENTER);

        // Search Controls
        GridPane searchPane = new GridPane();
        searchPane.setHgap(10);
        searchPane.setVgap(10);

        TextField droneIdField = new TextField();
        droneIdField.setPromptText("Drone ID");

        DatePicker datePicker = new DatePicker();
        TextField timeField = new TextField();
        timeField.setPromptText("HH:MM:SS");

        Button searchButton = new Button("Search");

        searchPane.add(new Label("Drone ID:"), 0, 0);
        searchPane.add(droneIdField, 1, 0);
        searchPane.add(new Label("Date:"), 0, 1);
        searchPane.add(datePicker, 1, 1);
        searchPane.add(new Label("Time:"), 0, 2);
        searchPane.add(timeField, 1, 2);
        searchPane.add(searchButton, 1, 3);

        // Table View for displaying history
        TableView<DroneHistory> tableView = new TableView<>();
        tableView.setPlaceholder(new Label("No data to display, please refine your query"));

        TableColumn<DroneHistory, String> timestampCol = new TableColumn<>("Timestamp");
        timestampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));

        TableColumn<DroneHistory, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<DroneHistory, Double> speedCol = new TableColumn<>("Speed (km/h)");
        speedCol.setCellValueFactory(new PropertyValueFactory<>("speed"));

        tableView.getColumns().addAll(timestampCol, statusCol, speedCol);

        view.getChildren().addAll(searchPane, tableView);
    }

    public VBox getView() {
        return view;
    }
}

class DroneHistory {
    private String timestamp;
    private String status;
    private double speed;

    // Getters and setters

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
