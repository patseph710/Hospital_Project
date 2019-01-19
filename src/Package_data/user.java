package Package_data;

import java.io.Serializable;

public class user implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int id_num;
	private int code_num;
	private int index_num;
	
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
	
	public void set_Id_Num(int id_num)
	{
		this.id_num=id_num;
	}
	
	public int get_Id_Num()
	{
		return this.id_num;
	}
	
	public void set_code_num(int code_num)
	{
		this.code_num=code_num;
	}
	
	public int get_code_num()
	{
		return this.code_num;
	}
	
	public void set_index_num(int new_indexnum)
	{
		this.index_num=new_indexnum;
	}
	public int get_index_num()
	{
		return this.index_num;
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
