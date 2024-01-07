import java.util.PriorityQueue;
import java.util.Random;
import java.util.Vector;

public class Customer extends Thread {
	private int customerNum;
	private Thread thread;
	private Vector<Thread> readyToLeave = new Vector<>();
	public static Vector<Customer> customerQueue= new Vector <Customer>();
	public static Vector<Customer> adoptionQueue = new Vector<Customer>();
	public static long time = System.currentTimeMillis();
	public static volatile boolean cashierIsReady = false;
	public static volatile int numVisitors;
	public static volatile int numPets = 12;
	public static volatile boolean allowedIn = true;
	public static volatile boolean adopt = false;
	AdoptionClerk clerk = new AdoptionClerk(1);
	Random random = new Random();
	
	public Customer(int num, AdoptionClerk clerk) {
	 this.customerNum = num;
	 this.clerk = clerk;
	 
	 
	}
	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"]"+getName()+":"+m);
	} 

	public  void run(){
		 comeToPetStore();
		 
		 }
	public void comeToPetStore() {
		Main.isReady = true;
	      try {
	         sleep(random.nextInt(1000)); // allow the customers to commute to the pet store in different ways
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	      msg("Enter the Happy Pet Store");
 	      int randomNum = random.nextInt(10) + 1;
	      if (randomNum < 4) {
	    	buyStuff();
	      }
	      else if(randomNum % 2 == 0) {
	    	  lookAtPets();
	      }
	      else {
	    	// first do shopping and maybe adopt a pet
	    	  buyStuff();
	    	  lookAtPets();
	    	  
	      }
	      // if done everything leave the store
	      msg("Customer leaving the store");
	}
	public void buyStuff() {
		// only buy food and toys so we will rush to get it done
        msg("Rushing to buy stuff");
		setPriority(Thread.MAX_PRIORITY);
        // Sleep for a random time -browse aisles
        try { 
			Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
        }
        msg("Browsing the aisles");
        // as soon as wakes up we set it back to normal priority
        setPriority(Thread.NORM_PRIORITY);
        customerQueue.add(this);
        while (!cashierIsReady) {
        	msg("Waiting at the cashier");
        }
        //customerQueue.remove(0);
        //msg("Customer being helped");
        
        
        
       }  
	public void lookAtPets() {
	     msg("Waiting to enter the room");
	     numVisitors++;
	     adoptionQueue.add(this);
			
			try {
	            Thread.sleep(random.nextInt(2000));
	        } catch (InterruptedException e) {
	        }
	        msg("Waiting to enter the area where pets are available");
	      
		msg("I've been allowed into the store!");
		msg("Checking pets in room");
		try {
	         sleep(random.nextInt(100)); // thread sleeps while browsing aisles
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
		
		if(numPets == 0)leave();
		int randomNumber = random.nextInt(10) + 1;
		if(randomNumber < 10 ) {
			Customer.adopt = true;

		}

		
		}
		
	
	
	public void leave() {
		this.yield();
		this.yield();
		readyToLeave.add(this);
		 
			
		}
	}
