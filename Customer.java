public class Customer { 
	 
	   private int pax;
	   private int cust_id; 
	   private String cust_name; 
	   private int tableId; 
	   private boolean membership;
	    
	   public Customer() {}
	   
	   public Customer(int cust_id) { 
	    this.cust_id = cust_id;  
	    // TODO - implement Customer.operation 
	   } 
	    
	    
	   public int getCustomerID() { 
	    return this.cust_id; 
	   } 
	    
	   public String getCustomerName() { 
	    return this.cust_name; 
	   } 
	    
	   public int getTableId() { 
	    return this.tableId; 
	   } 
	    
	   public void setCustomerID(int cust_id) { 
	    this.cust_id = cust_id; 
	   } 
	    
	   public void setCustomerName(String cust_name) { 
	    this.cust_name = cust_name; 
	   } 
	    
	   public void setTableId(int tableId) { 
	    this.tableId = tableId; 
	   } 
	   
	   public void member(boolean membership) {
	    this.membership = membership;
	  }
	   public void setPaxSize(int paxsize)
	   {
		   this.pax=paxsize;
	   }
	   public int getPaxSize()
	   {
		   return this.pax;
	   }
	}
