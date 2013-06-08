package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Element;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Reindeer;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * UI Class for medication
 */
class MedicationComponent extends PmsComponentController implements PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblView;
	@AutoGenerated
	private Button btnEditMedication;
	@AutoGenerated
	private Button btnDeleteMedication;
	@AutoGenerated
	private Button btnNewMedication;
	private static final long serialVersionUID = -4426948260684454466L;
	
	private PmsDataAccess pmsContainers;
	
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

		this.pmsContainers = PmsDataAccessCreator.getDataAccess();
		
		PmsPermission permission = new PmsPermission(this.pmsContainers.getCurrentUser().getUserGroup());
		this.btnNewMedication.setEnabled(permission.hasPermission(Element.NEW_MEDICATION));
		this.btnEditMedication.setEnabled(permission.hasPermission(Element.EDIT_MEDICATION));
		this.btnDeleteMedication.setEnabled(permission.hasPermission(Element.DELETE_MEDICATION));
		
		// Static elements
		this.lblView.addStyleName(Reindeer.LABEL_H2);
		this.lblView.setValue("Medikamente");
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
		
		// btnNewMedication
		btnNewMedication = new Button();
		btnNewMedication.setCaption("Neues Medikament");
		btnNewMedication.setImmediate(true);
		btnNewMedication.setWidth("140px");
		btnNewMedication.setHeight("-1px");
		mainLayout.addComponent(btnNewMedication, "top:20.0px;left:250.0px;");
		
		// btnDeleteMedication
		btnDeleteMedication = new Button();
		btnDeleteMedication.setCaption("Medikament löschen");
		btnDeleteMedication.setImmediate(true);
		btnDeleteMedication.setWidth("-1px");
		btnDeleteMedication.setHeight("-1px");
		mainLayout
				.addComponent(btnDeleteMedication, "top:20.0px;left:580.0px;");
		
		// btnEditMedication
		btnEditMedication = new Button();
		btnEditMedication.setCaption("Medikament bearbeiten");
		btnEditMedication.setImmediate(true);
		btnEditMedication.setWidth("160px");
		btnEditMedication.setHeight("-1px");
		mainLayout.addComponent(btnEditMedication, "top:20.0px;left:400.0px;");
		
		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("Label");
		mainLayout.addComponent(lblView, "top:20.0px;left:20.0px;");
		
		return mainLayout;
	}

}
