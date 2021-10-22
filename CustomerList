import java.util.ArrayList;


public class CustomerList {


	ArrayList<Customer> list = new ArrayList<Customer>();
	int cust_id;
	
	
  	public boolean checkCustInfo(int cust_id)
  	{
  		for(int i=0; i<list.size(); i++) {
  			int foundId = list.get(i).getCustomerID();
  			if(foundId == cust_id)
  				return true;
  		}
  		return false;
  	}
  	
  
  	public void createCust(String name , int cust_id , boolean membership)
  	{
  		Customer newCust = new Customer(cust_id);
  		newCust.setCustomerName(name);
  		newCust.member(membership);
  		list.add(newCust);
  		
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
}
