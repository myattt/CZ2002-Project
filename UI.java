import java.util.Scanner;
import java.util.ArrayList;
public class UI {

	// ArrayList<String> customerID = new ArrayList<String>(); Need?
	
	
	//Our Database -----------
	// For each customer and an order, please add the total price into this Revenue ArrayList ==> call printReport() easier
	ArrayList<Integer> Revenue = new ArrayList<Integer>();
	static ArrayList<String> Menu_of_restaurants = new ArrayList<String>();
	
	//Our Database -----------
	
	
	private static void MakeOrder() {
		Staff s = new Staff();
		s.createOrder();

	}

	private static void Booking() {
		// TODO - implement UI.Booking
		throw new UnsupportedOperationException();
	}

	private void CreateMenu() {
		Menu m = new Menu();
		m.displayMenu();
	}

	private void PrintReport() {
		// TODO - implement UI.PrintReport
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		// Create some menu items first for testing, you can add/remove items (I havent added ala_carte, bundles, etc.)
		// Please select option 3 to display the menu >>> [Main Course, Drinks, Dessert]
		Menu_of_restaurants.add("Main Course");
		Menu_of_restaurants.add("Drinks");
		Menu_of_restaurants.add("Dessert");
		
		
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("Please select option \n 1. Make Order \n 2. Booking \n 3. CreateMenu \n 4. PrintReport");
			int option = s.nextInt();
			if(option == 1) {
				MakeOrder();
			}
			else if (option == 2)
				Booking();
			else if (option == 3)
				CreateMenu();
			else if (option == 4)
				PrintReport();
			else
				option=0;
		}while(option==0);
		
	}

}
