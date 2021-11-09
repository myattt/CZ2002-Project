import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Calendar;

public class CustomerList {
	int var=1001;
	static ArrayList<Customer> list = new ArrayList<Customer>();
	int cust_id;
	
	/**
	 * To print out details of all customers in the CustomerList , prints customer's Name , Id , TableId, 
	 * Ala carte and Bundle order , Staff information and Total Price
	 */
	
	public void printList() {
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println("Customer Name:	" + list.get(i).getCustomerName());
			System.out.println("Customer Id:	" + list.get(i).getCustomerID());
			System.out.println("Table Id:	" + list.get(i).getTableId());
			if(list.get(i).getAlaOrder()==null && list.get(i).getBundleOrder()==null)
				System.out.println("Order has not been placed.");
			else {
			System.out.println("Ala Carte Orders: " + Arrays.toString(list.get(i).getAlaOrder()));
			System.out.println("Bundle Orders: " + Arrays.toString(list.get(i).getBundleOrder()));
			System.out.println("The staff who serves you is " + list.get(i).getStaffName() +", " + list.get(i).getStaffGender()+", "+list.get(i).getStaffPos());

			System.out.println("Total Price: $" + list.get(i).getTotalPrice());
			System.out.println();
			}
			
			
		}
	}
	
	/**
	 * finds the relevant Customer object and remove it from CustomerList
	 * @param cust_id
	 */
	
	public void removeCust(int cust_id) {
		for(int i=0; i<list.size();i++) {
  			if(list.get(i).getCustomerID()==cust_id) {
  				list.remove(i);
  				System.out.println("Removed");
  				break;
  			}
  		}
	}
	/**
	 * Traverse the CustomerList to find if customer exits, by matching the cust_id from the parameter 
	 * and stored Customer Id
	 * @param cust_id
	 * @return
	 */
	
  	public boolean checkCustInfo(int cust_id)
  	{
  		for(int i=0; i<list.size(); i++) {
  			int foundId = list.get(i).getCustomerID();
  			if(foundId == cust_id)
  				return true;
  		}
  		return false;
  	}
  	
  	/**
  	 * Creates a new Customer object with relevant customer details in parameter, adds Customer into the CustomerList 
  	 * and returns the Customer
  	 * @param name
  	 * @param cust_id
  	 * @param membership
  	 * @param paxsize
  	 * @param contact
  	 * @return
  	 */
  
  	public Customer createCust(String name , int cust_id , boolean membership,int paxsize, double contact)
  	{
  		
  		this.cust_id=cust_id;
  		Customer newCust = new Customer(paxsize, cust_id, name, membership, contact);
  		list.add(newCust);
  		return newCust;
  		
  	}
  	
  	/**
  	 * Finds the Customer by matching cust_id from parameter and the Stored customer Id. 
  	 * If found, the customer object will be returned.
  	 * @param cust_id
  	 * @return
  	 */
  	
  	public Customer getCust(int cust_id) 
  	{
  		int foundId;
  		for(int i=0 ; i<list.size() ; i++) {
  			foundId = list.get(i).getCustomerID();
  			if(foundId==cust_id) 
  				return list.get(i);
  		}
  		return null;
  	}
  	
  	/**
  	 * Generates a unique customer Id that is assigned to new customers
  	 * @return
  	 */
  	public int getCustID() 
  	{
  		return var++;
  	}
  	
  	/**
  	 * Traverse the CustomerList to find the relevant customer based on cust_id parameter. 
  	 * If customer is found, returns the date array that contains date and time of Customer Reservation
  	 * @param cust_id
  	 * @return
  	 */
  	public int[] getCustDate(int cust_id) {
  		int[] date=null;
  		for(int i=0; i<list.size();i++) {
  			if(list.get(i).getCustomerID()==cust_id) {
  				date = list.get(i).getDate();
  				break;
  			}
  		}
  		//int[] date = list.get(cust_id).getDate();
  		return date;
  	}
	
  	/**
  	 * returns the size of CustomerList or the number of Customers in the CustomerList
  	 * @return
  	 */
  	public int getCListSize()
  	{
  		return list.size();
  	}
  	
}
