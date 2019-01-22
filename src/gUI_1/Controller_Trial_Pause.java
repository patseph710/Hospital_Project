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
			Go_to("Experiment_page.fxml");

	    }
    }
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		seconds=5;
		Temporary_content.get_game().set_trial_num(
					Temporary_content.get_game().get_trial_num()+1);
		text1.setText("Trial "+Temporary_content.get_game().get_trial_num()+" Over");
	    timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> {
				try {
					updateTime();
				} catch (IOException e) {e.printStackTrace();}
			})); 
	    
	     timeline.setCycleCount(Animation.INDEFINITE); 
	     timeline.play();
	}
	
	
	
	public void Go_to(String page) throws IOException
	{
		Stage stage = (Stage) timerLabel.getScene().getWindow();
		AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource(page));
		Scene scene= new Scene(pane,stage.getScene().getWidth(),stage.getScene().getHeight());
	    stage.setScene(scene);		
	}
	
	


    
    
}
