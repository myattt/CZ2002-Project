import java.util.Scanner;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class UI{

	


	private static void MakeOrder(Customer cust) {
		System.out.println("****Order Interface****");
		Staff staff=new Staff();
		staff.main(cust);
	}

		private static void Booking(TableList tablelist , CustomerList custlist){
		System.out.println("****Booking Interface****");
		char cont;
		boolean member = false;
		if(tablelist.getNumEmptyTables()<=0 )
			System.out.println("All tables are filled.. Please try again later");
		else {
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Customer Name:");
				String custName = sc.nextLine();
				System.out.println("Are you a member? t/f");
				char membership = sc.next().charAt(0);
				if(membership=='t'||membership=='T')
					member = true;
				int paxsize=0;
				boolean error=true;
				while(error) {
					System.out.println("Customer pax?");
			         try {
			        	paxsize=sc.nextInt();
			        	if(paxsize<1 || paxsize>10) {
							System.out.println("Customer pax too large!");
							continue;
						}
			            error=false;
			          }
			          catch (Exception e){
			        	  System.out.println("User input was not a number.");
			        	  sc.next();
			          }
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
				error=true;
				int month=0;
				while(error) {
					System.out.println("Enter reservation month");
			         try {
			        	month=sc.nextInt();
			        	if(month<1 || month>12) {
							System.out.println("Please enter the Month from 1 - 12");
							continue;
						}
			            error=false;
			          }
			          catch (Exception e){
			        	  System.out.println("Please input a number.");
			        	  sc.next();
			          }
				}
				
				int day=0;
				error=true;
				while(error) {
					System.out.println("Enter reservation day");
			         try {
			        	 day=sc.nextInt();
			        	if(day<1 || day>29) {
							System.out.println("Please enter the Day from 1 - 28");
							continue;
						}
			            error=false;
			          }
			          catch (Exception e){
			        	  System.out.println("Please input a number.");
			        	  sc.next();
			          }
				}
				
				int hour=0;
				error=true;
				while(error) {
					System.out.println("Enter reservation hour in  24H time");
			         try {
			        	hour=sc.nextInt();
			        	if(hour<10 || hour>22) {
							System.out.println("Store Operating Hours : 10AM - 10PM");
							System.out.println("Please enter a time between 10 and 22");
							continue;
						}
			            error=false;
			          }
			          catch (Exception e){
			        	  System.out.println("Please input a number.\n");
			        	  sc.next();
			          }
				}
				
				error = true;
				int minute=0;
				while(error) {
					System.out.println("Enter reservation minute");
			         try {
			        	minute=sc.nextInt();
			        	if(minute<0 || minute>59) {
							System.out.println("Please enter a number between 0 - 59");
							continue;
						}
			            error=false;
			          }
			          catch (Exception e){
			        	  System.out.println("Please input a number.");
			        	  sc.next();
			          }
				}
				
				Calendar rDate;
				rDate = Calendar.getInstance();
				int suitableTable = table_size(paxsize);
				int tableId = tablelist.findSuitableTable(suitableTable);
				if(tableId == -1)
				{
					System.out.println("Please try again");
				}
				else {
					Customer customer= custlist.createCust(custName , custlist.getCustID() , member, paxsize, contact);
					int customerId = customer.getCustomerID();
					boolean assigned = tablelist.assignTable(tableId+1 , customerId);
					if(assigned){
						customer.setTableId(tableId+1);
						customer.setDate(month, day, hour, minute);
					}
		
					tablelist.showAssignedTables();
					System.out.println("\n");
					tablelist.showEmptyTables();
					System.out.println("\n");
				}
				System.out.println("Continue adding reservations? t/f");
				//need exception here
				cont=sc.next().charAt(0);

			}while((cont=='t' || cont=='T') && tablelist.getNumEmptyTables()>0);
		}
	}

	private static void RemoveReservation(TableList tablelist , CustomerList custlist)
	{
		System.out.println("Enter CustomerID");
		Scanner sc = new Scanner(System.in);
		int cust_id = sc.nextInt();
		while(cust_id<0) {
			System.out.println("Error!");
			System.out.println("Enter CustomerID");
			cust_id = sc.nextInt();
		}
		Customer customer =custlist.getCust(cust_id);
		if(customer==null) {
			System.out.println("No customer found");
		}
		else {
		System.out.println("**** Double Check Customer Info****");
		System.out.println("Customer ID	:" + customer.getCustomerID());
		System.out.println("Customer Name	:" + customer.getCustomerName());
		System.out.println("Table ID	:" + customer.getTableId()+"\n");

		System.out.println("Remove Reservation? true/false");
		boolean choice = sc.nextBoolean();

		if(choice) {
			tablelist.unAssignSeat(customer.getTableId());
			System.out.println("Assigned seats");
			tablelist.showAssignedTables();
			System.out.println("Empty seats");
			tablelist.showEmptyTables();
			custlist.removeCust(cust_id);
			System.out.println("\nCurrent Customer list");
			custlist.printList();
		}
		else
			System.out.println("No reservations removed...");
		}
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

	
	private static void ModifyMenu() {
		System.out.println("1. Ala Carte\n2. Promotional Package?");
		Scanner sc = new Scanner(System.in);
		int op;
		try {op = sc.nextInt();}catch (Exception e) {
			System.out.println("User input was not a number.");
			return;
		}
		
		
		if (op == 1) {
			Ala_Carte m = new Ala_Carte();
			Scanner s = new Scanner(System.in);
			int option;
			do {
				System.out.println("Please select option \n 1. Add item \n 2. Delete items \n 3. Clear Menu \n 4. Display the Menu (0 to quit)");
				option = s.nextInt();
				s.nextLine();
				if (option == 1) {
					System.out.println("Enter Item you want to add");
					String item = s.nextLine();
					if(!Ala_Carte.Menu_of_restaurants.containsKey(item)) {
						System.out.println("Enter the description for the item");
						String description = s.nextLine();
						System.out.println("Enter the price");
						int price = s.nextInt();
						s.nextLine();
						String cate="";
						int choice;
						do {
						System.out.println("Enter the category: 1. Main Course, 2. Drinks, 3. Dessert");
						choice = 0 ;
						try {choice = sc.nextInt();}catch (Exception e) {
							System.out.println("User input was not a number.");
							break;
						}
						switch(choice) {
						case 1:
							cate ="Main Course";
							break;
						case 2:
							cate="Drinks";
							break;
						case 3:
							cate="Dessert";
							break;
						default:
							System.out.println("Enter correct integer!");
							choice=0;
						}}while(choice==0);
;
						m.addItem(item, description, price, cate);

					} else {
						System.out.println("Already exists, try another name");
					}
				} else if (option == 2) {
					m.displayItem();
					System.out.println("Enter the item you want to delete");
					String item_to_delete = s.nextLine();
					m.removeItem(item_to_delete);
				} else if (option == 3) {
					Ala_Carte.Menu_of_restaurants.clear();
				} else if (option == 4) {
					m.displayItem();
				} else option = 0;
			} while (option != 0);
		}
		else if (op == 2) {
			Promotional_Package p = new Promotional_Package();
			Scanner s = new Scanner(System.in);
			int option;
			do {
				System.out.println("Please select option \n 1. Add item \n 2. Delete items \n 3. Clear Menu \n 4. Display the Menu (0 to quit)");
				option = s.nextInt();
				s.nextLine();
				if (option == 1) {
					p.addItem();
				}
				else if (option == 2) {
					p.displayItem();
					p.removeitem();
				} else if (option == 3) {
					Promotional_Package.bundle.clear();
					Promotional_Package.bundle_desc.clear();
					Promotional_Package.bundle_prices.clear();
				} else if (option == 4) {
					p.displayItem();
				} else option = 0;
			} while (option != 0);
		}else{
			System.out.println("Invalid choice");
		}
	}

	private static void PrintReport(CustomerList custlist) {
		System.out.println("-----------------REPORT-----------------");
		SalesRevenueReport.generateByDay(custlist);
		SalesRevenueReport.generateByMonth(custlist);
		SalesRevenueReport.individualitemsales();
		System.out.println("-----------------REPORT-----------------");

	}
	public static boolean checkCustomerDetails(int cust_id , CustomerList cust_list){
		boolean exist =cust_list.checkCustInfo(cust_id);
		return exist;

	}
	
	public static boolean checkPeriodExpiry(int cust_id, CustomerList cust_list , TableList tablelist) {
	int[] date = cust_list.getCustDate(cust_id);
	Calendar Period = Calendar.getInstance();
	int periodMon = date[0];
	int periodDay = date[1];
	int periodMin = date[3];
	int periodHour = date[2];
	if(date[3] + 30 > 59) {
		periodHour++;
		periodMin -= 30;
	}
	String[] monthName = {"Jan","Feb", "Mar","Apr", "May", "Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	System.out.printf("Reserved on %02d %s %02d : %02d \n", date[1], monthName[date[0]-1], date[2], date[3]);
	int mon = Period.get(Calendar.MONTH);
	int day =  Period.get(Calendar.DAY_OF_MONTH);
	int hour = Period.get(Calendar.HOUR_OF_DAY);
	int min = Period.get(Calendar.MINUTE);
	

	if(mon >= periodMon-1 && min >= periodMin && hour >= periodHour && day >= periodDay) {
		System.out.printf("Currently %02d %s %02d : %02d \n",day,monthName[mon], hour, min );
		Customer cust = cust_list.getCust(cust_id);
		tablelist.unAssignSeat(cust.getTableId());
		System.out.println("\nCustomer ID:"+cust.getCustomerID() + " 		" + "Customer Name:" + cust.getCustomerName());
		System.out.print("Reservation was ");
		cust_list.removeCust(cust_id);
		System.out.println("Due to Period Expired");
		return true;
	}
	return false;
	}
	
	private static void ReservationandTables(TableList tablelist,CustomerList custlist)
	{
		Scanner sc = new Scanner(System.in);
		int choice=0;
		
		do{
			System.out.println("****Reservation and Table Settings*****");
			System.out.println("1. Make Reservation\n2. Check Reservation\n3. Remove Reservation\n4. Table Availability\n0. Quit");
			boolean error=true;
			while (error)
			{
				try {
	            	choice = sc.nextInt();
	            	error=false;
	                }
	            catch (Exception e){
	                System.out.println("You did not enter an integer, please enter an integer value");
	                sc.next();
	                }
			}
			if(choice == 1){
				Booking(tablelist , custlist);
			}
			else if(choice == 2){
				System.out.println("Enter CustomerID");
				int cust_id = sc.nextInt();
				Customer customer =custlist.getCust(cust_id);
				boolean expired=checkPeriodExpiry(cust_id ,custlist , tablelist);
				if(!expired && customer!=null) {
					System.out.println("****Check Customer Info****");
					System.out.println("Customer ID	:" + customer.getCustomerID());
					System.out.println("Customer Name	:" + customer.getCustomerName());
					System.out.println("Table ID	:" + customer.getTableId());
					System.out.println("Reservation Date:"+ customer.getDate()[1] + "/" + customer.getDate()[0]+ "/"+ Calendar.getInstance().get(Calendar.YEAR));
					System.out.println("Reservation Time:"+ customer.getDate()[2] +":"+customer.getDate()[3]+"\n");}
				}
			else if(choice == 3){
				RemoveReservation(tablelist , custlist);
			}
			else if(choice == 4){
				System.out.println("***Table Availability****\n");
				tablelist.showEmptyTables();
				System.out.println("\n");
			}
		}while(choice != 0);
				    
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		TableList tablelist= new TableList();
		CustomerList custlist = new CustomerList();
		int option;
		System.out.println("Welcome to Pub & Grill\n");
		do {
			System.out.println("Please select option \n 1. Make Order \n 2. Reservations & Tables \n 3. Modify Menu \n 4. Print Report \n 5. Update System \n 6. Quit");
			option = sc.nextInt();
			sc.nextLine();
			if(option == 1) {
				System.out.println("Enter Customer ID");
				int input1 = sc.nextInt();
				boolean exist = checkCustomerDetails(input1 , custlist);
				if (exist) {
					Customer cust= custlist.getCust(input1);
					boolean expire = checkPeriodExpiry(input1,custlist , tablelist);
					if(expire == false && cust.getAlaOrder()==null && cust.getBundleOrder()==null){
					MakeOrder(cust);
					OrderInvoice invoice=new OrderInvoice();
					invoice.printInvoice(input1,custlist);
					tablelist.unAssignSeat(cust.getTableId());
					//System.out.println("***Current Customers and Order***");
					//custlist.printList();
					}
				else {
					System.out.println("Your reservation period has expired, please book again");
				}
				}
				else {
					System.out.println("Please make a booking first");
				}
			}
			else if (option == 2) {
				ReservationandTables(tablelist,custlist);
			}
			else if (option==3)
			{
				ModifyMenu();
			}
			else if (option == 4){
				PrintReport(custlist);
			}
			else if (option== 5)
			{
				for(int i=0 ; i<10; i++) {
					Table table = tablelist.getTable(i);
					if(!table.isOccupied())
						continue;
					else {
						checkPeriodExpiry(table.getCustomerID() ,custlist , tablelist);
					}
				}
			}
			else if(option ==6) {
				System.out.println("******End******");
				option=0;
			}
			else option=0;
		}while(option != 0);
	}
}
