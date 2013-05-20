package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class PmsUI extends UI {

	public static final String PERSISTENCE_UNIT = "ch.bfh.bti7081.s2013.white";
	
	@Override
	protected void init(VaadinRequest request) {
		this.setContent(new MainPanel(this));
	}
}
