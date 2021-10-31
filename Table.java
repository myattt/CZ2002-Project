import java.util.ArrayList;

public class Table {
	public int tableId;
	private boolean assigned=false;
	private int customerId;
	private int table_size;
	//tableNo would be the max number of table in the list - will be set in the mainUI
	//public static final int tableNo=10;
	
	public Table(int tableId, int table_size, int customerId) 
	{
		this.tableId=tableId;
		this.table_size=table_size;
		this.customerId=-1;
	}
	public int getTableSize()
	{
		return this.table_size;
	}
	public int gettableID() {
		return this.tableId;
	}
	
	public int getCustomerID() {
		return this.customerId;
	}
	
	public boolean isOccupied() {
		return this.assigned;
	}
	
	public void assign(int customerId) {
		this.customerId = customerId;
		this.assigned = true;
	}
	
	public void unAssign() {
		this.assigned = false;
		this.tableId = 0;
		this.customerId = 0;
	}
}
