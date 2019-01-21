package gUI_1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Package_data.Temporary_content;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller_Trial_Pause implements Initializable 
{
    private static int seconds;
    private static int minutes; 
    private Timeline timeline;
    @FXML
    private Label timerLabel;
    @FXML
    public Text text1;
    @FXML
    public Text text2;
    
    @FXML
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
			Stage stage = (Stage) timerLabel.getScene().getWindow();
			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Experiment_page.fxml"));
			Scene scene= new Scene(pane,600,600);
		    stage.setScene(scene);
			
	    }

        
    }
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		Temporary_content.get_game().set_trial_num(
				Temporary_content.get_game().get_trial_num()+1);
		
		text1.setText("Trial "+Temporary_content.get_game().get_trial_num()+" Over");
		
		seconds=5;
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
