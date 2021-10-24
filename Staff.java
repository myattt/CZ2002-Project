
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
				System.out.println("(2)Booking");
				System.out.println("(3) Create Order");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter Customer ID");
					input1 = sc.nextInt();
					boolean exist = checkCustomerDetails(input1 , custlist);
					
					  if(exist) {
						  Customer customer = custlist.getCust(input1);
						  System.out.println(customer.getCustomerID());
					  }
					  else {
						  //Booking();
						  System.out.println("Customer not in system");
						  System.out.println("Enter Customer Name:");
						  String custName = sc.nextLine();
						  sc.nextLine();
						  System.out.println("Are you a member? Y/N");
						  char membership = sc.next().charAt(0);
						  System.out.println("Customer pax?");
						  int paxsize=sc.nextInt();
						  //will generate the suitable table size for customer -- if pax of 3 , suitable for table of 4,6,8,10
						  int tableSize = table_size(paxsize);
						  
						  
						  //finding if there are tables with sizes more than or equals to suitable size
						  //if yes, return tableId , else try again
						  
						  int tableId = tablelist.findSuitableTable(tableSize);
						  
						  if(tablelist.getNumEmptyTables()<=0 )
							  System.out.println("All tables are filled.. Please try again later");
						  
						  else if(tableId == -1)
							  System.out.println("Please try again");
						  
						  
						  else {
						  		if(membership =='y' || membership=='Y') {
						  				custlist.createCust(custName , -1 , true, paxsize);
						  		}
						  		else {
						  				custlist.createCust(custName , -1 , false, paxsize);
						  		}
						  		Customer customer = new Customer(custlist.getCListSize()); 
						  		int customerId = customer.getCustomerID();
						  		tablelist.assignTable(tableId+1 , customerId);
						  		tablelist.showAssignedTables();
						  		System.out.println("\n");
						  		tablelist.showEmptyTables();
						  		System.out.println("\n");
						  }
						  
						  loop=true;
					  }
					  
					break;
				case 2:
					createOrder();
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
	  private static int table_size(int paxsize) { 
		  int tableSize; 
		  switch(paxsize){ 
		  case 1,2: 
		   tableSize = 2; 
		   break; 
		  case 3,4: 
		   tableSize = 4; 
		   break; 
		  case 5,6: 
		   tableSize = 6; 
		   break; 
		  case 7,8: 
		   tableSize = 8; 
		   break; 
		  case 9,10: 
		   tableSize = 10; 
		   break; 
		  default: 
		   System.out.println("Size unknown."); 
		   tableSize=-1; 
		   break; 
		  } 
		  return tableSize; 
		 }
}
