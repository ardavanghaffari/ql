package nl.uva.ql.gui.panel;

import nl.uva.ql.ast.expression.Expression;
import nl.uva.ql.evaluator.Evaluator;
import nl.uva.ql.evaluator.value.Value;
import nl.uva.ql.gui.widget.Widget;

public class ComputedQuestionPanel extends QuestionPanel{
	
	private final Expression expression;

	public ComputedQuestionPanel(Widget widget, String labelText, Expression expression) {
		super(widget, labelText);
		widget.getComponent().setEnabled(false);
		this.expression = expression;
	}
	
	@Override
	public void update(Evaluator evaluator){
		Value value = evaluator.evaluate(expression);
		if (!value.isUnknownValue() && !value.equals(widget.getValue())) {
			widget.setValue(value);
			widget.valueChanged(value);
		}
	}

}
