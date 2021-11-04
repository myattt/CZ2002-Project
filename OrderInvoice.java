
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
                 "\n***********Pub & Grill*************\n"
                 // add timestamp of current time and date 
                  + "         Pulau NTU S60056          \n"
                  + "           Tel: 65652722           \n"
                  + "-----------------------------------\n"
                  + "Customer:"+ customer.getCustomerName()+"\n"
                  + "Table ID:"+ customer.getTableId()+"\n"
                  + "Staff:"+ customer.getStaffName()+"\n"
                  + "Items Ordered                    \n"
                  + "Name             Qty       Amount\n"
                //add order items and price and quantity
                  + "-----------------------------------\n";
      
          // String a=jLabel4.getText()+"      "+jTextField1.getText()+"      "+jLabel2.getText()+"\n;";
          //String h=Header+a;
      String amt  =
                  "\n-----------------------------------\n"
    		  	// add in subtotal amount
                  + "SubTotal Amount:      	SGD"+ df.format(calcSubtotal(customer)) +"\n"
    		    // calculate gst 
                  + "7% GST:			SGD"+ df.format(calcGST(customer))+"\n"
    		  	// calculate svc charge  
    		  	  + "10% GST:		SGD"+ df.format(calcSvcCharge(customer))+"\n"
    		  	  + "Member Discount:	-SGD"+ df.format(calcDiscount(customer))+"\n"
    		    // add in total amt with gst, svccharge and discount
                  + "Total Amount:		SGD"+df.format(calcTotal(customer))+"\n"
                  + "-----------------------------------\n"
                  + "***********************************\n"
                  + "             Thank You              \n"
                  + "___________________________________\n";
      
      	System.out.println(Header+amt);
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
	
	
	
}
