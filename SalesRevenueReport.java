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
	 * print daily sales report, which includes the total sales revenue of each order day.
	 * @param cust_list	list of customer Objects
	 */
	public static void generateByDay(CustomerList cust_list) {
		ArrayList<String>dates = new ArrayList<>();
		HashMap<String, Integer> revenue_day= new HashMap<String,Integer>();





		for(int i=0 ; i<CustomerList.list.size() +100; i++) {
			try{
			int[] date = cust_list.getCustDate(i+1001);
			String day = String.valueOf(date[1]) +"/"+String.valueOf(date[0]);
			revenue_day.put(day, 0);
		}catch(Exception e){}
		}


		for(int i=0 ; i<CustomerList.list.size() +100 ; i++) {
			try {
				String[] ala = CustomerList.list.get(i).getAlaOrder();
				Integer[] bunbun = CustomerList.list.get(i).getBundleOrder();
				int total_price = 0;
				int total_prices_ala = 0;
				for (int k = 0; k < ala.length; k++) {
					total_prices_ala += Ala_Carte.Menu_of_restaurants.get(ala[k]);
				}
				int total_prices_bunbun = 0;
				for (int k = 0; k < bunbun.length; k++) {
					total_prices_ala += Promotional_Package.bundle_prices.get(bunbun[k]);
				}
				total_price = total_prices_ala + total_prices_bunbun;


				int[] date = cust_list.getCustDate(i + 1001);
				String day = String.valueOf(date[1]) + "/" + String.valueOf(date[0]);

				revenue_day.put(day, revenue_day.get(day) + total_price);
			}catch(Exception e){}
		}

		System.out.println(
				          "+----------------------------------------+");
		System.out.println(
						   "|             Revenue By Day             |");
		System.out.println(
				          "+----------------------------------------+");
		for(String x : revenue_day.keySet()){
			try{
			System.out.print(x + "\t: $");
			System.out.println(revenue_day.get(x));
		}catch(Exception e){}
		}
	}


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
	 * print individual sales report 
	 */
	public static void individualitemsales(){

		HashMap<String, Integer> item_sales= new HashMap<String,Integer>();
		for(String item: Ala_Carte.Menu_of_restaurants.keySet()){
			item_sales.put(item, 0);
		}
		for(int i=0 ; i<CustomerList.list.size() +100; i++){
			try{
			for(String item: CustomerList.list.get(i).getAlaOrder()){
				item_sales.put(item, item_sales.get(item) + 1);
			}
		}catch(Exception e){}
		}

		System.out.println(
				"+----------------------------------------+");
		System.out.println(
				"|          Individual Item Sales         |");
		System.out.println(
				"+----------------------------------------+");
		System.out.println("----Ala Carte----------------------------");
		DecimalFormat df = new DecimalFormat("0.00");
		String it = "Item";
		String qu = "Quantity";
		String pr = "Price";
		String nnn = new String(new char[18 - qu.length()]).replace('\0', ' ');
		System.out.println(it + nnn + qu + "     " + pr);
		for(String x : item_sales.keySet()){
			try{
				String ItemNameSpacing = new String(new char[18 - x.length()]).replace('\0', ' ');
				System.out.println(x + ItemNameSpacing + item_sales.get(x) + "        $" + df.format(Ala_Carte.Menu_of_restaurants.get(x)*item_sales.get(x)));
		}catch(Exception e){}
		}
		System.out.println("----Promotional Package------------------");

		HashMap<Integer, Integer> bundle_sales= new HashMap<Integer,Integer>();
		for(Integer bun: Promotional_Package.bundle.keySet()){
			bundle_sales.put(bun, 0);
		}


		for(int i=0 ; i<CustomerList.list.size() +100; i++){
			try{
			for(Integer item: CustomerList.list.get(i).getBundleOrder()){
				bundle_sales.put(item, bundle_sales.get(item) + 1);
			}
		}catch(Exception e){}
		}



		String bid = "Bundle ID";
		System.out.println(it + nnn + qu + "     " + pr);
		for(Integer xx : Promotional_Package.bundle.keySet()){
			try{
				String ItemNameSpacing = new String(new char[18 - xx.toString().length()]).replace('\0', ' ');
				System.out.println(xx + ItemNameSpacing + bundle_sales.get(xx) + "        $" + df.format(Promotional_Package.bundle_prices.get(xx)*bundle_sales.get(xx)));
			}catch(Exception e){}
		}

	}



}
