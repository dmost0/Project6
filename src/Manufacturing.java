/**
 * The employee is of manufacturing subclass
 *  
 */
public class Manufacturing extends Employee
{
	// Fields
	private final static Position p = Position.MANUFACTURING;
	private double pieceAmount;
	private double pricePerPiece;



	/**
	 * Default constructor for Manufacturing
	 */
	public Manufacturing()
	{
		super();
		setPieceAmount(0);
		setPricePerPiece(0);
	}
	
	/**
	 * Specialized constructor
	 * @param fName first name
	 * @param lName last name 
	 * @param pieceAmount piece amount 
	 * @param pricePerPiece price per piece 
	 * @param empNum employee number
	 */
	public Manufacturing(String fName, String lName, double pieceAmount, double pricePerPiece, int empNum)
	{
		// call super
		super(fName, lName, empNum, p);
		setPieceAmount(pieceAmount);
		setPricePerPiece(pricePerPiece);

	}
	/**
	 * Gets weekly pay for manufacturer
	 */
	public double calculateWeeklyPay() {
		return getPieceAmount() * getPricePerPiece();
	}
	
	/**
	 * Returns amount of pieces
	 * @return amount of pieces
	 */
	public double getPieceAmount() {
		return pieceAmount;
	}
	
	/**
	 * Set amount of pieces
	 * @param pieceAmount amount of pieces
	 */
	public void setPieceAmount(double pieceAmount) {
		this.pieceAmount = pieceAmount;
	}
	
	/**
	 * Returns price per piece
	 * @return price per piece
	 */
	public double getPricePerPiece() {
		return pricePerPiece;
	}
	
	/**
	 * Set price per piece
	 * @param pricePerPiece price per piece
	 */
	public void setPricePerPiece(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}
	
	/**
	 * Checks to make sure user input valid data
	 */
	public boolean inputValidation()
	{
		if(pieceAmount < 0 || pricePerPiece < 0)
			return false;
		else
			return true;
	}	
}
