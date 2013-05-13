package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.MenuBarComponentListener;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MhcPmsMainUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalSplitPanel verticalPanel = new VerticalSplitPanel();
		HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
		
		MenuBarComponentListener menuBarComponentListener = new MenuBarComponentListener();
		MenuBarComponent menuBar = new MenuBarComponent(menuBarComponentListener);
		
		HomeTitleBar homeTitleBar = new HomeTitleBar();
		PatientTableComponent patientTable = new PatientTableComponent();
		PatientInfoComponent patInfo = new PatientInfoComponent();
		CaseInfoComponent caseInfo = new CaseInfoComponent();
		PatientProgressComponent verlaufComp = new PatientProgressComponent();
		DiagnosisComponent diagnosisComp = new DiagnosisComponent();
		MedicationComponent medComp = new MedicationComponent();
		
		menuBarComponentListener.addButton(MenuBarComponentListener.MenuBarButtonEnum.HOME, homeTitleBar, patientTable);
		
		horizontalPanel.setFirstComponent(menuBar);
		horizontalPanel.setSecondComponent(patientTable);
		verticalPanel.setFirstComponent(homeTitleBar);
		verticalPanel.setSecondComponent(horizontalPanel);
		verticalPanel.setSplitPosition(20.0f, Unit.PERCENTAGE);
		horizontalPanel.setSplitPosition(10.0f, Unit.PERCENTAGE);
		this.setContent(verticalPanel);
	}

}
