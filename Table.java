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
	 * @param tableId 
	 * @param table_size size of table 
	 * @param customerId
	 */
	public Table(int tableId, int table_size, int customerId) 
	{
		this.tableId=tableId;
		this.table_size=table_size;
		this.customerId=-1;
	}
	
	/**
	 * returns size of table 
	 * @return int table size
	 */
	public int getTableSize()
	{
		return this.table_size;
	}
	
	/**
	 * returns id of table 
	 * @return int table id 
	 */
	public int gettableID() {
		return this.tableId;
	}
	
	/**
	 * returns id of customer 
	 * @return int cust_id
	 */
	public int getCustomerID() {
		return this.customerId;
	}
	
	/**
	 * checks if table is reserved
	 * @return true/false 
	 */
	public boolean isOccupied() {
		return this.assigned;
	}
	
	/**
	 * assigns table to customer using customer id
	 * @param customerId
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
