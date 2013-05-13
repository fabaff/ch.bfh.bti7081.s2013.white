package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MhcPmsMainUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout vertLayout = new VerticalLayout();
		this.setContent(new Label("MHC PMS"));
		
		
	}

}
