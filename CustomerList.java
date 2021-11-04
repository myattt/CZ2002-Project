import java.util.ArrayList;
import java.util.Calendar;

public class CustomerList {

	ArrayList<Customer> list = new ArrayList<Customer>();
	int cust_id;
	
	public void printList() {
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println("Customer Name:	" + list.get(i).getCustomerName());
			System.out.println("Customer Id:	" + list.get(i).getCustomerID());
			System.out.println("Table Id:	" + list.get(i).getTableId());
			if(list.get(i).getAlaOrder()==null && list.get(i).getBundleOrder()==null)
				System.out.println("Order has not been placed.");
			else {
			System.out.println("Ala Carte Orders: " + list.get(i).getAlaOrder());
			System.out.println("Bundle Orders: " + list.get(i).getBundleOrder());
			System.out.println("The staff who serves you is " + list.get(i).getStaffName() +", " + list.get(i).getStaffGender()+", "+list.get(i).getStaffPos());}
			System.out.println();
			
			
		}
	}
	
	public void removeCust(int cust_id) {
		list.remove(cust_id);
		System.out.println("Removed");
	}
	
  	public boolean checkCustInfo(int cust_id)
  	{
  		for(int i=0; i<list.size(); i++) {
  			int foundId = list.get(i).getCustomerID();
  			if(foundId == cust_id)
  				return true;
  		}
  		return false;
  	}
  	
  
  	public Customer createCust(String name , int cust_id , boolean membership,int paxsize, double contact, Calendar rDate)
  	{
  		cust_id=list.size();
  		Customer newCust = new Customer(paxsize, cust_id, name, membership, contact, rDate);
  		list.add(newCust);
  		return newCust;
  		
  	}
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
  	public int getCListSize()
  	{
  		return list.size();
  	}
  	
}
