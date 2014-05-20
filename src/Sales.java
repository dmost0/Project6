/**
 * Sales employee
 *
 */
public class Sales extends Employee{
	// Fields
	private final static int bonus = 250;
	private final static Position p = Position.SALES;
	private double weeklySales;


	/** 
	 * Default Constructor for sales
	 */
	public Sales()
	{
		super();
		weeklySales = 0;
	}
	
	/**
	 * Specialized constructor
	 * @param fName first name 
	 * @param lName last name 
	 * @param empNum employee number
	 * @param weeklySales weekly sales of this sales person
	 */
	public Sales(String fName, String lName, int empNum, double weeklySales)
	{
		super(fName, lName, empNum, p);
		this.weeklySales = weeklySales;
		
	}
	/**
	 * Get weekly pay for this sales person
	 */
	public double calculateWeeklyPay() {
		return (weeklySales * .057) + bonus;
	}
	
	/**
	 * Set weekly sales of this sales person
	 * @param weeklySales amount of weekly sales
	 */
	public void setWeeklySales(double weeklySales)
	{
		this.weeklySales = weeklySales;
	}
	
	/**
	 * Get weekly sales
	 * @return weekly sales
	 */
	public double getWeeklySales()
	{
		return weeklySales;
	}
	
	/**
	 * Checks user input data
	 */
	public boolean inputValidation()
	{
		if(weeklySales < 0)
			return false;
		else
			return true;
	}
	
	
}
