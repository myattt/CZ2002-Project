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
	   private String[] ala;
	   private Integer[] bundle;
	   private String staff_name;
	   private String staff_gender;
	   private String staff_position;
	   private int employeeID;
	   
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
	   public void setAlaOrder(String[] ala)
	   {
		   this.ala=ala;
	   }
	   public void setBundleOrder(Integer[] bundle)
	   {
		   this.bundle=bundle;
	   }
	   
	   
	   public String[] getAlaOrder()
	   {
		   return this.ala;
	   }
	   public Integer[] getBundleOrder()
	   {
		   return this.bundle;
	   }
	   
	   public void setStaffinfo(String staff_name , String staff_gender , String staff_position ,int employeeID) {
		   this.staff_name = staff_name;
		   this.staff_gender = staff_gender;
		   this.staff_position = staff_position;
		   this.employeeID = employeeID;
	   }
	   
	   
	   public String getStaffName()
	   {
		   return this.staff_name;
	   }
	   
	   public String getStaffGender()
	   {
		   return this.staff_gender;
	   }
	   
	   public String getStaffPos()
	   {
		   return this.staff_position;
	   }
	   
	   public int getEmployeeId()
	   {
		   return this.employeeID;
	   }
	}
