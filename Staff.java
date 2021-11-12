import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Staff {
	  public static String[] name = new String[4];
	  public static String[] gender = new String[4];
	  public static int[] employeeID = new int[4];
	  public static String[] jobTitle = new String[4];
	  public static String[] alaorder;
	  public static Integer[] bundleorder;
	  
	  public static ArrayList<String> ala;
	  public static ArrayList<Integer> bundle;
	  

	  public static void main(CustomerList custlist , TableList tablelist ) {
		  
		  	Customer cust = MakeOrder(custlist , tablelist);
		  	if(cust==null) {
		  		System.out.println("Error");
		  		return;
		  	}
			Scanner sc = new Scanner(System.in);
			Order o = new Order();
			o.startOrder();
			int op=0;
			int staff_id = staffInfo();
			cust.setStaffinfo(name[staff_id], gender[staff_id], jobTitle[staff_id] , employeeID[staff_id]);
			System.out.println("The staff who serves you is " + name[staff_id] +", Staff ID:" + employeeID[staff_id] +", Position:"+ jobTitle[staff_id]);
			do{
			
				boolean error=true;
				while(error) {
					System.out.println("Please select an option");
					System.out.println("+---+------------------------------------+");
					System.out.println("| 1 |  View Menu                         |");
					System.out.println("| 2 |  Add Ala_Carte Item                |");
					System.out.println("| 3 |  Add Bundle                        |");
					System.out.println("| 4 |  Remove Ala_Carte Item             |");
					System.out.println("| 5 |  Remove Bundle                     |");
					System.out.println("| 6 |  View order                        |");
					System.out.println("| 0 |  Quit                              |");
					System.out.println("+---+------------------------------------+");
			         try {
			            op = sc.nextInt();
			            error=false;
			          }
			          catch (Exception e){
			        	  System.out.println("User input was not a number.\n");
			        	  sc.next();
			          }
				}
				if(op == 1){
					o.viewMenu();
				}else if(op == 2){
					o.addalaItem();
				}else if(op == 3){
					o.addbundleItem();
				}else if(op == 4){
					o.removealaItem();
				}else if(op == 5){
					o.removebundleItem();
				}
				else if(op == 6){
					o.viewOrder();
				}
			}while(op  != 0);
			

				ala=o.getAlaOrder();
				
				alaorder =ala.toArray(new String[ala.size()]);
		
				bundle=o.getBundleOrder();
				bundleorder=bundle.toArray(new Integer[bundle.size()]);
				
				cust.setAlaOrder(alaorder);
				cust.setBundleOrder(bundleorder);
				
				OrderInvoice invoice=new OrderInvoice();
				invoice.printInvoice(cust.getCustomerID() , custlist);
				tablelist.unAssignSeat(cust.getTableId());
	  }
	  
	 
	  public static int staffInfo() {
	    Random rand = new Random();
	    int rdint = rand.nextInt(3);
	    return rdint;
	  }
	  
	  /**
	   * Order Interface that returns Customer
	   * @param custlist :
	   * @param tablelist
	   * @return Customer
	   */
	  private static Customer MakeOrder(CustomerList custlist , TableList tablelist) {
			boolean val=false;
			do {
			System.out.println(
					"+--------------------------------------+");
			System.out.println(
					"|           Order Interface            |");
			System.out.println(
					"+---+----------------------------------+");
			System.out.println(
					"| 1 | Walk In Order                    |");
			System.out.println(
					"| 2 | Customer with Reservation        |");
			System.out.println(
					"| 0 | Quit                             |");
			System.out.println(
					"+--------------------------------------+");
			

			Scanner sc = new Scanner(System.in);
			int choice=0;
			boolean error = true;

			while(error) {
				System.out.println("Please select an option");
		         try {
		        	choice=sc.nextInt();
		        	if(choice==0)
		        		return null;
		        	else if(choice<0 || choice>2) {
						System.out.println("Invalid number try again!");
						continue;
					}
		            error=false;
		          }
		          catch (Exception e){
		        	  System.out.println("Input was not a number.");
		        	  sc.next();
		          }
			}
				switch(choice) {
				case 1:
					Customer customer =walkIns(custlist, tablelist);
					return customer;
				case 2:
					System.out.println("Enter Customer ID");
					int input1 = sc.nextInt();
					boolean exist = UI.checkCustomerDetails(input1 , custlist);
					if (exist) {
						Customer cust= custlist.getCust(input1);
						boolean expire = UI.checkPeriodExpiry(input1,custlist , tablelist);
						if(expire == false && cust.getAlaOrder()==null && cust.getBundleOrder()==null){
							return cust;
						//System.out.println("***Current Customers and Order***");
						//custlist.printList();
						}
						else {
							System.out.println("Your reservation period has expired, please book again or try Walking In");
							val=true;
						}
					}
					else {
						System.out.println("Please make a booking first or try Walking In");
						val=true;
					}
					break;
				default:
					System.out.println("Error please try again");
					break;
				}
			}while(val==true);
			return null;
	}
	  
	  /**
		 * Creates and returns a new customer with only the necessary customer details, proceeds with ordering and payment 
		 * @param custlist
		 * @param tablelist
		 * @return Customer
		 */
		private static Customer walkIns(CustomerList custlist , TableList tablelist) {
			if(tablelist.getNumEmptyTables()<=0 ) {
				System.out.println("All tables are filled.. Please try again later");
				return null;}
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Customer Name:");
			String custName = sc.nextLine();
			char membership = 0;
			boolean member = false;
					
			boolean error = true;
			while(error) {
				System.out.println("Are you a member? t/f");
				membership = sc.next().charAt(0);
				if(membership=='t'||membership=='T') {
				member = true;
				error=false;
				}
				else if(membership=='f'||membership=='F') {
				      member = false;
				      error=false;
				}
				else {
					System.out.println("User input invalid.");
				}
			}
					
					int paxsize=0;
					error=true;
					while(error) {
						System.out.println("Customer pax?");
				         try {
				        	paxsize=sc.nextInt();
				        	if(paxsize<1 || paxsize>10) {
								System.out.println("Customer pax invalid!");
								continue;
							}
				            error=false;
				          }
				          catch (Exception e){
				        	  System.out.println("User input was not a number.");
				        	  sc.next();
				          }
					}
					int suitableTable = UI.table_size(paxsize);
					int tableId = tablelist.findSuitableTable(suitableTable);
					if(tableId == -1)
					{
						System.out.println("Please try again");
						return null;
					}
					
					error=true;
					double contact=0;
					while(error) {
						System.out.println("Customer contact?");
				         try {
				        	contact=sc.nextDouble();
				            error=false;
				          }
				          catch (Exception e){
				        	  System.out.println("Please input a double");
				        	  sc.next();
				          }
					}
					
					Calendar rDate;
					rDate = Calendar.getInstance();
					int month = rDate.get(Calendar.MONTH);
					int day =  rDate.get(Calendar.DAY_OF_MONTH);
					if(day>28)
					{
						System.out.println("Store is closed");
						return null;
					}
					int hour = rDate.get(Calendar.HOUR_OF_DAY);
					int min = rDate.get(Calendar.MINUTE);

					Customer customer= custlist.createCust(custName , custlist.getCustID() , member, paxsize, contact);
					int customerId = customer.getCustomerID();
					boolean assigned = tablelist.assignTable(tableId+1 , customerId);
					if(assigned){
						System.out.println("Customer ID: " + customerId);
						customer.setTableId(tableId+1);
						customer.setDate(month+1, day, hour, min);
					}
					
					return customer;

		}
}
