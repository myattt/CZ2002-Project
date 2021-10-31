import java.util.Calendar;
import java.util.ArrayList;

public class Customer { 
	 
	   private int pax;
	   private int cust_id; 
	   private String cust_name; 
	   private int tableId; 
	   private boolean membership;
	   private double contact;
	   private Calendar rDate;
	   private ArrayList ala;
	   private ArrayList bundle;
	     
	   public Customer(int pax, int cust_id, String cust_name, boolean membership, double contact, Calendar rDate) { 
	    this.pax=pax;
		this.cust_id = cust_id;  
	    this.cust_name=cust_name;
	    this.membership=membership;
	    this.contact=contact;
	    this.rDate=rDate;
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
	   public void setContact(double contact)
	   {
		   this.contact=contact;
	   }
	   public void setRDate(Calendar rDate)
	   {
		   this.rDate=rDate;
	   }
	   public void setAlaOrder(ArrayList ala)
	   {
		   this.ala=ala;
	   }
	   public void setBundleOrder(ArrayList bundle)
	   {
		   this.bundle=bundle;
	   }
	}
