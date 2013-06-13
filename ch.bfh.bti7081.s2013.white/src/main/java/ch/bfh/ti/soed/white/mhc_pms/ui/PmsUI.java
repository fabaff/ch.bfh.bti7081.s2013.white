package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.util.DummyDataCreator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The Vaadin entry point of the application.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class PmsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		DummyDataCreator.createDummyUsers();
		this.setContent(new MainPanel(this));
	}
}
