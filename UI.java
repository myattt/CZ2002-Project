import java.util.Scanner;
import java.util.*;
public class UI{
	// Not needed for now
	//static ArrayList<Integer> Revenue = new ArrayList<Integer>();

	//static ArrayList<String> customer_menu = new ArrayList<String>();


	public static HashMap<String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>();
	//Name of item, price
	public static HashMap<String, String> descriptions = new HashMap <String,  String>();
	//Name of item, description
	public static HashMap<String, String> categories = new HashMap <String,  String>();
	//Name of item, categories


	private static void MakeOrder() {
		
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
				if(!m.checkifexist(item)) {
					System.out.println("Enter the description for the item");
					String description = s.nextLine();
					System.out.println("Enter the price");
					int price = s.nextInt();
					s.nextLine();
					System.out.println("Enter the category: 1. Main Course, 2. Drinks, 3. Dessert");
					String cate = s.nextLine();
					m.addMenuItem(item, description, price, cate);

				}else{
					System.out.println("Already exists, try another name");
				}
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
			else if (option == 2) {
				CreateMenu();
			}
			else if (option == 3){
				PrintReport();
			}
			else option=0;
		}while(option != 0);
	}

}
