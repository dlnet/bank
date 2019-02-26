package ca.ucalgary.tui;

/**
 * G02 T07
 * App Demo 1
 */

// Imports
import java.util.Scanner;
import ca.ucalgary.domain.Budget;
import ca.ucalgary.domain.Invest;
import ca.ucalgary.domain.RegistrationForm;
import ca.ucalgary.domain.Goal;

// Main Class
public class AppDemoOne {

	// Main Method
	public static void main(String[] args) {
		
		// declare variables 
		Scanner input;
		String userSelection;
	
		// initialize variables
		input = new Scanner(System.in);  
		userSelection = "";
		
		while (true) {
			
			// welcome message
			System.out.println("--------------------------------------------");
			System.out.println("            Welcome to myMoney!");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Sign-In  [2] Sign-Up  [q] Quit \n");
			
			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// call SignInSelected method
				SignInSelected();
				break;

			case "2":
				// call SignUpSelected method
				SignUpSelected();
				break;
			
			case "q":
				System.out.println("\nHave a Nice Day!");
				System.exit(1);

			default:  // will never run 
				break;
			}
			
		}
				
	}
	
	// Menu Method
	public static void Menu() {
		
		// declare variables 
		Scanner input ;
		String userSelection;
		boolean run;
		
		// initialize variables
		input = new Scanner(System.in);  
		userSelection = "";
		run = true;
		
		// menu
		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                   Menu");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Account  [2] Budget  [3] Goal  [4] Invest  [q] Quit \n");

			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("3")||userSelection.equals("4")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			case "1":
				// call AccountSelected method
				AccountSelected();
				break;

			case "2":
				// call BudgetSelected method
				BudgetSelected();
				break;
				
			case "3":
				// call GoalsSelected method
				GoalsSelected();
				break;
				
			case "4":
				// call InvestSelected method
				InvestSelected();
				break;
			
			case "q":
				System.out.println();
				run = false;
				break;

			default:  // will never run
				break;
			}
		}
	}
	
	// Sign-In Selected Method
	public static void SignInSelected() {
		
		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Sign-In");
		System.out.println("--------------------------------------------");
		
		// username and password
		Scanner input =  new Scanner(System.in);
		System.out.print("Enter Username: ");
		String username = input.nextLine();
		System.out.print("Enter Password: ");
		String password = input.nextLine();
		
		// call Menu method
		Menu();
		
	}
		
	// Sign-Up Selected Method
	public static void SignUpSelected() {
		
		// declare variables 
		RegistrationForm myRegistrationForm;
		
		// initialize variables
		myRegistrationForm = new RegistrationForm();

		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Sign-Up");
		System.out.println("--------------------------------------------");
		
		// call main method in RegistrationForm class
		myRegistrationForm.main(null);  
		
		// call Menu method
		Menu();
	}
	
	// 1.Account Selected Method
	public static void AccountSelected() {

		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Account");
		//System.out.println("--------------------------------------------");
		
		// run CLI class
		CLI myCLI = new CLI();
		myCLI.main(null);
		
	}

	// 2.Budget Selected Method
	public static void BudgetSelected() {
		
		// declare variables 
		Budget myBudget;
		Scanner input ;
		String userSelection, userBudget, expenseName, expenseAmount;
		boolean run;

		// initialize variables
		myBudget = new Budget(0);
		input = new Scanner(System.in);  
		userSelection = "";
		run = true;

		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                   Budget");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Set Income  [2] Add Expense  [3] View Budget  [q] Quit \n");

			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("3")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// set income;
				System.out.print("\nEnter Income: ");
				userBudget = input.nextLine();
				myBudget.setIncome(Double.valueOf(userBudget));
				break;
				
			case "2":
				// add expense
				System.out.print("\nEnter Expense Name: ");
				expenseName = input.nextLine();
				System.out.print("Enter Expense Amount: ");
				expenseAmount = input.nextLine();
				myBudget.addExpense(expenseName, Double.valueOf(expenseAmount));
				break;
				
			case "3":
				// view budget
				System.out.println("\n" + myBudget.toString());
				break;
				
			case "q":
				run = false;
				break;
				
			default:  // will never run
				break;
			}
			
		}

	}
	
	// 3.Goals Selected Method
	public static void GoalsSelected() {
		
		// declare variables 
		Goal myGoal;
		Scanner input ;
		String userSelection, userInput;
		int time;
		boolean run;

		// initialize variables
		myGoal = new Goal();
		input = new Scanner(System.in);  
		userSelection = "";
		userInput = "";
		time = 0;
		run = true;

		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                    Goal");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Set Goal  [2] Set Time Period  [3] View Goal  [q] Quit \n");

			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("3")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// set goal;
				System.out.print("\nEnter Goal Name: ");
				userInput = input.nextLine();
				myGoal.setGoalName(userInput);
				System.out.print("Enter Goal Amount: ");
				userInput = input.nextLine();
				myGoal.setGoalAmount(Double.valueOf(userInput));
				break;
				
			case "2":
				// set time period
				System.out.print("\nSelect Time Period: [y = Years, m = Months, w = Weeks, d = Days] ");
				userInput = input.nextLine();
				switch (userInput) {
				case "y":
					time = 365;
					myGoal.setTimePeriod("Years");
					break;
				case "m":
					time = 30;
					myGoal.setTimePeriod("Months");
					break;
				case "w":
					time = 7;
					myGoal.setTimePeriod("Weeks");
					break;
				case "d":
					time = 1;
					myGoal.setTimePeriod("Days");
					break;
				default:
					break;
				}
				System.out.print("Enter Time Period: ");
			    userInput = input.nextLine();
			    myGoal.setTimePeriodInput(Integer.parseInt(userInput));
				myGoal.setTimePeriodDays(Integer.parseInt(userInput) * time);
				break;
				
			case "3":
				// view goal
				System.out.println("\n" + myGoal.toString());
				break;
				
			case "q":
				run = false;
				break;
				
			default:  // will never run
				break;
			}
			
		}

	}

	// 4.Invest Selected Method
	public static void InvestSelected() {
		
		// declare variables 
		Invest myInvest;
		Scanner input ;
		String userSelection;
		boolean run;

		// initialize variables
		myInvest = new Invest();
		input = new Scanner(System.in);  
		userSelection = "";
		run = true;

		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                   Invest");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Search Stock  [2] View All Stocks  [3] View Portfolio  [4] Invest  [q] Quit \n");

			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("3")||userSelection.equals("4")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// call SearchStock method
				myInvest.SearchStock();
				break;
				
			case "2":
				// call ViewAllStocks method
				myInvest.ViewAllStocks();
				break;
				
			case "3":
				// call ViewPortfolio method
				myInvest.ViewPortfolio();
				break;
				
			case "4":
				// call InvestSelected method
				myInvest.InvestSelected();
				break;
				
			case "q":
				run = false;
				break;
				
			default:  // will never run
				break;
			}
			
		}

	}
	
}
