public class Staff {

	private static String[] name = {"Harry", "Ron", "Hermione"};
	private static String[] gender = {"M", "M", "F"};
	private static int[] employeeID = {0,1,2};
	private static String[] jobTitle = {"waiter", "waiter", "waitress"};
	
	public Staff(String name , String gender , int employeeID , String jobTitle){
		this.name = name;
		this.gender = gender;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}
	
	private void createOrder() {
		Order o = new Order();
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rdint = rand.nextInt(3);
		System.out.println("The staff who serves you is " + name[rdint] +", " + gender[rdint]+", "+jobTitle[rdint]);
		System.out.println("Let's create your menu");
		System.out.println();
	}

}