import java.util.Scanner;
import java.util.*;
public class UI{

	static ArrayList<Integer> Revenue = new ArrayList<Integer>();
	static HashMap <String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>();
	static ArrayList<String> customer_menu = new ArrayList<String>();


	private static void MakeOrder() {
		Staff ss = new Staff();
		ss.createOrder();

		customer_menu.clear();
		Menu_ForCustomer m = new Menu_ForCustomer();
		Scanner s = new Scanner(System.in);
		System.out.println("Please select option \n 1. Add Item \n 2. Remove Item \n 3. DisplayItems \n 4. Finish");
		int menu_option = s.nextInt();
		s.nextLine();

		while(menu_option != 4){
			if(menu_option == 1) {
				System.out.println("Select your wanted items (please type correctly)");
				System.out.println(Menu_of_restaurants);
				String added_items = s.nextLine();
				m.addMenuItem(added_items);
			}if(menu_option == 2) {
				System.out.println("Select your wanted items to delete (please type correctly)");
				System.out.println(Menu_of_restaurants);
				String del_items = s.nextLine();
				m.removeMenuItem(del_items);
			}if(menu_option == 3) {
				System.out.println(customer_menu);
			}


			System.out.println("Please select option \n 1. Add Item \n 2. Remove Item \n 3. DisplayItems \n 4. Finish");
			menu_option = s.nextInt();
			s.nextLine();
		}

		System.out.println("Our Final Menu: " + customer_menu);
		int revenue = 0;
		for(int i =0; i<customer_menu.size(); i++){
			revenue += Menu_of_restaurants.get(customer_menu.get(i));
		}
		Revenue.add(revenue);
	}

	private static void Booking() {
		// TODO - implement UI.Booking
		static ArrayList<Table>tables= new ArrayList<Table>();
		throw new UnsupportedOperationException();
	}

	private static void CreateMenu() {
		Menu m = new Menu();
		Scanner s = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select option \n 1. Add item \n 2. Delete items \n 3. Clear Menu \n 4. Display the Menu");
			option = s.nextInt();
			s.nextLine();
			if(option == 1) {
				System.out.println("Enter Item you want to add");
				String item = s.nextLine();
				System.out.println("Enter the description for the item");
				String description = s.nextLine();
				System.out.println("Enter the price");
				int price = s.nextInt();
				s.nextLine();
				m.addMenuItem(item,description,price);
			}
			else if (option == 2) {
				m.displayMenu();
				System.out.println("Enter the item you want to delete");
				String item_to_delete = s.nextLine();
				m.removeMenuItem(item_to_delete);
			}
			else if (option == 3) {
				Menu_of_restaurants.clear();
			}
			else if (option == 4){
				m.displayMenu();
			}
			else option=0;
		}while(option != 0);
	}

	private static void PrintReport() {
		System.out.println(Revenue);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select option \n 1. Make Order \n 2. Booking \n 3. CreateMenu \n 4. PrintReport");
			option = s.nextInt();
			s.nextLine();
			if(option == 1) {
				MakeOrder();
			}
			else if (option == 2)
				Booking();
			else if (option == 3) {
				CreateMenu();
			}
			else if (option == 4){
				PrintReport();
			}
			else option=0;
		}while(option != 0);
	}

}
