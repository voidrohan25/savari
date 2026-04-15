package vehiclerentalsystem.com;

import java.util.Scanner;

public class paymentgateway {
	static Scanner sc=new Scanner(System.in);

	public static boolean proceedpayment(double amount)
	{
		System.out.println("Enter amount to pay:");
		double am=sc.nextDouble();

		if(am >= amount)
		{
			System.out.println("Transaction complete!");
			return true;
		}
		else {
			System.out.println("Transaction incomplete!");
			System.out.println("Please pay remaining amount:"+(amount-am));
			return false;
		}
	}
}