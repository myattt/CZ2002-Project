public class TableList {
	private int numEmptyTables;
	private Table[] table = new Table[10];
	
	/**
	 * initialise Tablelist , which is an array that contains 10 Table objects
	 */
	public TableList() {
		this.numEmptyTables = 10;
		int j=11;
		for (int i=0; i<10; i++) {
			this.table[i] = new Table(i, 2*(j/2), -1);
			j--;
		}
	}
	
	/**
	 * prints out the number of empty tables 
	 */
	public void showNumEmptyTables() {
		System.out.println("There are " + this.numEmptyTables + " empty tables");
	}
	
	/**
	 * ascessor method that shows number of empty tables
	 * @return number of empty table 
	 */
	public int getNumEmptyTables() {
		return this.numEmptyTables;
	}
	
	/**
	 * prints a list of empty tables with the TableId and the corresponding tableSize
	 */
	public void showEmptyTables() {
		System.out.println("The following tables are empty:");
		for (int i=0; i<10; i++) {
			if (this.table[i].isOccupied() == false) {
				System.out.println("TableID " + (i+1) + " TableSize" + this.table[i].getTableSize());
			}
		}
	}
	
	/**
	 * prints a list of assigned tables with the TableId and the CustomerID of the assigned customer
	 */
	public void showAssignedTables() {
		System.out.println("The table assignments are as follow:");
			for (int i=0; i<10; i++) {
				if (this.table[i].isOccupied()) {
					System.out.println("TableID " + (i+1) + " assigned to CustomerID " + this.table[i].getCustomerID() + ".");
				}
			}
	}
	
	/**
	 * assigns customer to table
	 * @param tableId	id of tables
	 * @param cust_id 	id of customers 
	 * @return true if the table is free and is assigned to the latest customer
	 *    	   false if the table is currently occupied by another customer
	 */
	public boolean assignTable(int tableId, int cust_id) {
		if (this.table[tableId-1].isOccupied()) {
			System.out.println("Table already assigned to a customer.");
			return false;
		} else {
			this.table[tableId-1].assign(cust_id);
			this.numEmptyTables--;
			System.out.println("Table Assigned! Table ID:" + tableId );
			return true;
		}
	}
	
	/**
	 * acessor method that returns table object (using tableid)
	 * @param tableId	id of the table
	 * @return corresponding table object  
	 *	   null if the tableId given is invalid or table object does not exist
	 */
	public Table getTable(int tableId) {
		return this.table[tableId];
	}
	
	/**
	 * unassigns table 
	 * @param tableId	table Id to identify which table to unassign
	 */
	public void unAssignSeat(int tableId) {
		this.table[tableId-1].unAssign();
		this.numEmptyTables++;
		System.out.println("Table Unassigned!");
	}
	
	/**
	 * traverse through the table list to find a suitable and avaialble table that has size more than or equals to customer pax
	 * @param table_size	a suitable table size as per the number of pax of the customer
	 * @return table id of suitable table
	 */
	public int findSuitableTable(int table_size) {
		if(table_size==-1)
			return -1;
		for(int i=9 ; i>=0; i--) {
			if(table_size <= this.table[i].getTableSize() && this.table[i].isOccupied()==false)
				return i;
		}
		
		System.out.println("Unable to assign a table of suitable size");
		return -1;
	}
}
