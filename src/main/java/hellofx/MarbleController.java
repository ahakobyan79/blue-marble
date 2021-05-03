package hellofx;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MarbleController {

	BlueMarble marble = new BlueMarble();
	
    @FXML
    private Button button;

    @FXML
    private DatePicker datePicker;
    
    @FXML
    private ImageView display;
    
    @FXML
    private Button bwButton;

    @FXML
    private Button enhancedBtn;

    
    LocalDate selectedDate = null;

    
    @FXML
    void blackAndWhite(ActionEvent event) {
    	
    	if(bwButton.getText().equals("Black & White")) {
        ColorAdjust desaturate = new ColorAdjust();
        desaturate.setSaturation(-1);
        display.setEffect(desaturate);
        bwButton.setText("Undo BW");
        } else {
        	display.setEffect(null);
        	bwButton.setText("Black & White");
        }
    }
    
    
    
    @FXML
    void buttonPressed(ActionEvent event) {
    	if(checkDate()) {
    		marble.setEnhanced(false);
    		marble.setDate(selectedDate.toString());
    		display.setImage(new Image(marble.getImage()));
    	}
    	
       }
    
    
    
    
    @FXML
    void dateSelected(ActionEvent event) {
    	selectedDate = datePicker.getValue();
    	checkDate();
    	display.setImage(new Image("hellofx/load.gif"));
    	
    }
    
    
    
    @FXML
    void makeEnhanced(ActionEvent event) {
    	marble.setEnhanced(true);
    	display.setImage(new Image(marble.getImage()));
    }
    
    

    
    private boolean checkDate() {
     	LocalDate date = selectedDate;
     	LocalDate enhanced = LocalDate.parse("2018-06-01");
    	LocalDate from = LocalDate.parse("2015-06-17");
    	LocalDate to = LocalDate.now().minusDays(1);
    	// If date is prior to 2018 June 1, set quality to enhanced.
    	if(date.compareTo(enhanced) < 0){
    		enhancedBtn.setDisable(false); // Enable Enhanced Version button
    	} else {
    		enhancedBtn.setDisable(true);  // Disable Enhanced Version button
    	}
    	// Check to make sure the selected date is between 2015-06-17 and now. Outside these dates no photos are available.
    	if(date.compareTo(from) > 0 && date.compareTo(to) < 0) {
    		return true;
    	} else {
    		JOptionPane.showMessageDialog(null, "WRONG DATE!\nPlease select between " + from.toString() +" and " + to.toString());
    		datePicker.getEditor().clear();
    		return false;
    	}
  
    }
    
    

    
    
}