public class TableList {
	private int numEmptyTables;
	private Table[] table = new Table[10];
	
	public TableList() {
		this.numEmptyTables = 10;
		int j=11;
		for (int i=0; i<10; i++) {
			this.table[i] = new Table(i, 2*(j/2), -1);
			j--;
		}
	}
	public void showNumEmptyTables() {
		System.out.println("There are " + this.numEmptyTables + " empty tables");
	}
	
	public int getNumEmptyTables() {
		return this.numEmptyTables;
	}
	
	public void showEmptyTables() {
		System.out.println("The following tables are empty:");
		for (int i=0; i<10; i++) {
			if (this.table[i].isOccupied() == false) {
				System.out.println("TableID " + (i+1) + " TableSize" + this.table[i].getTableSize());
			}
		}
	}
	
	public void showAssignedTables() {
		System.out.println("The table assignments are as follow:");
			for (int i=0; i<10; i++) {
				if (this.table[i].isOccupied()) {
					System.out.println("TableID " + (i+1) + " assigned to CustomerID " + this.table[i].getCustomerID() + ".");
				}
			}
	}
	
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
	
	public void unAssignSeat(int tableId) {
		this.table[tableId-1].unAssign();
		this.numEmptyTables++;
		System.out.println("Table Unassigned!");
	}
	
	public int findSuitableTable(int table_size) {
		if(table_size==-1)
			return -1;
		for(int i=9 ; i>=0; i--) {
			if(table_size <= this.table[i].getTableSize() && this.table[i].isOccupied()==false)
				return i;
		}
		
		System.out.println("Unable to a table of suitable size");
		return -1;
	}
}
