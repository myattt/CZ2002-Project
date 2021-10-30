
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Staff {
	  private static String[] name = {"Harry", "Ron", "Hermione"};
	  private static String[] gender = {"M", "M", "F"};
	  private static int[] employeeID = {0,1,2};
	  private static String[] jobTitle = {"waiter", "waiter", "waitress"};
	  
	 
	  public static void main(String[] args){
			int choice;
			CustomerList custlist = new CustomerList();
			TableList tablelist= new TableList();
			Scanner sc = new Scanner(System.in);
			int input1;
			boolean loop=false;
			
			do{
			//print menu
				System.out.println("(1) Check Customer Information");
				System.out.println("(2) Create Order");
				System.out.println("(3) Add Order");
				System.out.println("(4) Remove Order");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter Customer ID");
					input1 = sc.nextInt();
					boolean exist = checkCustomerDetails(input1 , custlist);
	
				case 2:
					 if(exist) {
						 // returns customer object
						  Customer customer = custlist.getCust(input1);
						  createOrder();
						  //System.out.println(customer.getCustomerID());
					  }
					 else 
					 {
						// make booking 
					 }
					
					break;
				default:
					System.out.println("Try again");
					loop=true;
				}

				
			}while(loop);
			sc.close();
			
	  }
	  
	  public static boolean checkCustomerDetails(int cust_id , CustomerList cust_list){
		  boolean exist =cust_list.checkCustInfo(cust_id);
		  return exist;

	  }
	  
	  private static void createOrder() {
	    //Order o = new Order(1,2,3,4,5);
	    Random rand = new Random();
	    // Generate random integers in range 0 to 999
	    int rdint = rand.nextInt(3);
	    System.out.println("The staff who serves you is " + name[rdint] +", " + gender[rdint]+", "+jobTitle[rdint]);
	    System.out.println("Let's create your menu");
	    System.out.println();
	  }
}
