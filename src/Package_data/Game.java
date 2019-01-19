package Package_data;

import java.io.Serializable;

public class Game implements Serializable 
{

	private static final long serialVersionUID = 1L;
	private int line_num;
	private int id_num;
	private int code_num;
	private String time_elapsed;
	private String total_time_elapsed;
	private String Date;
	private String Game_name;
	
	public Game(int id_num,int code_num,String Game_name,
				String time_elapsed,String Date )
	{
		this.id_num=id_num;
		this.code_num=code_num;
		this.time_elapsed=time_elapsed;
		this.Game_name=Game_name;
		
		this.Date=Date;
	}
	
	
	
	
	public int get_id_num()
	{
		return this.id_num;
	}
	
	public void set_id_num(int id_num)
	{
		this.id_num=id_num;
	}
	
	public String get_date()
	{
		return this.Date;
	}
	
	public void set_date(String Date)
	{
		this.Date=Date;
	}
	
	public String get_total_time_elapsed()
	{
		return this.total_time_elapsed;
	}
	
	public void set_total_time_elapsed(String total_time_elapsed)
	{
		this.total_time_elapsed=total_time_elapsed;
	}
	
	
	
	public String get_time_elapsed()
	{
		return this.time_elapsed;
	}
	
	public void set_time_elapsed(String time_elapsed)
	{
		this.time_elapsed=time_elapsed;
	}
	
	public int get_code_num()
	{
		return this.code_num;
	}
	
	public void set_code_num(int code_num)
	{
		this.code_num=code_num;
	}
	
	public int get_line_num()
	{
		return this.line_num;
	}
	
	public void set_line_num(int line_num)
	{
		this.line_num=line_num;
	}
	
	
	public String get_game_name()
	{
		return this.Game_name;
	}
	
	public void set_game_name(String Game_name)
	{
		this.Game_name=Game_name;
	}
	
	
	
	
}
