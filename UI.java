import java.util.Scanner;
import java.util.ArrayList;
public class UI {

	// ArrayList<String> customerID = new ArrayList<String>(); Need?
	
	// For each customer and an order, please add the total price into this Revenue ArrayList
	ArrayList<Integer> Revenue = new ArrayList<Integer>();
	private static void MakeOrder() {
		Staff s = new Staff();
		s.createOrder();

	}

	private static void Booking() {
		// TODO - implement UI.Booking
		throw new UnsupportedOperationException();
	}

	private void CreateMenu() {
		// TODO - implement UI.CreateMenu
		throw new UnsupportedOperationException();
	}

	private void PrintReport() {
		// TODO - implement UI.PrintReport
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
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
