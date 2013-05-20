package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;

class MedicationComponent extends PmsComponent implements PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnEditMedication;
	@AutoGenerated
	private Button btnDeleteMedication;
	@AutoGenerated
	private Button btnNewMedication;
	private static final long serialVersionUID = -4426948260684454466L;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public MedicationComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

//		NursePermission permission = UserSingleton.getUser().getUIPermission();
//		this.btnNewMedication.setEnabled(permission.isNewMedicationAllowed());
//		this.btnEditMedication.setEnabled(permission.isEditMedicationAllowed());
//		this.btnDeleteMedication.setEnabled(permission.isDeleteMedicationAllowed());
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
		
		// btnNewMedication
		btnNewMedication = new Button();
		btnNewMedication.setCaption("Neues Medikament");
		btnNewMedication.setImmediate(true);
		btnNewMedication.setWidth("140px");
		btnNewMedication.setHeight("-1px");
		mainLayout.addComponent(btnNewMedication, "top:20.0px;left:20.0px;");
		
		// btnDeleteMedication
		btnDeleteMedication = new Button();
		btnDeleteMedication.setCaption("Medikament löschen");
		btnDeleteMedication.setImmediate(true);
		btnDeleteMedication.setWidth("-1px");
		btnDeleteMedication.setHeight("-1px");
		mainLayout
				.addComponent(btnDeleteMedication, "top:20.0px;left:360.0px;");
		
		// btnEditMedication
		btnEditMedication = new Button();
		btnEditMedication.setCaption("Medikament bearbeiten");
		btnEditMedication.setImmediate(true);
		btnEditMedication.setWidth("160px");
		btnEditMedication.setHeight("-1px");
		mainLayout.addComponent(btnEditMedication, "top:20.0px;left:180.0px;");
		
		return mainLayout;
	}

	@Override
	public void pCaseItemChange(Object itemId) {
		// TODO Auto-generated method stub
		
	}

}
