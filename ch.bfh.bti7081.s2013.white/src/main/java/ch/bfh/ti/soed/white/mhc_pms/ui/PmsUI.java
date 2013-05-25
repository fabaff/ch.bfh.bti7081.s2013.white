package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * @author	Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version	0.0.2 
 * @since	0.0.1
 * 
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class PmsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		// TODO generate user dummy data
		// TODO user authentication
		this.setContent(new MainPanel(this));
	}
}
