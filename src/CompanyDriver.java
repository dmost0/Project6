// Imports used in CompanyDriver
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.*;


/**
 * CompanyDriver starts the program and provides a GUI
 *
 */
@SuppressWarnings("serial")
public class CompanyDriver extends JFrame implements ActionListener{
	// Fields
	private Company thisCompany;
	private String companyName;
	private JTextField fNameText;
	private JTextField lNameText;
	private JTextField empIDText;
	private JTextField weeklySalesText;
	private JTextField payRateText;
	private JTextField hoursText;
	private JTextField pieceRateText;
	private JTextField pieceNumberText;
	private JTextField salaryText;
	private JRadioButton design;
	private JRadioButton sales;
	private JRadioButton manufacturing;
	private JRadioButton manager;
	private JFileChooser choose;
	private JPanel midPanel;
	private JPanel variablePanel;
	

	/**
	 * Constructor sets up the instance of the class
	 */
	public CompanyDriver()
	{
		
		variablePanel = new JPanel();
		variablePanel.setLayout(new GridLayout(5,2));
		// Get company name from user and use this to set title and create new Company instance
		companyName = JOptionPane.showInputDialog("What is the name of this company?");
		thisCompany = new Company(companyName);
		setTitle(companyName);
		// Settings for frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		setSize(400, 770);
		setVisible(true);
		setResizable(false);
		// instantiate fields
		fNameText = new JTextField(15);
		lNameText = new JTextField(15);
		// Build frame
		buildTopPanel();
		buildMidPanel();
		buildBotPanel();
	}
	
	/**
	 * Main starts the program
	 * @param args default arguments to main
	 */
	public static void main(String[] args)
	{
		new CompanyDriver();
	}

	
	/**
	 * Builds the top panel of the JFrame
	 */
	private void buildTopPanel()
	{
		// Create the top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// Image used in top panel
		ImageIcon image = new ImageIcon("company.jpg");
		JLabel imageLabel = new JLabel(image);
		JLabel companyNameLabel = new JLabel("   " + companyName);
		JLabel filler = new JLabel("                          ");  // used to make flow across new row
		JLabel presidentNameLabel = new JLabel("President: Obama");
		// Add components to top panel
		topPanel.add(imageLabel);
		topPanel.add(companyNameLabel);
		topPanel.add(filler);
		topPanel.add(presidentNameLabel);
		// add to JFrame
		add(topPanel);
		
	}
	
