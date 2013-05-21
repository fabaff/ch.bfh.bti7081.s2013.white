package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.ComponentChangeListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.EditEvent;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;

class MainPanel extends HorizontalSplitPanel implements ComponentChangeListener {
	
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
	private NewPatientComponent newPatientComp = new NewPatientComponent();
	private EditCaseInfoComponent editCaseInfoComp = new EditCaseInfoComponent();
	private MenuBarComponent menuBar;
	private Navigator navigator;
	
	public MainPanel(PmsUI pmsUI) {
		Panel detailPanel = new Panel();
		this.navigator = new Navigator(pmsUI, detailPanel);
		this.menuBar = new MenuBarComponent(this.navigator);
		this.newPatientComp = new NewPatientComponent();
		this.editCaseInfoComp = new EditCaseInfoComponent();
		
		detailPanel.setSizeFull();
		this.setFirstComponent(this.menuBar);
		this.setSecondComponent(this.verticalPanel);
		this.setSplitPosition(HORIZONTAL_SPLIT_POS, Unit.PERCENTAGE);
		this.verticalPanel.setFirstComponent(this.titleBar);
		this.verticalPanel.setSecondComponent(detailPanel);		
		this.verticalPanel.setSplitPosition(VERTICAL_SPLIT_POS, Unit.PERCENTAGE);
		
		this.navigator.addView(MenuBarComponent.ButtonEnum.HOME.toString(),
				this.patientTable);
		this.navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
				this.patInfo);
		this.navigator.addView(MenuBarComponent.ButtonEnum.CASE_INFO.toString(),
				this.caseInfo);
		this.navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_PROGRESS.toString(),
				this.progressComp);
		this.navigator.addView(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(),
				this.diagnosisComp);
		this.navigator.addView(MenuBarComponent.ButtonEnum.MEDICATION.toString(),
				this.medComp);
		this.navigator.navigateTo(MenuBarComponent.ButtonEnum.HOME.toString());

		this.menuBar.addPmsComponentListener(this.titleBar);
		this.menuBar.addPmsComponentListener(this.patientTable);
		this.menuBar.addPmsComponentListener(this.patInfo);
		this.menuBar.addPmsComponentListener(this.caseInfo);
		this.menuBar.addPmsComponentListener(this.progressComp);
		this.menuBar.addPmsComponentListener(this.diagnosisComp);
		this.menuBar.addPmsComponentListener(this.medComp);
		
		this.patientTable.addPmsComponentListener(this.titleBar);
		this.patientTable.addPmsComponentListener(this.patInfo);
		this.patientTable.addPmsComponentListener(this.caseInfo);
		this.patientTable.addPmsComponentListener(this.progressComp);
		this.patientTable.addPmsComponentListener(this.diagnosisComp);
		this.patientTable.addPmsComponentListener(this.medComp);
		this.patientTable.addComponentChangeListener(this);
		this.patientTable.addUIActivationListener(this.menuBar);
		this.patientTable.addUIActivationListener(this.titleBar);
		
		this.patInfo.addUIActivationListener(this.menuBar);
		this.patInfo.addUIActivationListener(this.titleBar);
		this.patInfo.addComponentChangeListener(this);
		
		this.newPatientComp.addPmsComponentListener(this.titleBar);
		this.newPatientComp.addPmsComponentListener(this.patientTable);
		this.newPatientComp.addPmsComponentListener(this.patInfo);
		this.newPatientComp.addPmsComponentListener(this.caseInfo);
		this.newPatientComp.addPmsComponentListener(this.progressComp);
		this.newPatientComp.addPmsComponentListener(this.diagnosisComp);
		this.newPatientComp.addPmsComponentListener(this.medComp);
		this.newPatientComp.addUIActivationListener(this.menuBar);
		this.newPatientComp.addUIActivationListener(this.titleBar);
		this.newPatientComp.addComponentChangeListener(this);
		
		this.editCaseInfoComp.addUIActivationListener(this.menuBar);
		this.editCaseInfoComp.addUIActivationListener(this.titleBar);
		this.editCaseInfoComp.addComponentChangeListener(this);
		
		this.caseInfo.addUIActivationListener(this.menuBar);
		this.caseInfo.addUIActivationListener(this.titleBar);
		this.caseInfo.addComponentChangeListener(this);
		
//		TODO restliche Component Listner
//		 setComponentAlignment(button, Alignment.MIDDLE_CENTER);
//		 Notification.show("Welcome to the Animal Farm");
	}

	@Override
	public void componentChange(EditEvent event) {
		switch (event) {
		case PATIENT:
			this.navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
					this.newPatientComp);
			this.navigator.navigateTo(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString());
			break;
		case PCASE:
			this.navigator.addView(MenuBarComponent.ButtonEnum.CASE_INFO.toString(),
					this.editCaseInfoComp);
			this.navigator.navigateTo(MenuBarComponent.ButtonEnum.CASE_INFO.toString());
			break;
		case PATIENT_BACK:
			this.navigator.addView(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
					this.patInfo);
			this.navigator.navigateTo(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString());
			break;
		case PCASE_BACK:
			this.navigator.addView(MenuBarComponent.ButtonEnum.CASE_INFO.toString(),
					this.caseInfo);
			this.navigator.navigateTo(MenuBarComponent.ButtonEnum.CASE_INFO.toString());
			break;
		}
	}

}
