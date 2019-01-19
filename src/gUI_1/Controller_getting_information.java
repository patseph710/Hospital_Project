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
		Game_choicebox.setValue("02 seconds");
		Game_choicebox.setItems(FXCollections.observableArrayList("Game 1","Game 2","Game 3","Game 4"));
		time_elapse_choicebox.setItems(FXCollections.observableArrayList("2","20","30","60"));
	}


	
	
	
	
	
	@FXML
	public void Start_Experiment()
	{	
		System.out.println("username:"+Temporary_content.get_user().get_username());
		

		
		Game newgame=new Game(Integer.parseInt(id_num_textfield.getText()),
				Integer.parseInt( Code_num_textfield.getText()),
				Game_choicebox.getValue().toString()
				,time_elapse_choicebox.getValue().toString(),
				User_bag.get_Time_and_Date());
			
		
		Temporary_content.set_game(newgame);
			
		
		
		
		
		
		System.out.println("id num:"+Temporary_content.get_game().get_id_num());
		System.out.println("code num:"+Temporary_content.get_game().get_code_num());
		System.out.println("Game:"+Temporary_content.get_game().get_game_name());
		System.out.println("Time elapse:"+Temporary_content.get_game().get_time_elapsed());
		System.out.println("Date:"+Temporary_content.get_game().get_date());
		
	}
	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	@FXML
	public void Go_back_page() throws IOException
	{
		Stage stage = (Stage) back_btn.getScene().getWindow();
		AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("MainScene.fxml"));
//		root.getChildren().setAll(pane);
		Scene scene= new Scene(pane,stage.getScene().getWidth(),stage.getScene().getHeight());
	    stage.setScene(scene);
//		
	}
}
