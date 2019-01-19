package gUI_1;

import java.io.IOException;

import Package_data.Game;
import Package_data.Game_bag;
import Package_data.Temporary_content;
import Package_data.User_bag;

import Package_data.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Controller {
	@FXML
	public AnchorPane root;
	@FXML
	public TextField username_textfield;

	@FXML
	public TextField password_textfield;
	@FXML
	public TextArea text_area;
	@FXML
	public Button Log_in_btn;
	
	@FXML
	public Button register_btn;
	
	@FXML
	public Text hidden_text;
	
	@FXML
	public void Log_in(ActionEvent event) throws IOException, InterruptedException
	{
	
		User_bag userbag=new User_bag();
		Game_bag gamebag=new Game_bag();
		
		//log in successful
		user newuser=new user(username_textfield.getText(),password_textfield.getText());
//		if(bag.is_in_userbag(new user(username_textfield.getText(),password_textfield.getText()))==true
//			&& !username_textfield.getText().equals(""))
		
		if(userbag.is_in_userbag(newuser)==true)
		{
			Temporary_content.set_user(newuser);
			
			
			
			
			
			
			Temporary_content.set_user(newuser);
			Stage stage = (Stage) Log_in_btn.getScene().getWindow();
			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("getting_information.fxml"));
			Scene scene= new Scene(pane,600,400);
		    stage.setScene(scene);
			
			
			
		}
		//log in unsuccessful
		else
		{
			Thread.sleep(500);
		
			hidden_text.setVisible(true);
			
		}
	
	}
	
	@FXML
	public void Register_page() throws IOException
	{
		Stage stage = (Stage) Log_in_btn.getScene().getWindow();
		AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Registering_page.fxml"));
		Scene scene= new Scene(pane,500,500);
	    stage.setScene(scene);
	}
}
