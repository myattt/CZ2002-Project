import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SalesRevenueReport {

	private int period;
	private int individual_sales_items;
	private int total_revenue;



	public static void generateByDay() {
		ArrayList<String>dates = new ArrayList<>();
		HashMap<String, Integer> revenue_day= new HashMap<String,Integer>();

		for(int i=0 ; i<CustomerList.list.size() ; i++) {

			if(!dates.contains(CustomerList.list.get(i).getRDate().getTime().toString().substring(0,10))) {
				dates.add(CustomerList.list.get(i).getRDate().getTime().toString().substring(0, 10));
				revenue_day.put(CustomerList.list.get(i).getRDate().getTime().toString().substring(0, 10) , 0);
			}
		}


		for(int i=0 ; i<CustomerList.list.size() ; i++) {
			String[] ala = CustomerList.list.get(i).getAlaOrder();
			Integer[] bunbun = CustomerList.list.get(i).getBundleOrder();
			int total_price = 0;
			int total_prices_ala = 0;
			for(int k = 0; k < ala.length; k++){
				total_prices_ala += Ala_Carte.Menu_of_restaurants.get(ala[k]);
			}
			int total_prices_bunbun = 0;
			for(int k = 0; k < bunbun.length; k++){
				total_prices_ala += Promotional_Package.bundle_prices.get(bunbun[k]);
			}
			total_price = total_prices_ala + total_prices_bunbun;




			revenue_day.put(CustomerList.list.get(i).getRDate().getTime().toString().substring(0,10),revenue_day.get(CustomerList.list.get(i).getRDate().getTime().toString().substring(0,10)) + total_price);
		}
		System.out.println("REVENUE BY DAY");
		for(String x : revenue_day.keySet()){
			System.out.print(x + ": $");
			System.out.println(revenue_day.get(x));
		}
	}

	public static void generateByMonth() {
		ArrayList<String>dates = new ArrayList<>();
		HashMap<String, Integer> revenue_month= new HashMap<String,Integer>();

		for(int i=0 ; i<CustomerList.list.size() ; i++) {
			
			if(!dates.contains(CustomerList.list.get(i).getRDate().getTime().toString().substring(4,7))) {
				dates.add(CustomerList.list.get(i).getRDate().getTime().toString().substring(4,7));
				revenue_month.put(CustomerList.list.get(i).getRDate().getTime().toString().substring(4,7) , 0);
			}
		}


		for(int i=0 ; i<CustomerList.list.size() ; i++) {
			String[] ala = CustomerList.list.get(i).getAlaOrder();
			Integer[] bunbun = CustomerList.list.get(i).getBundleOrder();
			int total_price = 0;
			int total_prices_ala = 0;
			for(int k = 0; k < ala.length; k++){
				total_prices_ala += Ala_Carte.Menu_of_restaurants.get(ala[k]);
			}
			int total_prices_bunbun = 0;
			for(int k = 0; k < bunbun.length; k++){
				total_prices_ala += Promotional_Package.bundle_prices.get(bunbun[k]);
			}
			total_price = total_prices_ala + total_prices_bunbun;




			revenue_month.put(CustomerList.list.get(i).getRDate().getTime().toString().substring(4,7),revenue_month.get(CustomerList.list.get(i).getRDate().getTime().toString().substring(4,7)) + total_price);
		}
		System.out.println("REVENUE BY MONTH");
		for(String x : revenue_month.keySet()){
			System.out.print(x + ": $");
			System.out.println(revenue_month.get(x));
		}
	}

	public static void main(String[] args) {

	}

}
