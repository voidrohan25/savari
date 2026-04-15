package vehiclerentalsystem.com;

import java.util.ArrayList;

public class inventory {

	ArrayList<vehicle> vehicle;

	public inventory()
	{
		this.vehicle=new ArrayList<>();
	}

	public void addvehicle(vehicle vehicle)
	{
		this.vehicle.add(vehicle);
	}

	public void removevehicle(vehicle v) {
	    vehicle.remove(v);
	}

	public ArrayList<vehicle> getallvehicle()
	{
		return vehicle;
	}

	public void showavailablevehicle(Class<?> type)
	{
	  System.out.println("--------------------"+type.getSimpleName()+"--------------------");
	   System.out.println("---------------------------------------------------------------");
	   System.out.println("           VEHICLE ID   ||      RATE      ||  AVAILABLE   ");
	   System.out.println("---------------------------------------------------------------");

	   for(vehicle veh:vehicle)
	   {
		   if(type.isInstance(veh) && veh.isAvailable())
		   {
			   System.out.println("|\t\t"+veh.getVehicleId()+"\t|\t"+veh.getRentalRate()+"\t|\t"+veh.isAvailable());
		   }
	   }
	}
}