// imports
import java.util.ArrayList;
import java.text.NumberFormat;

/**
 * 
 *
 */
public class Company implements CompanyInterface {
	// Fields
	private String companyName;
	private ArrayList<Employee> employees;
	private static int numberOfCompanies = 0;
	private int numDesign;
	private int numEmployees;
	private int numManufacturing;
	private int numSales;
	private int numManager;
	private NumberFormat fmt;
	
	
	
		
	
	/**
	 * Constructor for company
	 * @param arg name of company
	 */
	public Company(String arg)
	{
		// Instantiate fields
		companyName = arg;
		employees = new ArrayList<Employee>();
		numSales = 0;
		numEmployees = 0;
		numDesign = 0;
		numManufacturing = 0;
		numManager = 0;
		updateCompanyNumber();
		fmt = NumberFormat.getCurrencyInstance();
	}

	/**
	 * Add employee to company
	 */
	public String addEmployee(String fname, String lname, String pos,double firstParam, int secondParam, int empNum)
	{	
		if(numSales == 1 && pos.equals("Sales")){
			return "There is already a sales person\nEmployee not added";
		}
		else if(numDesign == 2 && pos == "Design")
			return "There are already two design persons\nEmployee not added";
		else if(numManufacturing == 4 && pos.equals("Manufacturing"))
			return "There are already four manufacturing persons\nEmployee not added";
		else if (numManager == 1 && pos.equals("Manager"))
			return "There is already a manager\nEmployee not added";
		else if(this.getNumEmployees()== 8)
			return "There are already 8 employees\nEmployee not added";
		else if(pos.equals("Sales") == false && pos.equals("Design") == false && pos.equals("Manufacturing") == false && pos.equals("Manager") == false)
			return "That position does not exist";
		else{
			if(pos.equals("Sales")){
				Sales s = new Sales(fname, lname, empNum, firstParam);
				employees.add(s);
				numSales++;
			}
			else if (pos.equals("Design")){
				Design d = new Design(fname, lname, empNum, firstParam, secondParam);
				employees.add(d);
				numDesign++;
			}
			else if(pos.equals("Manufacturing")){
				Manufacturing m = new Manufacturing(fname, lname, secondParam, firstParam, empNum);
				employees.add(m);
				numManufacturing++;
			}
			else{
				Manager m = new Manager(fname, lname, empNum, firstParam);
				employees.add(m);
				numManager++;
			}

			return null;
		}
	}
	
	/**
	 * Gets the amount of companies
	 * @return number of companies
	 */
	public static int getNumCompanies()
	{
		return numberOfCompanies;
	}
	
	/**
	 * Updates company number
	 */
	private static void updateCompanyNumber()
	{
		numberOfCompanies += 1;
	}
	
	/**
	 * resets company number
	 */
	public static void resetCompanyCount()
	{
		numberOfCompanies = 0;
	}
	/**
	 * Gets the number of employees
	 * @return number of employees
	 */
	public int getNumEmployees()
	{
		return numEmployees;
	}
	
	/**
	 * Returns a String representation of the company
	 * @return String representing company
	 */
	public String printCompany()
	{
		String a = companyName;
		a = this.companyName + "\n";
		for(Employee e: employees){
			a += e.getfName() + " " + e.getlName() + "  Position: " + e.getPos() + "\n";
		}
		return a;
	}
	
	/**
	 * Returns a String representation of the company
	 * @return String representation
	 */
	public String toString()
	{
		String s = "";
		for(Employee e : employees){
			s += e.toString() + "\n";
		}
		return s;
	}



	/**
	 * Generates weekly report
	 * @return weekly report
	 */
	public String generateWeeklyReport() {
		// TODO Auto-generated method stub
		String s = "WEEKLY PAY REPORT FOR " + companyName + " COMPANY\n\nEMPLOYEE        WEEKLY PAY\n" + toString() + "\nTotal payroll: " + fmt.format(calculateTotalWeeklyPay()) + "\nTotal number of managers paid:   " + String.valueOf(numManager) + "\nTotal number of Design employees paid:  " + String.valueOf(numDesign) + "\nTotal number of Sales employees paid:  " + String.valueOf(numSales) + "\nTotal number of Manufacturing employees paid:  " + String.valueOf(numManufacturing) ;
		return s;
	}

	/**
	 * Gets total weekly pay
	 * @return total weekly pay
	 */
	public double calculateTotalWeeklyPay() {
		double total = 0;
		for(Employee e: employees){
			total += e.calculateWeeklyPay();
		}
		return total;
	}

	/**
	 * Gets the number of managers
	 * @return number of managers
	 */
	public int getNumManager() {
		// TODO Auto-generated method stub
		return numManager;
	}

	/**
	 * Gets number of designers
	 * @return number of designers
	 */
	public int getNumDesign() {
		// TODO Auto-generated method stub
		return numDesign;
	}

	/**
	 * Get number of sales people
	 * @return number of sales employees
	 */
	public int getNumSales() {
		// TODO Auto-generated method stub
		return numSales;
	}


	/**
	 * Gets the number of manufacturers
	 * @return number of manufacturers
	 */
	public int getNumManufacturing() {
		// TODO Auto-generated method stub
		return numManufacturing;
	}
	
}
