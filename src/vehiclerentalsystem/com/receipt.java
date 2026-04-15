package vehiclerentalsystem.com;

public class receipt {
	public static void generatereceipt( String msg)
	{
		System.out.println("Generating Receipt........(Please wait)");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
	}
}