package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class PmsUI extends UI {

	public static final String PERSISTENCE_UNIT = "ch.bfh.bti7081.s2013.white";
	
	@Override
	protected void init(VaadinRequest request) {
		Panel panel = new Panel();
		Navigator navigator = new Navigator(this, panel);
		HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
		PmsVerticalSplitPanel verticalPanel = new PmsVerticalSplitPanel();
		
		horizontalPanel.setFirstComponent(new MenuBarComponent(navigator));
		horizontalPanel.setSecondComponent(panel);
		navigator.addView("", verticalPanel);
		panel.setContent(new PatientTableComponent());
		panel.setSizeFull();
		
		verticalPanel.setFirstComponent(new HomeTitleBarComponent());
		verticalPanel.setSecondComponent(new PatientTableComponent());
		navigator.addView(MenuBarComponent.ButtonEnum.HOME.toString(),
				verticalPanel);
		verticalPanel = new PmsVerticalSplitPanel();
		verticalPanel.setFirstComponent(new TitleBarComponent());
		verticalPanel.setSecondComponent(new PatientInfoComponent());
		navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
				verticalPanel);
		this.setContent(horizontalPanel);
		
		navigator.navigateTo(MenuBarComponent.ButtonEnum.HOME.toString());

//		 setComponentAlignment(button, Alignment.MIDDLE_CENTER);
//		 Notification.show("Welcome to the Animal Farm");
//		 this.setContent(new MainPanel());
	}
}
