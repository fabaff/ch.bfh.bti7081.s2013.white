package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;

class MainPanel extends HorizontalSplitPanel {
	
	private static final long serialVersionUID = 6726671929546867989L;
	
	private static final float  VERTICAL_SPLIT_POS = 20.0f;
	
	private static final float HORIZONTAL_SPLIT_POS = 10.0f;

	public MainPanel(PmsUI pmsUI) {
		Panel detailPanel = new Panel();
		Navigator navigator = new Navigator(pmsUI, detailPanel);
		VerticalSplitPanel verticalPanel = new VerticalSplitPanel();
		TitleBarComponent titleBar = new TitleBarComponent();
		PatientTableComponent patientTable = new PatientTableComponent();
		MenuBarComponent menuBar = new MenuBarComponent(navigator);
		PatientInfoComponent patInfo = new PatientInfoComponent();
		CaseInfoComponent caseInfo = new CaseInfoComponent();
		PatientProgressComponent progressComp = new PatientProgressComponent();
		DiagnosisComponent diagnosisComp = new DiagnosisComponent();
		MedicationComponent medComp = new MedicationComponent();
		
		detailPanel.setSizeFull();
		this.setFirstComponent(menuBar);
		this.setSecondComponent(verticalPanel);
		this.setSplitPosition(HORIZONTAL_SPLIT_POS, Unit.PERCENTAGE);
		verticalPanel.setFirstComponent(titleBar);
		verticalPanel.setSecondComponent(detailPanel);		
		verticalPanel.setSplitPosition(VERTICAL_SPLIT_POS, Unit.PERCENTAGE);
		
		navigator.addView(MenuBarComponent.ButtonEnum.HOME.toString(),
				patientTable);
		navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
				patInfo);
		navigator.addView(MenuBarComponent.ButtonEnum.CASE_INFO.toString(),
				caseInfo);
		navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_PROGRESS.toString(),
				progressComp);
		navigator.addView(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(),
				diagnosisComp);
		navigator.addView(MenuBarComponent.ButtonEnum.MEDICATION.toString(),
				medComp);
		
		navigator.navigateTo(MenuBarComponent.ButtonEnum.HOME.toString());

//		TODO				
//		 setComponentAlignment(button, Alignment.MIDDLE_CENTER);
//		 Notification.show("Welcome to the Animal Farm");
	}

}
