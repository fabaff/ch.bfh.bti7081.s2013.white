package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.Patient;
import ch.bfh.ti.soed.white.mhc_pms.security.UIPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.UserSingleton;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;

class PatientTableComponent extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnNewCase;
	@AutoGenerated
	private Button btnNewPatient;
	@AutoGenerated
	private Table tblPatients;
	private static final long serialVersionUID = 3262703309337559597L;
	
	private ImhcPmsComponent mainComponent;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 * @param mainPanel 
	 */
	public PatientTableComponent(ImhcPmsComponent mainComponent) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.mainComponent = mainComponent;
		this.tblPatients.setContainerDataSource(MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class));
		//this.tblPatients.setSizeFull();
		// TODO Strings eliminieren
		this.tblPatients.setVisibleColumns(new Object[] { "firstName", "lastName", "dateOfBirth", "gender", "status", "kindOfTreatment" });
		this.tblPatients.setColumnHeader("firstName", "Vorname");
		this.tblPatients.setColumnHeader("lastName", "Nachname");
		this.tblPatients.setColumnHeader("dateOfBirth", "Geburtsdatum");
		this.tblPatients.setColumnHeader("gender", "Geschlecht");
		this.tblPatients.setColumnHeader("status", "Status");
		this.tblPatients.setColumnHeader("kindOfTreatment", "Behandlungsart");
		
		UIPermission permission = UserSingleton.getUser().getUIPermission();
		this.btnNewPatient.setEnabled(permission.isNewPatientAllowed());
		this.btnNewCase.setEnabled(permission.isNewCaseAllowed());
		
		this.tblPatients.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = 2883881874240424835L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (event.getProperty().getValue() != null) {
					UserSingleton.getUser().setCurrentItem(Patient.class, event.getProperty().getValue());
					PatientTableComponent.this.mainComponent.updateComponentDataSource();
				}
			}
		});
		
		this.tblPatients.setSelectable(true);
		this.tblPatients.setImmediate(true);
	}

	public void updateComponentDataSource() {
		// TODO check auf null
		// TODO Item über Interface auswählen
		this.tblPatients.select(((Patient) MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class).getCurrentItem().getEntity()).getId());
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
		tblPatients.setCaption("Übersicht Patienten");
		tblPatients.setImmediate(false);
		tblPatients.setWidth("980px");
		tblPatients.setHeight("500px");
		mainLayout.addComponent(tblPatients, "top:80.0px;left:20.0px;");
		
		// btnNewPatient
		btnNewPatient = new Button();
		btnNewPatient.setCaption("Neuer Patient");
		btnNewPatient.setImmediate(true);
		btnNewPatient.setWidth("-1px");
		btnNewPatient.setHeight("-1px");
		mainLayout.addComponent(btnNewPatient, "top:20.0px;left:20.0px;");
		
		// btnNewCase
		btnNewCase = new Button();
		btnNewCase.setCaption("Neuer Fall");
		btnNewCase.setImmediate(true);
		btnNewCase.setWidth("-1px");
		btnNewCase.setHeight("-1px");
		mainLayout.addComponent(btnNewCase, "top:20.0px;left:160.0px;");
		
		return mainLayout;
	}

}