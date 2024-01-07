
import java.util.*;

public class AdoptionClerk  extends Thread{
	public static long time = System.currentTimeMillis();
	public int clerkID;
	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"]"+getName()+":"+m);
	}
	public AdoptionClerk(int id) {
		clerkID = id;
	}
	public void run() {
//		openingTime();
// if roomn in store let customer in 
		while (! Main.isReady) {}
		if(Customer.numVisitors <= 3 && Customer.numVisitors >0) {
			Thread thread = Customer.adoptionQueue.remove(0);
			thread.interrupt();
			Customer.numVisitors--;
		}
		if(!Customer.adopt) {}
		removePet();
		
//        for(Thread customer: Main.cashiers){ //Wait for all customers to leave
//            try {
//                customer.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        msg("Clerk leaves!");
}
	public void removePet() {
		Customer.numPets--;
	}
}