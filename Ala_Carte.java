import java.util.HashMap;


public class Ala_Carte implements Item{

	public static HashMap<String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>() {{put("Coca Cola",100);put("Ice cream",66);put("Pizza",123);put("Spaghetti",444); }};
	//Name of item, price
	public static HashMap<String, String> descriptions = new HashMap <String,  String>(){{put("Coca Cola","Cool");put("Ice cream","Cold");put("Pizza","Hot");put("Spaghetti","Delicious"); }};
	//Name of item, description
	public static HashMap<String, String> categories = new HashMap <String,  String>(){{put("Coca Cola","Drinks");put("Ice cream","Dessert");put("Pizza","Main Course");put("Spaghetti","Main Course"); }};
	//Name of item, categories

	public void addItem( String item , String description, int price, String category) {
		Ala_Carte.Menu_of_restaurants.put(item, price);
		Ala_Carte.descriptions.put(item, description);
		Ala_Carte.categories.put(item, category);
	}

	public void removeItem(String item) {
		if(Ala_Carte.Menu_of_restaurants.containsKey(item)){
			Ala_Carte.Menu_of_restaurants.remove(item);
			Ala_Carte.categories.remove(item);
			Ala_Carte.descriptions.remove(item);
		}

	}

	

	public void displayItem(){

		String[] catecate= {"Main Course", "Drinks", "Dessert"};
		for(String cate:catecate){
			System.out.println("******* " + cate +" ******* ");
			for(String key: Ala_Carte.Menu_of_restaurants.keySet()) {
				if(Ala_Carte.categories.get(key).equals(cate)) {
					System.out.println(key +": " + Ala_Carte.descriptions.get(key) + "($"+Ala_Carte.Menu_of_restaurants.get(key)+")");
				}
			}
		}

	}

}
