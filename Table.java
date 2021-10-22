package project;

public class Table {

	public int tableId;
	private boolean assigned;
	private int customerId;
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
	
	public void assign(int tableId , int customerId) {
		this.tableId=tableId;
		this.customerId = customerId;
		this.assigned = true;
	}
	
	public void unAssign() {
		this.assigned = false;
		this.tableId = 0;
		this.customerId = 0;
	}
}
