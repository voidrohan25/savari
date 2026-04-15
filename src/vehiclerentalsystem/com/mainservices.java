package vehiclerentalsystem.com;

import java.util.ArrayList;
import java.util.Scanner;

public class mainservices {
	static Scanner sc = new Scanner(System.in);
	static inventory inventory = new inventory();

	public static void main(String[] args) {

		System.out.println("----------Welcome to Safari--------------");

	    initializevehicle();
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		System.out.println("Enter your choice:");
		int ch = sc.nextInt();

		switch (ch) {
		case 1 -> showadminmenu();
		case 2 -> showcustomermenu();
		default -> System.out.println("Invalid choice!");
		}
	}

	public static void initializevehicle()
	{
		inventory.addvehicle(new car("c100",5000,7));
		inventory.addvehicle(new bus("B700",7000,5));
		inventory.addvehicle(new bike("c200",500,true));
		inventory.addvehicle(new car("c400",4000,6));
		inventory.addvehicle(new bike("b200",8000,false));
		inventory.addvehicle(new bus("c500",50000,21));
	}

	public static void showadminmenu() {

		System.out.println("Enter Username:");
		String username = sc.next();

		System.out.println("Enter Password:");
		String password = sc.next();

		if (admin.authenticate(username, password)) {

			boolean flag = true;

			while (flag) {

				System.out.println("1.Add a vehicle");
				System.out.println("2.Remove a vehicle");
				System.out.println("3.send vehicle for maintanence");
				System.out.println("4.complete vehicle maintainance");
				System.out.println("5.Show all vehicles");
				System.out.println("6.exit");

				int ch = sc.nextInt();

				switch (ch) {

				case 1 -> {
					System.out.println("1.CAR");
					System.out.println("2.BUS");
					System.out.println("3.BIKE");

					int choice = sc.nextInt();

					System.out.println("Enter vehicle ID:");
					String id = sc.next();

					System.out.println("Enter Rental Rate:");
					double rate = sc.nextDouble();

					switch (choice) {
					case 1 -> {
						int no = sc.nextInt();
						inventory.addvehicle(new car(id, rate, no));
					}
					case 2 -> {
						int no = sc.nextInt();
						inventory.addvehicle(new bus(id, rate, no));
					}
					case 3 -> {
						String ha = sc.next();
						boolean hat = ha.equalsIgnoreCase("yes");
						inventory.addvehicle(new bike(id, rate, hat));
					}
					}
				}

				case 2 -> {
					String id = sc.next();
					vehicle v = findvehiclebyid(id);

					if(v != null)
					{
						inventory.removevehicle(v);
					}
				}

				case 3 -> {
					String id = sc.next();
					vehicle v = findvehiclebyid(id);

					if(v != null)
						v.sendForMaintenance();
				}

				case 4 -> {
					String id = sc.next();
					vehicle v = findvehiclebyid(id);

					if(v != null)
						v.completeMiantenance();
				}

				case 5 -> {
					ArrayList<vehicle> list = inventory.getallvehicle();

					for (vehicle v : list) {
						System.out.println(v.getVehicleId()+" "+v.getRentalRate()+" "+v.isAvailable());
					}
				}

				case 6 -> flag = false;
				}
			}
		}
	}

	private static vehicle findvehiclebyid(String id) {

	    ArrayList<vehicle> vehicle = inventory.getallvehicle();

	    for (vehicle v : vehicle) {
	        if (v.getVehicleId().equals(id)) {
	            return v;
	        }
	    }
	    return null;
	}

	public static void showcustomermenu() {

		System.out.println("Enter your name:");
		String name=sc.next();

		System.out.println("Enter your Email id:");
		String email=sc.next();

		System.out.println("Enter your phone no:");
		long no=sc.nextLong();

		System.out.println("License available:(Yes/no)");
		String la=sc.next();
		boolean ls=la.equalsIgnoreCase("yes");

		customer customer=new customer(name,email,no,ls );

		boolean f=true;

		while(f)
		{
			System.out.println("1.show available cars");
			System.out.println("2.show available bike");
			System.out.println("3.show available bus");
			
			System.out.println("4.Rent a Vehicle");
			System.out.println("5.Return rented vehicle");
			System.out.println("6.Show rented vehicle");
			System.out.println("7.Exit");
			System.out.println("Enter your choice:");

			int ch=sc.nextInt();

			switch(ch)
			{
			case 1->inventory.showavailablevehicle(car.class);
			case 2->inventory.showavailablevehicle(bike.class);
			case 3->inventory.showavailablevehicle(bus.class);

			case 4->{
				System.out.println("Enter Vehicle id:");
				String id=sc.next();
				System.out.println("Enter number of days:");
				int days=sc.nextInt();
				vehicle vehicle=findvehiclebyid(id);
				customer.rentvehicle(vehicle,days);
			}

			case 5->{
				System.out.println("Enter Vehicle id:");
				String id=sc.next();
				vehicle v=findvehiclebyid(id);
				if(v!=null){
					v.returnvehicle();
					System.out.println("Vehicle returned Successfully\nVisit Again.....");
				}
			}

			case 6->{
				customer.viewrentedvehicle();
			}

			case 7->f=false;
			}
		}
	}
}