import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.InputStream;


public class CustomButton extends Button {

    private static final String ICON_BUTTON_STYLE_CLASS = "icon-button";
    private final String text;
    private final String iconName;

    /**
     * Constructs an XButton with the specified text and icon.
     *
     * @param text     The text to display on the button.
     * @param iconName The name of the icon file in the "/icons/" directory.
     * @see #initializeButton()
     */
    public CustomButton(final String text, final String iconName) {
        this.text = text;
        this.iconName = iconName;
        initializeButton();
    }

    /**
     * Initializes the button with the provided text and icon.
     * If the icon resource is not found, it logs an error.
     */
    private void initializeButton() {
        try {
            String iconPath = "/icons/" + iconName;
            InputStream iconStream = CustomButton.class.getResourceAsStream(iconPath);
            if (iconStream != null) {
                Image iconImage = new Image(iconStream);
                ImageView icon = new ImageView(iconImage);
                setGraphic(icon);
                icon.setFitHeight(18);
                icon.setFitWidth(18);
            } else {
                System.out.println("Error initializing Button. Text: " + text + ", IconName: " + iconName + " Error: Icon resource not found");
            }
            setText(text);

            getStyleClass().addAll(ICON_BUTTON_STYLE_CLASS);
        } catch (Exception e) {
            System.out.println("Error occurred in  XButton.initializeButton() : " + e.getMessage());
        }
    }

}