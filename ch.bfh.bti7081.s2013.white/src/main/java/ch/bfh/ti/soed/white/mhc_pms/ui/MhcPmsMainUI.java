package ch.bfh.ti.soed.white.mhc_pms.ui;


import ch.bfh.ti.soed.white.mhc_pms.ui.MenuBarComponent.ButtonEnum;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MhcPmsMainUI extends UI implements ImhcPmsUI {

	private VerticalSplitPanel verticalPanel = new VerticalSplitPanel();
	
	private HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
	
	@Override
	protected void init(VaadinRequest request) {
		MenuBarComponent menuBar = new MenuBarComponent(this);
		HomeTitleBarComponent homeTitleBar = new HomeTitleBarComponent();
		TitleBarComponent titleBar = new TitleBarComponent();
		PatientTableComponent patientTable = new PatientTableComponent();
		PatientInfoComponent patInfo = new PatientInfoComponent();
		CaseInfoComponent caseInfo = new CaseInfoComponent();
		PatientProgressComponent progressComp = new PatientProgressComponent();
		DiagnosisComponent diagnosisComp = new DiagnosisComponent();
		MedicationComponent medComp = new MedicationComponent();
		
		menuBar.addTab(ButtonEnum.HOME, homeTitleBar, patientTable);
		menuBar.addTab(ButtonEnum.PATIENT_INFO, titleBar, patInfo);
		menuBar.addTab(ButtonEnum.CASE_INFO, titleBar, caseInfo);
		menuBar.addTab(ButtonEnum.PATIENT_PROGRESS, titleBar, progressComp);
		menuBar.addTab(ButtonEnum.DIAGNOSIS, titleBar, diagnosisComp);
		menuBar.addTab(ButtonEnum.MEDICATION, titleBar, medComp);
		
		this.setActiveComponents(homeTitleBar, patientTable);
		this.horizontalPanel.setFirstComponent(menuBar);
		this.verticalPanel.setSecondComponent(this.horizontalPanel);
		this.verticalPanel.setSplitPosition(20.0f, Unit.PERCENTAGE);
		this.horizontalPanel.setSplitPosition(10.0f, Unit.PERCENTAGE);
		this.setContent(this.verticalPanel);
	}

	@Override
	public void setActiveComponents(Component title, Component detail) {
		this.verticalPanel.setFirstComponent(title);
		this.horizontalPanel.setSecondComponent(detail);
	}

}
