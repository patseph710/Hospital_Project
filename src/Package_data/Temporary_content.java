package Package_data;

public class Temporary_content
{
	static user temporary_user;
	static Game temporary_game;
	
	
	
	public static void  set_user(user temporary_user)
	{
	 Temporary_content.temporary_user=temporary_user;	
	}
	
	public static void set_game(Game temporary_game)
	{
		Temporary_content.temporary_game=temporary_game;	
	}
	
	

	
	
	
	public static user get_user()
	{
		return Temporary_content.temporary_user; 
	}
	public static Game get_game()
	{
		return Temporary_content.temporary_game;
	}
	

}
