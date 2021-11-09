import java.util.Calendar;
import java.util.ArrayList;

public class Customer { 
	 
	   private int pax;
	   private int cust_id; 
	   private String cust_name; 
	   private int tableId; 
	   private boolean membership;
	   private double contact;
	   private String[] ala;
	   private Integer[] bundle;
	   private String staff_name;
	   private String staff_gender;
	   private String staff_position;
	   private int employeeID;
	   private int totalPrice;
	   private int month;
	   private int day;
	   private int minute;
	   private int hours;

	   
	  /**
	    * constructor to initialise customer 
	    * @param pax
	    * @param cust_id
	    * @param cust_name
	    * @param membership
	    * @param contact
	    */
	   public Customer(int pax, int cust_id, String cust_name, boolean membership, double contact) { 
	    this.pax=pax;
		this.cust_id = cust_id;  
	    this.cust_name=cust_name;
	    this.membership=membership;
	    this.contact=contact;
	    // TODO - implement Customer.operation 
	   } 
	    
	    /**
	     * Retrieve the ID of the customer
	     * @return int cust_id
	     */
	   public int getCustomerID() { 
	    return this.cust_id; 
	   } 
	
	   /**
	    * @return String cust_name;
	    */

	   public String getCustomerName() { 
	    return this.cust_name; 
	   } 
	    
	   /**
	    * 
	    * @return int tableId
	    */
	   public int getTableId() { 
	    return this.tableId; 
	   } 
	
	   /**
	    * sets id of customer
	    * @param cust_id
	    */
	   public void setCustomerID(int cust_id) { 
	    this.cust_id = cust_id; 
	   } 
	   /**
	    * sets customer name
	    * @param cust_name
	    */
	   
	   public void setCustomerName(String cust_name) { 
	    this.cust_name = cust_name; 
	   } 
	   /**
	    * set tableid for customer 
	    * @param tableId
	    */
	   
	   public void setTableId(int tableId) { 
	    this.tableId = tableId; 
	   } 
	   /**
	    * set membership for customer ( if they have membership)
	    * @param membership
	    */
	   public void member(boolean membership) {
	    this.membership = membership;
	  }
	   /**
	    * checks if customer has membership
	    * @return boolean membership
	    */
	   
	   public boolean getMembership() {
		   return this.membership;
	   }
	   /**
	    * set paxsize of customer
	    * @param paxsize
	    */
	   public void setPaxSize(int paxsize)
	   {
		   this.pax=paxsize;
	   }
	   /**
	    * return paxsize of customer 
	    * @return int pax
	    */
	   public int getPaxSize()
	   {
		   return this.pax;
	   }
	   /**
	    * set contact of customer
	    * @param contact
	    */
	   public void setContact(double contact)
	   {
		   this.contact=contact;
	   }
	   /**
	    * set alacarte order for customer 
	    * @param ala
	    */
	   public void setAlaOrder(String[] ala)
	   {
		   this.ala=ala;
	   }
	   /**
	    * set promotional order for customer 
	    * @param bundle
	    */
	   public void setBundleOrder(Integer[] bundle)
	   {
		   this.bundle=bundle;
	   }
	   /**
	    * get alacarte order details for customer 
	    * @return String[] ala
	    */
	   
	   public String[] getAlaOrder()
	   {
		   return this.ala;
	   }
	   /**
	    * get bundleorder details for customer 
	    * @return Integer[] bundle
	    */
	   public Integer[] getBundleOrder()
	   {
		   return this.bundle;
	   }
	   
	   /**
	    * 
	    * @param staff_name
	    * @param staff_gender
	    * @param staff_position
	    * @param employeeID
	    */
	   
	   public void setStaffinfo(String staff_name , String staff_gender , String staff_position ,int employeeID) {
		   this.staff_name = staff_name;
		   this.staff_gender = staff_gender;
		   this.staff_position = staff_position;
		   this.employeeID = employeeID;
	   }
	   
	   /**
	    * 
	    * @return String staff_name;
	    */
	   public String getStaffName()
	   {
		   return this.staff_name;
	   }
	   /**
	    * 
	    * @return String staff_gender
	    */
	   
	   public String getStaffGender()
	   {
		   return this.staff_gender;
	   }
	   /**
	    * 
	    * @return String staff_position
	    */
	   public String getStaffPos()
	   {
		   return this.staff_position;
	   }
	   /**
	    * 
	    * @return employeeID
	    */
	   public int getEmployeeId()
	   {
		   return this.employeeID;
	   }
	   /**
	    * 
	    * @return totalPrice
	    */
	   public int getTotalPrice() {
		   	String[] alaorder = this.ala;
			Integer[] bunbun = this.bundle;
			int total_price = 0;
			int total_prices_ala = 0;
			
			for(int k = 0; k < ala.length; k++){
				total_prices_ala += Ala_Carte.Menu_of_restaurants.get(alaorder[k]);
			}
			int total_prices_bunbun = 0;
			for(int k = 0; k < bunbun.length; k++){
				total_prices_ala += Promotional_Package.bundle_prices.get(bunbun[k]);
			}
			total_price = total_prices_ala + total_prices_bunbun;
			this.totalPrice = total_price;
			return this.totalPrice;
	   }
	   /**
	    * 
	    * @return int[] date
	    */
       public int[] getDate() {
		   int[] date = {month,day,hours,minute};
		   return date;
	   }
       /**
        * 
        * @param month
        * @param day
        * @param hours
        * @param minutes
        */
	   public void setDate(int month, int day, int hours, int minutes) {
		  this.month = month;
		  this.day = day;
		  this.hours = hours;
		  this.minute = minutes;

	   }
	

	}
