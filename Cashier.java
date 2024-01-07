import java.util.*;

public class Cashier extends Thread {
	public static long time = System.currentTimeMillis();	
	public int cashierID;
	Random random = new Random();
	public Cashier(int cashier) {
		cashierID = cashier;
	}


	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"]"+getName()+":"+m);
	}
	
	
	public void run() {
		while (! Main.isReady) {}
		Customer.cashierIsReady = true;

		if(!Customer.customerQueue.isEmpty()){// assist customers in fcfs
		Customer.customerQueue.remove(0);
		msg("Customer being helped");
		}
		
//        for(Thread  customer: Main.totalCustomers){
//		//Wait for all customers to leave
//        	
//            try {
//                customer.join();
//            } catch (InterruptedException e) {
//                //e.printStackTrace();
//            }
//        }
//        msg("Cashier leaving");
	}
	}
	
