package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.ui.MenuBarComponent.ButtonEnum;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalSplitPanel;

class MainPanel extends VerticalSplitPanel implements ImhcPmsComponent {
	
	private static final long serialVersionUID = 6726671929546867989L;

	private HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
	
	private TitleBarComponent titleBar = new TitleBarComponent();
	private PatientTableComponent patientTable;
	private PatientInfoComponent patInfo = new PatientInfoComponent();
	private CaseInfoComponent caseInfo = new CaseInfoComponent();
	private PatientProgressComponent progressComp = new PatientProgressComponent();
	private DiagnosisComponent diagnosisComp = new DiagnosisComponent();
	private MedicationComponent medComp = new MedicationComponent();
	
	public MainPanel() {
		MenuBarComponent menuBar = new MenuBarComponent(this);
		HomeTitleBarComponent homeTitleBar = new HomeTitleBarComponent();
		this.patientTable = new PatientTableComponent(this);
		
		menuBar.addTab(ButtonEnum.HOME, homeTitleBar, this.patientTable);
		menuBar.addTab(ButtonEnum.PATIENT_INFO, this.titleBar, this.patInfo);
		menuBar.addTab(ButtonEnum.CASE_INFO, this.titleBar, this.caseInfo);
		menuBar.addTab(ButtonEnum.PATIENT_PROGRESS, this.titleBar, this.progressComp);
		menuBar.addTab(ButtonEnum.DIAGNOSIS, this.titleBar, this.diagnosisComp);
		menuBar.addTab(ButtonEnum.MEDICATION, this.titleBar, this.medComp);
		
		this.setActiveComponents(homeTitleBar, this.patientTable);
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

}
