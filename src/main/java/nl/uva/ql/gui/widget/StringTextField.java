package nl.uva.ql.gui.widget;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JTextField;
import nl.uva.ql.evaluator.Evaluator;
import nl.uva.ql.evaluator.value.StringValue;
import nl.uva.ql.evaluator.value.Value;
import nl.uva.ql.gui.QLFrame;

public class StringTextField extends Widget implements ActionListener {
	
	private JTextField stringTextField;

	public StringTextField(Evaluator evaluator, QLFrame form) {
		super(evaluator, form);
		this.stringTextField = new JTextField();
		this.stringTextField.setPreferredSize(new Dimension(100, 25));
		this.stringTextField.addActionListener(this);
	}

	@Override
	public JComponent getComponent() {
		return stringTextField;
	}

	@Override
	public void setValue(Value value) {
		stringTextField.setText(value.toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		updateValue();
		passFocus();
	}
	
	private void updateValue() {
		String input = stringTextField.getText();
		valueChanged(new StringValue(input));
	}
}
