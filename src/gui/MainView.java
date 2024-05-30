package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab catalogueTab = new Tab("Drone Catalogue", new DroneCatalogueView().getView());
        Tab historyTab = new Tab("Drone History", new DroneHistoryView().getView());
        Tab dynamicsTab = new Tab("Flight Dynamics", new FlightDynamicsView().getView());

        tabPane.getTabs().addAll(catalogueTab, historyTab, dynamicsTab);

        Scene scene = new Scene(tabPane, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("darkmode.css").toExternalForm());

        primaryStage.setTitle("Drone Simulation Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene getMainScene() {
        TabPane tabPane = new TabPane();

        Tab catalogueTab = new Tab("Drone Catalogue", new DroneCatalogueView().getView());
        Tab historyTab = new Tab("Drone History", new DroneHistoryView().getView());
        Tab dynamicsTab = new Tab("Flight Dynamics", new FlightDynamicsView().getView());

        tabPane.getTabs().addAll(catalogueTab, historyTab, dynamicsTab);

        Scene scene = new Scene(tabPane, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("darkmode.css").toExternalForm());

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
