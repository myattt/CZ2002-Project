import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Staff {
	  public static String[] name = {"Harry", "Ron", "Hermione"};
	  public static String[] gender = {"M", "M", "F"};
	  public static int[] employeeID = {0,1,2};
	  public static String[] jobTitle = {"waiter", "waiter", "waitress"};
	  public static String[] alaorder;
	  public static Integer[] bundleorder;
	  
	  public static ArrayList<String> ala;
	  public static ArrayList<Integer> bundle;
	  

	  public static void main(Customer cust) {
			Scanner sc = new Scanner(System.in);
			Order o = new Order();
			o.startOrder();
			int op=0;
			int staff_id = staffInfo();
			cust.setStaffinfo(name[staff_id], gender[staff_id], jobTitle[staff_id] , employeeID[staff_id]);
			do{
			
				boolean error=true;
				while(error) {
					System.out.println("1.View menu \n2.Add Ala_Carte Item \n3.Add Bundle \n4.Remove Ala_Carte Item \n5.Remove Bundle \n6.View order \n0.Quit");
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
					staffInfo();
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
	 
	  public static int staffInfo() {
	    Random rand = new Random();
	    int rdint = rand.nextInt(3);
	    return rdint;
	  }
}
