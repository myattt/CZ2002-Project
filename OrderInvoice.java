public class OrderInvoice {
	private static double taxRate=0.07;
	private static double discountRate=0.1;
	private static double svcCharge=0.1;
	
	public double calcTotalPrice()
	{
		double price;
		
		return price;
	}
	
	public void printInvoice(int custID,CustomerList custlist)
	{
		//timestamp
		//and a complete breakdown of order items details with taxes, discountRate,svcCharge
		Customer customer =custlist.getCust(custID);
		String Header =
                 "******Pub & Grill*******;"
                 // add timestamp of current time and date 
                  + "         Pulau NTU S60056        \n;"
                  + "          Tel: 65652722          \n;"
                  + "---------------------------------\n;"
                  + "Customer:"+ customer.getCustomerName()+"\n;"
                  + "Table ID:"+ customer.getTableId()+"\n;"
                  + "Staff:"+ customer.getStaffName()+"\n;"
                  + "Items Ordered                    \n;"
                  + "Name             Qty       Amount\n;"
                //add order items and price and quantity
                  + "---------------------------------\n;";
      
          // String a=jLabel4.getText()+"      "+jTextField1.getText()+"      "+jLabel2.getText()+"\n;";
          //String h=Header+a;
      String amt  =
                  "\n;---------------------------------\n;"
    		  	// add in subtotal amount
                //  + "SubTotal Amount:      SGD"+SUBTOTALAMT+"\n;"
    		    // calculate gst 
                //  + "7% GST:"+ CALCGST+"\n;"
    		  	// calculate svc charge  
    		  	//  + "10% GST:"+ SVCCHARGE+"\n;
    		    // add in total amt with gst, svccharge and discount
                //  + "Total Amount:      SGD"+TOTALAMT+"\n;"
                  + "---------------------------------\n;"
                  + "*********************************\n;"
                  + "            Thank You             \n;"
                  + "_________________________________\n;";
	}
	
	public void removeInvoice(int cust)
	{
		
	}
	public double calcSubtotal()
	{
		
	}
	public double calcTotal()
	{
		
	}
	public double calcGST()
	{
		
	}
	public double calcSvcCharge()
	{
		
	}

}
