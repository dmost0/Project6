/**
 * Manager subclass of Employee
 *
 */
public class Manager extends Employee {
	
	// Fields
	private final static Position p = Position.MANAGER;
	private double salary;
	
	/**
	 * Default constructor
	 */
	public Manager()
	{
		super();
		salary = 0;
	}
	
	/**
	 * Specialized constructor
	 * @param fName first name
	 * @param lName last name
	 * @param empNum employee number
	 * @param salary salary of this manager
	 */
	public Manager(String fName, String lName, int empNum, double salary)
	{
		super(fName, lName, empNum, p);
		this.salary = salary;
	}
	
	/**
	 * Calculates weekly pay of this manager
     */
	public double calculateWeeklyPay() {
		// TODO Auto-generated method stub
		return salary;
	}

	/**
	 * get salary of this manager
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Set salary of this manager
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * Validates input from user
	 * @return false if salary < 0.
	 */
	public boolean inputValidation()
	{
		if(salary < 0)
			return false;
		else
			return true;
	}
}
