public class Order {

	private int custID;
	private int tableNumber;
	private int timeStamp;
	private int taxDetails;
	private int employeeID;
	
	public Order(int custID,int tableNumber, int timeStamp, int taxDetails, int employeeID)
	{
		this.custID=custID;
		this.tableNumber=tableNumber;
		this.timeStamp=timeStamp;
		this.taxDetails=taxDetails;
		this.employeeID=employeeID;
	}
	public void addItem() {
		// TODO - implement Order.addItem
		throw new UnsupportedOperationException();
	}

	public void removeItem() {
		// TODO - implement Order.removeItem
		throw new UnsupportedOperationException();
	}

	public void viewOrder() {
		// TODO - implement Order.viewOrder
		throw new UnsupportedOperationException();
	}

	public void discount() {
		// TODO - implement Order.discount
		throw new UnsupportedOperationException();
	}

	public void getTaxesDetails() {
		// TODO - implement Order.getTaxesDetails
		throw new UnsupportedOperationException();
	}

	public void orderInvoice() {
		// TODO - implement Order.orderInvoice
		throw new UnsupportedOperationException();
	}

}
