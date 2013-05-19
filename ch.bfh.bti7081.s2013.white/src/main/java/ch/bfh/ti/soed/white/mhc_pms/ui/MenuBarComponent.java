package ch.bfh.ti.soed.white.mhc_pms.ui;

import java.util.HashMap;
import java.util.Map;


import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Window;

class MenuBarComponent extends CustomComponent {
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnLogout;
	@AutoGenerated
	private Button btnForward;
	@AutoGenerated
	private Button btnBack;
	@AutoGenerated
	private Button btnMedication;
	@AutoGenerated
	private Button btnDiagnosis;
	@AutoGenerated
	private Button btnPatientProgress;
	@AutoGenerated
	private Button btnCaseInfo;
	@AutoGenerated
	private Button btnPatientInfo;
	@AutoGenerated
	private Button btnHome;
	private class MenuBarButtonListener implements Button.ClickListener {

		private static final long serialVersionUID = 6871625769306860092L;

		private Map<String, Component[]> buttonComponentMap;
		
		private MenuBarButtonListener() {
			this.buttonComponentMap = new HashMap<>();
		}
		
		@Override
		public void buttonClick(ClickEvent event) {
			Component[] comp = this.buttonComponentMap.get(event.getButton().getCaption());
			//MenuBarComponent.this.mainComponent.setActiveComponents(comp[0], comp[1]);
		}

		private void addTab(String caption, Component title, Component main) {
			this.buttonComponentMap.put(caption, new Component[] { title, main });
		}
		
	}
	
	enum ButtonEnum {
		HOME, PATIENT_INFO, CASE_INFO, PATIENT_PROGRESS, DIAGNOSIS, MEDICATION
	}
	
	private static final long serialVersionUID = 2747224025250099607L;
	
	private Map<ButtonEnum, String> buttonCaptionMap;
	
	private MenuBarButtonListener buttonListener;
	
	private Navigator navigator;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 * @param mhcPmsMainUI 
	 */
	public MenuBarComponent(Navigator navigator) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.navigator = navigator;
		this.buttonCaptionMap = new HashMap<>();
		this.buttonListener = new MenuBarButtonListener();
		
		this.buttonCaptionMap.put(ButtonEnum.HOME, this.btnHome.getCaption());
		this.buttonCaptionMap.put(ButtonEnum.PATIENT_INFO, this.btnPatientInfo.getCaption());
		this.buttonCaptionMap.put(ButtonEnum.CASE_INFO, this.btnCaseInfo.getCaption());
		this.buttonCaptionMap.put(ButtonEnum.PATIENT_PROGRESS, this.btnPatientProgress.getCaption());
		this.buttonCaptionMap.put(ButtonEnum.DIAGNOSIS, this.btnDiagnosis.getCaption());
		this.buttonCaptionMap.put(ButtonEnum.MEDICATION, this.btnMedication.getCaption());
		
		this.btnHome.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -5118039408005091733L;

			@Override
			public void buttonClick(ClickEvent event) {
				MenuBarComponent.this.navigator.navigateTo(ButtonEnum.HOME.toString());
			}
		});
		
		this.btnPatientInfo.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -5118039408005091733L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				MenuBarComponent.this.navigator.navigateTo(ButtonEnum.PATIENT_INFO.toString());				
			}
		});
		
//		this.btnHome.addClickListener(this.buttonListener);
//		this.btnPatientInfo.addClickListener(this.buttonListener);
		this.btnCaseInfo.addClickListener(this.buttonListener);
		this.btnPatientProgress.addClickListener(this.buttonListener);
		this.btnDiagnosis.addClickListener(this.buttonListener);
		this.btnMedication.addClickListener(this.buttonListener);
		
