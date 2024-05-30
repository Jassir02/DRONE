package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FlightDynamicsView {

    private VBox view;

    public FlightDynamicsView() {
        view = new VBox(10);
        view.setPadding(new Insets(10));
        view.setAlignment(Pos.CENTER);

        ListView<String> droneList = new ListView<>();
        // Populate this list from the API data
        // for (int i = 71; i <= 95; i++) {
        //     droneList.getItems().add("Drone " + i);
        // }

        GridPane infoPane = new GridPane();
        infoPane.setHgap(10);
        infoPane.setVgap(10);

        infoPane.add(new Label("Speed:"), 0, 0);
        infoPane.add(new Label("N/A"), 1, 0);

        infoPane.add(new Label("Battery:"), 0, 1);
        infoPane.add(new Label("N/A"), 1, 1);

        infoPane.add(new Label("Location:"), 0, 2);
        infoPane.add(new Label("N/A"), 1, 2);

        view.getChildren().addAll(droneList, infoPane);
    }

    public VBox getView() {
        return view;
    }
}
