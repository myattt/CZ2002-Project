public class Menu {

    private int promo_items;
    private int alacarte_items;
    private String item;
    private String description;


    public void addMenuItem( String item , String description, int price) {
        UI.Menu_of_restaurants.put(item,price);
    }

    public void removeMenuItem(String item) {
        UI.Menu_of_restaurants.remove(item);
    }

    public void updateMenuItem() {
        // TODO - implement Menu.updateMenuItem
        throw new UnsupportedOperationException();
    }

    public void displayMenu() {
        System.out.println(UI.Menu_of_restaurants);
    }

}
