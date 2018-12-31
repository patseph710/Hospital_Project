package Package_data;

public class test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		user newuser=new user("qqqqq", "wwwww");
		User_bag bag=new User_bag();
		//user a=new user("new","stuff");
		bag.add(newuser);

		System.out.println(""+bag.FiletoString());
	
		
		
		
	}

}
