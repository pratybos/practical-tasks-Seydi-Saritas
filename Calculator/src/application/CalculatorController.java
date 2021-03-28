package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

public class CalculatorController implements Initializable {

	Float data = 0f;
	int operation = -1;

	@FXML
	private Button minus;

	@FXML
	private Button nine;

	@FXML
	private Button six;

	@FXML
	private Button mult;

	@FXML
	private Button one;

	@FXML
	private TextField display;

	@FXML
	private Button clear;

	@FXML
	private Button seven;

	@FXML
	private Label label;

	@FXML
	private Button two;

	@FXML
	private Button three;

	@FXML
	private Button plus;

	@FXML
	private Button eight;

	@FXML
	private Button zero;

	@FXML
	private Button div;

	@FXML
	private Button four;

	@FXML
	private Button equals;

	@FXML
	private Button five;

	@FXML
	private Button changeTheme;

	@FXML
	private TextField textField;

	@FXML
	void handleButtonAction(ActionEvent event) throws MyException {
		if (event.getSource() == one) {
			display.setText(display.getText() + "1");
		} else if (event.getSource() == two) {
			display.setText(display.getText() + "2");
		} else if (event.getSource() == three) {
			display.setText(display.getText() + "3");
		} else if (event.getSource() == four) {
			display.setText(display.getText() + "4");
		} else if (event.getSource() == five) {
			display.setText(display.getText() + "5");
		} else if (event.getSource() == six) {
			display.setText(display.getText() + "6");
		} else if (event.getSource() == seven) {
			display.setText(display.getText() + "7");
		} else if (event.getSource() == eight) {
			display.setText(display.getText() + "8");
		} else if (event.getSource() == nine) {
			display.setText(display.getText() + "9");
		} else if (event.getSource() == zero) {
			display.setText(display.getText() + "0");
		} else if (event.getSource() == clear) {
			display.setText("");
		} else if (event.getSource() == plus) {
			data = Float.parseFloat(display.getText());
			operation = 1; // Addition
			display.setText("");
		} else if (event.getSource() == minus) {
			data = Float.parseFloat(display.getText());
			operation = 2; // Substraction
			display.setText("");
		} else if (event.getSource() == mult) {
			data = Float.parseFloat(display.getText());
			operation = 3; // Mul
			display.setText("");
		} else if (event.getSource() == div) {
			data = Float.parseFloat(display.getText());
			operation = 4; // Division
			display.setText("");
		} else if (event.getSource() == equals) {
			Float secondOperand = Float.parseFloat(display.getText());
			switch (operation) {
			case 1: // Addition
				Float ans = data + secondOperand;
				display.setText(String.valueOf(ans));
				break;
			case 2: // Subtraction
				ans = data - secondOperand;
				display.setText(String.valueOf(ans));
				break;
			case 3: // Mul
				ans = data * secondOperand;
				display.setText(String.valueOf(ans));
				break;
			case 4: // Div
				if (secondOperand == 0.0) {
					throw new MyException("MYEXCEPTION OCCURED! DIVISION BY ZERO!");
				}

				ans = 0f;
				ans = data / secondOperand;
				display.setText(String.valueOf(ans));
				break;
			}
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		UnaryOperator<Change> filter = change -> {
			String text = change.getText();

			if (text.matches("[0-9]*")) {
				return change;
			}

			return null;
		};
		TextFormatter<String> textFormatter = new TextFormatter<>(filter);
		textField.setTextFormatter(textFormatter);
	}

}