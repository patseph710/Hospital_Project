package Package_data;

public class keep_user_Object 
{
	static private user user;
	public keep_user_Object(){}
	
	public static user get_user()
	{
		return user;
	}
	
	public static void set_userbag(user newuser)
	{
		User_bag bag=new User_bag();
		
		for(int i = 0; i < bag.getlistuser().size(); i++)
		{

			String this_user=bag.getlistuser().get(i).get_username();
			String this_password=bag.getlistuser().get(i).get_password();
			
			
			
			if(this_user.equals(newuser.get_username())
				&& this_password.equals(newuser.get_password()))
					{
					user=bag.getlistuser().get(i);
					
					}
        }
		

	}

}
