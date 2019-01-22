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
		
	String str="Game_Name  id_num  code_num time_elapsed Total_time_elapsed   Btn_clicked Date \n";
	
	for(int i = 0; i < listgame.size(); i++)
		{
 
			 str=str+ String.format("%.50s  %d  %d %.50s %.50s %d %.50s \n",
					listgame.get(i).get_game_name(),
			 		listgame.get(i).get_id_num(),						//id num
					 listgame.get(i).get_code_num(),					//code num
					 listgame.get(i).get_time_elapsed() , 				//TIME ELAPSED
			 		 listgame.get(i).get_total_time_elapsed(),			//TOTAL TIME ELAPSED
			 		 listgame.get(i).getnum_btn_clicked(),				//num btn clicked
			 		 listgame.get(i).get_date());						//date
			 
            
            }
		return str;
		
	}
	
	
	

}
