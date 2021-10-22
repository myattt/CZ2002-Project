package project;

public class Table {

	public int tableId;
	private boolean assigned;
	private int customerId;
	private int table_size;
	//tableNo would be the max number of table in the list - will be set in the mainUI
	//public static final int tableNo=10;
	
	
	public Table() {}
	/*public Table(int tableId , int customerId) {
		this.tableId = tableId;
		this.customerId = customerId;
	}*/
	
	public int gettableID() {
		return this.tableId;
	}
	
	public int getCustomerID() {
		return this.customerId;
	}
	
	public boolean isOccupied() {
		return this.assigned;
	}
	
	public void assign(int tableId , int customerId , int table_size) {
		this.tableId=tableId;
		this.customerId = customerId;
		this.table_size = table_size;
		this.assigned = true;
	}
	
	public void unAssign() {
		this.assigned = false;
		this.tableId = 0;
		this.customerId = 0;
	}
}
