package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsDiagnosisListener;
import ch.bfh.ti.soed.white.mhc_pms.data.Diagnosis;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Operation;
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
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 */
public class DiagnosisDetailComponent extends PmsComponentController implements
		PmsComponentListener, PmsDiagnosisListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnEditDiagnosis;
	@AutoGenerated
	private Panel panMaster;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private GridLayout gridLayout_1;
	@AutoGenerated
	private FormLayout formLayout_1;
	@AutoGenerated
	private TextArea txtDiagnosisComment;
	@AutoGenerated
	private Label lblDiagnosisCreator;
	@AutoGenerated
	private Label lblDateOfCreation;
	@AutoGenerated
	private Label lblIcdCode;
	@AutoGenerated
	private Label lblClinic;
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

		// Static UI elements
		this.lblView.setValue("Diagnose-Details");
		this.lblView.addStyleName(Reindeer.LABEL_H2);
		this.panMaster.addStyleName(Reindeer.PANEL_LIGHT);

		
		this.addToggleDiagnosisViewButtonListener();
		this.addNewDiagnosisButtonListener();
		this.addEditDiagnosisButtonListener();
	}

	private void addEditDiagnosisButtonListener() {
		this.btnEditDiagnosis.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = 7009987843107108151L;

			@Override
			public void buttonClick(ClickEvent event) {
				DiagnosisDetailComponent.this.fireUIActivationEvent(false);
				DiagnosisDetailComponent.this
						.fireComponentChangeEvent(NavigationEvent.EDIT_DIAGNOSIS);
			}
		});

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

	@Override
	public void enter(ViewChangeEvent event) {
	}

	private void setPermissions() throws UnknownUserException {
		Object pCaseItemId = PmsDataAccessCreator.getDataAccess()
				.getPCaseContainer().getCurrentItemId();
		PCase pCaseItem = PmsDataAccessCreator.getDataAccess()
				.getPCaseContainer().getCurrentItem();
		Object itemId = PmsDataAccessCreator.getDataAccess()
				.getDiagnosisContainer().getCurrentItemId();

		boolean isOpen = pCaseItem == null
				|| pCaseItem.getCaseStatus() != CaseStatus.CLOSED;

		this.btnNewDiagnosis.setEnabled(PmsDataAccessCreator.getDataAccess()
				.getPermission().hasPermission(Operation.NEW_DIAGNOSIS)
				&& pCaseItemId != null && isOpen);
		this.btnEditDiagnosis.setEnabled(PmsDataAccessCreator.getDataAccess()
				.getPermission().hasPermission(Operation.EDIT_DIAGNOSIS)
				&& itemId != null && isOpen);
	}

	@Override
	public void pCaseItemChange() {
		try {
			PmsDataAccessCreator.getDataAccess().getPCaseContainer().refresh();
			PmsDataAccessCreator.getDataAccess().getDiagnosisContainer()
					.refresh();

			// set filter for the new current patient case
			PmsDataAccessCreator
					.getDataAccess()
					.getDiagnosisContainer()
					.setCurrentPCaseFilter(
							PmsDataAccessCreator.getDataAccess()
									.getPCaseContainer().getCurrentItemId());

			this.setPermissions();
			this.setLabelValues();
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
			e.printStackTrace();
		}
	}

	private void setLabelValues() throws UnknownUserException {
		Diagnosis currentDiag = PmsDataAccessCreator.getDataAccess()
				.getDiagnosisContainer().getCurrentItem();

		if (currentDiag == null) {
			currentDiag = new Diagnosis();
		}

		// set label values to the current diagnosis values
		this.lblClinic.setValue(currentDiag.getClinicName());
		this.lblDateOfCreation.setValue(ValueConverter.convertDate(currentDiag
				.getDateOfCreation()));
		this.txtDiagnosisComment.setValue(currentDiag.getDiagnosisComment());
		this.lblDiagnosisCreator.setValue(currentDiag.getDiagnosisCreator());
		this.lblDiagnosisName.setValue(currentDiag.getDiagnosisName());
		this.lblIcdCode.setValue(currentDiag.getIcdCode());
	}

	@Override
	public void diagnosisItemChange() {
		try {
			PmsDataAccessCreator.getDataAccess().getDiagnosisContainer()
					.refresh();

			this.setPermissions();
			this.setLabelValues();
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
		lblView.setValue("Details Diagnosen");
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
		mainLayout.addComponent(panMaster, "top:61.0px;left:20.0px;");
		
		// btnEditDiagnosis
		btnEditDiagnosis = new Button();
		btnEditDiagnosis.setCaption("Diagnose bearbeiten");
		btnEditDiagnosis.setImmediate(true);
		btnEditDiagnosis.setWidth("160px");
		btnEditDiagnosis.setHeight("-1px");
		mainLayout.addComponent(btnEditDiagnosis, "top:20.0px;left:520.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanMaster() {
		// common part: create layout
		panMaster = new Panel();
		panMaster.setImmediate(false);
		panMaster.setWidth("560px");
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
		
		// formLayout_1
		formLayout_1 = buildFormLayout_1();
		gridLayout_1.addComponent(formLayout_1, 0, 0);
		
		return gridLayout_1;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_1() {
		// common part: create layout
		formLayout_1 = new FormLayout();
		formLayout_1.setImmediate(false);
		formLayout_1.setWidth("100.0%");
		formLayout_1.setHeight("-1px");
		formLayout_1.setMargin(false);
		formLayout_1.setSpacing(true);
		
		// lblDiagnosisName
		lblDiagnosisName = new Label();
		lblDiagnosisName.setCaption("Name");
		lblDiagnosisName.setImmediate(false);
		lblDiagnosisName.setWidth("140px");
		lblDiagnosisName.setHeight("-1px");
		lblDiagnosisName.setValue("Label");
		formLayout_1.addComponent(lblDiagnosisName);
		
		// lblClinic
		lblClinic = new Label();
		lblClinic.setCaption("Institution");
		lblClinic.setImmediate(false);
		lblClinic.setWidth("-1px");
		lblClinic.setHeight("-1px");
		lblClinic.setValue("Label");
		formLayout_1.addComponent(lblClinic);
		
		// lblIcdCode
		lblIcdCode = new Label();
		lblIcdCode.setCaption("ICD Kode");
		lblIcdCode.setImmediate(false);
		lblIcdCode.setWidth("120px");
		lblIcdCode.setHeight("-1px");
		lblIcdCode.setValue("Label");
		formLayout_1.addComponent(lblIcdCode);
		
		// lblDateOfCreation
		lblDateOfCreation = new Label();
		lblDateOfCreation.setCaption("Datum");
		lblDateOfCreation.setImmediate(false);
		lblDateOfCreation.setWidth("-1px");
		lblDateOfCreation.setHeight("-1px");
		lblDateOfCreation.setValue("Label");
		formLayout_1.addComponent(lblDateOfCreation);
		
		// lblDiagnosisCreator
		lblDiagnosisCreator = new Label();
		lblDiagnosisCreator.setCaption("Ersteller");
		lblDiagnosisCreator.setImmediate(false);
		lblDiagnosisCreator.setWidth("-1px");
		lblDiagnosisCreator.setHeight("-1px");
		lblDiagnosisCreator.setValue("Label");
		formLayout_1.addComponent(lblDiagnosisCreator);
		
		// txtDiagnosisComment
		txtDiagnosisComment = new TextArea();
		txtDiagnosisComment.setCaption("Kommentar");
		txtDiagnosisComment.setImmediate(false);
		txtDiagnosisComment.setWidth("420px");
		txtDiagnosisComment.setHeight("140px");
		formLayout_1.addComponent(txtDiagnosisComment);
		
		return formLayout_1;
	}

}
