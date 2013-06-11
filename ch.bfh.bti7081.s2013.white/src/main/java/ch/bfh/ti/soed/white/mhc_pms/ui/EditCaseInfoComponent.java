package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.NewItemListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.KindOfTreatment;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.OrderOfPatient;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.ReanimationStatus;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * @author Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 0.0.2
 * @since 0.0.1
 * 
 * UI Class for a editing case details
 */
public class EditCaseInfoComponent extends PmsComponentController implements
		NewItemListener {

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblView;
	@AutoGenerated
	private Panel panMaster;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private GridLayout gridLayout_1;
	@AutoGenerated
	private Panel panStatus;
	@AutoGenerated
	private FormLayout formLayout_2;
	@AutoGenerated
	private TextField txtJudicialStatus;
	@AutoGenerated
	private TextField txtVacation;
	@AutoGenerated
	private TextField txtDegreeOfDanger;
	@AutoGenerated
	private TextField txtAssignment;
	@AutoGenerated
	private TextField txtSanction;
	@AutoGenerated
	private Panel panDetails;
	@AutoGenerated
	private FormLayout formLayout_1;
	@AutoGenerated
	private TextField txtGoOutStatus;
	@AutoGenerated
	private ComboBox cmbOrderOfPatient;
	@AutoGenerated
	private TextField txtSuicidalTendency;
	@AutoGenerated
	private ComboBox cmbKindOfTreatment;
	@AutoGenerated
	private ComboBox cmbReanimationStatus;
	@AutoGenerated
	private Button btnCancel;
	@AutoGenerated
	private Button btnSave;
	
	private class SaveButtonListener implements Button.ClickListener {
		private static final long serialVersionUID = 7137875461203747513L;

		@Override
		public void buttonClick(ClickEvent event) {
			try {
				if (EditCaseInfoComponent.this.isNewCase) {
					PCase currentPCaseItem = EditCaseInfoComponent.this.pmsDataAccess
							.getPCaseContainer().getCurrentItem();
					if (currentPCaseItem != null) {
						currentPCaseItem.closeCase();
					}

					EditCaseInfoComponent.this.fieldGroup.commit();
					BeanItem<PCase> beanItem = EditCaseInfoComponent.this.fieldGroup
							.getItemDataSource();
					if (beanItem != null) {
						EditCaseInfoComponent.this.pmsDataAccess
								.getPCaseContainer().addEntity(
										beanItem.getBean());
					}
				} else {
					EditCaseInfoComponent.this.fieldGroup.commit();
				}

				EditCaseInfoComponent.this.fireUIActivationEvent(true);
				EditCaseInfoComponent.this
						.fireComponentChangeEvent(NavigationEvent.PCASE_BACK);
				EditCaseInfoComponent.this.firePCaseItemChangeEvent();
				EditCaseInfoComponent.this.setNewItem(false);
				Notification.show(EditCaseInfoComponent.this.isNewCase ? NEW_CASE_MESSAGE : EDIT_CASE_MESSAGE,
						Notification.Type.HUMANIZED_MESSAGE);
			} catch (CommitException e) {
				Notification.show(
						"Bitte alle mit * markierten Felder ausfüllen!",
						Notification.Type.HUMANIZED_MESSAGE);
			}
		}

	}

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = 7804702033977054145L;

	private String TITLE_NEW_CASE = "Neuer Fall eröffnen";
	private String TITLE_EDIT_CASE = "Fall bearbeiten";
	
	private String NEW_CASE_MESSAGE = "Neuer Fall hinzugefügt";
	private String EDIT_CASE_MESSAGE = "Fall gespeichert";

	private PmsDataAccess pmsDataAccess;

	private BeanFieldGroup<PCase> fieldGroup;

	private boolean isNewCase;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public EditCaseInfoComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.pmsDataAccess = PmsDataAccessCreator.getDataAccess();
		this.pmsDataAccess.getPCaseContainer().refresh();
		this.fieldGroup = new BeanFieldGroup<PCase>(PCase.class);

		this.setNewItem(false);
		this.initComboBoxes();
		this.lblView.addStyleName(Reindeer.LABEL_H2);

		this.btnSave.addClickListener(new SaveButtonListener());
		this.addBtnCancelListener();

		// TODO ComboBoxes not editable
		// TODO input validation
	}

	private void addBtnCancelListener() {
		this.btnCancel.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				EditCaseInfoComponent.this.setNewItem(false);
				EditCaseInfoComponent.this.fieldGroup.discard();
				EditCaseInfoComponent.this.fireUIActivationEvent(true);
				EditCaseInfoComponent.this
						.fireComponentChangeEvent(NavigationEvent.PCASE_BACK);
			}
		});
	}

	private void initComboBoxes() {
		this.cmbKindOfTreatment.addItem(KindOfTreatment.INPATIENT);
		this.cmbKindOfTreatment.addItem(KindOfTreatment.PART_INPATIENT);
		this.cmbKindOfTreatment.addItem(KindOfTreatment.AMBULANT);

		this.cmbOrderOfPatient.addItem(OrderOfPatient.NO);
		this.cmbOrderOfPatient.addItem(OrderOfPatient.YES);

		this.cmbReanimationStatus.addItem(ReanimationStatus.YES);
		this.cmbReanimationStatus.addItem(ReanimationStatus.LIMITED);
		this.cmbReanimationStatus.addItem(ReanimationStatus.NO);
	}

	private void bindFields(PCase item) {
		if (item != null) {
			this.fieldGroup.setItemDataSource(item);
			this.fieldGroup
					.bind(this.cmbReanimationStatus, "reanimationStatus");
			this.fieldGroup.bind(this.cmbKindOfTreatment, "kindOfTreatment");
			this.fieldGroup.bind(this.cmbOrderOfPatient, "orderOfPatient");
			this.fieldGroup.bind(this.txtAssignment, "assignment");
			this.fieldGroup.bind(this.txtDegreeOfDanger, "degreeOfDanger");
			this.fieldGroup.bind(this.txtGoOutStatus, "goOutStatus");
			this.fieldGroup.bind(this.txtJudicialStatus, "judicialStatus");
			this.fieldGroup.bind(this.txtSanction, "sanction");
			this.fieldGroup.bind(this.txtSuicidalTendency, "suicidalTendency");
			this.fieldGroup.bind(this.txtVacation, "vacation");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController#enter(
	 * com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		this.pmsDataAccess.getPCaseContainer().refresh();
		PCase item = this.pmsDataAccess.getPCaseContainer().getCurrentItem();

		if (item != null) {
			if (this.isNewCase) {
				this.bindFields((PCase) item.clone());
			} else {
				this.bindFields(item);
			}
		}
	}

	@Override
	public void setNewItem(boolean value) {
		this.isNewCase = value;
		this.lblView.setValue(value ? TITLE_NEW_CASE : TITLE_EDIT_CASE);
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
		
		// btnSave
		btnSave = new Button();
		btnSave.setCaption("Speichern");
		btnSave.setImmediate(true);
		btnSave.setWidth("100px");
		btnSave.setHeight("-1px");
		mainLayout.addComponent(btnSave, "top:20.0px;left:250.0px;");
		
		// btnCancel
		btnCancel = new Button();
		btnCancel.setCaption("Abbrechen");
		btnCancel.setImmediate(true);
		btnCancel.setWidth("-1px");
		btnCancel.setHeight("-1px");
		mainLayout.addComponent(btnCancel, "top:20.0px;left:370.0px;");
		
		// panMaster
		panMaster = buildPanMaster();
		mainLayout.addComponent(panMaster, "top:60.0px;left:20.0px;");
		
		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("Label");
		mainLayout.addComponent(lblView, "top:20.0px;left:20.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanMaster() {
		// common part: create layout
		panMaster = new Panel();
		panMaster.setImmediate(false);
		panMaster.setWidth("-1px");
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
		verticalLayout_3.setHeight("100.0%");
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
		gridLayout_1.setWidth("-1px");
		gridLayout_1.setHeight("-1px");
		gridLayout_1.setMargin(false);
		gridLayout_1.setSpacing(true);
		gridLayout_1.setColumns(2);
		
		// panDetails
		panDetails = buildPanDetails();
		gridLayout_1.addComponent(panDetails, 0, 0);
		
		// panStatus
		panStatus = buildPanStatus();
		gridLayout_1.addComponent(panStatus, 1, 0);
		
		return gridLayout_1;
	}

	@AutoGenerated
	private Panel buildPanDetails() {
		// common part: create layout
		panDetails = new Panel();
		panDetails.setCaption("Details");
		panDetails.setImmediate(false);
		panDetails.setWidth("-1px");
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
		formLayout_1.setWidth("320px");
		formLayout_1.setHeight("-1px");
		formLayout_1.setMargin(true);
		formLayout_1.setSpacing(true);
		
		// cmbReanimationStatus
		cmbReanimationStatus = new ComboBox();
		cmbReanimationStatus.setCaption("Reanimationsstatus: ");
		cmbReanimationStatus.setImmediate(false);
		cmbReanimationStatus.setWidth("-1px");
		cmbReanimationStatus.setHeight("-1px");
		formLayout_1.addComponent(cmbReanimationStatus);
		
		// cmbKindOfTreatment
		cmbKindOfTreatment = new ComboBox();
		cmbKindOfTreatment.setCaption("Behandlungsart: ");
		cmbKindOfTreatment.setImmediate(false);
		cmbKindOfTreatment.setWidth("-1px");
		cmbKindOfTreatment.setHeight("-1px");
		cmbKindOfTreatment.setRequired(true);
		formLayout_1.addComponent(cmbKindOfTreatment);
		
		// txtSuicidalTendency
		txtSuicidalTendency = new TextField();
		txtSuicidalTendency.setCaption("Suizidalität: ");
		txtSuicidalTendency.setImmediate(false);
		txtSuicidalTendency.setWidth("-1px");
		txtSuicidalTendency.setHeight("-1px");
		formLayout_1.addComponent(txtSuicidalTendency);
		
		// cmbOrderOfPatient
		cmbOrderOfPatient = new ComboBox();
		cmbOrderOfPatient.setCaption("Patientenverfügung: ");
		cmbOrderOfPatient.setImmediate(false);
		cmbOrderOfPatient.setWidth("-1px");
		cmbOrderOfPatient.setHeight("-1px");
		formLayout_1.addComponent(cmbOrderOfPatient);
		
		// txtGoOutStatus
		txtGoOutStatus = new TextField();
		txtGoOutStatus.setCaption("Ausgang: ");
		txtGoOutStatus.setImmediate(false);
		txtGoOutStatus.setWidth("-1px");
		txtGoOutStatus.setHeight("-1px");
		formLayout_1.addComponent(txtGoOutStatus);
		
		return formLayout_1;
	}

	@AutoGenerated
	private Panel buildPanStatus() {
		// common part: create layout
		panStatus = new Panel();
		panStatus.setCaption("Status");
		panStatus.setImmediate(false);
		panStatus.setWidth("-1px");
		panStatus.setHeight("-1px");
		
		// formLayout_2
		formLayout_2 = buildFormLayout_2();
		panStatus.setContent(formLayout_2);
		
		return panStatus;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_2() {
		// common part: create layout
		formLayout_2 = new FormLayout();
		formLayout_2.setImmediate(false);
		formLayout_2.setWidth("320px");
		formLayout_2.setHeight("-1px");
		formLayout_2.setMargin(true);
		formLayout_2.setSpacing(true);
		
		// txtSanction
		txtSanction = new TextField();
		txtSanction.setCaption("Zwangsmassnahmen: ");
		txtSanction.setImmediate(false);
		txtSanction.setWidth("-1px");
		txtSanction.setHeight("-1px");
		formLayout_2.addComponent(txtSanction);
		
		// txtAssignment
		txtAssignment = new TextField();
		txtAssignment.setCaption("Zuweiser: ");
		txtAssignment.setImmediate(false);
		txtAssignment.setWidth("-1px");
		txtAssignment.setHeight("-1px");
		formLayout_2.addComponent(txtAssignment);
		
		// txtDegreeOfDanger
		txtDegreeOfDanger = new TextField();
		txtDegreeOfDanger.setCaption("Fremdgefährtung: ");
		txtDegreeOfDanger.setImmediate(false);
		txtDegreeOfDanger.setWidth("-1px");
		txtDegreeOfDanger.setHeight("-1px");
		formLayout_2.addComponent(txtDegreeOfDanger);
		
		// txtVacation
		txtVacation = new TextField();
		txtVacation.setCaption("Urlaub: ");
		txtVacation.setImmediate(false);
		txtVacation.setWidth("-1px");
		txtVacation.setHeight("-1px");
		formLayout_2.addComponent(txtVacation);
		
		// txtJudicialStatus
		txtJudicialStatus = new TextField();
		txtJudicialStatus.setCaption("Juristischer Status: ");
		txtJudicialStatus.setImmediate(false);
		txtJudicialStatus.setWidth("-1px");
		txtJudicialStatus.setHeight("-1px");
		formLayout_2.addComponent(txtJudicialStatus);
		
		return formLayout_2;
	}
}
