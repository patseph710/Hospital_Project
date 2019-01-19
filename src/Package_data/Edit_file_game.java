package Package_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Edit_file_game implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Edit_file_game() {}
	
	public void add_to_file(Game newgame) 
	{

		try 
		{	
			//read
			
			FileInputStream fi = new FileInputStream("gamefile.txt");
			
			ObjectInputStream oi = new ObjectInputStream(fi);
		
			Game_bag gamebag = (Game_bag) oi.readObject();

			gamebag.listgame.add(newgame);
			oi.close();
			fi.close();
			
			//Write
			FileOutputStream f = new FileOutputStream("gamefile.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(gamebag);
		
			o.close();
			f.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e2) {
			System.out.println("Edit_FIle_game");
			e2.printStackTrace();
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
		
		
		
	}
	
	public String FiletoString()
	{
		String str="";
		try 
		{
			//read
			FileInputStream fi = new FileInputStream("gamefile.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);
			Game_bag userbag = (Game_bag) oi.readObject();
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
