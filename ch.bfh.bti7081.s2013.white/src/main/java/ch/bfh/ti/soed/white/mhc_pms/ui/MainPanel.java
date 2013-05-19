package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.ui.MenuBarComponent.ButtonEnum;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

class MainPanel extends VerticalSplitPanel implements ImhcPmsComponent {
	
	private static final long serialVersionUID = 6726671929546867989L;

	private HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
	
	private TitleBarComponent titleBar = new TitleBarComponent();
	private PatientProgressComponent progressComp = new PatientProgressComponent();
	private DiagnosisComponent diagnosisComp = new DiagnosisComponent();
	private MedicationComponent medComp = new MedicationComponent();
	private PatientTableComponent patientTable;
	private PatientInfoComponent patInfo;
	private CaseInfoComponent caseInfo;
	private HomeTitleBarComponent homeTitleBar;
	private MenuBarComponent menuBar;
	private NewPatientComponent newPatientComponent;
	private EditCaseInfoComponent editCaseInfoComponent;
	
	public MainPanel() {
		//this.menuBar = new MenuBarComponent();
		this.homeTitleBar = new HomeTitleBarComponent();
		this.patInfo = new PatientInfoComponent();
		this.caseInfo = new CaseInfoComponent(this);
		this.newPatientComponent = new NewPatientComponent(this);
		this.editCaseInfoComponent = new EditCaseInfoComponent(this);
		this.patientTable = new PatientTableComponent();
		
		menuBar.addTab(ButtonEnum.HOME, homeTitleBar, this.patientTable);
		menuBar.addTab(ButtonEnum.PATIENT_INFO, this.titleBar, this.patInfo);
		menuBar.addTab(ButtonEnum.CASE_INFO, this.titleBar, this.caseInfo);
		menuBar.addTab(ButtonEnum.PATIENT_PROGRESS, this.titleBar, this.progressComp);
		menuBar.addTab(ButtonEnum.DIAGNOSIS, this.titleBar, this.diagnosisComp);
		menuBar.addTab(ButtonEnum.MEDICATION, this.titleBar, this.medComp);
		
		this.setActiveComponents(this.homeTitleBar, this.patientTable);
		this.horizontalPanel.setFirstComponent(menuBar);
		this.setSecondComponent(this.horizontalPanel);
		this.setSplitPosition(20.0f, Unit.PERCENTAGE);
		this.horizontalPanel.setSplitPosition(10.0f, Unit.PERCENTAGE);
	}

	@Override
	public void setActiveComponents(Component title, Component detail) {
		this.setFirstComponent(title);
		this.horizontalPanel.setSecondComponent(detail);
	}

	@Override
	public void updateComponentDataSource() {
		this.titleBar.updateComponentDataSource();
		if (this.patientTable != null) {
			this.patientTable.updateComponentDataSource();
		}
		this.patInfo.updateComponentDataSource();
		this.caseInfo.updateComponentDataSource();
		this.progressComp.updateComponentDataSource();
		this.diagnosisComp.updateComponentDataSource();
		this.medComp.updateComponentDataSource();
	}

	@Override
	public Component getHomeTitleBarComponent() {
		return this.homeTitleBar;
	}

	@Override
	public Component getNewPatientComponent() {
		return this.newPatientComponent;
	}
	
	@Override
	public Component getEditCaseInfoComponent() {
		return this.editCaseInfoComponent;
	}

	@Override
	public void enableMenuBar(boolean value) {
		this.menuBar.enableMenuBar(value);
	}

	@Override
	public Component getPatientInfoComponent() {
		return this.patInfo;
	}

	@Override
	public Component getCaseInfoComponent() {
		return this.caseInfo;
	}

	@Override
	public Component getTitleBarComponent() {
		return this.titleBar;
	}

}
