import java.util.*;

public class Promotional_Package {

	static HashMap<Integer,ArrayList<String>> bundle=new HashMap<Integer,ArrayList<String>>(){{
		put(1,new ArrayList<String>(Arrays.asList("Coca Cola", "Pizza", "Ice cream")));
		put(2, new ArrayList<String>(Arrays.asList("Coca Cola", "Pizza")));
	}};
	static HashMap<Integer,Integer> bundle_prices=new HashMap<Integer,Integer>(){{put(1,300);put(2,400);}};

	public static void displayItem() {
		System.out.println(bundle);
		System.out.println(bundle_prices);
	}

	public static void addItem() {
		int s = bundle.size();
		int id_bundle = 99999;
		for(int i =1; i<=s+1;i++){
			if(!bundle.containsKey(i)) {
				id_bundle = Math.min(id_bundle, i);
			}
		}
		String bundle_item;
		int bundle_price=0;
		ArrayList<String> bundle_items = new ArrayList<String>();
		do {
			System.out.println("Item to add? (q to quit)");
			Scanner sc = new Scanner(System.in);
			bundle_item = sc.nextLine();
			if(Ala_Carte.Menu_of_restaurants.containsKey(bundle_item)){
				System.out.println(Ala_Carte.Menu_of_restaurants.get(bundle_item));
				bundle_price += Ala_Carte.Menu_of_restaurants.get(bundle_item);
				bundle_items.add(bundle_item);
			}else if(!bundle_item.equals("q")){
				System.out.println("Not in menu");
			}
		}while(!bundle_item.equals("q"));
		bundle.put(id_bundle, bundle_items);
		bundle_prices.put(id_bundle,bundle_price);
	}

	public static void removeitem() {
		System.out.println("Select id bundle to delete");
		displayItem();
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if(bundle.containsKey(id)){
			bundle.remove(id);
			bundle_prices.remove(id);
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Invalid id");
		}
	}

	public static void main(String[] args) {
		addItem();
		displayItem();
		removeitem();
		displayItem();
		addItem();
		displayItem();

	}

}
