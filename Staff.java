import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Staff {
	  public static String[] name = {"Harry", "Ron", "Hermione","Jerry"};
	  public static String[] gender = {"M", "M", "F","M"};
	  public static int[] employeeID = {0,1,2,3};
	  public static String[] jobTitle = {"waiter", "waiter", "waitress","manager"};
	  public static String[] alaorder;
	  public static Integer[] bundleorder;
	  
	  public static ArrayList<String> ala;
	  public static ArrayList<Integer> bundle;
	  
	  
	 /**
	  * interface for staffs to make orders 
	  * @param Customer cust
	  */
	  public static void main(Customer cust) {
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
	  }
	 
	  /**
	   * returns id of staff 
	   * @return int staff_id
	   */
	  public static int staffInfo() {
	    Random rand = new Random();
	    int rdint = rand.nextInt(4);
	    return rdint;
	  }
}
