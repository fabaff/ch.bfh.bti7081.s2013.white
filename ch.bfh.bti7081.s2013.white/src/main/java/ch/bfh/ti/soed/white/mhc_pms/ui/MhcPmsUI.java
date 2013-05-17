package ch.bfh.ti.soed.white.mhc_pms.ui;



import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsContainer;
import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.Patient;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MhcPmsUI extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
		this.setContent(new MainPanel());
	}

}
