package nl.uva.ql.gui.panel;

import java.util.List;
import nl.uva.ql.evaluator.Evaluator;

public class BoxPanel extends Panel{
	
	private List<Panel> panels;
	
	public BoxPanel(List<Panel> panels) {
		this.panels = panels;
		addToPanel(panels);
	}
	
	private void addToPanel(List<Panel> panels){
		for(Panel panel: panels) {
			addToPanel(panel, "hidemode 3, growx, wrap");
		}
	}

	@Override
	public void update(Evaluator evaluator) {
		for(Panel panel: panels) {
			panel.update(evaluator);
		}
	}

}
