package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MhcPmsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
//		MhcPmsVerticalSplitPanel verticalPanel = new MhcPmsVerticalSplitPanel();
//		Panel panel = new Panel();
//		Navigator navigator = this.getNavigator();
//		if (navigator != null) {
//			navigator.addView("", verticalPanel);
//		} else {
//			navigator = new Navigator(this, panel);
//		}
//
//		HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
//		horizontalPanel.setFirstComponent(new MenuBarComponent(navigator));
//		horizontalPanel.setSecondComponent(panel);
//
//		verticalPanel.setFirstComponent(new HomeTitleBarComponent());
//		verticalPanel.setFirstComponent(new PatientTableComponent());
//		navigator.addView(MenuBarComponent.ButtonEnum.HOME.toString(),
//				verticalPanel);
//		verticalPanel = new MhcPmsVerticalSplitPanel();
//		verticalPanel.setFirstComponent(new TitleBarComponent());
//		verticalPanel.setFirstComponent(new PatientInfoComponent());
//		navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
//				verticalPanel);
//		this.setContent(horizontalPanel);

		// setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		// Notification.show("Welcome to the Animal Farm");
		// this.setContent(new MainPanel());
	}

}
