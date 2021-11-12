import java.util.HashMap;


public class Ala_Carte implements Item{

	public static HashMap<String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>() {};
	//Name of item, price
	public static HashMap<String, String> descriptions = new HashMap <String,  String>(){};
	//Name of item, description
	public static HashMap<String, String> categories = new HashMap <String,  String>(){};
	//Name of item, categories

	/**
	 * adding item into AlaCarte Menu
	 * @param item String: name of the item added
	 * @param description String: the description of the item
	 * @param price int: the price of the item
	 * @param category String: the category of the item (Main Course, Drinks or Dessert)
	 */
	public static void addItem( String item , String description, int price, String category) {
		Ala_Carte.Menu_of_restaurants.put(item, price);
		Ala_Carte.descriptions.put(item, description);
		Ala_Carte.categories.put(item, category);
	}

	/**
	 * remove the item out of the AlaCarte menu
	 * @param item String: name of the item want to be removed
	 */
	public void removeItem(String item) {
		if(Ala_Carte.Menu_of_restaurants.containsKey(item)){
			Ala_Carte.Menu_of_restaurants.remove(item);
			Ala_Carte.categories.remove(item);
			Ala_Carte.descriptions.remove(item);
		}

	}


	/**
	 * to display the menu of ala carte
	 */
	public void displayItem(){

		String[] catecate= {"Main Course", "Drinks", "Dessert"};
		for(String cate:catecate){
			System.out.println("+----------------------------------------+");
			String ItemNameSpacing = new String(new char[19 - cate.length()]).replace('\0', ' ');
			System.out.println("|         "+cate+ ItemNameSpacing+"            |");
			System.out.println("+----------------------------------------+");
			for(String key: Ala_Carte.Menu_of_restaurants.keySet()) {
				if(Ala_Carte.categories.get(key).equals(cate)) {
					System.out.println(key +": " + Ala_Carte.descriptions.get(key) + "($"+Ala_Carte.Menu_of_restaurants.get(key)+")");
				}
			}
		}

	}

}
