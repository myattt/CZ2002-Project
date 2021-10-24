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
			int input1 , input2;
			boolean loop=false;
			
			do{
			//print menu
				System.out.println("(1) Check Customer Information");
				System.out.println("(2) Create Order");
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
						  System.out.println("Enter Customer Name:");
						  String custName = sc.nextLine();
						  sc.nextLine();
						  System.out.println("Are you a member? Y/N");
						  char membership = sc.next().charAt(0);
						  System.out.println("Customer pax?");
						  int paxsize=sc.nextInt();
						  
						  
						  
						  
						  			if(membership =='y' || membership=='Y') {
						  					custlist.createCust(custName , -1 , true,paxsize);
						  			}
						  			else {
						  					custlist.createCust(custName , -1 , false,paxsize);
						  			}
						  			Customer customer = new Customer(custlist.getCListSize()); 
						  			int customerId = customer.getCustomerID();
						 
						
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
		   paxsize=0; 
		   System.out.println("Size unknown. Please try again!"); 
		   tableSize=-1; 
		   break; 
		  } 
		  return tableSize; 
		 }
