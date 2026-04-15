package vehiclerentalsystem.com;

public class vehicle {

private String vehicleId;
private double rentalRate;
private boolean isAvailable;
private int rentedDay;
private boolean underMaintenance;

public vehicle(String Id, double Rate) {
this.vehicleId = Id;
this.rentalRate = Rate;
this.isAvailable = true;
this.rentedDay = 0;
this.underMaintenance = false;
}

public boolean rent(customer customer, int no) {

	if(this.isAvailable)
	{
		double amount = rentalRate * no;

		System.out.println("Amount to pay:" + amount);

		if(paymentgateway.proceedpayment(amount))
		{
			this.isAvailable = false;
		    this.rentedDay = no;

			System.out.println("Vehicle rented successfully!");
			String msg=emailservices.sendconfirmationmail(customer,this,amount);
			receipt.generatereceipt(msg);
			return true;
		}
	}
	return false;
}

public void returnvehicle() {
	isAvailable = true;
	rentedDay = 0;
}

public void sendForMaintenance() {
	if(this.isAvailable)
	{
	underMaintenance = true;
	isAvailable = false;
	}
}

public void completeMiantenance() {
	if(this.underMaintenance) {
	underMaintenance = false;
	isAvailable = true;
	}
}

public String getVehicleId() {
return vehicleId;
}

public double getRentalRate() {
return rentalRate;
}

public boolean isAvailable() {
return isAvailable;
}

public int getRentedDay() {
	return rentedDay;
}

public void setRentedDay(int rentedDay) {
	this.rentedDay = rentedDay;
}

public boolean isUnderMaintenance() {
	return underMaintenance;
}

public void setUnderMaintenance(boolean underMaintenance) {
	this.underMaintenance = underMaintenance;
}

public void setVehicleId(String vehicleId) {
	this.vehicleId = vehicleId;
}

public void setRentalRate(double rentalRate) {
	this.rentalRate = rentalRate;
}

public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}


}