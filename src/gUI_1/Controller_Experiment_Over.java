package gUI_1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

public class Controller_Experiment_Over implements Initializable{

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Text text1;
    @FXML
    private Slider slider;
    @FXML
    private Text text2;
    @FXML
    private Text slider_choice_num;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//slidernumber
		slider.valueProperty().addListener(new ChangeListener<Number>() 
		{
			 
	         @Override
	         public void changed(ObservableValue<? extends Number> observable, //
	               Number oldValue, Number newValue) 
	         {
	        	 slider_choice_num.setText( Integer.toString(newValue.intValue()));
	        	 
	         }
	      });
		
		
	}
	
}
