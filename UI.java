import java.util.Scanner;
import java.util.*;
public class UI{



	private static void MakeOrder() {


	private static void Booking() {
		// TODO - implement UI.Booking
		throw new UnsupportedOperationException();
	}

	private static void CreateMenu() {
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