	/*
	 * Builds the middle panel of the JFrame
	 */
	private void buildMidPanel()
	{
		// setup mid panel properties
		midPanel = new JPanel();
		midPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		/*Components for mid panel*/
		// Position JPanel setup
		JPanel position = new JPanel();
		position.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "Position"));
		// Setup radio buttons
		design = new JRadioButton("Design");
		design.setActionCommand("1");
		design.addActionListener(this);
		sales = new JRadioButton("Sales");
		sales.setActionCommand("2");
		sales.addActionListener(this);
		manufacturing = new JRadioButton("Manufacturing");
		manufacturing.setActionCommand("3");
		manufacturing.addActionListener(this);
		manager = new JRadioButton("Manager");
		manager.setActionCommand("4");
		manager.addActionListener(this);
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(design);
		radioGroup.add(sales);
		radioGroup.add(manufacturing);
		radioGroup.add(manager);
		// Add buttons to position
		position.add(design);
		position.add(sales);
		position.add(manufacturing);
		position.add(manager);
		// Setup last two buttons
		JButton addEmployee = new JButton("Add Employee");
		JButton clear = new JButton("Clear");
		// Add Action Listeners
		addEmployee.addActionListener(this);
		clear.addActionListener(this);
		// Set Action Commands
		addEmployee.setActionCommand("1");
		clear.setActionCommand("2");
		// Add last two buttons
		midPanel.add(position);
		midPanel.add(variablePanel);
		midPanel.add(addEmployee);
		midPanel.add(clear);
		add(midPanel);
		
	}
	
	/**
	 * Builds the bottom panel of the JFrame
	 */
	private void buildBotPanel()
	{
		// Setup Panel
		JPanel botPanel = new JPanel();
		// Setup JButtons
		JButton jPrint = new JButton("Print Company Employees");
		JButton jExit = new JButton("Exit");
		JButton jWeek = new JButton("Print Weekly Pay Report");
		JButton jRead = new JButton("Read File");
		// Add Action Listeners
		jPrint.addActionListener(this);
		jExit.addActionListener(this);
		jWeek.addActionListener(this);
		jRead.addActionListener(this);
		// Setup Action commands
		jPrint.setActionCommand("3");
		jWeek.setActionCommand("4");
		jRead.setActionCommand("5");
		jExit.setActionCommand("6");
		botPanel.add(jPrint);
		botPanel.add(jWeek);
		botPanel.add(jRead);
		botPanel.add(jExit);
		add(botPanel);
	}
	
	/**
	 * Builds design panel
	 */
	public void buildDesign()
	{
		variablePanel.removeAll();
		empIDText = new JTextField(15);
		payRateText = new JTextField(15);
		hoursText = new JTextField(15);
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel employeeID = new JLabel("Employee ID: ");
		JLabel payRate= new JLabel("PayRate: ");
		JLabel hours = new JLabel("Hours: ");
		variablePanel.add(employeeID);
		variablePanel.add(empIDText);
		variablePanel.add(firstName);
		variablePanel.add(fNameText);
		variablePanel.add(lastName);
		variablePanel.add(lNameText);
		variablePanel.add(payRate);
		variablePanel.add(payRateText);
		variablePanel.add(hours);
		variablePanel.add(hoursText);
		this.validate();
		this.repaint();

	}
	/**
	 * Builds sales panel
	 */
	public void buildSales()
	{
		variablePanel.removeAll();
		weeklySalesText = new JTextField(15);
		empIDText = new JTextField(15);
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel employeeID = new JLabel("Employee ID: ");
		JLabel weeklySales = new JLabel("Weekly Sales: ");
		variablePanel.add(employeeID);
		variablePanel.add(empIDText);
		variablePanel.add(firstName);
		variablePanel.add(fNameText);
		variablePanel.add(lastName);
		variablePanel.add(lNameText);
		variablePanel.add(weeklySales);
		variablePanel.add(weeklySalesText);
		this.validate();
		this.repaint();
	}
	/**
	 * Builds manufacturing panel
	 */
	public void buildManufacturing()
	{
		variablePanel.removeAll();
		pieceRateText = new JTextField(15);
		pieceNumberText = new JTextField(15);
		empIDText = new JTextField(15);
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel employeeID = new JLabel("Employee ID: ");
		JLabel pieceRate = new JLabel("Piece Rate: ");
		JLabel pieceAmount = new JLabel("# pieces: ");
		variablePanel.add(employeeID);
		variablePanel.add(empIDText);
		variablePanel.add(firstName);
		variablePanel.add(fNameText);
		variablePanel.add(lastName);
		variablePanel.add(lNameText);
		variablePanel.add(pieceRate);
		variablePanel.add(pieceRateText);
		variablePanel.add(pieceAmount);
		variablePanel.add(pieceNumberText);
		
		this.validate();
		this.repaint();
	}
	/**
	 * Builds manager panel
	 */
	public void buildManager()
	{
		variablePanel.removeAll();
		salaryText = new JTextField(10);
		empIDText = new JTextField(10);
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel employeeID = new JLabel("Employee ID: ");
		JLabel salary = new JLabel("Salary: ");
		variablePanel.add(employeeID);
		variablePanel.add(empIDText);
		variablePanel.add(firstName);
		variablePanel.add(fNameText);
		variablePanel.add(lastName);
		variablePanel.add(lNameText);
		variablePanel.add(salary);
		variablePanel.add(salaryText);
		
		this.validate();
		this.repaint();
	}

	/**
	 * Performs actions for JButtons that are pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Radio
		if(e.getSource().getClass() == design.getClass()){
			int value2 = Integer.parseInt(e.getActionCommand());
			switch(value2){
			case 1:
				buildDesign();
				break;
			
			case 2:
				buildSales();
				break;
			
			case 3:
				buildManufacturing();
				break;
			
			case 4:
				buildManager();
				break;
			}
		}
		else{
			int value = Integer.parseInt(e.getActionCommand());
			switch (value) {
			// add employee button pressed
			case 1:
				String errorMessage = null;
				if(design.isSelected() == true)
					errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Design", Double.parseDouble(payRateText.getText()), Integer.parseInt(hoursText.getText()), Integer.parseInt(empIDText.getText()));
				else if(sales.isSelected() == true)
					errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Sales", Double.parseDouble(weeklySalesText.getText()), 0, Integer.parseInt(empIDText.getText()));
				else if(manufacturing.isSelected() == true)
					errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Manufacturing", Double.parseDouble(pieceRateText.getText()), Integer.parseInt(pieceNumberText.getText()), Integer.parseInt(empIDText.getText()));
				else if(manager.isSelected() == true){
					errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Manager", Double.parseDouble(salaryText.getText()), 0, Integer.parseInt(empIDText.getText()));
				}
				else{
					errorMessage = "No position was selected";
				}
				if(errorMessage != null)
					JOptionPane.showMessageDialog(this, errorMessage);
				break;
			// clear button pressed
			case 2:
				fNameText.setText("");
				lNameText.setText("");
				empIDText.setText("");;
				weeklySalesText.setText("");;
				payRateText.setText("");;
				hoursText.setText("");;
				pieceRateText.setText("");;
				pieceNumberText.setText("");;
				salaryText.setText("");;
				break;
			// Print Company Employees button pressed
			case 3:
				JOptionPane.showMessageDialog(this, thisCompany.printCompany());
				break;
			// New Company button pressed
			case 4:
				JOptionPane.showMessageDialog(this, thisCompany.generateWeeklyReport());
				
				break;
			// Read file pressed
			case 5:
				choose = new JFileChooser();
				int row = 0;
				
				String[][] employees = new String[30][7];
				if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					File x = choose.getSelectedFile();
				    try(BufferedReader br = new BufferedReader(new FileReader(x.getPath()))) {
				        String line = br.readLine();
				        while (line != null) {
				        	String[] temp = line.split(":");
				            for(int i = 0; i < temp.length; i++){
				            	employees[row][i] = temp[i];
				            }	
				            line = br.readLine();
				            row++;
				            
				        }
				        
				        for(String[] a : employees){
				        	int sinceNull = 0;
							String fName = "";
							String lName = "";
							String position = "";
							int empNum = -1;
							double param1 = -1;
							int param2 = -1;
				        	for(String b: a){
				        		if(b == null){
				        			continue;
				        		}
				        		
								
				        		else if(sinceNull == 0){
				        			fName = b;
				        			sinceNull++;
				        		}
				        		else if(sinceNull == 1){
				        			lName = b;
				        			sinceNull++;
				        		}
				        		else if(sinceNull == 2){
				        			position = b;
				        			sinceNull++;
				        		}
				        		else{
				        			if(position.equals("Design")){
				        				if(sinceNull == 3){
				        					param1 = Double.parseDouble(b);
				        					sinceNull++;
				        				}
				        				else if(sinceNull == 4){
				        					param2 = Integer.parseInt(b);
				        					sinceNull++;
				        				}
				        				else if(sinceNull == 5){
				        					empNum = Integer.parseInt(b);
				        					thisCompany.addEmployee(fName, lName, position, param1, param2, empNum);
				        					sinceNull=0;
				        				}
				        				
				        					
				        			}
				        			else if (position.equals("Sales")){
				        				if(sinceNull == 3){
				        					param1 = Double.parseDouble(b);
				        					sinceNull++;
				        				}
				        				else if(sinceNull == 4){
				        					empNum = Integer.parseInt(b);
				        					thisCompany.addEmployee(fName, lName, position, param1, 0, empNum);
				        					sinceNull=0;
				        				}

				        			}
				        			else if(position.equals("Manufacturing")){
				        				if(sinceNull == 3){
				        					param1 = Double.parseDouble(b);
				        					sinceNull++;
				        				}
				        				else if(sinceNull == 4){
				        					param2 = Integer.parseInt(b);
				        					sinceNull++;
				        				}
				        				else if(sinceNull == 5){
				        					empNum = Integer.parseInt(b);
				        					thisCompany.addEmployee(fName, lName, position, param1, param2, empNum);
				        					sinceNull=0;
				        				}

				        				
				        			}
				        			else if(position.equals("Manager")){
				        				if(sinceNull == 3){
				        					param1 = Double.parseDouble(b);
				        					sinceNull++;
				        				}
				        				else if(sinceNull == 4){
				        					empNum = Integer.parseInt(b);
				        					thisCompany.addEmployee(fName, lName, position, param1, param2, empNum);
				        					sinceNull=0;
				        				}

				        					
				        			}

				        		}
				        	}
				        	
				        	
				        		
				        }
				    } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}
				}
				else
					JOptionPane.showMessageDialog(this, "File not uploaded");
				
				break;
			// Exit button pressed	
			case 6:
				setVisible(false);
				dispose();
				break;
			}
			
		}
		
		
		
	}
	/**
	 * Tests if string is numeric
	 * @param strNum tested string
	 * @return true if strNum is numeric
	 */
	public static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {

	        Double.parseDouble(strNum);

	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
}

