import java.util.ArrayList;

public class Menu_ForCustomer {


	public void addMenuItem(String item) {
		UI.customer_menu.add(item);

	}

	public void removeMenuItem(String item) {
		UI.customer_menu.remove(item);
	}

	public void updateMenuItem() {
		// TODO - implement Menu.updateMenuItem
		throw new UnsupportedOperationException();
	}

	public void displayMenu() {
		System.out.println(UI.customer_menu);
	}

}
