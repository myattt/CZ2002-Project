
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Staff {
	  private static String[] name = {"Harry", "Ron", "Hermione"};
	  private static String[] gender = {"M", "M", "F"};
	  private static int[] employeeID = {0,1,2};
	  private static String[] jobTitle = {"waiter", "waiter", "waitress"};

	  public static void main(Customer cust) {
			int choice;
			Scanner sc = new Scanner(System.in);
			Order o = new Order();
			o.startOrder();
			int op;
			do{
				System.out.println("1.View menu 2.Add Ala_Carte Item 3.Add Bundle 4.Remove Ala_Carte Item 5.Remove Bundle 6.View order 0.Quit");
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
			}
			while(op  != 0);

			System.out.println("FINISH, LET's ADD THE ORDER INTO DATABASE TO PRINT REPORT");
			ArrayList ala=o.getAlaOrder();
			ArrayList bundle=o.getBundleOrder();
			cust.setAlaOrder(ala);
			cust.setBundleOrder(bundle);
	  }
	 
	  private static void staffInfo() {
	    Random rand = new Random();
	    int rdint = rand.nextInt(3);
	    System.out.println("The staff who serves you is " + name[rdint] +", " + gender[rdint]+", "+jobTitle[rdint]);
	    System.out.println("Let's create your menu");
	    System.out.println();
	  }
}

