package ch.bfh.ti.soed.white.mhc_pms.ui;


import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.NewCaseListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.ContainerCollection;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.KindOfTreatment;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.OrderOfPatient;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.ReanimationStatus;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 * @author	Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version	0.0.2 
 * @since	0.0.1
 * 
 * UI Class for a editing case details
 */
public class EditCaseInfoComponent extends PmsComponentController implements NewCaseListener {

	private class SaveButtonListener implements Button.ClickListener {
		private static final long serialVersionUID = 7137875461203747513L;

		@Override
		public void buttonClick(ClickEvent event) {
			try {
				if (EditCaseInfoComponent.this.newCaseItem != null) {
					EditCaseInfoComponent.this.fieldGroup.commit();
					PCase pCaseItem = EditCaseInfoComponent.this.newCaseItem.getBean();
					
					if (EditCaseInfoComponent.this.isNewCase) {
						pCaseItem.closeCase();
						EditCaseInfoComponent.this.pmsContainers.getPCaseContainer().addEntity(pCaseItem);
						
						pCaseItem = EditCaseInfoComponent.this.newCaseItem.getBean();
						pCaseItem.openCase();
					} 

					Object id = EditCaseInfoComponent.this.pmsContainers
							.getPCaseContainer().addEntity(pCaseItem);

					EditCaseInfoComponent.this.fireUIActivationEvent(true);
					EditCaseInfoComponent.this
							.fireComponentChangeEvent(NavigationEvent.PCASE_BACK);
					EditCaseInfoComponent.this.firePCaseItemChangeEvent(id);
					EditCaseInfoComponent.this.setNewCase(false);
				}
			} catch (CommitException e) {
				// TODO Exception Handling
				EditCaseInfoComponent.this.getUI().addWindow(new Window("Beim Speichern des Falls ist ein Fehler aufgetreten!"));
			}
		}
		
	}
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private ComboBox cmbKindOfTreatment;
	@AutoGenerated
	private TextField txtSuicidalTendency;
	@AutoGenerated
	private ComboBox cmbOrderOfPatient;
	@AutoGenerated
	private TextField txtSanction;
	@AutoGenerated
	private TextField txtJudicialStatus;
	@AutoGenerated
	private TextField txtVacation;
	@AutoGenerated
	private TextField txtGoOutStatus;
	@AutoGenerated
	private TextField txtDegreeOfDanger;
	@AutoGenerated
	private TextField txtAssignment;
	@AutoGenerated
	private ComboBox cmbReanimationStatus;
	@AutoGenerated
	private Button btnCancel;
	@AutoGenerated
	private Button btnSave;
	private static final long serialVersionUID = 7804702033977054145L;

	private ContainerCollection pmsContainers;

	private BeanFieldGroup<PCase> fieldGroup;

	private BeanItem<PCase> newCaseItem;
	
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

		this.pmsContainers = PmsDataAccess.getContainers();
		this.pmsContainers.getPCaseContainer().refresh();
		this.fieldGroup = new BeanFieldGroup<PCase>(PCase.class);
		this.isNewCase = false;

		this.initComboBoxes();
		this.bindFields();
		this.setComboBoxDefaultValues();
		this.btnSave.addClickListener(new SaveButtonListener());
		this.addBtnCancelListener();
		
