public class Table {

	private int assigned;
	private int tableId;
	private int customerId;
	private int capacityLimit;
	public static final int tableNo=10;
	
	public Table(int assigned, int tableId, int customerID, int capacityLimit)
	{
		this.assigned=assigned;
		this.tableId=tableId;
		this.customerId=customerID;
		this.capacityLimit=capacityLimit;
	}
	/**
	 * 
	 * @param tableID
	 */
	public void tableID(int tableID) {
		// TODO - implement Table.tableID
		throw new UnsupportedOperationException();
	}

	public void getTableID() {
		// TODO - implement Table.getTableID
		throw new UnsupportedOperationException();
	}

	public void getCustomerID() {
		// TODO - implement Table.getCustomerID
		throw new UnsupportedOperationException();
	}

	public void isOccuppied() {
		// TODO - implement Table.isOccuppied
		throw new UnsupportedOperationException();
	}

	public void assign() {
		// TODO - implement Table.assign
		throw new UnsupportedOperationException();
	}

	public void unassign() {
		// TODO - implement Table.unassign
		throw new UnsupportedOperationException();
	}

}
