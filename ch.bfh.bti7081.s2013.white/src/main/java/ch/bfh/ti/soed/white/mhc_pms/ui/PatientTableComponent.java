package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission;
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
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 * 
 */
class PatientTableComponent extends PmsComponentController implements
		PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblView;
	@AutoGenerated
	private Button btnNewCase;
	@AutoGenerated
	private Button btnNewPatient;
	@AutoGenerated
	private Table tblPatients;
	private static final long serialVersionUID = 3262703309337559597L;

	private static final String[] VISIBLE_COLUMNS = { "pcid", "caseStatus",
			"firstName", "lastName", "dateOfBirth", "gender",
			"kindOfTreatment", "dateCaseOpened" };

	private static final String[] VISIBLE_COLUMN_NAMES = { "Fallnummer",
			"Status", "Vorname", "Nachname", "Geburtsdatum", "Geschlecht",
			"Behandlungsart", "Datum Falleröffnung" };

	private PmsDataAccess pmsDataAccess;

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
			this.pmsDataAccess = PmsDataAccessCreator.getDataAccess();

			this.initPatientTable();
			this.pCaseItemChange();
			this.lblView.addStyleName(Reindeer.LABEL_H2);
			this.lblView.setValue("Übersicht Patienten und Fälle");

			this.addValueChangeListener();
			this.addNewPatientClickListener();
			this.addNewCaseClickListener();

			// TODO format dateOfBirth in Tab
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	/**
	 * Initialization of the table element
	 */
	private void initPatientTable() {
		this.tblPatients.setContainerDataSource(this.pmsDataAccess
				.getPCaseContainer());
		this.tblPatients.setSelectable(true);
		this.tblPatients.setImmediate(true);
		this.tblPatients.setVisibleColumns(VISIBLE_COLUMNS);
		for (int i = 0; i < VISIBLE_COLUMNS.length; i++) {
			this.tblPatients.setColumnHeader(VISIBLE_COLUMNS[i],
					VISIBLE_COLUMN_NAMES[i]);
		}
	}

	private void addNewCaseClickListener() {
		this.btnNewCase.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;

			@Override
			public void buttonClick(ClickEvent event) {
				PatientTableComponent.this.fireUIActivationEvent(false);
				PatientTableComponent.this
						.fireComponentChangeEvent(NavigationEvent.PCASE);
				PatientTableComponent.this.fireNewCaseEvent(true);
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
							Object id = PatientTableComponent.this.tblPatients
									.getValue();
							PatientTableComponent.this.pmsDataAccess
									.getPCaseContainer().setCurrentItemId(id);
							PatientTableComponent.this
									.firePCaseItemChangeEvent();
						}
					}
				});
	}

	@Override
	public void pCaseItemChange() {
		try {
			this.pmsDataAccess = PmsDataAccessCreator.getDataAccess();
			this.pmsDataAccess.getPCaseContainer().refresh();
			Object itemId = this.pmsDataAccess.getPCaseContainer()
					.getCurrentItemId();

			if (itemId != null) {
				this.tblPatients.select(itemId);
			}
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	private void setPermissions(Object itemId) {
		this.btnNewPatient.setEnabled(this.pmsDataAccess.getPermission()
				.hasPermission(Operation.NEW_PATIENT));
		this.btnNewCase.setEnabled(this.pmsDataAccess.getPermission()
				.hasPermission(Operation.NEW_CASE) && itemId != null);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		try {
		this.pmsDataAccess = PmsDataAccessCreator.getDataAccess();
		this.setPermissions(this.pmsDataAccess.getPCaseContainer()
				.getCurrentItemId());
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
		mainLayout.addComponent(btnNewPatient, "top:20.0px;left:280.0px;");

		// btnNewCase
		btnNewCase = new Button();
		btnNewCase.setCaption("Neuer Fall");
		btnNewCase.setImmediate(true);
		btnNewCase.setWidth("-1px");
		btnNewCase.setHeight("-1px");
		mainLayout.addComponent(btnNewCase, "top:20.0px;left:417.0px;");

		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("View title");
		mainLayout.addComponent(lblView, "top:20.0px;left:20.0px;");

		return mainLayout;
	}

}
