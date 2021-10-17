import java.util.Scanner;
import java.util.ArrayList;
public class UI {

	// ArrayList<String> customerID = new ArrayList<String>(); Need?
	
	// For each customer and an order, please add the total price into this Revenue ArrayList
	ArrayList<Integer> Revenue = new ArrayList<Integer>();
	static ArrayList<String> Menu_of_restaurants = new ArrayList<String>();
	
	private static void makeOrder(){
		Staff s = new Staff();
		s.createOrder();

	}

	private static void booking() {
		// TODO - implement UI.Booking
		throw new UnsupportedOperationException();
	}

	private void createMenu(ArrayList<String> menu) {
		// TODO - implement UI.CreateMenu
		throw new UnsupportedOperationException();
	}
	private void modifyMenu(ArrayList<String> menu){
		
		throw new UnsupportedOperationException();
	}

	private void printReport() {
		// TODO - implement UI.PrintReport
		throw new UnsupportedOperationException();
	}
	public static void main(String[] args) {
		Menu_of_restaurants.add("Main Course");
		Menu_of_restaurants.add("Drinks");
		Menu_of_restaurants.add("Dessert");
		
		ArrayList<String> menu = new Menu<String>();
		createMenu(menu);
		
		Scanner s = new Scanner(System.in);
		do {
			
			System.out.println("Please select option \n 1. Make Order \n 2. Booking \n 3. ModifyMenu \n 4. PrintReport");
			int option = s.nextInt();
			if(option == 1) {
				makeOrder();
			}
			else if (option == 2)
				booking();
			else if (option == 3)
				menu.modifyMenu(menu);
			else if (option == 4)
				printReport();
			else
				option=0;
		}while(option==0);
		
	}

}
