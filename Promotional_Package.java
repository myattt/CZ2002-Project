import java.util.*;

public class Promotional_Package implements Item{

	static HashMap<Integer,ArrayList<String>> bundle=new HashMap<Integer,ArrayList<String>>(){{
//		put(1,new ArrayList<String>(Arrays.asList("Coca Cola", "Pizza", "Ice cream")));
//		put(2, new ArrayList<String>(Arrays.asList("Coca Cola", "Pizza")));
	}};
	static HashMap<Integer,Integer> bundle_prices=new HashMap<Integer,Integer>(){
//		{put(1,18);put(2,22);}
	};
	static HashMap<Integer,String> bundle_desc=new HashMap<Integer,String>(){
//		{put(1,"Set on sale");put(2,"Fizzy chilled drink and warm pizza");}
	};
	/**
	 * display the menu of the promotional package
	 */
	 public void displayItem() {
		 System.out.println("+----------------------------------------+");
		 System.out.println("|         Promotional Package            |");
		 System.out.println("+----------------------------------------+");
	 	for(int i=1; i<bundle.size()+1; i++){
			System.out.println(bundle.get(i) +": " + bundle_desc.get(i) + " ($" + bundle_prices.get(i)+")");
		}
	}

	/**
	 * add an bundle into the menu (with the the assigned bundle id)
	 */
	 static void addItem() {
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
		 bundle_price*=0.9;
		if(bundle_items.size() != 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter description:");
			String desc = sc.nextLine();
			bundle.put(id_bundle, bundle_items);
			bundle_prices.put(id_bundle, bundle_price);
			bundle_desc.put(id_bundle, desc);
		}
	}

	/**
	 * remove an bundle by removing the bundle id
	 */
	 public static void removeitem() {
		System.out.println("Select id bundle to delete");
		Scanner sc = new Scanner(System.in);
		int id;
		 String ss;
		 int cout = 0;
		 do {
			 cout += 1;
			 if(cout >= 2) {System.out.println("Integer only");
				 System.out.println("Select id bundle to delete");}
			 ss = sc.nextLine();

		 } while (!(ss.matches("[0-9]+") && ss.length() > 0));
		 id = Integer.parseInt(ss);


		if(bundle.containsKey(id)){
			bundle.remove(id);
			bundle_prices.remove(id);
			bundle_desc.remove(id);
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Invalid id");
		}
	}


}
