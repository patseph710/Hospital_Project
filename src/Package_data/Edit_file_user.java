package Package_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Edit_file_user implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Edit_file_user() {}
	public void add_to_File(user newuser)
	{
		try 
		{	
			//read
			
			FileInputStream fi = new FileInputStream("userfile.txt");
			
			ObjectInputStream oi = new ObjectInputStream(fi);
		
			User_bag userbag = (User_bag) oi.readObject();

			userbag.listuser.add(newuser);
			oi.close();
			fi.close();
			
			//Write
			FileOutputStream f = new FileOutputStream("userfile.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(userbag);
		
			o.close();
			f.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e2) {
			System.out.println("Error initializing stream");
			e2.printStackTrace();
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
	
	
	}
	
	
	
	//will show all the usernames 
	//and passwords in binaryfile "usertxt"
	public String FiletoString()
	{
		String str="";
		try 
		{
			//read
			FileInputStream fi = new FileInputStream("userfile.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);
			User_bag userbag = (User_bag) oi.readObject();
			str=userbag.toString();
			oi.close();
			fi.close();
	
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e2) {
			System.out.println("Error initializing stream");
			e2.printStackTrace();
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
		return str;
		
	}
	
	
}
