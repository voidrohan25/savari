package vehiclerentalsystem.com;

import java.util.ArrayList;

public class customer {

	private String name;
	private long mobile;
	private String email;
	private boolean islicense;
	private ArrayList<vehicle> rentedvehicles;

	public customer(String name,long mobile,String email,boolean islicense,ArrayList<vehicle> rentedvehicles)
	{
		this.email=email;
		this.islicense=islicense;
		this.name=name;
		this.mobile=mobile;
		this.rentedvehicles= new ArrayList<>();
	}

	public customer(String name, String email, long no, boolean ls) {
		this.name = name;
		this.email = email;
		this.mobile = no;
		this.islicense = ls;
		this.rentedvehicles = new ArrayList<vehicle>();
	}

	public void rentvehicle(vehicle vehicle, int no) {
		if( vehicle.isAvailable())
		{
			if(vehicle.rent(this, no))
			{
				System.out.println("Process complete!");
				this.rentedvehicles.add(vehicle);
			}
			else {
				System.out.println("Process incomplete!");
			}
		}
		else {
			System.out.println("Vehicle not available");
		}
	}

	public void viewrentedvehicle() {
		System.out.println("\t\tCustomer name:"+this.name);
		System.out.println("--------------------Rented List--------------------");
		System.out.println("---------------------------------------------------------------");
		System.out.println("           VEHICLE ID   ||      RATE      ||  AVAILABLE   ");
		System.out.println("---------------------------------------------------------------");

		for(vehicle veh:rentedvehicles)
		{
			System.out.println("|\t\t"+veh.getVehicleId()+"\t|\t"+veh.getRentalRate()+"\t|\t"+veh.isAvailable());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIslicense() {
		return islicense;
	}

	public void setIslicense(boolean islicense) {
		this.islicense = islicense;
	}

	public ArrayList<vehicle> getRentedvehicles() {
		return rentedvehicles;
	}

	public void setRentedvehicles(ArrayList<vehicle> rentedvehicles) {
		this.rentedvehicles = rentedvehicles;
	}
	
}