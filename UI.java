import java.util.Scanner;
import java.util.*;
public class UI{


	private static void MakeOrder() {

	}

	private static void Booking() {
		// TODO - implement UI.Booking
		throw new UnsupportedOperationException();
	}

	private static void ModifyMenu(){
		Scanner s = new Scanner(System.in);
		System.out.println("1. Ala Carte or 2. Bundle or 3. Display whole menu");
		int op = s.nextInt();
		if(op==1) {
			Ala_Carte m = new Ala_Carte();

			int option;
			do {
				System.out.println("Please select option \n 1. Add item \n 2. Delete items \n 3. Clear Menu \n 4. Display the Menu \n 0. Quit");
				option = s.nextInt();
				s.nextLine();
				if (option == 1) {
					System.out.println("Enter Item you want to add");
					String item = s.nextLine();
					if (!m.checkifexist(item)) {
						System.out.println("Enter the description for the item");
						String description = s.nextLine();
						System.out.println("Enter the price");
						int price = s.nextInt();
						s.nextLine();
						System.out.println("Enter the category: 1. Main Course, 2. Drinks, 3. Dessert");
						String cate = s.nextLine();
						m.addItem(item, description, price, cate);

					} else {
						System.out.println("Already exists, try another name");
					}
				} else if (option == 2) {
					m.displayItem();
					System.out.println("Enter the item you want to delete");
					String item_to_delete = s.nextLine();
					m.removeItem(item_to_delete);
				} else if (option == 3) {
					Ala_Carte.Menu_of_restaurants.clear();
				} else if (option == 4) {
					m.displayItem();
				} else option = 0;
			} while (option != 0);
		}else if(op == 2){
			Promotional_Package m = new Promotional_Package();

			int option;
			do {
				System.out.println("Please select option \n 1. Add bundle \n 2. Delete bundle \n 3. Display Menu \n 0. Quit");
				option = s.nextInt();

				if (option == 1) {
					m.addItem();
				} else if (option == 2) {
					m.removeitem();
				} else if (option == 3) {
					m.displayItem();
				} else option = 0;
			} while (option != 0);
		}
		else{
			Ala_Carte a = new Ala_Carte();
			Promotional_Package p = new Promotional_Package();
			a.displayItem();
			p.displayItem();
		}

	}

	private static void PrintReport() {

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int option;
		do {
			System.out.println("Please select option \n 1. Make Order \n 2. ModifyMenu \n 3. PrintReport");
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
