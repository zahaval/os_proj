import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
public class Main {
	public static Customer[] totalCustomers;
	public static Cashier[] cashiers;
	public static volatile boolean cashierReady = false;
	public static boolean emptyStore = true;
	public static Random random = new Random();
	public static volatile int numVisitors;

	public static volatile boolean isReady = false;
	public static void main(String[] args) {
	
		totalCustomers = new Customer[20];
		AdoptionClerk clerkMan = new AdoptionClerk(1);
		
	    cashiers = new Cashier[3];
		for (int i = 0; i < 20; i++) {
			
			Customer customer = new Customer(i, clerkMan);
			totalCustomers[i] = customer;
		}
		for(int i = 0; i < 3; i++){
			Cashier cashier = new Cashier(i);
			cashiers[i] = cashier;
				
			cashierReady = true;
			emptyStore = false;
			}
		
		//start the customers

		
		//start the cashiers
		for(int i = 0; i < 3; i++) {
			cashiers[i].start();
		}
		
		//start the clerk
		
		clerkMan.start();
		for (int i = 0; i < 20; i++) {
			totalCustomers[i].start();
		}
	}

	
	
}
