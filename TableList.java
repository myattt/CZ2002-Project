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
	
	public void showEmptyTables() {
		System.out.println("The following tables are empty:");
		for (int i=0; i<10; i++) {
			if (this.table[i].isOccupied() == false) {
				System.out.println("TableID " + (i+1) + "TableSize" + this.table[i].getTableSize());
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
	
	public void assignTable(int tableId, int cust_id) {
		if (this.table[tableId-1].isOccupied()) {
			System.out.println("Table already assigned to a customer.");
		} else {
			this.table[tableId-1].assign(cust_id);
			this.numEmptyTables--;
			System.out.println("Table Assigned!");
		}
	}
	
	public void unAssignSeat(int seatId) {
		this.table[seatId-1].unAssign();
		this.numEmptyTables++;
		System.out.println("Table Unassigned!");
	}
}