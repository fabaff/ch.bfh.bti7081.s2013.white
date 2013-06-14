package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Operation;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;

/**
 * UI Class for treatment progress
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
class PatientProgressComponent extends PmsComponentController implements
		PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button btnDeletePatientProgressEntry;
	@AutoGenerated
	private Button btnEditPatientProgressEntry;
	@AutoGenerated
	private Button btnNewPatientProgressEntry;
	private static final long serialVersionUID = 1022303185979278516L;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public PatientProgressComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

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

		// btnNewPatientProgressEntry
		btnNewPatientProgressEntry = new Button();
		btnNewPatientProgressEntry.setCaption("Neuer Eintrag");
		btnNewPatientProgressEntry.setImmediate(true);
		btnNewPatientProgressEntry.setWidth("100px");
		btnNewPatientProgressEntry.setHeight("-1px");
		mainLayout.addComponent(btnNewPatientProgressEntry,
				"top:20.0px;left:20.0px;");

		// btnEditPatientProgressEntry
		btnEditPatientProgressEntry = new Button();
		btnEditPatientProgressEntry.setCaption("Eintrag bearbeiten");
		btnEditPatientProgressEntry.setImmediate(true);
		btnEditPatientProgressEntry.setWidth("140px");
		btnEditPatientProgressEntry.setHeight("-1px");
		mainLayout.addComponent(btnEditPatientProgressEntry,
				"top:20.0px;left:140.0px;");

		// btnDeletePatientProgressEntry
		btnDeletePatientProgressEntry = new Button();
		btnDeletePatientProgressEntry.setCaption("Eintrag Löschen");
		btnDeletePatientProgressEntry.setImmediate(true);
		btnDeletePatientProgressEntry.setWidth("-1px");
		btnDeletePatientProgressEntry.setHeight("-1px");
		mainLayout.addComponent(btnDeletePatientProgressEntry,
				"top:20.0px;left:300.0px;");

		return mainLayout;
	}

	@Override
	public void pCaseItemChange() {
		try {
			this.setPermissions();
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	private void setPermissions() throws UnknownUserException {
		Object itemId = PmsDataAccessCreator.getDataAccess().getPatientProgressContainer().getCurrentItemId();
		Object pCaseItemId = PmsDataAccessCreator.getDataAccess().getPCaseContainer().getCurrentItemId();
		PCase currentPCase = PmsDataAccessCreator.getDataAccess().getPCaseContainer().getCurrentItem();

		boolean isOpen = (currentPCase == null || currentPCase.getCaseStatus() != CaseStatus.CLOSED);

		this.btnNewPatientProgressEntry.setEnabled(PmsDataAccessCreator.getDataAccess()
				.getPermission().hasPermission(
						Operation.NEW_PATIENT_PROGRESS_ENTRY) && pCaseItemId != null && isOpen);
		this.btnEditPatientProgressEntry.setEnabled(PmsDataAccessCreator.getDataAccess()
				.getPermission().hasPermission(
						Operation.EDIT_PATIENT_PROGRESS_ENTRY)
				&& itemId != null && isOpen);
		this.btnDeletePatientProgressEntry.setEnabled(PmsDataAccessCreator.getDataAccess()
				.getPermission().hasPermission(
						Operation.DELETE_PATIENT_PROGRESS_ENTRY)
				&& itemId != null && isOpen);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
