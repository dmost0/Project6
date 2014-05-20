
/**
 * Abstract class Employee represents an employee
 *
 */
public abstract class Employee 
{
	private String fName;
	private String lName;
	private int empNum;
	private Position p;
	
	/**
	 * Default constructor
	 */
	public Employee() {
		fName = "";
		lName = "";
		empNum = -1;
		p = null;
	}
	
	/**
	 * Specialized constructor
	 * @param fName first name
	 * @param lName last name
	 * @param empNum employee number
	 * @param p position of this employee
	 */
	public Employee(String fName, String lName, int empNum, Position p)
	{
		this.fName = fName;
		this.lName = lName;
		this.empNum = empNum;
		this.p = p;
	}

	/**
	 * Get weekly pay
	 * @return double weekly pay
	 */
	public abstract double calculateWeeklyPay();

	/**
	 * String representation of Employee
	 * @return String representation of Employee
	 */
	public String toString() {
		if(String.valueOf(calculateWeeklyPay()) != null){
			return String.valueOf(empNum) + "           $"  + calculateWeeklyPay()+"0";
		}
		return null;
	}

	/**
	 * Get position of Employee
	 * @return position of this employee
	 */
	public Position getPos() {
		return p;
	}

	/**
	 * Set position of this Employee
	 * @param pos position of this Employee
	 */
	public void setPos(Position pos) {
		this.p = pos;
	}
	
	/**
	 * get first name
	 * @return first name
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * Set firstName
	 * @param fName
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * get last name
	 * @return last name
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * Set last name
	 * @param lName last name
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * get employee number
	 * @return employee number
	 */
	public int getEmpNum() {
		return empNum;
	}

	/**
	 * set employee number
	 * @param empNum
	 */
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	
	
}
