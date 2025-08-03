package CarRentalSystem;

import java.util.*;

abstract class Car{
	private String ID;
	private String BrandName;
	private String modelNo;
	private double rate;
	private String phoneNumber;
	private boolean isAvailable = true;

	public Car(String ID, String BrandName, String modelNo, double rate) {
		this.ID = ID;
		this.BrandName = BrandName;
		this.modelNo = modelNo;
		this.rate = rate;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	abstract void userDetails();
	abstract void emailId();
	
}
class user extends Car{
	private String name;
    private String email;
    private int days;

    public user(String id, String brand, String model, double rate) {
        super(id, brand, model, rate);
    }

    @Override
    void userDetails() {
        
    }

    @Override
    void emailId() {
        
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public String getUserName() {
        return name;
    }
	public void printBill() {
		    System.out.println("\n===== CAR RENTAL BILL =====");
	        System.out.println("Name: " + name);
	        System.out.println("Email: " + email);
	        System.out.println("Phone: " + getPhoneNumber());
	        System.out.println("Car ID: " + getID());
	        System.out.println("Brand: " + getBrandName());
	        System.out.println("Model: " + getModelNo());
	        System.out.println("Rate per Day: ₹" + getRate());
	        System.out.println("Rental Days: " + days);
	        System.out.println("Total Amount: ₹" + (getRate() * days));
	        System.out.println("\nNB: This bill is important for car return.");
	        System.out.println("Thank you, " + name + ". Have a nice day!");
	}

	
	
}
public class CarRentalBilling {

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
	        List<user> carList = new ArrayList<>();

	        carList.add(new user("C001", "Toyota", "Innova", 2500));
	        carList.add(new user("C002", "Hyundai", "i20", 1800));
	        carList.add(new user("C003", "Honda", "City", 2200));
	        carList.add(new user("C004", "Maruti", "Swift", 1600));
	        carList.add(new user("C005", "Ford", "Ecosport", 2100));
	        carList.add(new user("C006", "Kia", "Seltos", 2300));
	        carList.add(new user("C007", "Tata", "Harrier", 2400));
	        carList.add(new user("C008", "Mahindra", "XUV300", 2000));
	        carList.add(new user("C009", "Renault", "Kiger", 1700));
	        carList.add(new user("C010", "Nissan", "Magnite", 1750));
	        carList.add(new user("C011", "Volkswagen", "Polo", 1850));
	        carList.add(new user("C012", "Skoda", "Slavia", 1950));
	        carList.add(new user("C013", "Jeep", "Compass", 2600));
	        carList.add(new user("C014", "MG", "Hector", 2500));
	        carList.add(new user("C015", "BMW", "X1", 4500));
	        carList.add(new user("C016", "Mercedes", "A-Class", 5500));

	        System.out.println("===== Welcome to Car Rental Service =====");
	        System.out.print("Enter Your Full Name: ");
	        String customerName = sc.nextLine();

	        System.out.print("Enter Phone Number: ");
	        String phone = sc.nextLine();
	        System.out.print("Enter Email ID: ");
	        String email = sc.nextLine();

	        System.out.println("\nAvailable Cars:");
	        for (int i = 0; i < carList.size(); i++) {
	            user c = carList.get(i);
	            System.out.println((i + 1) + ". " + c.getBrandName() + " - " + c.getModelNo()
	                    + " | Rate/Day: ₹" + c.getRate() + " | Car ID: " + c.getID());
	        }

	        System.out.print("\nEnter the number of the car you want to rent (1 to " + carList.size() + "): ");
	        int choice = sc.nextInt();
	        sc.nextLine();

	        if (choice < 1 || choice > carList.size()) {
	            System.out.println("Invalid selection.");
	            return;
	        }

	        user selectedCar = carList.get(choice - 1);
	        selectedCar.setAvailable(false);
	        selectedCar.setPhoneNumber(phone);
	        selectedCar.setName(customerName); 
	        selectedCar.setEmail(email);        
	        selectedCar.emailId();
	        selectedCar.userDetails();

	        
	        // Rental days
	        System.out.print("Enter number of rental days: ");
	        int days = sc.nextInt();
	        selectedCar.setDays(days);

	        selectedCar.printBill();

	        // Payment confirmation
	        sc.nextLine();
	        System.out.print("Do you want to proceed with payment? (yes/no): ");
	        String payment = sc.nextLine();

	        if (payment.equalsIgnoreCase("yes")) {
	            System.out.println("\nPayment Successful!");
	            System.out.println("Thank you, " + customerName + ". Have a nice day!");
	        } else {
	            System.out.println("Payment Cancelled. Booking not confirmed.");
	        }
	}

}
