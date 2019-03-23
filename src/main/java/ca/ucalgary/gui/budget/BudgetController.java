package ca.ucalgary.gui.budget;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ucalgary.datastore.BudgetRepository;
import ca.ucalgary.domain.Budget;
import ca.ucalgary.domain.Expense;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BudgetController implements Initializable{
	private BudgetRepository br = new BudgetRepository();
	private Budget budget = br.loadBudget();
	
	
	//Main scene
	@FXML
	AnchorPane budgetPane;
	@FXML
	Button editBudgetButton;
	@FXML
	Label expenseLabel;
	//menu scene 
	@FXML
	AnchorPane menuPane;
	@FXML
	Button removeExpenseButton;
	@FXML
	Button addExpenseButton;
	@FXML
	Button editIncomeButton;
	@FXML
	Button backButton;
	
	//add expense scene
	@FXML
	AnchorPane expensePane;
	@FXML
	TextField nameField;
	@FXML
	TextField costField;
	@FXML
	Button addExpenseToBudgetButton;
	@FXML
	Button cancelAddExpenseButton;
	@FXML
	Label expenseErrorLabel;
	@FXML
	Label expenseSuccessLabel;
	
	//remove expense scene
	@FXML
	AnchorPane removePane;
	@FXML
	ChoiceBox<String> expenseRemoveChoice;
	@FXML
	Button removeButton;
	@FXML
	Button returnRemoveButton;
	
	//edit income scene
	@FXML
	AnchorPane incomePane;
	@FXML
	TextField incomeField;
	@FXML
	Label incomeErrorLabel;
	@FXML
	Label incomeSuccessLabel;
	@FXML
	Button enterNewIncomeButton;
	@FXML
	Button returnFromIncomeButton;
	
	//controllers
	@FXML
	private void openMenu(ActionEvent event) throws Exception {
		System.out.print("button");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BudgetMenu.fxml"));
		Parent menuParent = (Parent)fxmlLoader.load();
		//Scene menuScene = new Scene(menuParent);
		budgetPane.getChildren().clear();
		budgetPane.getChildren().addAll(menuParent);
		//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //window.setScene(menuScene);
       // window.show();	
	}
	
	//Menu Buttons
	@FXML
	private void addExpense(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/AddBudget.fxml"));
		Parent addParent = (Parent)fxmlLoader.load();
		menuPane.getChildren().clear();
		menuPane.getChildren().addAll(addParent);
	}
	@FXML
	private void removeExpense(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/RemoveExpense.fxml"));
		Parent toRemove = (Parent)fxmlLoader.load();
		menuPane.getChildren().clear();
		menuPane.getChildren().addAll(toRemove);
	}
	@FXML
	private void editIncome(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/EditIncome.fxml"));
		Parent toIncome = (Parent)fxmlLoader.load();
		menuPane.getChildren().clear();
		menuPane.getChildren().addAll(toIncome);
	}
	@FXML
	private void closeMenu(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Budget.fxml"));
		Parent closeParent = (Parent)fxmlLoader.load();
		menuPane.getChildren().clear();
		menuPane.getChildren().addAll(closeParent);
	}
	//Add expense buttons
	@FXML
	private void addExpenseToBudget(ActionEvent event) throws Exception{
		try{double expenseAmount = Double.parseDouble(costField.getText());
			if (expenseAmount > 0 && budget.hasEnoughMoneyToAdd(expenseAmount)) {
				budget.addExpense(nameField.getText(),Double.parseDouble(costField.getText()));
				expenseSuccessLabel.setText("Expense Added Successfully");
				br.saveBudget(budget);
			}else if (expenseAmount > 0) 
				expenseErrorLabel.setText("Not enough income to add expense");
			else expenseErrorLabel.setText("Expense cost cannot be negative");
		} catch (Exception e) {
			expenseErrorLabel.setText("Cost must be in dollars");
		}
	}
	@FXML
	private void returnToMenuFromExpense(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Budget.fxml"));
		Parent closeParent = (Parent)fxmlLoader.load();
		expensePane.getChildren().clear();
		expensePane.getChildren().addAll(closeParent);
	}
	
	//remove expense buttons
	@FXML
	private void removeExpenseFromBudget(ActionEvent event) throws Exception{
		budget.removeExpense(expenseRemoveChoice.getValue());
		expenseRemoveChoice.getItems().clear();
		for(Expense x:budget.getExpenses())
			expenseRemoveChoice.getItems().add(x.getName());
		br.saveBudget(budget);
	}
	@FXML
	private void returnToMenuFromRemove(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BudgetMenu.fxml"));
		Parent toMenu = (Parent)fxmlLoader.load();
		removePane.getChildren().clear();
		removePane.getChildren().addAll(toMenu);
	}
	//edit income buttons
	@FXML
	private void enterNewIncome(ActionEvent event) throws Exception{
		try{double incomeToAdd = Double.parseDouble(incomeField.getText());
			if (incomeToAdd > budget.totalCostInDollars()) {
				budget.setIncome(incomeToAdd);
				incomeSuccessLabel.setText("Income Successfully Added");
				br.saveBudget(budget);
			} else if (incomeToAdd < 0){
				incomeErrorLabel.setText("Income cannot be negative");
			}else incomeErrorLabel.setText("Expenses too high to change income, remove some expenses");
			
		} catch(Exception e) {
			incomeErrorLabel.setText("Income must be in dollars");
		}
	}
	@FXML
	private void returnToMenuFromIncome(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BudgetMenu.fxml"));
		Parent toMenu = (Parent)fxmlLoader.load();
		incomePane.getChildren().clear();
		incomePane.getChildren().addAll(toMenu);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try{expenseLabel.setText(budget.toString());} catch(Exception e) {}
		try {
			for (Expense x:budget.getExpenses())
			expenseRemoveChoice.getItems().add(x.getName());
		}catch(Exception e) {}
	}
	
	
}
