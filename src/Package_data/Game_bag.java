package Package_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Game_bag implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Game> listgame=new ArrayList<Game>();
	Edit_file_game game_file=new Edit_file_game();
	
	public Game_bag() 
	{
		File file=new File("gamefile.txt");
		if(file.exists()==false)
		{
			try 
			{	
				//write(creates new binary file) 
				FileOutputStream f = new FileOutputStream("gamefile.txt");
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(new Game_bag());
			
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
			FileInputStream fi = new FileInputStream("gamefile.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);
			Game_bag userbag = (Game_bag) oi.readObject();
			this.listgame=userbag.listgame;
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

	public void add(Game newgame)
	{
		listgame.add(newgame);
		game_file.add_to_file(newgame);
	}
	
	public ArrayList<Game>  get_listgame()
	{
		return this.listgame;
	}
	
	@Override
	public String toString()
	{
		
		String str="";
		for(int i = 0; i < listgame.size(); i++)
		{
 
			 str=str+ String.format("id_num:%d  code_num:%d time_elapsed:%.50s Total_time_elapsed:%.50s Date:%.50s  \n",
					 listgame.get(i).get_id_num(),
					 listgame.get(i).get_code_num(),
					 listgame.get(i).get_time_elapsed() , 
			 		 listgame.get(i).get_total_time_elapsed(),
			 		 listgame.get(i).get_date());
            
            }
		return str;
		
	}
	
	
	

}
