import java.util.Scanner; 
import java.util.*; 
import java.util.Calendar;
import java.util.GregorianCalendar;
public class UI{ 
 
 
 
 private static void MakeOrder() { 
/* 		Scanner s = new Scanner(System.in);
		Order o = new Order();
		o.startOrder();
		int op;
		do{
			System.out.println("1.View menu 2.Add Ala_Carte Item 3.Add Bundle 4.Remove Ala_Carte Item 5.Remove Bundle 6.View order 0.Quit");
			op = s.nextInt();
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

		}
		while(op  != 0);
		
		System.out.println("FINISH, LET's ADD THE ORDER INTO DATABASE TO PRINT REPORT");*/
 } 
 
 private static void Booking(TableList tablelist , CustomerList custlist){ 
	 System.out.println("****Booking Interface****");
	 boolean cont=false;
	 if(tablelist.getNumEmptyTables()<=0 ) 
		     System.out.println("All tables are filled.. Please try again later"); 
	 else {
		 do {
		  Scanner sc = new Scanner(System.in); 
		  System.out.println("Enter Customer Name:"); 
		  String custName = sc.nextLine();
		  System.out.println("Are you a member? true/false"); 
		  boolean membership = sc.nextBoolean(); 
		  System.out.println("Customer pax?"); 
		  int paxsize=sc.nextInt(); 
		  System.out.println("Customer contact?"); 
		  double contact=sc.nextDouble(); 
		  System.out.println("Enter reservation month");
		  int month=sc.nextInt();
		  System.out.println("Enter reservation day");
		  int day=sc.nextInt();
		  System.out.println("Enter reservation hour"); 
		  int hour=sc.nextInt();
		  Calendar aDate;
		  aDate = new GregorianCalendar(2021, month, day, hour, 00);
		  int suitableTable = table_size(paxsize); 
		  int tableId = tablelist.findSuitableTable(suitableTable); 
		  if(tableId == -1) 
		  {
			  System.out.println("Please try again");
		  }
		  else { 
	      Customer customer= custlist.createCust(custName , (custlist.getCListSize())+1 , membership, paxsize, contact , aDate); 
	      int customerId = customer.getCustomerID(); 
	      boolean assigned = tablelist.assignTable(tableId+1 , customerId);
	      if(assigned)
	    	  customer.setTableId(tableId+1);
	      tablelist.showAssignedTables(); 
	      System.out.println("\n"); 
	      tablelist.showEmptyTables(); 
	      System.out.println("\n"); 
		  } 
		  System.out.println("Continue adding reservations? true/false");
		  //need exception here
		  cont=sc.nextBoolean();
		 }while(cont==true && tablelist.getNumEmptyTables()>0);
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
   
 private static void RemoveReservation(TableList tablelist , CustomerList custlist)
 {
	 	System.out.println("Enter CustomerID");
		Scanner sc = new Scanner(System.in);
		int cust_id = sc.nextInt();
		while(cust_id>custlist.getCListSize() || cust_id<0) {
			System.out.println("Error!");
			System.out.println("Enter CustomerID");
			cust_id = sc.nextInt();
		}
		Customer customer =custlist.getCust(cust_id);
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
 private static void ModifyMenu() { 
	  Ala_Carte m = new Ala_Carte(); 
	  Scanner s = new Scanner(System.in); 
	  int option; 
	  do { 
	   System.out.println("Please select option \n 1. Add item \n 2. Delete items \n 3. Clear Menu \n 4. Display the Menu"); 
	   option = s.nextInt(); 
	   s.nextLine(); 
	   if(option == 1) { 
	    System.out.println("Enter Item you want to add"); 
	    String item = s.nextLine(); 
	    if(!m.checkifexist(item)) { 
	     System.out.println("Enter the description for the item"); 
	     String description = s.nextLine(); 
	     System.out.println("Enter the price"); 
	     int price = s.nextInt(); 
	     s.nextLine(); 
	     System.out.println("Enter the category: 1. Main Course, 2. Drinks, 3. Dessert"); 
	     String cate = s.nextLine(); 
	     m.addItem(item, description, price, cate); 
	 
	    }else{ 
	     System.out.println("Already exists, try another name"); 
	    } 
	   } 
	   else if (option == 2) { 
	    m.displayItem(); 
	    System.out.println("Enter the item you want to delete"); 
	    String item_to_delete = s.nextLine(); 
	    m.removeItem(item_to_delete); 
	   } 
	   else if (option == 3) { 
	    Ala_Carte.Menu_of_restaurants.clear(); 
	   } 
	   else if (option == 4){ 
	    m.displayItem(); 
	   } 
	   else option=0; 
	  }while(option != 0); 
	 } 
	 
	 private static void PrintReport() { 
	  System.out.print(false); 
 } 
 
 public static void main(String[] args){ 
	  Scanner s = new Scanner(System.in); 
	  TableList tablelist= new TableList(); 
	  CustomerList custlist = new CustomerList(); 
	  int option; 
	  do { 
	   System.out.println("Please select option \n 1. Make Order \n 2. Create Reservation \n 3. Remove Reservation \n 4. ModifyMenu \n 5. PrintReport \n 6.Quit"); 
	   option = s.nextInt(); 
	   s.nextLine(); 
	   if(option == 1) { 
	    MakeOrder(); 
	   } 
	   else if (option == 2) { 
	    Booking(tablelist , custlist); 
	   } 
	   else if (option==3)
	   {
		RemoveReservation(tablelist , custlist);
	   }
	   else if (option==4)
	   {
		ModifyMenu();
	   }
	   else if (option == 5){ 
	    PrintReport(); 
	   } 
	   else if(option ==6) {
		   System.out.println("******End******");
		   option=0;
	   }
	   else option=0; 
	  }while(option != 0); 
	 } 
 
}
