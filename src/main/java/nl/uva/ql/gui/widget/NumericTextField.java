package nl.uva.ql.gui.widget;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JTextField;

import nl.uva.ql.evaluator.Evaluator;
import nl.uva.ql.evaluator.value.IntegerValue;
import nl.uva.ql.evaluator.value.MoneyValue;
import nl.uva.ql.evaluator.value.UnknownValue;
import nl.uva.ql.evaluator.value.Value;
import nl.uva.ql.gui.QLFrame;

public class NumericTextField extends Widget implements ActionListener{
	
	private JTextField numericTextField;

	private Pattern integerPattern = Pattern.compile("[-+]?[0-9]+");
	private Pattern moneyPattern = Pattern.compile("[0-9]+\\.[0-9][0-9]?");

	public NumericTextField(Evaluator evaluator, QLFrame frame) {
		super(evaluator, frame);
		this.numericTextField = new JTextField();
		this.numericTextField.setPreferredSize(new Dimension(100, 25));
		this.numericTextField.addActionListener(this);
	}

	@Override
	public JComponent getComponent() {
		return numericTextField;
	}

	@Override
	public void setValue(Value value) {
		numericTextField.setText(value.toString());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		updateValue();
		passFocus();
	}
	
	private void updateValue() {
		try {
			String input = numericTextField.getText();
			Matcher integerMatcher = integerPattern.matcher(input);
			Matcher moneyMatcher = moneyPattern.matcher(input);
			
			if (input.length() == 0) {
				valueChanged(new UnknownValue());
			} else if (integerMatcher.matches()) {
				valueChanged(new IntegerValue(Integer.parseInt(input)));
			} else if (moneyMatcher.matches()) {
				valueChanged(new MoneyValue(new BigDecimal(input)));
			} else {
				giveError("Error parsing input for Numeric text field: " + this.getIdentifier().getName());
			}
		} catch (Exception exception) {
			giveError(MessageFormat.format("Error in Numeric text field ''{0}'' : {1}", this.getIdentifier().getName(), exception.getMessage()));
		}
	}

}
