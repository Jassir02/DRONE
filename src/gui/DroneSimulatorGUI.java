package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DroneSimulatorGUI extends Application {

    private boolean isDarkMode = false;
    private Scene loginScene;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Drone Application");

        // Initialize and show the login page first
        showLoginPage();

        primaryStage.show();
    }

    private HBox createDashboard(Stage primaryStage) {
        Button btnMenu = new Button("Menu");
        btnMenu.setOnAction(event -> showMenu(primaryStage));

        Button btnLogin = new Button("Logout");
        btnLogin.setOnAction(event -> showLoginPage());

        Button btnRefresh = new Button("Refresh");
        btnRefresh.setOnAction(event -> handleRefresh());

        Button toggleModeButton = new Button("Toggle Mode");
        toggleModeButton.setOnAction(event -> toggleMode());

        HBox dashboard = new HBox(10, btnMenu, btnLogin, btnRefresh, toggleModeButton);
        dashboard.setPadding(new Insets(10));
        dashboard.setAlignment(Pos.CENTER);

        return dashboard;
    }

    private void setMode(Scene scene) {
        String darkMode = getClass().getResource("/gui/darkmode.css").toExternalForm();
        if (isDarkMode) {
            if (!scene.getStylesheets().contains(darkMode)) {
                scene.getStylesheets().add(darkMode);
            }
        } else {
            scene.getStylesheets().remove(darkMode);
        }
    }

    private void toggleMode() {
        isDarkMode = !isDarkMode;
        setMode(primaryStage.getScene());
    }

    private void handleLogin() {
        // Add login handling logic here
        System.out.println("Login button clicked");
    }

    private void handleRefresh() {
        // Add refresh handling logic here
        System.out.println("Refresh button clicked");
    }

    private void showLoginPage() {
        Label lblGroupName = new Label("Group Name:");
        TextField txtGroupName = new TextField();

        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();

        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();

        Button btnLogin = new Button("Login");
        btnLogin.setOnAction(e -> {
            // Handle login logic here
            System.out.println("Group: " + txtGroupName.getText() + ", Username: " + txtUsername.getText());
            // Transition to MainView upon successful login
            MainView mainView = new MainView();
            Scene mainScene = mainView.getMainScene();
            primaryStage.setScene(mainScene);
            setMode(mainScene);
        });

        VBox loginFields = new VBox(10, lblGroupName, txtGroupName, lblUsername, txtUsername, lblPassword, txtPassword, btnLogin);
        loginFields.setPadding(new Insets(20));
        loginFields.setAlignment(Pos.CENTER_RIGHT);
        loginFields.setMaxWidth(400);

        // Load the image
        ImageView imageView = new ImageView(new Image(getClass().getResource("/Image/drone.jpg").toExternalForm()));
        imageView.setFitWidth(600);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        // Create an HBox to hold the image and the login fields
        HBox loginBox = new HBox(imageView, loginFields);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));

        loginScene = new Scene(loginBox, 800, 400);
        setMode(loginScene);

        primaryStage.setScene(loginScene);
    }

    private void showMenu(Stage primaryStage) {
        HBox dashboard = createDashboard(primaryStage);

        Button btnHealthCheck = new Button("Drone Health Check");
        btnHealthCheck.setOnAction(event -> showHealthCheckPage(primaryStage));

        Button btnFlightDynamic = new Button("Drone Flight Dynamic");
        btnFlightDynamic.setOnAction(event -> showFlightDynamicPage(primaryStage));

        Button btnCatalogue = new Button("Drone Catalogue");
        btnCatalogue.setOnAction(event -> showCataloguePage(primaryStage));

        Button btnHistory = new Button("Drone History");
        btnHistory.setOnAction(event -> showHistoryPage(primaryStage));

        VBox menuBox = new VBox(10, dashboard, btnHealthCheck, btnFlightDynamic, btnCatalogue, btnHistory);
        menuBox.setPadding(new Insets(20));
        menuBox.setAlignment(Pos.CENTER);

        Scene menuScene = new Scene(menuBox, 1300, 1200);
        setMode(menuScene);

        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void showHealthCheckPage(Stage primaryStage) {
        HBox dashboard = createDashboard(primaryStage);

        Button btnBack = new Button("Back");
        btnBack.setOnAction(event -> showMenu(primaryStage));
        VBox healthCheckBox = new VBox(10, dashboard, btnBack);
        healthCheckBox.setPadding(new Insets(20));
        healthCheckBox.setAlignment(Pos.CENTER);

        Scene healthCheckScene = new Scene(healthCheckBox, 1300, 1200);
        setMode(healthCheckScene);

        primaryStage.setScene(healthCheckScene);
        primaryStage.show();
    }

    private void showFlightDynamicPage(Stage primaryStage) {
        HBox dashboard = createDashboard(primaryStage);

        Button btnBack = new Button("Back");
        btnBack.setOnAction(event -> showMenu(primaryStage));

        FlightDynamicsView flightDynamicsView = new FlightDynamicsView();

        VBox flightDynamicBox = new VBox(10, dashboard, btnBack, flightDynamicsView.getView());
        flightDynamicBox.setPadding(new Insets(20));
        flightDynamicBox.setAlignment(Pos.CENTER);

        Scene flightDynamicScene = new Scene(flightDynamicBox, 1300, 1200);
        setMode(flightDynamicScene);

        primaryStage.setScene(flightDynamicScene);
        primaryStage.show();
    }

    private void showCataloguePage(Stage primaryStage) {
        HBox dashboard = createDashboard(primaryStage);

        Button btnBack = new Button("Back");
        btnBack.setOnAction(event -> showMenu(primaryStage));

        DroneCatalogueView droneCatalogueView = new DroneCatalogueView();
        VBox catalogueBox = new VBox(10, dashboard, btnBack, droneCatalogueView.getView());
        catalogueBox.setPadding(new Insets(20));
        catalogueBox.setAlignment(Pos.CENTER);

        Scene catalogueScene = new Scene(catalogueBox, 1300, 1200);
        setMode(catalogueScene);

        primaryStage.setScene(catalogueScene);
        primaryStage.show();
    }

    private void showHistoryPage(Stage primaryStage) {
        HBox dashboard = createDashboard(primaryStage);

        Button btnBack = new Button("Back");
        btnBack.setOnAction(event -> showMenu(primaryStage));

        DroneHistoryView droneHistoryView = new DroneHistoryView();
        VBox historyBox = new VBox(10, dashboard, btnBack, droneHistoryView.getView());
        historyBox.setPadding(new Insets(20));
        historyBox.setAlignment(Pos.CENTER);

        Scene historyScene = new Scene(historyBox, 1300, 1200);
        setMode(historyScene);

        primaryStage.setScene(historyScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
