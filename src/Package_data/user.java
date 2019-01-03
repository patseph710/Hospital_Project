package Package_data;

import java.io.Serializable;

public class user implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String last_log_in;
	
	
	//0=user 1=physcician
	
	public user(String username,String Password)
	{
		this.username=username;
		this.password=Password;
		this.last_log_in=User_bag.get_Time_and_Date();
	}
	
	public String get_password()
	{
		return this.password;
	}
	
	public String get_last_log_in()
	{
		return this.last_log_in;
	}
	public void update_last_log_in()
	{
		this.last_log_in=User_bag.get_Time_and_Date();
	}

	public String get_username()
	{
		return this.username;
		
	}
	

	

}
