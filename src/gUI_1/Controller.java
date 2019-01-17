package gUI_1;

import Package_data.User_bag;
import Package_data.user;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {
	@FXML
	public TextField username_textfield;

	@FXML
	public TextField password_textfield;
	
	@FXML
	public Button Log_in_btn;
	
	@FXML
	public Button register_btn;
	
	@FXML
	public void Log_in()
	{
		User_bag bag=new User_bag();
		//log in successful
		if(bag.is_in_userbag(new user(username_textfield.getText(),password_textfield.getText()))==true)
		{
			
		}
		//log in unsuccessful
		else
		{
			
		}
	
	}
	
	@FXML
	public void Register()
	{
		 PopOver popOver = new PopOver();
	}
}
