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
	    * Constructor that initialises Customer's pax, cust_id, membership and contact
	    * @param pax stores Customer's pax
	    * @param cust_id stores Customer's ID
	    * @param cust_name stores Customer's name
	    * @param membership stores information of Customer's membership
	    * @param contact stores Customer's contact
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
	    * accessor of Customer's ID
	    * @return cust_id if it exists, null if Customer does not exist
	    */
	   public int getCustomerID() { 
	    return this.cust_id; 
	   } 
	
	   /**
	    * accessor of Customer's name
	    * @return cust_name if it exists, null if Customer does not exist 
	    */

	   public String getCustomerName() { 
	    return this.cust_name; 
	   } 
	    
	  /**
	   * accessor of Customer's tableId
	   * @return tableId if it exists, null if Customer does not exist
	   */
	   public int getTableId() { 
	    return this.tableId; 
	   } 
	
	   /**
	    * mutator of Customer's ID
	    * @param cust_id 
	    */
	   public void setCustomerID(int cust_id) { 
	    this.cust_id = cust_id; 
	   } 
	   
	   /**
	    * mutator of Customer's name
	    * @param cust_name
	    */
	   public void setCustomerName(String cust_name) { 
	    this.cust_name = cust_name; 
	   } 
	   
	   /**
	    * mutator of Table's ID
	    * @param tableId
	    */
	   public void setTableId(int tableId) { 
	    this.tableId = tableId; 
	   } 
	   
	   /**
	    * mutator of Customer's membership
	    * @param membership
	    */
	   public void member(boolean membership) {
	    this.membership = membership;
	  }
	   /**
	    * accessor of Customer's membership
	    * @return membership
	    */
	   public boolean getMembership() {
		   return this.membership;
	   }
	   /**
	    * mutator of Customer's paxsize
	    * @param paxsize
	    */
	   public void setPaxSize(int paxsize)
	   {
		   this.pax=paxsize;
	   }
	   
	   /**
	    * accessor of Customer's paxsize 
	    * @return pax paxsize of Customer
	    */
	   public int getPaxSize()
	   {
		   return this.pax;
	   }

	   /**
	    * mutator of Customer's contact 
	    * @param contact
	    */
	   public void setContact(double contact)
	   {
		   this.contact=contact;
	   }
	   
	   /**
	    * mutator of Customer's AlaCarte Order
	    * @param ala
	    */
	   public void setAlaOrder(String[] ala)
	   {
		   this.ala=ala;
	   }

	   /**
	    * mutator of Customer's Promotional Package Order
	    * @param bundle
	    */
	   public void setBundleOrder(Integer[] bundle)
	   {
		   this.bundle=bundle;
	   }
	   
	   /**
	   * accessor of Customer's AlaCarte Order 
	   * @return Customer's AlaCarte Order
	   */
	   public String[] getAlaOrder()
	   {
		   return this.ala;
	   }
	   
	   /**
	   * mutator of Customer's Promotional Package Order 
	   * @return Customer's Promotional Package Order
	    */
	   public Integer[] getBundleOrder()
	   {
		   return this.bundle;
	   }
	   
	   /**
	    * mutator of Staff's name, gender, position and employeeID
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
	   * accessor of Staff's name
	   * @return staff_name 
	   */
	   public String getStaffName()
	   {
		   return this.staff_name;
	   }
	   
	  /**
	   * accessor of Staff's gender
	   * @return staff_gender 
	   */
	   public String getStaffGender()
	   {
		   return this.staff_gender;
	   }
	   
	   /**
	    * accessor of Staff's position
	    * @return staff_position
	    */
	   public String getStaffPos()
	   {
		   return this.staff_position;
	   }
	   
	   /**
	    * accessor of Staff's EmployeeID
	    * @return employeeID
	    */
	   public int getEmployeeId()
	   {
		   return this.employeeID;
	   }
	   
	   /**
	    * calculates total price of Customer's order
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
	    * returns date of Customer's reservation 
	    * @return date
	    */
       public int[] getDate() {
		   int[] date = {month,day,hours,minute};
		   return date;
	   }
       
       /**
        * mutator of Customer's reservation month, day, hours, minutes
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
