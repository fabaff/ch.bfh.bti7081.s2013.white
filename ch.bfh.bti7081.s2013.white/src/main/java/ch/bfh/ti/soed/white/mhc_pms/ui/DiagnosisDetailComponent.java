package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.Diagnosis;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.util.ValueConverter;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * UI class for diagnosis details
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public class DiagnosisDetailComponent extends PmsComponentController implements
		PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Panel panMaster;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private GridLayout gridLayout_1;
	@AutoGenerated
	private Panel panDetails;
	@AutoGenerated
	private FormLayout formLayout_1;
	@AutoGenerated
	private TextArea txtComment;
	@AutoGenerated
	private Label lblClinic;
	@AutoGenerated
	private Label lblCreator;
	@AutoGenerated
	private Label lblDate;
	@AutoGenerated
	private Label lblICDCode;
	@AutoGenerated
	private Label lblDiagnosisName;
	@AutoGenerated
	private Button btnNewDiagnosis;
	@AutoGenerated
	private Button btnToggleDiagnosisView;
	@AutoGenerated
	private Label lblView;
	private static final long serialVersionUID = 4997014971018144148L;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public DiagnosisDetailComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.pCaseItemChange();
		
		// Static UI elements
		this.lblView.addStyleName(Reindeer.LABEL_H2);
		this.lblView.setValue("Diagnose-Details");
		this.panMaster.addStyleName(Reindeer.PANEL_LIGHT);
		this.panDetails.addStyleName(Reindeer.PANEL_LIGHT);

		this.addToggleDiagnosisViewButtonListener();
		this.addNewDiagnosisButtonListener();
	}

	private void addNewDiagnosisButtonListener() {
		this.btnNewDiagnosis.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = -7261845370145460948L;

			@Override
			public void buttonClick(ClickEvent event) {
				DiagnosisDetailComponent.this.fireUIActivationEvent(false);
				DiagnosisDetailComponent.this.fireNewCaseEvent(true);
				DiagnosisDetailComponent.this
						.fireComponentChangeEvent(NavigationEvent.EDIT_DIAGNOSIS);
			}
		});
	}

	private void addToggleDiagnosisViewButtonListener() {
		this.btnToggleDiagnosisView
				.addClickListener(new Button.ClickListener() {

					private static final long serialVersionUID = 7009987843107108151L;

					@Override
					public void buttonClick(ClickEvent event) {
						DiagnosisDetailComponent.this
								.fireComponentChangeEvent(NavigationEvent.DIAGNOSIS_TABLE);
					}
				});
	}

	private void setPermissions() throws UnknownUserException {
		//PCase pCaseItem = PmsDataAccessCreator.getDataAccess()
		//		.getPCaseContainer().getCurrentItem();
		//Object itemId = PmsDataAccessCreator.getDataAccess().getPCaseContainer().getCurrentItemId();
		//boolean isOpen = pCaseItem != null && pCaseItem.getCaseStatus() != CaseStatus.CLOSED;
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void pCaseItemChange() {
		try {
			Diagnosis item = PmsDataAccessCreator.getDataAccess()
					.getDiagnosisContainer().getCurrentItem();
			this.setPermissions();
			
			if (item == null) {
				item = new Diagnosis();
			}
			
			
			this.lblDiagnosisName.setValue(item.getDiagnosisName());
			this.lblDate.setValue(ValueConverter.convertDate(item.getDateOfCreation()));
			this.lblClinic.setValue(item.getClinicName());
			this.lblCreator.setValue(item.getDiagnosisCreator());
			this.lblICDCode.setValue(item.getIcdCode());
			this.txtComment.setValue(item.getDiagnosisComment());
			
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}		
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
		
		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("Label");
		mainLayout.addComponent(lblView, "top:20.0px;left:20.0px;");
		
		// btnToggleDiagnosisView
		btnToggleDiagnosisView = new Button();
		btnToggleDiagnosisView.setCaption("Tabellenansicht");
		btnToggleDiagnosisView.setImmediate(true);
		btnToggleDiagnosisView.setWidth("120px");
		btnToggleDiagnosisView.setHeight("-1px");
		mainLayout.addComponent(btnToggleDiagnosisView,
				"top:20.0px;left:240.0px;");
		
		// btnNewDiagnosis
		btnNewDiagnosis = new Button();
		btnNewDiagnosis.setCaption("Neue Diagnose");
		btnNewDiagnosis.setImmediate(true);
		btnNewDiagnosis.setWidth("120px");
		btnNewDiagnosis.setHeight("-1px");
		mainLayout.addComponent(btnNewDiagnosis, "top:20.0px;left:380.0px;");
		
		// panMaster
		panMaster = buildPanMaster();
		mainLayout.addComponent(panMaster, "top:60.0px;left:20.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanMaster() {
		// common part: create layout
		panMaster = new Panel();
		panMaster.setImmediate(false);
		panMaster.setWidth("540px");
		panMaster.setHeight("-1px");
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		panMaster.setContent(verticalLayout_3);
		
		return panMaster;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("100.0%");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(false);
		
		// gridLayout_1
		gridLayout_1 = buildGridLayout_1();
		verticalLayout_3.addComponent(gridLayout_1);
		
		return verticalLayout_3;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_1() {
		// common part: create layout
		gridLayout_1 = new GridLayout();
		gridLayout_1.setImmediate(false);
		gridLayout_1.setWidth("100.0%");
		gridLayout_1.setHeight("-1px");
		gridLayout_1.setMargin(false);
		gridLayout_1.setSpacing(true);
		
		// panDetails
		panDetails = buildPanDetails();
		gridLayout_1.addComponent(panDetails, 0, 0);
		
		return gridLayout_1;
	}

	@AutoGenerated
	private Panel buildPanDetails() {
		// common part: create layout
		panDetails = new Panel();
		panDetails.setImmediate(false);
		panDetails.setWidth("100.0%");
		panDetails.setHeight("-1px");
		
		// formLayout_1
		formLayout_1 = buildFormLayout_1();
		panDetails.setContent(formLayout_1);
		
		return panDetails;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_1() {
		// common part: create layout
		formLayout_1 = new FormLayout();
		formLayout_1.setImmediate(false);
		formLayout_1.setWidth("100.0%");
		formLayout_1.setHeight("100.0%");
		formLayout_1.setMargin(false);
		formLayout_1.setSpacing(true);
		
		// lblDiagnosisName
		lblDiagnosisName = new Label();
		lblDiagnosisName.setCaption("Name:");
		lblDiagnosisName.setImmediate(false);
		lblDiagnosisName.setWidth("-1px");
		lblDiagnosisName.setHeight("-1px");
		lblDiagnosisName.setValue("Label");
		formLayout_1.addComponent(lblDiagnosisName);
		
		// lblICDCode
		lblICDCode = new Label();
		lblICDCode.setCaption("ICD Code");
		lblICDCode.setImmediate(false);
		lblICDCode.setWidth("-1px");
		lblICDCode.setHeight("-1px");
		lblICDCode.setValue("Label");
		formLayout_1.addComponent(lblICDCode);
		
		// lblDate
		lblDate = new Label();
		lblDate.setCaption("Datum:");
		lblDate.setImmediate(false);
		lblDate.setWidth("-1px");
		lblDate.setHeight("-1px");
		lblDate.setValue("Label");
		formLayout_1.addComponent(lblDate);
		
		// lblCreator
		lblCreator = new Label();
		lblCreator.setCaption("Verfasser:");
		lblCreator.setImmediate(false);
		lblCreator.setWidth("-1px");
		lblCreator.setHeight("-1px");
		lblCreator.setValue("Label");
		formLayout_1.addComponent(lblCreator);
		
		// lblClinic
		lblClinic = new Label();
		lblClinic.setCaption("Name der Klinik:");
		lblClinic.setImmediate(false);
		lblClinic.setWidth("-1px");
		lblClinic.setHeight("-1px");
		lblClinic.setValue("Label");
		formLayout_1.addComponent(lblClinic);
		
		// txtComment
		txtComment = new TextArea();
		txtComment.setCaption("Kommentar");
		txtComment.setImmediate(false);
		txtComment.setWidth("400px");
		txtComment.setHeight("200px");
		formLayout_1.addComponent(txtComment);
		
		return formLayout_1;
	}
}
