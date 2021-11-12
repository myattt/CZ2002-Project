import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class SalesRevenueReport {

	private int period;
	private int individual_sales_items;
	private int total_revenue;


	/**
	 * print monthly sales report , which includes the total sales revenue for each month
	 * @param cust_list 	list of customer Objects
	 */

	public static void generateByMonth(CustomerList cust_list) {
		ArrayList<String>dates = new ArrayList<>();
		HashMap<String, Integer> revenue_month= new HashMap<String,Integer>();





		for(int i=0 ; i<CustomerList.list.size() +100; i++) {
			try{
			int[] date = cust_list.getCustDate(i+1001);
			String day = "Month "+ String.valueOf(date[0]);
			revenue_month.put(day, 0);
		}catch(Exception e){}
		}


		for(int i=0 ; i<CustomerList.list.size() +100; i++) {
			try{
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


			int[] date = cust_list.getCustDate(i+1001);
			String day = "Month "+ String.valueOf(date[0]);

			revenue_month.put(day, revenue_month.get(day) + total_price);
		}catch(Exception e){}
		}

		System.out.println(
				"+----------------------------------------+");
		System.out.println(
				"|             Revenue By Month           |");
		System.out.println(
				"+----------------------------------------+");

		for(String x : revenue_month.keySet()){
			try{
			System.out.print(x + "\t: $");
			System.out.println(revenue_month.get(x));
		}catch(Exception e){}
		}
	}


	/**
	 * prints individual sales report for each month
	 */
	public static void individualitemsales(CustomerList cust_list){


		HashMap<String, Integer> revenue_month= new HashMap<String,Integer>();

		for(int i=0 ; i<CustomerList.list.size() +100; i++) {
			try{
				int[] date = cust_list.getCustDate(i+1001);
				String day = "Month "+ String.valueOf(date[0]);
				revenue_month.put(day, 0);
			}catch(Exception e){}
		}

		for(String x : revenue_month.keySet()){
			try{
				HashMap<String, Integer> item_sales= new HashMap<String,Integer>();
				HashMap<Integer, Integer> item_bundle_sales= new HashMap<Integer,Integer>();
				for(String item: Ala_Carte.Menu_of_restaurants.keySet()){
					item_sales.put(item, 0);
				}
				for(Integer item: Promotional_Package.bundle.keySet()){
					item_bundle_sales.put(item, 0);
				}

				for(int i=0 ; i<CustomerList.list.size() +100; i++) {
					try {
						int[] date = cust_list.getCustDate(i + 1001);
						if (date[0] == Integer.parseInt(x.substring(6))) {
							for(String item: CustomerList.list.get(i).getAlaOrder()){
								item_sales.put(item, item_sales.get(item) + 1);
							}

							for(Integer item: CustomerList.list.get(i).getBundleOrder()){
								item_bundle_sales.put(item, item_bundle_sales.get(item) + 1);
							}
						}
					}catch(Exception e){}
				}

				System.out.println(x);
				//System.out.println(item_sales);
				System.out.println(
						"\n+----------------------------------------+");
				System.out.println(
						"|          Individual Item Sales         |");
				System.out.println(
						"+----------------------------------------+");
				System.out.println("\n----Ala Carte----------------------------");
				DecimalFormat df = new DecimalFormat("0.00");
				String it = "Item";
				String qu = "Quantity";
				String pr = "Price";
				String nnn = new String(new char[18 - qu.length()]).replace('\0', ' ');
				System.out.println(it + nnn + qu + "     " + pr);
				for(String xx : item_sales.keySet()){
					String ItemNameSpacing = new String(new char[18 - xx.toString().length()]).replace('\0', ' ');
					System.out.println(xx + ItemNameSpacing + item_sales.get(xx) + "        $" + df.format(Ala_Carte.Menu_of_restaurants.get(xx)*item_sales.get(xx)));
				}
				
				
				//System.out.println(item_bundle_sales);
				
				System.out.println("\n----Promotional Package------------------");
				df = new DecimalFormat("0.00");
				it = "Item";
				qu = "Quantity";
				pr = "Price";
				nnn = new String(new char[18 - qu.length()]).replace('\0', ' ');
				System.out.println(it + nnn + qu + "     " + pr);
				for(Integer xx : item_bundle_sales.keySet()){
					String ItemNameSpacing = new String(new char[7 - xx.toString().length()]).replace('\0', ' ');
					System.out.println("Bundle ID: "+ xx + ItemNameSpacing + item_bundle_sales.get(xx) + "        $" + df.format(Promotional_Package.bundle_prices.get(xx)*item_bundle_sales.get(xx)));
				}
				System.out.println("\n");
				

			}catch(Exception e){}
		}

	}



}
