package Package_data;

import java.io.Serializable;

public class Game implements Serializable 
{

	private static final long serialVersionUID = 1L;
	private int line_num,id_num,code_num,time_elapsed;
	private String Date;
	private int num_btn_clicked=0;
	private String Game_name;
	private int minutes,seconds,trial_num;
	
	public Game(int id_num,int code_num,String Game_name,
				int time_elapsed,String Date )
	{
		this.id_num=id_num;
		this.code_num=code_num;
		this.time_elapsed=time_elapsed;
		this.Game_name=Game_name;
		
		this.Date=Date;
	}
	
	public int get_trial_num()
	{
		return this.trial_num;
	}
	
	public void set_trial_num(int _trial_num)
	{
		this.trial_num=_trial_num;
	}
	
	
	public int getnum_btn_clicked()
	{
		return this.num_btn_clicked;
	}
	
	public void setnum_btn_clicked(int num_btn_clicked)
	{
		this.num_btn_clicked=num_btn_clicked;
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
		String minutesformatted = String.format("%02d", minutes);			
		String secondsformatted = String.format("%02d", seconds);
		return (minutesformatted+":"+secondsformatted);
	}
	
	public void set_total_time_elapsed(int total_time_in_seconds)
	{
		//seconds to minutes
		 minutes= total_time_in_seconds/60;
		double s=total_time_in_seconds/60.0 -minutes;
		s=s*60;
		 seconds=(int) s;
	}

	public int get_time_elapsed()
	{
		return this.time_elapsed;
	}
	
	public void set_time_elapsed(int time_elapsed)
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
