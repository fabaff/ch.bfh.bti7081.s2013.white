package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.ComponentChangeListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.Reindeer;

/**
 * The main panel of the GUI.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
class MainPanel extends Panel implements ComponentChangeListener {

	private class ApplicationPanel extends Panel implements View {

		private static final long serialVersionUID = 2341663541014297015L;

		@Override
		public void enter(ViewChangeEvent event) {
			MainPanel.this.applicationNavigator.navigateTo(MenuBarComponent.ButtonEnum.HOME.toString());
		}
		
	}
	
	// Static vars for positioning
	private static final long serialVersionUID = 6726671929546867989L;
	private static final float VERTICAL_SPLIT_POS = 90.0f;
	private static final float HORIZONTAL_SPLIT_POS = 140.0f;

	/*
	 * Screen layout of the GUI 
	 * +----+-------------------------+ 
	 * |    |                    90px |
	 * |    +-------------------------+ 
	 * |    |                         |
	 * |    |                         |
	 * | 140|                         |
	 * +----+-------------------------+
	 */

	// UI elements
	private LoginComponent loginComponent = new LoginComponent();
	private HorizontalSplitPanel horizontalPanel = new HorizontalSplitPanel();
	private VerticalSplitPanel verticalPanel = new VerticalSplitPanel();
	private Panel detailPanel = new Panel();
	private ApplicationPanel applicationPanel = new ApplicationPanel();
	private TitleBarComponent titleBar = new TitleBarComponent();
	private PatientTableComponent patientTable = new PatientTableComponent();
	private PatientInfoComponent patInfo = new PatientInfoComponent();
	private CaseInfoComponent caseInfo = new CaseInfoComponent();
	private PatientProgressComponent progressComp = new PatientProgressComponent();
	private DiagnosisTableComponent diagnosisTableComp = new DiagnosisTableComponent();
	private DiagnosisDetailComponent diagnosisDetailComp = new DiagnosisDetailComponent();
	private MedicationComponent medComp = new MedicationComponent();
	private NewPatientComponent newPatientComp = new NewPatientComponent();
	private EditCaseInfoComponent editCaseInfoComp = new EditCaseInfoComponent();
	private EditDiagnosisComponent editDiagnosisComp = new EditDiagnosisComponent();
	private MenuBarComponent menuBar;
	private Navigator applicationNavigator;
	private Navigator loginNavigator;

	/**
	 * 
	 * @param pmsUI
	 */
	public MainPanel(PmsUI pmsUI) {
		this.loginNavigator = new Navigator(pmsUI, this);
		this.applicationNavigator = new Navigator(pmsUI, this.detailPanel);
		this.menuBar = new MenuBarComponent(this.applicationNavigator);
		this.newPatientComp = new NewPatientComponent();
		this.editCaseInfoComp = new EditCaseInfoComponent();

		this.setSizeFull();
		this.detailPanel.setSizeFull();
		this.applicationPanel.setSizeFull();
		this.setContent(this.loginComponent);
		this.setUpHorizontalPanel();
		this.setUpVerticalPanel();
		this.addNavigatorViews();
		
		this.addLoginComponentListeners();
		this.addMenuBarListeners();
		this.addTitleBarListeners();
		this.addPatientTableListeners();
		this.addPatientInfoListeners();
		this.addNewPatientListeners();
		this.addCaseInfoListeners();
		this.addEditCaseListeners();
		this.addDiagnosisTableListeners();
		this.addDiagnosisDetailListeners();
		this.addEditDiagnosisListeners();

		// TODO Add missing Component Listener
	}

	private void addTitleBarListeners() {
		this.titleBar.addComponentChangeListener(this);
		this.titleBar.addPmsComponentListener(this.patientTable);
	}

	private void addLoginComponentListeners() {
		this.loginComponent.addComponentChangeListener(this);
		this.loginComponent.addInitListener(this.patientTable);
		this.loginComponent.addInitListener(this.diagnosisTableComp);
	}

	private void addEditDiagnosisListeners() {
		this.editDiagnosisComp.addUIActivationListener(this.menuBar);
		this.editDiagnosisComp.addUIActivationListener(this.titleBar);
		this.editDiagnosisComp.addComponentChangeListener(this);
	}

	private void addDiagnosisDetailListeners() {
		this.diagnosisDetailComp.addUIActivationListener(this.menuBar);
		this.diagnosisDetailComp.addUIActivationListener(this.titleBar);
		this.diagnosisDetailComp.addComponentChangeListener(this);
		this.diagnosisDetailComp.addNewCaseListener(this.editDiagnosisComp);
	}

	private void addDiagnosisTableListeners() {
		this.diagnosisTableComp.addUIActivationListener(this.menuBar);
		this.diagnosisTableComp.addUIActivationListener(this.titleBar);
		this.diagnosisTableComp.addComponentChangeListener(this);
		this.diagnosisTableComp.addNewCaseListener(this.editDiagnosisComp);
	}

	private void setUpHorizontalPanel() {
		this.applicationPanel.setContent(this.horizontalPanel);
		this.horizontalPanel.setFirstComponent(this.menuBar);
		this.horizontalPanel.setSecondComponent(this.verticalPanel);
		
		// Panel splitting static size or dynamic
		// Horizontal panel
		//this.setSplitPosition(HORIZONTAL_SPLIT_POS, Unit.PERCENTAGE);
		this.horizontalPanel.setSplitPosition(HORIZONTAL_SPLIT_POS, Unit.PIXELS);
		// Lock panel size, only needed when size in %
		this.horizontalPanel.setLocked(true);
		// Panel divider formating with theme
		this.horizontalPanel.addStyleName(Reindeer.SPLITPANEL_SMALL);
	}

	private void setUpVerticalPanel() {
		// Vertical panel
		//this.verticalPanel.setSplitPosition(VERTICAL_SPLIT_POS, Unit.PERCENTAGE);
		this.verticalPanel.setSplitPosition(VERTICAL_SPLIT_POS, Unit.PIXELS);
		this.verticalPanel.setFirstComponent(this.titleBar);
		this.verticalPanel.setSecondComponent(this.detailPanel);
		this.verticalPanel.setLocked(true);
		this.verticalPanel.addStyleName(Reindeer.SPLITPANEL_SMALL);
	}

	private void addEditCaseListeners() {
		// Edit Case section
		this.editCaseInfoComp.addPmsComponentListener(this.titleBar);
		this.editCaseInfoComp.addPmsComponentListener(this.patientTable);
		this.editCaseInfoComp.addPmsComponentListener(this.patInfo);
		this.editCaseInfoComp.addPmsComponentListener(this.caseInfo);
		this.editCaseInfoComp.addPmsComponentListener(this.progressComp);
		this.editCaseInfoComp.addPmsComponentListener(this.diagnosisTableComp);
		this.editCaseInfoComp.addPmsComponentListener(this.diagnosisDetailComp);
		this.editCaseInfoComp.addPmsComponentListener(this.medComp);
		this.editCaseInfoComp.addUIActivationListener(this.menuBar);
		this.editCaseInfoComp.addUIActivationListener(this.titleBar);
		this.editCaseInfoComp.addComponentChangeListener(this);
	}

	private void addCaseInfoListeners() {
		// Case info section
		this.caseInfo.addUIActivationListener(this.menuBar);
		this.caseInfo.addUIActivationListener(this.titleBar);
		this.caseInfo.addComponentChangeListener(this);
		this.caseInfo.addNewCaseListener(this.editCaseInfoComp);
	}

	private void addNewPatientListeners() {
		// New Patient section
		this.newPatientComp.addPmsComponentListener(this.titleBar);
		this.newPatientComp.addPmsComponentListener(this.patientTable);
		this.newPatientComp.addPmsComponentListener(this.patInfo);
		this.newPatientComp.addPmsComponentListener(this.caseInfo);
		this.newPatientComp.addPmsComponentListener(this.progressComp);
		this.newPatientComp.addPmsComponentListener(this.diagnosisTableComp);
		this.newPatientComp.addPmsComponentListener(this.diagnosisDetailComp);
		this.newPatientComp.addPmsComponentListener(this.medComp);
		this.newPatientComp.addUIActivationListener(this.menuBar);
		this.newPatientComp.addUIActivationListener(this.titleBar);
		this.newPatientComp.addComponentChangeListener(this);
	}

	private void addPatientInfoListeners() {
		// Patient info section
		this.patInfo.addUIActivationListener(this.menuBar);
		this.patInfo.addUIActivationListener(this.titleBar);
		this.patInfo.addComponentChangeListener(this);
	}

	private void addPatientTableListeners() {
		// Patient table section
		this.patientTable.addPmsComponentListener(this.titleBar);
		this.patientTable.addPmsComponentListener(this.patInfo);
		this.patientTable.addPmsComponentListener(this.caseInfo);
		this.patientTable.addPmsComponentListener(this.progressComp);
		this.patientTable.addPmsComponentListener(this.diagnosisTableComp);
		this.patientTable.addPmsComponentListener(this.diagnosisDetailComp);
		this.patientTable.addPmsComponentListener(this.medComp);
		this.patientTable.addUIActivationListener(this.menuBar);
		this.patientTable.addUIActivationListener(this.titleBar);
		this.patientTable.addComponentChangeListener(this);
		this.patientTable.addNewCaseListener(this.editCaseInfoComp);
	}

	private void addMenuBarListeners() {
		this.menuBar.addPmsComponentListener(this.titleBar);
		this.menuBar.addPmsComponentListener(this.patientTable);
		this.menuBar.addPmsComponentListener(this.patInfo);
		this.menuBar.addPmsComponentListener(this.caseInfo);
		this.menuBar.addPmsComponentListener(this.progressComp);
		this.menuBar.addPmsComponentListener(this.diagnosisTableComp);
		this.menuBar.addPmsComponentListener(this.medComp);
	}

	private void addNavigatorViews() {
		this.loginNavigator.addView(NavigationEvent.LOGIN.toString(), this.applicationPanel);
		this.loginNavigator.addView(NavigationEvent.LOGOUT.toString(), this.loginComponent);
		this.loginNavigator.navigateTo(NavigationEvent.LOGOUT.toString());
		
		this.applicationNavigator.addView(MenuBarComponent.ButtonEnum.HOME.toString(),
				this.patientTable);
		this.applicationNavigator.addView(
				MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(),
				this.patInfo);
		this.applicationNavigator
				.addView(MenuBarComponent.ButtonEnum.CASE_INFO.toString(),
						this.caseInfo);
		this.applicationNavigator.addView(
				MenuBarComponent.ButtonEnum.PATIENT_PROGRESS.toString(),
				this.progressComp);
		this.applicationNavigator.addView(
				MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(),
				this.diagnosisTableComp);
		this.applicationNavigator
				.addView(MenuBarComponent.ButtonEnum.MEDICATION.toString(),
						this.medComp);		
		this.applicationNavigator.navigateTo(MenuBarComponent.ButtonEnum.HOME.toString());
	}

	@Override
	public void componentChange(NavigationEvent event) {
		switch (event) {
		case PATIENT:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(), this.newPatientComp);
			break;
		case PCASE:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.CASE_INFO.toString(), this.editCaseInfoComp);
			break;
		case PATIENT_BACK:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.PATIENT_INFO.toString(), this.patInfo);
			break;
		case PCASE_BACK:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.CASE_INFO.toString(), this.caseInfo);
			break;
		case DIAGNOSIS_TABLE:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(), this.diagnosisTableComp);
			break;
		case DIAGNOSIS_DETAIL:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(), this.diagnosisDetailComp);
			break;
		case EDIT_DIAGNOSIS:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(), this.editDiagnosisComp);
			break;
		case DIAGNOSIS_BACK:
			this.applicationNavigate(MenuBarComponent.ButtonEnum.DIAGNOSIS.toString(), this.diagnosisDetailComp);
			break;
		case LOGIN:
			this.loginNavigator.navigateTo(NavigationEvent.LOGIN.toString());
			break;
		case LOGOUT:
			this.loginNavigator.navigateTo(NavigationEvent.LOGOUT.toString());
			break;
		}
	}

	private void applicationNavigate(String viewName, View view) {
		this.applicationNavigator.addView(viewName, view);
		this.applicationNavigator.navigateTo(viewName);
	}
}
