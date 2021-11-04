import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Staff {
	  public static String[] name = {"Harry", "Ron", "Hermione"};
	public static String[] gender = {"M", "M", "F"};
	public static int[] employeeID = {0,1,2};
	public static String[] jobTitle = {"waiter", "waiter", "waitress"};

	  public static void main(Customer cust) {
			Scanner sc = new Scanner(System.in);
			Order o = new Order();
			o.startOrder();
			int op;
			int staff_id = staffInfo();
			cust.setStaffinfo(name[staff_id], gender[staff_id], jobTitle[staff_id] , employeeID[staff_id]);
			do{
				System.out.println("1.View menu \n2.Add Ala_Carte Item \n3.Add Bundle \n4.Remove Ala_Carte Item \n5.Remove Bundle \n6.View order \n0.Quit");
				op = sc.nextInt();
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
			
			ArrayList<String> ala=o.getAlaOrder();
			ArrayList<Integer> bundle=o.getBundleOrder();
			cust.setAlaOrder(ala);
			cust.setBundleOrder(bundle);
	  }
	 
	  public static int staffInfo() {
	    Random rand = new Random();
	    int rdint = rand.nextInt(3);
	    return rdint;
	  }
}
