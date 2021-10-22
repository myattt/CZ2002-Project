import java.util.HashMap;
import java.util.Enumeration;
public class Menu {

//    public static HashMap<String, Integer> Menu_of_restaurants = new HashMap <String,  Integer>();


    public void addMenuItem( String item , String description, int price, String category) {
        UI.Menu_of_restaurants.put(item, price);
        UI.descriptions.put(item, description);
        UI.categories.put(item, category);
    }

    public void removeMenuItem(String item) {
        if(UI.Menu_of_restaurants.containsKey(item)){
            UI.Menu_of_restaurants.remove(item);
            UI.categories.remove(item);
            UI.descriptions.remove(item);
        }

    }

    public boolean checkifexist(String item) {
        if(UI.Menu_of_restaurants.containsKey(item)){
            return true;
        }

        return false;
    }

    public void displayMenu() {

        String[] catecate= {"Main Course", "Drinks", "Dessert"};
        for(String cate:catecate){
            System.out.println("******* " + cate +" ******* ");
            for(String key: UI.Menu_of_restaurants.keySet()) {
                if(UI.categories.get(key).equals(cate)) {
                    System.out.println(key +": " + UI.descriptions.get(key) + "($"+UI.Menu_of_restaurants.get(key)+")");
                }
            }
        }

    }

}
