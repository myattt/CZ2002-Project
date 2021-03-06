import java.text.DecimalFormat;
import java.util.*;

public class OrderInvoice {
	private static double taxRate=0.07;
	private static double discountRate=0.1;
	private static double svcCharge=0.1;
	
	/**
	 * prints Order Invoice (receipt)
	 * @param custID uses unique customer ID to find Customer's Order 
	 * @param custlist list of customers 
	 */
	public void printInvoice(int custID,CustomerList custlist)
	{
		//timestamp
		//and a complete breakdown of order items details with taxes, discountRate,svcCharge
		DecimalFormat df = new DecimalFormat("0.00");
		Customer customer =custlist.getCust(custID);
		String Header =
                 "\n***********Pub & Grill************\n"
                 // add timestamp of current time and date 
                  + "         Pulau NTU S60056          \n"
                  + "           Tel: 65652722           \n"
                  + "-----------------------------------\n"
                  + "Customer:"+ customer.getCustomerName()+"\n"
                  + "Table ID:"+ customer.getTableId()+"\n"
                  + "Staff:"+ customer.getStaffName()+"\n"
                  + "Date:"+ customer.getDate()[1] + "/" + customer.getDate()[0]+ "/"+ Calendar.getInstance().get(Calendar.YEAR)+"\n"
                  + "Time:"+ (customer.getDate()[2]+2) +":"+customer.getDate()[3]+"\n"
                  + "Items Ordered                    \n"
                  + "Name             Qty       Amount\n"
                //add order items and price and quantity
                  + "-----------------------------------";
      
          // String a=jLabel4.getText()+"      "+jTextField1.getText()+"      "+jLabel2.getText()+"\n;";
          //String h=Header+a;
      String amt  =
                  "-----------------------------------\n"
    		  	// add in subtotal amount
                  + "SubTotal Amount:        	 "+ df.format(calcSubtotal(customer)) +"\n"
    		    // calculate gst 
                  + "7% GST:			             "+ df.format(calcGST(customer))+"\n"
    		  	// calculate svc charge  
    		  	  + "10% GST:		             "+ df.format(calcSvcCharge(customer))+"\n"
    		  	  + "Member Discount:	       -"+ df.format(calcDiscount(customer))+"\n"
    		    // add in total amt with gst, svccharge and discount
                  + "Total Amount:		    SGD"+df.format(calcTotal(customer))+"\n"
                  + "-----------------------------------\n"
                  + "***********************************\n"
                  + "             Thank You              \n"
                  + "___________________________________\n";
      
      	System.out.println(Header);
      	findAlaQuantity(customer);
      	System.out.println(amt);
      	
	}
	
	/**
	 * calculates subtotal (without GST,disount,service charge)
	 * @param customer unique Customer object to calculate subtotal of their order
	 * @return subTotal
	 */
	public double calcSubtotal(Customer customer) {
		return (double) customer.getTotalPrice();
	}
	
	/**
	 * returns total amount including GST, discount and service charge 
	 * @param customer unique Customer object to calculate total of their order
	 * @return Total 
	 */
	public double calcTotal(Customer customer)
	{
		return(customer.getTotalPrice() - calcDiscount(customer)+ calcGST(customer) + calcSvcCharge(customer));
	}
	
	/**
	 * calculates discount customer is entitled to(if customer has membership)
	 * @param customer unique Customer object to calculate membership discount
	 * @return discount if customer has membership,
	 * return 0.00 if customer has no membership
	 */
	public double calcDiscount(Customer customer)
	{
		if(customer.getMembership())
			return (customer.getTotalPrice()*discountRate);
		return(0.00);
		
	}
	
	/**
	 * calculates GST customer has to pay
	 * @param customer unique Customer object to calculate GST incurred
	 * @return GST customer has to pay
	 */
	public double calcGST(Customer customer)
	{
		return( customer.getTotalPrice()*taxRate);
		
	}
	
	/**
	 * calculates service charge customer has to pay
	 * @param customer unique Customer object to calculate service charge incurred
	 * @return service charge customer has to pay
	 */
	public double calcSvcCharge(Customer customer)
	{
		return(customer.getTotalPrice()*svcCharge);
	}
	
	/**
	 * prints items and quantity of items that customer has purchased 
	 * @param cust unique Customer object to find 
	 * Customer's AlaCarte and PromotionalPackage order 
	 * and quantity of each items ordered
	 */
	public void findAlaQuantity(Customer cust) {
		DecimalFormat df = new DecimalFormat("0.00");
		List<String> ala_list = Arrays.asList(cust.getAlaOrder());
		Set<String> distinct = new HashSet<>(ala_list);
		int fixed_num = 18;
        for (String s: distinct) {
        	int quantity = Collections.frequency(ala_list, s);
			String ItemNameSpacing = new String(new char[18 - s.toString().length()]).replace('\0', ' ');
			String ItemNameSpacing2 = new String(new char[18 - s.toString().length()]).replace('\0', ' ');
            System.out.println(s + ItemNameSpacing2 + quantity + "           " + df.format(Ala_Carte.Menu_of_restaurants.get(s)*quantity));
	}
        List<Integer> bunbun_list = Arrays.asList(cust.getBundleOrder());
		Set<Integer> distinctbundle = new HashSet<>(bunbun_list);
        for (Integer s: distinctbundle) {
        	int quantity = Collections.frequency(bunbun_list, s);

        	String ItemNameSpacing = new String(new char[12 - s.toString().length()]).replace('\0', ' ');
			String ItemNameSpacing2 = new String(new char[12 - s.toString().length()]).replace('\0', ' ');
			System.out.println("Bundle" + s + ItemNameSpacing2 + quantity + ItemNameSpacing + df.format(Promotional_Package.bundle_prices.get(s)*quantity));
	}
	}
}
