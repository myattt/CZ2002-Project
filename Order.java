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

	/**
	 * start a new order by clearing the menu of the last customer
	 */
	public static void startOrder(){
		order_bundle.clear();
		order_ala.clear();
	}

	/**
	 * display both Ala Carte and Promotional Package menu
	 */
	public static void viewMenu(){
		Ala_Carte a = new Ala_Carte();
		Promotional_Package p = new Promotional_Package();
		a.displayItem();
		p.displayItem();
	}

	/**
	 * Adding Ala Carte item
	 */
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


	/**
	 * Adding Promotional Package item
	 */
	public static void addbundleItem() {
		int b=0;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("+----------------------------------------+");
			System.out.println("|         Promotional Package            |");
			System.out.println("+----------------------------------------+");
			for(int i=1; i<Promotional_Package.bundle.size()+1; i++){
				System.out.println("ID: "+ i + " "+Promotional_Package.bundle.get(i) +": " + Promotional_Package.bundle_desc.get(i) + " ($" + Promotional_Package.bundle_prices.get(i)+")");
			}
			System.out.println("Type the Bundle Id to add to the order (0 to quit)");
			boolean error=true;
			while (error)
			{
				try {
					b = sc.nextInt();
	            	error=false;
	                }
	            catch (Exception e){
	                System.out.println("You did not enter an integer, please enter an integer value");
	                sc.next();
	                }
			}

			if(b == 0)break;
			if(Promotional_Package.bundle.containsKey(b))order_bundle.add(b);
			else System.out.println("Invalid Bundle Id");
		}while(b != 0);
	}

	/**
	 * Removing Ala Carte item
	 */
	public static void removealaItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ala carte orders: " + order_ala);
		System.out.println("Which one?");
		String item = sc.nextLine();
		if(order_ala.contains(item)) { 
			order_ala.remove(item);
			System.out.println(item + " removed");
		}
		
		else System.out.println("Haven't chosen yet");
	}

	/**
	 * Removing Promotional Package item
	 */
	public static void removebundleItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bundle orders: " + order_bundle);
		System.out.println("Which one?");
		int b = 0;
		boolean error=true;
		while (error)
		{
			try {
				b = sc.nextInt();
            	error=false;
                }
            catch (Exception e){
                System.out.println("You did not enter an integer, please enter an integer value");
                sc.next();
                }
		}
		if(order_bundle.contains(b)) {
			order_bundle.remove(b);
			System.out.println("Bundle: " + b + " removed");
		}
		else System.out.println("Haven't chosen yet");
	}

	/**
	 * to view the order of the customer
	 */
	public static void viewOrder() {
		System.out.println(order_ala);
		System.out.println(order_bundle);
	}


	/**
	 *
	 * @return list of Ala Carte items in the menu
	 */
	public ArrayList<String> getAlaOrder()
	{
		return order_ala;
	}
	/**
	 *
	 * @return list of Promotional Package items in the menu
	 */
	public ArrayList<Integer> getBundleOrder()
	{
		return order_bundle;
	}

}
