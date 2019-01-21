package gUI_1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Package_data.Temporary_content;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.util.Duration;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_Experiment implements Initializable 
{


    private static final int STARTTIME = 0;
    private static int seconds;
    private static int minutes; 
    private Timeline timeline;
    private final IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    

    @FXML
    private Label timerLabel;
    @FXML
    private Button button;
	
	@FXML
	public ImageView Light_On_image;
	
	@FXML
	public ImageView Light_Off_image;

    private void updateTime() throws IOException 
    {
     	seconds--;
	    if (seconds<0){minutes-=1; seconds=59;}
	    if (minutes<0){minutes=59;seconds=59;}
	    
	 
		String minutesformatted = String.format("%02d", minutes);			
		String secondsformatted = String.format("%02d", seconds);
		
		timerLabel.setText(minutesformatted+":"+secondsformatted);

		if(minutes==0&&seconds==0)
	    {
			timeline.stop();
			Stage stage = (Stage) button.getScene().getWindow();
			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Trial_Pause_page.fxml"));
			Scene scene= new Scene(pane,600,600);
		    stage.setScene(scene);
			
	    }

        
    }

    
    //when button is clicked
    public void handle(ActionEvent event) {
		if (Light_Off_image.isVisible())
		{
			Light_Off_image.setVisible(false);
		}
		else
		{
			Light_Off_image.setVisible(true);
		}
		Temporary_content.get_game().setnum_btn_clicked(1+Temporary_content.get_game().getnum_btn_clicked());
		
		System.out.println(Temporary_content.get_game().getnum_btn_clicked());
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{

		seconds=Temporary_content.get_game().get_time_elapsed();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> {
			try {
				updateTime();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		})); 
        timeline.setCycleCount(Animation.INDEFINITE); 
        timeline.play();

	} 

    

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
