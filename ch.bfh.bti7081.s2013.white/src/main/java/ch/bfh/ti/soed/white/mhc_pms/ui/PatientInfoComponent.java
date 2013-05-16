package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.security.UIPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.UserSingleton;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;

class PatientInfoComponent extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnNewPatient;
	private static final long serialVersionUID = -6090834279643277087L;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PatientInfoComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
//		this.patientFieldGroup = new FieldGroup();
//		this.patientFieldGroup.bind(this.lblFirstName, "");
		
		UIPermission permission = UserSingleton.getUser().getUIPermission();
		this.btnNewPatient.setEnabled(permission.isNewPatientAllowed());
	}

	protected void updateComponentDataSource() {
		// TODO Auto-generated method stub
		
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
		
		// btnNewPatient
		btnNewPatient = new Button();
		btnNewPatient.setCaption("Neuer Patient");
		btnNewPatient.setImmediate(false);
		btnNewPatient.setWidth("-1px");
		btnNewPatient.setHeight("-1px");
		mainLayout.addComponent(btnNewPatient, "top:20.0px;left:20.0px;");
		
		return mainLayout;
	}

}
