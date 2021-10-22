import java.util.Random;
public class Staff {
	
	CustomerList custlist=new CustomerList();
	public static final int tableNo=10;
	public static int tablesoccupied=0;
	public static int custID=1;
	
	private static String[] name = {"Harry", "Ron", "Hermione"};
	private static String[] gender = {"M", "M", "F"};
	private static int[] employeeID = {0,1,2};
	private static String[] jobTitle = {"waiter", "waiter", "waitress"};
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ask cust details,id
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		int input1, input2;
		while (loop) {
			System.out.println("(1) Check Customer Information");
			System.out.println("(2) Create Order");
			switch (sc.nextInt()) {
				case 1:
					System.out.println("Please key in customer's ID");
					input1=sc.nextInt();
					checkCustDetails(input1);
					break;
					
				case 2:
					createOrder();
					break;
				default:
					System.out.println("Invalid command, please try again!");
			}
	}
	public void createCustAcct()
	{
			
	}
	public void checkCustDetails(int custID)
	{
		boolean result=custlist.checkCustInfo();
		if(result)
		{
			
		}
		else
		{
			createCustAcct();
		}
	}
	private static void createOrder() {
		Random rand = new Random();
		Order o = new Order(1,2,3,4,5);
		// Generate random integers in range 0 to 999
		int rdint = rand.nextInt(3);
		System.out.println("The staff who serves you is " + name[rdint] +", " + gender[rdint]+", "+jobTitle[rdint]);
		System.out.println("Let's create your menu");
		System.out.println();
	}


}
