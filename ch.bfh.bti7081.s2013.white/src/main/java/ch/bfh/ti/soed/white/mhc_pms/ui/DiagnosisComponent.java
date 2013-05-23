package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.ContainerCollection;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Element;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * 
 */
class DiagnosisComponent extends PmsComponentController implements PmsComponentListener {

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
	
	private ContainerCollection pmsContainers;
	
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
		
		this.pmsContainers = PmsDataAccess.getContainers();
		
		PmsPermission permission = new PmsPermission(this.pmsContainers.getCurrentUser().getUserGroup());
		this.btnNewDiagnosis.setEnabled(permission.hasPermission(Element.NEW_DIAGNOSIS));
		this.btnEditDiagnosis.setEnabled(permission.hasPermission(Element.EDIT_DIAGNOSIS));
		this.btnDeleteDiagnosis.setEnabled(permission.hasPermission(Element.DELETE_DIAGNOSIS));
	}

	@Override
	public void pCaseItemChange(Object itemId) {
		// TODO implement
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
		tblDiagnosis.setWidth("960px");
		tblDiagnosis.setHeight("460px");
		mainLayout.addComponent(tblDiagnosis, "top:100.0px;left:20.0px;");
		
		return mainLayout;
	}

}
