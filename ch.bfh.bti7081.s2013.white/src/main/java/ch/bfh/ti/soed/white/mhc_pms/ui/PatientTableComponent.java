package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.InitListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Operation;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;

/**
 * UI Class for patient overview
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
class PatientTableComponent extends PmsComponentController implements
		PmsComponentListener, InitListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = 3262703309337559597L;
	private static final String[] VISIBLE_COLUMN_NAMES = { "Fallnummer",
			"Status", "Vorname", "Nachname", "Geburtsdatum", "Geschlecht",
			"Behandlungsart", "Datum Falleröffnung" };
	private static final String[] VISIBLE_COLUMNS = { "pcid", "caseStatus",
			"firstName", "lastName", "dateOfBirth", "gender",
			"kindOfTreatment", "dateCaseOpened" };
	@AutoGenerated
	private Button btnNewCase;
	@AutoGenerated
	private Button btnNewPatient;
	@AutoGenerated
	private Label lblView;

	@AutoGenerated
	private AbsoluteLayout mainLayout;

	@AutoGenerated
	private Table tblPatients;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 * 
	 * @param mainPanel
	 */
	public PatientTableComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		try {
			this.initPatientTable();
			this.pCaseItemChange();
			
			// Static UI elements
			this.lblView.addStyleName(Reindeer.LABEL_H2);
			this.lblView.setValue("Übersicht Patienten und Fälle");

			this.addValueChangeListener();
			this.addNewPatientClickListener();
			this.addNewCaseClickListener();

		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	private void addNewCaseClickListener() {
		this.btnNewCase.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;

			@Override
			public void buttonClick(ClickEvent event) {
				PatientTableComponent.this.fireUIActivationEvent(false);
				PatientTableComponent.this.fireNewCaseEvent(true);
				PatientTableComponent.this
						.fireComponentChangeEvent(NavigationEvent.PCASE);
			}
		});
	}

	private void addNewPatientClickListener() {
		this.btnNewPatient.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				PatientTableComponent.this.fireUIActivationEvent(false);
				PatientTableComponent.this
						.fireComponentChangeEvent(NavigationEvent.PATIENT);
			}
		});
	}

	private void addValueChangeListener() {
		this.tblPatients
				.addValueChangeListener(new Property.ValueChangeListener() {
					private static final long serialVersionUID = 2883881874240424835L;

					@Override
					public void valueChange(ValueChangeEvent event) {
						if (event.getProperty().getValue() != null) {
							try {
								Object id = PatientTableComponent.this.tblPatients
										.getValue();
								PmsDataAccessCreator.getDataAccess()
										.getPCaseContainer().setCurrentItemId(
												id);

								PatientTableComponent.this.setPermissions();
								PatientTableComponent.this
										.firePCaseItemChangeEvent();
							} catch (UnknownUserException e) {
								Notification.show(e.getInvalidUserMessage(),
										Notification.Type.HUMANIZED_MESSAGE);
							}
						}
					}
				});
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
		
		// tblPatients
		tblPatients = new Table();
		tblPatients.setImmediate(false);
		tblPatients.setWidth("100.0%");
		tblPatients.setHeight("100.0%");
		mainLayout.addComponent(tblPatients,
				"top:80.0px;right:20.0px;bottom:40.0px;left:20.0px;");
		
		// btnNewPatient
		btnNewPatient = new Button();
		btnNewPatient.setCaption("Neuer Patient");
		btnNewPatient.setImmediate(true);
		btnNewPatient.setWidth("120px");
		btnNewPatient.setHeight("-1px");
		mainLayout.addComponent(btnNewPatient, "top:20.0px;left:250.0px;");
		
		// btnNewCase
		btnNewCase = new Button();
		btnNewCase.setCaption("Neuer Fall");
		btnNewCase.setImmediate(true);
		btnNewCase.setWidth("-1px");
		btnNewCase.setHeight("-1px");
		mainLayout.addComponent(btnNewCase, "top:20.0px;left:380.0px;");
		
		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("View title");
		mainLayout.addComponent(lblView, "top:20.0px;left:20.0px;");
		
		return mainLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void initialize() {
		try {
			this.initPatientTable();
			this.pCaseItemChange();
			PmsDataAccessCreator.getDataAccess().getPCaseContainer().enableCaseFilter(true);
			this.firePCaseItemChangeEvent();
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	/**
	 * Initialization of the table element
	 * 
	 * @throws UnknownUserException 
	 */
	private void initPatientTable() throws UnknownUserException {
		this.tblPatients.setContainerDataSource(PmsDataAccessCreator.getDataAccess()
				.getPCaseContainer());
		this.tblPatients.setSelectable(true);
		this.tblPatients.setImmediate(true);
		this.tblPatients.setVisibleColumns(VISIBLE_COLUMNS);
		for (int i = 0; i < VISIBLE_COLUMNS.length; i++) {
			this.tblPatients.setColumnHeader(VISIBLE_COLUMNS[i],
					VISIBLE_COLUMN_NAMES[i]);
		}
	}

	@Override
	public void pCaseItemChange() {
		try {
			PmsDataAccessCreator.getDataAccess().getPCaseContainer().refresh();
			Object itemId = PmsDataAccessCreator.getDataAccess().getPCaseContainer()
					.getCurrentItemId();
			this.setPermissions();
			
			if (itemId != null) {
				this.tblPatients.select(itemId);
			}
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}
	
	private void setPermissions() throws UnknownUserException {
		Object itemId = PmsDataAccessCreator.getDataAccess().getPCaseContainer()
				.getCurrentItemId();
		PCase pCaseItem = PmsDataAccessCreator.getDataAccess()
				.getPCaseContainer().getCurrentItem();
		
		boolean isOpen = pCaseItem != null
				&& pCaseItem.getCaseStatus() != CaseStatus.CLOSED;

		this.btnNewPatient.setEnabled(PmsDataAccessCreator.getDataAccess().getPermission()
				.hasPermission(Operation.NEW_PATIENT));
		this.btnNewCase.setEnabled(PmsDataAccessCreator.getDataAccess().getPermission()
				.hasPermission(Operation.NEW_CASE) && itemId != null && isOpen);
	}


}
