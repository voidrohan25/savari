package vehiclerentalsystem.com;

public class admin {

	
	final private static String username="admin";
	final  private static String password="admin@123";
	
		
	
	public static boolean authenticate(String username2, String password2) {
		if(username.equals(username2)&&password.equals(password2))
		{
			return true;
		}
		
		return false;
	}
}
