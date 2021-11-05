import java.text.DecimalFormat;
import java.util.*;

public class OrderInvoice {
	private static double taxRate=0.07;
	private static double discountRate=0.1;
	private static double svcCharge=0.1;
	
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
                  + "SubTotal Amount:      	   "+ df.format(calcSubtotal(customer)) +"\n"
    		    // calculate gst 
                  + "7% GST:			   "+ df.format(calcGST(customer))+"\n"
    		  	// calculate svc charge  
    		  	  + "10% GST:		   "+ df.format(calcSvcCharge(customer))+"\n"
    		  	  + "Member Discount:	   -"+ df.format(calcDiscount(customer))+"\n"
    		    // add in total amt with gst, svccharge and discount
                  + "Total Amount:		SGD"+df.format(calcTotal(customer))+"\n"
                  + "-----------------------------------\n"
                  + "***********************************\n"
                  + "             Thank You              \n"
                  + "___________________________________\n";
      
      	System.out.println(Header);
      	findAlaQuantity(customer);
      	System.out.println(amt);
      	
	}
	
	public double calcSubtotal(Customer customer) {
		return (double) customer.getTotalPrice();
	}
	
	public double calcTotal(Customer customer)
	{
		return(customer.getTotalPrice() - calcDiscount(customer)+ calcGST(customer) + calcSvcCharge(customer));
	}
	public double calcDiscount(Customer customer)
	{
		if(customer.getMembership())
			return (customer.getTotalPrice()*discountRate);
		return(0.00);
		
	}
	public double calcGST(Customer customer)
	{
		return( customer.getTotalPrice()*taxRate);
		
	}
	public double calcSvcCharge(Customer customer)
	{
		return(customer.getTotalPrice()*svcCharge);
	}
	
	public void findAlaQuantity(Customer cust) {
		DecimalFormat df = new DecimalFormat("0.00");
		List<String> ala_list = Arrays.asList(cust.getAlaOrder());
		Set<String> distinct = new HashSet<>(ala_list);
        for (String s: distinct) {
        	int quantity = Collections.frequency(ala_list, s);
            System.out.println(s + "	  " + quantity + "	   " + df.format(Ala_Carte.Menu_of_restaurants.get(s)*quantity));
	}
        List<Integer> bunbun_list = Arrays.asList(cust.getBundleOrder());
		Set<Integer> distinctbundle = new HashSet<>(bunbun_list);
        for (Integer s: distinctbundle) {
        	int quantity = Collections.frequency(bunbun_list, s);
            System.out.println("Bundle " + s + "	  " + quantity + "	   " + df.format(Promotional_Package.bundle_prices.get(s)*quantity));
	}
	}
}
