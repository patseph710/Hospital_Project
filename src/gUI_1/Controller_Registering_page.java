package gUI_1;

import java.io.IOException;

import Package_data.User_bag;
import Package_data.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_Registering_page 
{
	
	
	@FXML
	public AnchorPane root;
	
	@FXML
	public TextField username_textfield;

	@FXML
	public PasswordField password_textfield;
	
	@FXML
	public PasswordField Confirm_password_textfield;
	@FXML
	public Text hidden_text;
	
	@FXML
	public Button register_btn;
	
	@FXML
	public Button back_btn;
	
	
	
	@FXML
	public void Register_page() throws IOException
	{
		User_bag bag=new User_bag();
		
		if(password_textfield.getText().equals(Confirm_password_textfield.getText()))
		{
	
			if(bag.user_is_unique(new user(username_textfield.getText(),password_textfield.getText()))==true)		//checks for another user with the same
			{																										//username
				
				
				bag.add(new user(username_textfield.getText(),password_textfield.getText()));

				//		Switches to Log in page
				Stage stage = (Stage) register_btn.getScene().getWindow();
				AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("MainScene.fxml"));
				Scene scene= new Scene(pane,600,600);
			    stage.setScene(scene);
			}
			else
			{
				hidden_text.setText("Please choose another username");
				hidden_text.setVisible(true);
			}
		}
		else
		{
			hidden_text.setText("Password does not match");
			hidden_text.setVisible(true);
		}

	}
	
	@FXML
	public void Go_back_page() throws IOException
	{

		//switch to previous page
		Stage stage = (Stage) register_btn.getScene().getWindow();
		AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene= new Scene(pane,stage.getScene().getWidth(),stage.getScene().getHeight());
	    stage.setScene(scene);
//		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
