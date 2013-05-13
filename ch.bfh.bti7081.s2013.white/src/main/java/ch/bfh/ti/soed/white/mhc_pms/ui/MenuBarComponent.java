package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;

public class MenuBarComponent extends CustomComponent {
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
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
	private static final long serialVersionUID = 2747224025250099607L;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public MenuBarComponent(Button.ClickListener menuBarListener) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.btnHome.addClickListener(menuBarListener);
		this.btnPatientInfo.addClickListener(menuBarListener);
		this.btnCaseInfo.addClickListener(menuBarListener);
		this.btnPatientProgress.addClickListener(menuBarListener);
		this.btnDiagnosis.addClickListener(menuBarListener);
		this.btnMedication.addClickListener(menuBarListener);
		this.btnBack.addClickListener(menuBarListener);
		this.btnForward.addClickListener(menuBarListener);
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
		btnMedication.setWidth("-1px");
		btnMedication.setHeight("-1px");
		mainLayout.addComponent(btnMedication, "top:220.0px;left:20.0px;");
		
		// btnBack
		btnBack = new Button();
		btnBack.setCaption("Zurück");
		btnBack.setImmediate(true);
		btnBack.setWidth("-1px");
		btnBack.setHeight("-1px");
		mainLayout.addComponent(btnBack, "top:320.0px;left:13.0px;");
		
		// btnForward
		btnForward = new Button();
		btnForward.setCaption("Vor");
		btnForward.setImmediate(true);
		btnForward.setWidth("67px");
		btnForward.setHeight("-1px");
		mainLayout.addComponent(btnForward, "top:320.0px;left:93.0px;");
		
		return mainLayout;
	}

}
