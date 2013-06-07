package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Element;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2
 * @since		0.0.1
 * 
 *  UI Class for patient overview
 */
class PatientTableComponent extends PmsComponentController implements
		PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblView;
	@AutoGenerated
	private Button btnTest;
	@AutoGenerated
	private Button btnNewCase;
	@AutoGenerated
	private Button btnNewPatient;
	@AutoGenerated
	private Table tblPatients;
	private static final long serialVersionUID = 3262703309337559597L;

	private static final String[] VISIBLE_COLUMNS = {   "pcid",
														"caseStatus",
														"firstName",
														"lastName",
														"dateOfBirth",
														"gender",
														"kindOfTreatment"
														};

	private static final String[] VISIBLE_COLUMN_NAMES = {  "Fallnummer", 
															"Status", 
															"Vorname", 
															"Nachname", 
															"Geburtsdatum", 
															"Geschlecht",
															"Behandlungsart"
															};


	private PmsDataAccess pmsContainers;
	private PmsPermission permission;

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

		this.pmsContainers = PmsDataAccessCreator.getContainers();
		this.pmsContainers.getPCaseContainer().refresh();
		Object itemId = this.pmsContainers.getPCaseContainer().getCurrentPCaseId();
		this.permission = new PmsPermission(this.pmsContainers.getCurrentUser().getUserGroup());
		
		this.initPatientTable();
		this.addValueChangeListener();
		this.addNewPatientClickListener();
		this.addNewCaseClickListener();
		this.addTestClickListener();
		this.pCaseItemChange(itemId);
		// TODO abgeschlossene Fälle: Buttons sperren
		// TODO format dateOfBirth in Tab
		
		// Static elements
		this.lblView.addStyleName(Reindeer.LABEL_H2);
		this.lblView.setValue("Übersicht Patienten und Fälle");
	}

	// Initialization of the table element
	private void initPatientTable() {
		this.tblPatients.setContainerDataSource(this.pmsContainers.getPCaseContainer());
		this.tblPatients.setSelectable(true);
		this.tblPatients.setImmediate(true);
		//this.tblPatients.setEditable(true);
		this.tblPatients.setVisibleColumns(VISIBLE_COLUMNS);
		for (int i = 0; i < VISIBLE_COLUMNS.length; i++) {
			this.tblPatients.setColumnHeader(VISIBLE_COLUMNS[i], VISIBLE_COLUMN_NAMES[i]);
		}
	}

	private void addNewCaseClickListener() {
		this.btnNewCase.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;

			@Override
			public void buttonClick(ClickEvent event) {
				PatientTableComponent.this.fireUIActivationEvent(false);
				PatientTableComponent.this.fireComponentChangeEvent(NavigationEvent.PCASE);
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
				PatientTableComponent.this.fireComponentChangeEvent(NavigationEvent.PATIENT);
			}
		});
	}
	
	private void addTestClickListener() {
		this.btnTest.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
                Notification.show("Test notification", Notification.Type.HUMANIZED_MESSAGE);

			}
		});
	}

	private void addValueChangeListener() {
		this.tblPatients.addValueChangeListener(new Property.ValueChangeListener() {
					private static final long serialVersionUID = 2883881874240424835L;

					@Override
					public void valueChange(ValueChangeEvent event) {
						if (event.getProperty().getValue() != null) {
							Object id = PatientTableComponent.this.tblPatients.getValue();
							PatientTableComponent.this.pmsContainers.getPCaseContainer().setCurrentPCaseId(id);
							PatientTableComponent.this.firePCaseItemChangeEvent(id);
						}
					}
				});
	}

	@Override
	public void pCaseItemChange(Object itemId) {
		if (itemId != null) {
			this.tblPatients.select(itemId);
		}

		this.btnNewPatient.setEnabled(this.permission.hasPermission(Element.NEW_PATIENT));
		this.btnNewCase.setEnabled(this.permission.hasPermission(Element.NEW_CASE) && itemId != null);
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
		
		// btnTest
		btnTest = new Button();
		btnTest.setCaption("Test");
		btnTest.setImmediate(true);
		btnTest.setWidth("-1px");
		btnTest.setHeight("-1px");
		mainLayout.addComponent(btnTest, "top:20.0px;left:510.0px;");
		
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
