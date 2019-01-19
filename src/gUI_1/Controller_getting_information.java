package gUI_1;

import java.io.IOException;

import Package_data.User_bag;
import Package_data.keep_user_Object;
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
		
		
		keep_user_Object.get_user().set_Id_Num(Integer.parseInt(id_num_textfield.getText()));
		keep_user_Object.get_user().set_code_num(Integer.parseInt(Code_num_textfield.getText()));
	
		
		
		System.out.println("usernmae:"+keep_user_Object.get_user().get_username());
		System.out.println("id num:"+id_num_textfield.getText());
		System.out.println("code num:"+Code_num_textfield.getText());
		System.out.println("Game:"+Game_choicebox.getValue());
		System.out.println("Time elapse"+Integer.parseInt(time_elapse_choicebox.getValue()));
		
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
