package gUI_1;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
