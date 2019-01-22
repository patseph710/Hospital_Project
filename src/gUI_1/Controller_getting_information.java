package gUI_1;

import java.io.IOException;

import Package_data.Game;
import Package_data.Game_bag;
import Package_data.Temporary_content;
import Package_data.User_bag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller_getting_information 
{
	
	@FXML 
	public TextField id_num_textfield;
	@FXML 
	public TextField Code_num_textfield;
	
	@FXML 
	public Button Start_experiment_btn;
	
	@FXML 
	public Button back_btn;
	
	@FXML
	ChoiceBox<String> Game_choicebox;
	@FXML
	ChoiceBox<String> time_elapse_choicebox;
	
	@FXML
	private void initialize()
	{
		back_btn.setVisible(false);					//make it visible to use usernmane and log in page		
		
		Game_choicebox.setValue("2");
		Game_choicebox.setItems(FXCollections.observableArrayList("Game 1","Game 2","Game 3","Game 4"));
		time_elapse_choicebox.setItems(FXCollections.observableArrayList("2","20","30","60"));
	}

	@FXML
	public void Start_Experiment() throws IOException
	{	

		Temporary_content.set_game(new Game(Integer.parseInt(id_num_textfield.getText()),  //id_num
				Integer.parseInt( Code_num_textfield.getText()),						   //code_num
				Game_choicebox.getValue().toString(),									   //game_choice
				Integer.parseInt(time_elapse_choicebox.getValue().toString()),			   //time_elapsed
				User_bag.get_Time_and_Date()));											   //Date

		Temporary_content.get_game().set_total_time_elapsed(10*Integer.parseInt(time_elapse_choicebox.getValue().toString()));
			
	    Go_to("Experiment_page.fxml");
	   
	    
	    
	    
	    
	    
	}
	

	@FXML
	public void Go_back_page() throws IOException 
	{
		System.out.println("back pushed");
		Go_to("Experiment_page.fxml");
	}
	
	
	
	public void Go_to(String page) throws IOException
	{
		Stage stage = (Stage) back_btn.getScene().getWindow();
		AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource(page));
		Scene scene= new Scene(pane,stage.getScene().getWidth(),stage.getScene().getHeight());
	    stage.setScene(scene);		
	}
	
	
	
	
	
	
}
