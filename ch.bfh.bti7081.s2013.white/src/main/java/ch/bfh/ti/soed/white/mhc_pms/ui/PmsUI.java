package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class PmsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		this.setContent(new MainPanel(this));
	}
}