		// TODO ComboBoxes not editable
		// TODO Neuer Fall: WErte aus bestehendem Fall übernehmen
		// TODO wenn neuer Pat hinzugefügt -> DEfault Werte für Fallinfo automatisch hinzufügen
	}

	private void setComboBoxDefaultValues() {
		this.cmbKindOfTreatment.setValue(KindOfTreatment.stationär);
		this.cmbOrderOfPatient.setValue(OrderOfPatient.nein);
		this.cmbReanimationStatus.setValue(ReanimationStatus.ja);
	}

	private void addBtnCancelListener() {
		this.btnCancel.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				EditCaseInfoComponent.this.fieldGroup.discard();
				EditCaseInfoComponent.this.fireUIActivationEvent(true);
				EditCaseInfoComponent.this
						.fireComponentChangeEvent(NavigationEvent.PCASE_BACK);
				EditCaseInfoComponent.this.setNewCase(false);
			}
		});
	}

	private void initComboBoxes() {
		this.cmbKindOfTreatment.addItem(KindOfTreatment.stationär);
		this.cmbKindOfTreatment.addItem(KindOfTreatment.teilstationär);
		this.cmbKindOfTreatment.addItem(KindOfTreatment.ambulant);
		
		this.cmbOrderOfPatient.addItem(OrderOfPatient.nein);
		this.cmbOrderOfPatient.addItem(OrderOfPatient.ja);
		
		this.cmbReanimationStatus.addItem(ReanimationStatus.ja);
		this.cmbReanimationStatus.addItem(ReanimationStatus.eingeschränkt);
		this.cmbReanimationStatus.addItem(ReanimationStatus.nein);
	}

	private void bindFields() {
		EntityItem<PCase> entityItem = this.pmsContainers.getPCaseContainer()
				.getItem(this.pmsContainers.getPCaseContainer().getCurrentPCaseId());

		if (entityItem != null) {
			this.newCaseItem = new BeanItem<PCase>(entityItem.getEntity());
			
			this.fieldGroup.setItemDataSource(this.newCaseItem);
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
		this.bindFields();
		
		if (this.isNewCase) {
			this.setComboBoxDefaultValues();
		} 
	}

	@Override
	public void setNewCase(boolean value) {
		this.isNewCase = value;
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
		mainLayout.addComponent(btnSave, "top:220.0px;left:20.0px;");
		
		// btnCancel
		btnCancel = new Button();
		btnCancel.setCaption("Abbrechen");
		btnCancel.setImmediate(true);
		btnCancel.setWidth("-1px");
		btnCancel.setHeight("-1px");
		mainLayout.addComponent(btnCancel, "top:220.0px;left:140.0px;");
		
		// cmbReanimationStatus
		cmbReanimationStatus = new ComboBox();
		cmbReanimationStatus.setCaption("Reanimationsstatus: ");
		cmbReanimationStatus.setImmediate(false);
		cmbReanimationStatus.setWidth("-1px");
		cmbReanimationStatus.setHeight("-1px");
		mainLayout
				.addComponent(cmbReanimationStatus, "top:40.0px;left:20.0px;");
		
		// txtAssignment
		txtAssignment = new TextField();
		txtAssignment.setCaption("Zuweiser: ");
		txtAssignment.setImmediate(false);
		txtAssignment.setWidth("-1px");
		txtAssignment.setHeight("-1px");
		mainLayout.addComponent(txtAssignment, "top:40.0px;left:220.0px;");
		
		// txtDegreeOfDanger
		txtDegreeOfDanger = new TextField();
		txtDegreeOfDanger.setCaption("Fremdgefährtung: ");
		txtDegreeOfDanger.setImmediate(false);
		txtDegreeOfDanger.setWidth("-1px");
		txtDegreeOfDanger.setHeight("-1px");
		mainLayout.addComponent(txtDegreeOfDanger, "top:40.0px;left:600.0px;");
		
		// txtGoOutStatus
		txtGoOutStatus = new TextField();
		txtGoOutStatus.setCaption("Ausgang: ");
		txtGoOutStatus.setImmediate(false);
		txtGoOutStatus.setWidth("-1px");
		txtGoOutStatus.setHeight("-1px");
		mainLayout.addComponent(txtGoOutStatus, "top:100.0px;left:20.0px;");
		
		// txtVacation
		txtVacation = new TextField();
		txtVacation.setCaption("Urlaub: ");
		txtVacation.setImmediate(false);
		txtVacation.setWidth("-1px");
		txtVacation.setHeight("-1px");
		mainLayout.addComponent(txtVacation, "top:100.0px;left:220.0px;");
		
		// txtJudicialStatus
		txtJudicialStatus = new TextField();
		txtJudicialStatus.setCaption("Juristischer Status: ");
		txtJudicialStatus.setImmediate(false);
		txtJudicialStatus.setWidth("-1px");
		txtJudicialStatus.setHeight("-1px");
		mainLayout.addComponent(txtJudicialStatus, "top:100.0px;left:400.0px;");
		
		// txtSanction
		txtSanction = new TextField();
		txtSanction.setCaption("Zwangsmassnahmen: ");
		txtSanction.setImmediate(false);
		txtSanction.setWidth("-1px");
		txtSanction.setHeight("-1px");
		mainLayout.addComponent(txtSanction, "top:100.0px;left:600.0px;");
		
		// cmbOrderOfPatient
		cmbOrderOfPatient = new ComboBox();
		cmbOrderOfPatient.setCaption("Patientenverfügung vorhanden: ");
		cmbOrderOfPatient.setImmediate(false);
		cmbOrderOfPatient.setWidth("-1px");
		cmbOrderOfPatient.setHeight("-1px");
		mainLayout.addComponent(cmbOrderOfPatient, "top:160.0px;left:20.0px;");
		
		// txtSuicidalTendency
		txtSuicidalTendency = new TextField();
		txtSuicidalTendency.setCaption("Suizidalität: ");
		txtSuicidalTendency.setImmediate(false);
		txtSuicidalTendency.setWidth("-1px");
		txtSuicidalTendency.setHeight("-1px");
		mainLayout
				.addComponent(txtSuicidalTendency, "top:40.0px;left:399.0px;");
		
		// cmbKindOfTreatment
		cmbKindOfTreatment = new ComboBox();
		cmbKindOfTreatment.setCaption("Behandlungsart: ");
		cmbKindOfTreatment.setImmediate(false);
		cmbKindOfTreatment.setWidth("-1px");
		cmbKindOfTreatment.setHeight("-1px");
		mainLayout
				.addComponent(cmbKindOfTreatment, "top:160.0px;left:220.0px;");
		
		return mainLayout;
	}

}