//		this.btnBack.addClickListener(new Button.ClickListener() {
//			private static final long serialVersionUID = -5118039408005091733L;
//
//			@Override
//			public void buttonClick(ClickEvent event) {
//				UserSingleton.getUser().decrementCurrentItem(Patient.class);
////				MenuBarComponent.this.mainComponent.updateComponentDataSource();
//			}
//		});
//		
//		this.btnForward.addClickListener(new Button.ClickListener() {
//			private static final long serialVersionUID = -8920612956190749837L;
//
//			@Override
//			public void buttonClick(ClickEvent event) {
//				UserSingleton.getUser().incrementCurrentItem(Patient.class);
////				MenuBarComponent.this.mainComponent.updateComponentDataSource();
//			}
//		});
		
		this.btnLogout.addClickListener(new Button.ClickListener() {
			
			private static final long serialVersionUID = -7445511110217678724L;

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Implement Logout
				MenuBarComponent.this.getUI().addWindow(new Window("Logout"));
			}
		});
	}

	protected void addTab(ButtonEnum btnEnum, Component title, Component main) {
		this.buttonListener.addTab(this.buttonCaptionMap.get(btnEnum), title, main);
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// btnHome
		btnHome = new Button();
		btnHome.setCaption("Übersicht");
		btnHome.setImmediate(true);
		btnHome.setWidth("100px");
		btnHome.setHeight("-1px");
		mainLayout.addComponent(btnHome, "top:20.0px;left:20.0px;");
		
		// btnPatientInfo
		btnPatientInfo = new Button();
		btnPatientInfo.setCaption("Patient");
		btnPatientInfo.setImmediate(true);
		btnPatientInfo.setWidth("100px");
		btnPatientInfo.setHeight("-1px");
		mainLayout.addComponent(btnPatientInfo, "top:60.0px;left:20.0px;");
		
		// btnCaseInfo
		btnCaseInfo = new Button();
		btnCaseInfo.setCaption("Fallinfo");
		btnCaseInfo.setImmediate(true);
		btnCaseInfo.setWidth("100px");
		btnCaseInfo.setHeight("-1px");
		mainLayout.addComponent(btnCaseInfo, "top:100.0px;left:20.0px;");
		
		// btnPatientProgress
		btnPatientProgress = new Button();
		btnPatientProgress.setCaption("Verlauf");
		btnPatientProgress.setImmediate(true);
		btnPatientProgress.setWidth("100px");
		btnPatientProgress.setHeight("-1px");
		mainLayout.addComponent(btnPatientProgress, "top:140.0px;left:20.0px;");
		
		// btnDiagnosis
		btnDiagnosis = new Button();
		btnDiagnosis.setCaption("Diagnosen");
		btnDiagnosis.setImmediate(true);
		btnDiagnosis.setWidth("100px");
		btnDiagnosis.setHeight("-1px");
		mainLayout.addComponent(btnDiagnosis, "top:180.0px;left:20.0px;");
		
		// btnMedication
		btnMedication = new Button();
		btnMedication.setCaption("Medikamente");
		btnMedication.setImmediate(true);
		btnMedication.setWidth("100px");
		btnMedication.setHeight("-1px");
		mainLayout.addComponent(btnMedication, "top:220.0px;left:20.0px;");
		
		// btnBack
		btnBack = new Button();
		btnBack.setCaption("Zurück");
		btnBack.setImmediate(true);
		btnBack.setWidth("-1px");
		btnBack.setHeight("-1px");
		mainLayout.addComponent(btnBack, "top:360.0px;left:13.0px;");
		
		// btnForward
		btnForward = new Button();
		btnForward.setCaption("Vor");
		btnForward.setImmediate(true);
		btnForward.setWidth("67px");
		btnForward.setHeight("-1px");
		mainLayout.addComponent(btnForward, "top:360.0px;left:93.0px;");
		
		// btnLogout
		btnLogout = new Button();
		btnLogout.setCaption("Logout");
		btnLogout.setImmediate(true);
		btnLogout.setWidth("100px");
		btnLogout.setHeight("-1px");
		mainLayout.addComponent(btnLogout, "top:260.0px;left:20.0px;");
		
		return mainLayout;
	}

	public void enableMenuBar(boolean value) {
		this.btnBack.setEnabled(value);
		this.btnForward.setEnabled(value);
		this.btnHome.setEnabled(value);
		this.btnPatientInfo.setEnabled(value);
		this.btnCaseInfo.setEnabled(value);
		this.btnPatientProgress.setEnabled(value);
		this.btnDiagnosis.setEnabled(value);
		this.btnMedication.setEnabled(value);
		this.btnLogout.setEnabled(value);
	}

}
