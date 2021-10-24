import java.util.Scanner;
import java.util.*;
public class UI{

//	static ArrayList<Integer> Revenue = new ArrayList<Integer>();
////	static HashMap <String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>();
//	static ArrayList<String> customer_menu = new ArrayList<String>();


//	public static HashMap<String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>() {{put("Coca Cola",100);put("Ice cream",66);put("Pizza",123);put("Spaghetti",444); }};
//	//Name of item, price
//	public static HashMap<String, String> descriptions = new HashMap <String,  String>(){{put("Coca Cola","Cool");put("Ice cream","Cold");put("Pizza","Hot");put("Spaghetti","Delicious"); }};
//	//Name of item, description
//	public static HashMap<String, String> categories = new HashMap <String,  String>(){{put("Coca Cola","Drinks");put("Ice cream","Dessert");put("Pizza","Main Course");put("Spaghetti","Main Course"); }};
//	//Name of item, categories


	private static void MakeOrder() {
//		Staff ss = new Staff();
//		ss.createOrder();
//
//		customer_menu.clear();
//		Menu_ForCustomer m = new Menu_ForCustomer();
//		Scanner s = new Scanner(System.in);
//		System.out.println("Please select option \n 1. Add Item \n 2. Remove Item \n 3. DisplayItems \n 4. Finish");
//		int menu_option = s.nextInt();
//		s.nextLine();
//
//		while(menu_option != 4){
//			if(menu_option == 1) {
//				System.out.println("Select your wanted items (please type correctly)");
//				System.out.println(Menu_of_restaurants);
//				String added_items = s.nextLine();
//
//				m.addMenuItem(added_items);
//			}if(menu_option == 2) {
//				System.out.println("Select your wanted items to delete (please type correctly)");
//				System.out.println(Menu_of_restaurants);
//				String del_items = s.nextLine();
//				m.removeMenuItem(del_items);
//			}if(menu_option == 3) {
//				System.out.println(customer_menu);
//			}
//
//
//			System.out.println("Please select option \n 1. Add Item \n 2. Remove Item \n 3. DisplayItems \n 4. Finish");
//			menu_option = s.nextInt();
//			s.nextLine();
//		}
//
//		System.out.println("Our Final Menu: " + customer_menu);
//		int revenue = 0;
//		for(int i =0; i < customer_menu.size(); i++){
//			revenue += Menu_of_restaurants.get(customer_menu.get(i));
//		}
//		Revenue.add(revenue);
	}

	private static void Booking() {
		// TODO - implement UI.Booking
		throw new UnsupportedOperationException();
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

			else if (option == 2) {
				ModifyMenu();
			}
			else if (option == 3){
				PrintReport();
			}
			else option=0;
		}while(option != 0);
	}

}
