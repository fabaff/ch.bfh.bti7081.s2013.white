package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.model.MhcPmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.model.Patient;
import ch.bfh.ti.soed.white.mhc_pms.security.UIPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.UserSingleton;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;

public class PatientTableComponent extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnCloseCase;
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
		this.tblPatients.setContainerDataSource(MhcPmsDataAccess.getCurrentContainer(Patient.class));
		
		UIPermission permission = UserSingleton.getUser().getUIPermission();
		this.btnNewPatient.setEnabled(permission.isNewPatientAllowed());
		this.btnNewCase.setEnabled(permission.isNewCaseAllowed());
		this.btnCloseCase.setEnabled(permission.isCloseCaseAllowed());
		
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
		tblPatients.setWidth("700px");
		tblPatients.setHeight("340px");
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
		mainLayout.addComponent(btnNewCase, "top:20.0px;left:140.0px;");
		
		// btnCloseCase
		btnCloseCase = new Button();
		btnCloseCase.setCaption("Fall abschliessen");
		btnCloseCase.setImmediate(true);
		btnCloseCase.setWidth("-1px");
		btnCloseCase.setHeight("-1px");
		mainLayout.addComponent(btnCloseCase, "top:20.0px;left:240.0px;");
		
		return mainLayout;
	}

}
