package Package_data;

public class test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	
		User_bag bag=new User_bag();
		user newuser=new user("df","sdf");
		
		System.out.println(bag.is_in_userbag(newuser));
		
	}

}
