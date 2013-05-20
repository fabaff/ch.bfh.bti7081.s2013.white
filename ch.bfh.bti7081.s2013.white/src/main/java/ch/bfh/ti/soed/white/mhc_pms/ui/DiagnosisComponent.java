package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;

class DiagnosisComponent extends PmsComponent implements PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Table tblDiagnosis;
	@AutoGenerated
	private Button btnDeleteDiagnosis;
	@AutoGenerated
	private Button btnEditDiagnosis;
	@AutoGenerated
	private Button btnNewDiagnosis;
	private static final long serialVersionUID = -8871345981941787383L;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public DiagnosisComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

//		NursePermission permission = UserSingleton.getUser().getUIPermission();
//		this.btnNewDiagnosis.setEnabled(permission.isNewDiagnosisAllowed());
//		this.btnEditDiagnosis.setEnabled(permission.isEditDiagnosisAllowed());
//		this.btnDeleteDiagnosis.setEnabled(permission.isDeleteDiagnosisAllowed());
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
		
		// btnNewDiagnosis
		btnNewDiagnosis = new Button();
		btnNewDiagnosis.setCaption("Neue Diagnose");
		btnNewDiagnosis.setImmediate(true);
		btnNewDiagnosis.setWidth("120px");
		btnNewDiagnosis.setHeight("-1px");
		mainLayout.addComponent(btnNewDiagnosis, "top:20.0px;left:20.0px;");
		
		// btnEditDiagnosis
		btnEditDiagnosis = new Button();
		btnEditDiagnosis.setCaption("Diagnose bearbeiten");
		btnEditDiagnosis.setImmediate(true);
		btnEditDiagnosis.setWidth("140px");
		btnEditDiagnosis.setHeight("-1px");
		mainLayout.addComponent(btnEditDiagnosis, "top:20.0px;left:160.0px;");
		
		// btnDeleteDiagnosis
		btnDeleteDiagnosis = new Button();
		btnDeleteDiagnosis.setCaption("Diagnose löschen");
		btnDeleteDiagnosis.setImmediate(true);
		btnDeleteDiagnosis.setWidth("-1px");
		btnDeleteDiagnosis.setHeight("-1px");
		mainLayout.addComponent(btnDeleteDiagnosis, "top:20.0px;left:320.0px;");
		
		// tblDiagnosis
		tblDiagnosis = new Table();
		tblDiagnosis.setCaption("Übersicht Diagnosen");
		tblDiagnosis.setImmediate(false);
		tblDiagnosis.setWidth("740px");
		tblDiagnosis.setHeight("-1px");
		mainLayout.addComponent(tblDiagnosis, "top:100.0px;left:20.0px;");
		
		return mainLayout;
	}

	@Override
	public void pCaseItemChange(Object itemId) {
		// TODO Auto-generated method stub
		
	}

}
