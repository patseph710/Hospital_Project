package Package_data;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;



public class User_bag implements Serializable{

	private static final long serialVersionUID = 1L;
	Edit_file_user user_file=new Edit_file_user();	
	ArrayList<user> listuser=new ArrayList<user>();
	
	public User_bag(int i ) {}
	public User_bag() 
	{
		File file=new File("userfile.txt");
		//User_bag bag=new User_bag(2);
		if(file.exists()==false)
		{
		
			try 
			{	
				//write(creates new binary file) 
				FileOutputStream f = new FileOutputStream("userfile.txt");
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(new User_bag());
			
				o.close();
				f.close();
			} catch (FileNotFoundException e1) {
				System.out.println("File not found");
			} catch (IOException e2) {
				System.out.println("2.Error initializing stream");
				e2.printStackTrace();
			}
			
			
		}
	
		
		try 
		{
			//read
			FileInputStream fi = new FileInputStream("userfile.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);
			User_bag userbag = (User_bag) oi.readObject();
			this.listuser=userbag.listuser;
			oi.close();
			fi.close();
	
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e2) {
			System.out.println("1.Error initializing stream");
			e2.printStackTrace();
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
		
	}
	
	//will add newuser to ArrayList listuser
	//and will add newuser to the file user.txt  
	public void add(user newuser)
	{
		listuser.add(newuser);
	
		user_file.add_to_File(newuser);
	
	}
	public ArrayList<user> getlistuser()
	{
		return this.listuser;
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
	
	public boolean is_in_userbag(user newuser)
	{
		for(int i = 0; i < listuser.size(); i++)
		{

			String this_user=listuser.get(i).get_username();
			String this_password=listuser.get(i).get_password();
			listuser.get(i).set_index_num(i);
			
			
			if(this_user.equals(newuser.get_username())
				&& this_password.equals(newuser.get_password()))
					{
				
						return true;
					}
        }
	
		return false;	
	}
	
	public boolean user_is_unique(user newuser)
	{
		for(int i = 0; i < listuser.size(); i++)
		{

			String this_username=listuser.get(i).get_username();			
			if(this_username.equals(newuser.get_username()))				
						return false;		
        }
		return true;
	}
	
	
	


	//will show all the usernames and passwords in arraylist "userlist"
	@Override
	public String toString()
	{
		
		String str="";
		for(int i = 0; i < listuser.size(); i++)
		{
 
			 str=str+ String.format("Username:%.44s  Password:%.44s  Time:%.50s \n",
					 listuser.get(i).get_username(),
					 listuser.get(i).get_password(),
					 listuser.get(i).get_last_log_in() ); 
            
            }
		return str;
		
	}
	
	
	
	
}
