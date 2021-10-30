

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

	private int custID;
	private int tableNumber;
	private int timeStamp;
	private int taxDetails;
	private int employeeID;
	private static ArrayList<String> order_ala = new ArrayList<>();
	private static ArrayList<Integer> order_bundle = new ArrayList<>();

	public static void startOrder(){
		order_bundle.clear();
		order_ala.clear();
	}
	public static void viewMenu(){
		Ala_Carte a = new Ala_Carte();
		Promotional_Package p = new Promotional_Package();
		a.displayItem();
		p.displayItem();
	}

	public static void addalaItem() {
		String item;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Type the item you want to add to your order (q to quit)");
			item = sc.nextLine();
			if(item.equals("q"))break;
			if(Ala_Carte.Menu_of_restaurants.containsKey(item)) order_ala.add(item);
			else System.out.println("Invalid item");
		}while(!item.equals("q"));
	}

	public static void addbundleItem() {
		int b;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println(Promotional_Package.bundle);
			System.out.println("Type the bundle id you want to add to your order (0 to quit)");

			b = sc.nextInt();

			if(b == 0)break;
			if(Promotional_Package.bundle.containsKey(b))order_bundle.add(b);
			else System.out.println("Invalid bundle id");
		}while(b != 0);
	}

	public static void removealaItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which one?");
		String item = sc.nextLine();
		if(order_ala.contains(item)) order_ala.remove(item);
		else System.out.println("Haven't chosen yet");
	}

	public static void removebundleItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which one?");
		int b = sc.nextInt();
		if(order_bundle.contains(b)) order_bundle.remove(b);
		else System.out.println("Haven't chosen yet");
	}

	public static void viewOrder() {
		System.out.println(order_ala);
		System.out.println(order_bundle);
	}

	public void discount() {
		// TODO - implement Order.discount
		throw new UnsupportedOperationException();
	}

	public void getTaxesDetails() {
		// TODO - implement Order.getTaxesDetails
		throw new UnsupportedOperationException();
	}

	public void orderInvoice() {
		// TODO - implement Order.orderInvoice
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		viewMenu();
		addalaItem();
		addbundleItem();
		viewOrder();

	}

}
