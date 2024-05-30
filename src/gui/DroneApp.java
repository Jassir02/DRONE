package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DroneApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize the main scene with the GUI.DroneCatalogueView
        DroneCatalogueView catalogueView = new DroneCatalogueView();
        Scene scene = new Scene(catalogueView.getView(), 1200, 800);

        primaryStage.setTitle("Drone Simulation Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
