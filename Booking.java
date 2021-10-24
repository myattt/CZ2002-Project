import java.util.Date;


public class Booking {

	private int date;
	private int time;
	private int pax;
	private String name;
	private int contact;

	public void createReservation(int date, int time, int pax, String name, int contact) {
		// TODO - implement Booking.createReservation
		this.date=date;
		this.time=time;
		this.pax=pax;
		this.name=name;
		this.contact=contact;
		
	}

	public void checkReservation() {
		// TODO - implement Booking.checkReeservation
		throw new UnsupportedOperationException();
	}

	public void removeReservation() {
		// TODO - implement Booking.removeReservation
		throw new UnsupportedOperationException();
	}

	public void checkTableAvailability() {
		// TODO - implement Booking.checkTableAvailability
		throw new UnsupportedOperationException();
	}

}
