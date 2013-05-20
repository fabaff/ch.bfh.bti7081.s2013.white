package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;

class MainPanel extends HorizontalSplitPanel {
	
	private static final long serialVersionUID = 6726671929546867989L;
	
	private static final float  VERTICAL_SPLIT_POS = 20.0f;
	
	private static final float HORIZONTAL_SPLIT_POS = 10.0f;

	private VerticalSplitPanel verticalPanel = new VerticalSplitPanel();
	private TitleBarComponent titleBar = new TitleBarComponent();
	private PatientTableComponent patientTable = new PatientTableComponent();
	private PatientInfoComponent patInfo = new PatientInfoComponent();
	private CaseInfoComponent caseInfo = new CaseInfoComponent();
	private PatientProgressComponent progressComp = new PatientProgressComponent();
	private DiagnosisComponent diagnosisComp = new DiagnosisComponent();
	private MedicationComponent medComp = new MedicationComponent();
	private MenuBarComponent menuBar;
	
	public MainPanel(PmsUI pmsUI) {
		Panel detailPanel = new Panel();
		Navigator navigator = new Navigator(pmsUI, detailPanel);
		this.menuBar = new MenuBarComponent(navigator);
		
		detailPanel.setSizeFull();
		this.setFirstComponent(this.menuBar);
		this.setSecondComponent(this.verticalPanel);
		this.setSplitPosition(HORIZONTAL_SPLIT_POS, Unit.PERCENTAGE);
		this.verticalPanel.setFirstComponent(this.titleBar);
		this.verticalPanel.setSecondComponent(detailPanel);		
		this.verticalPanel.setSplitPosition(VERTICAL_SPLIT_POS, Unit.PERCENTAGE);
		
		navigator.addView(MenuBarComponent.ButtonEnum.HOME.toString(),
				this.patientTable);
		navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
				this.patInfo);
		navigator.addView(MenuBarComponent.ButtonEnum.CASE_INFO.toString(),
				this.caseInfo);
		navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_PROGRESS.toString(),
				this.progressComp);
		navigator.addView(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(),
				this.diagnosisComp);
		navigator.addView(MenuBarComponent.ButtonEnum.MEDICATION.toString(),
				this.medComp);
		navigator.navigateTo(MenuBarComponent.ButtonEnum.HOME.toString());

		this.patientTable.addPmsComponentListener(this.titleBar);
		this.patientTable.addPmsComponentListener(this.patInfo);
		this.patientTable.addPmsComponentListener(this.caseInfo);
		this.patientTable.addPmsComponentListener(this.progressComp);
		this.patientTable.addPmsComponentListener(this.diagnosisComp);
		this.patientTable.addPmsComponentListener(this.medComp);
		
//		TODO				
//		 setComponentAlignment(button, Alignment.MIDDLE_CENTER);
//		 Notification.show("Welcome to the Animal Farm");
	}

}
