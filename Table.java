import java.util.ArrayList;

public class Table {
	public int tableId;
	private boolean assigned=false;
	private int customerId;
	private int table_size;
	//tableNo would be the max number of table in the list - will be set in the mainUI
	//public static final int tableNo=10;
	
	/**
	 * constructor for initialising table 
	 *
	 * @param tableId	unique table Id value that is used to assign to customers
	 * @param table_size 	size of table 
	 * @param customerId	unique customer Id value that is assigned to customers
	 */
	public Table(int tableId, int table_size, int customerId) 
	{
		this.tableId=tableId;
		this.table_size=table_size;
		this.customerId=-1;
	}
	
	/**
	 * obtain the size of table 
	 *
	 * @return corresponding table size
	 *	   null if the table does not have a table size
	 */
	public int getTableSize()
	{
		return this.table_size;
	}
	
	/**
	 * returns id of table 
	 *
	 * @return table id of the table
	 *	   null if the table does not have a tableID assigned
	 */
	public int gettableID() {
		return this.tableId;
	}
	
	/**
	 * returns id of customer 
	 *
	 * @return cust_id , which each customer was assigned to a unique ID
	 * 	   null if no customers have been assigned to the table
	 */
	public int getCustomerID() {
		return this.customerId;
	}
	
	/**
	 * checks if table is reserved
	 * @return true	if the table has been reserved or is occupied by customers
	 	  false if table is free
	 */
	public boolean isOccupied() {
		return this.assigned;
	}
	
	/**
	 * assigns table to customer using customer id
	 * @param customerId	Unique customer Id that is assigned to each customer
	 */
	public void assign(int customerId) {
		this.customerId = customerId;
		this.assigned = true;
	}
	
	/**
	 * unassigns table from customer 
	 */
	public void unAssign() {
		this.assigned = false;
		this.tableId = 0;
		this.customerId = 0;
	}
}
