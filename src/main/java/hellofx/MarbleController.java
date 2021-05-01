package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;

public class MarbleController {

    @FXML
    private DatePicker datepick;

    @FXML
    private ImageView display;

    @FXML
    private Button button;

    @FXML
    void buttonPressed(ActionEvent event) {
    System.out.println("BUTTON PRESSED");
    }

    @FXML
    void dateChosen(ActionEvent event) {
        System.out.println("Date Selected: " + datepick.getValue());
    }

}
