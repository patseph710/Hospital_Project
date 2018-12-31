package Package_data;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User_bag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Edit_file_user user_file=new Edit_file_user();	
	ArrayList<user> listuser=new ArrayList<user>();
	public User_bag() {}
	
	
	
	//will add newuser to ArrayList listuser
	//and will add newuser to the file user.txt  
	public void add(user newuser)
	{
		listuser.add(newuser);
	
		user_file.add_to_File(newuser);
	
	}
	public String FiletoString()
	{
		return user_file.FiletoString();
	}
	
	static public String get_Time_and_Date()
	{

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
		String now_time=formatter.format(date);
		return now_time;
	}
	



	//will show all the usernames and passwords in arraylist "userlist"
	@Override
	public String toString()
	{
		
		String str="";
		for(int i = 0; i < listuser.size(); i++)
		{
//            str=str+(i+1)+". Username:"+listuser.get(i).get_username()+
//            			  " Password:"+listuser.get(i).get_password()+
//            			  "         Time:"+listuser.get(i).get_last_log_in()+"\n";  	
            
			 str=str+ String.format("Username:%.44s  Password:%.44s  Time:%.50s \n",listuser.get(i).get_username(),listuser.get(i).get_Password(),
					 listuser.get(i).get_last_log_in() ); 
            
            
            
            
            
            
            }
		return str;
		
	}
	
	
	
	
}
