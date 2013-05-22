package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.security.UIPermission;
import ch.bfh.ti.soed.white.mhc_pms.security.UIPermissionInstance;
import ch.bfh.ti.soed.white.mhc_pms.util.ValueConverter;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * 
 */
class CaseInfoComponent extends PmsComponentController implements PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblSanction;
	@AutoGenerated
	private Label lblDegreeOfDanger;
	@AutoGenerated
	private Label lblDateCaseClosed;
	@AutoGenerated
	private Label lblDateCaseOpended;
	@AutoGenerated
	private Label lblGoOutStatus;
	@AutoGenerated
	private Label lblJudicialStatus;
	@AutoGenerated
	private Label lblVacation;
	@AutoGenerated
	private Label lblOrderOfPatient;
	@AutoGenerated
	private Label lblSuicidalTendency;
	@AutoGenerated
	private Label lblAssignment;
	@AutoGenerated
	private Label lblReanimationStatus;
	@AutoGenerated
	private Button btnNewCase;
	@AutoGenerated
	private Button btnEditCaseData;
	private static final long serialVersionUID = -1488922640521851182L;

	private PmsDataAccess dataAccess;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public CaseInfoComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		// TODO init empty Labels
		this.dataAccess = PmsDataAccess.getInstance();
		this.dataAccess.getPCaseContainer().refresh();
		
		UIPermission permission = UIPermissionInstance.getPermission();
		this.btnNewCase.setEnabled(permission.isNewCaseAllowed());
		// TODO Nur aktiv, wenn schon Pat existiert
		this.btnEditCaseData.setEnabled(permission.isEditCaseDataAllowed());

		this.addListeners();
		this.pCaseItemChange(this.dataAccess.getCurrentPCaseId());
	}

	private void addListeners() {
		this.btnNewCase.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;
			@Override
			public void buttonClick(ClickEvent event) {
				CaseInfoComponent.this.fireUIActivationEvent(false);
				CaseInfoComponent.this.fireComponentChangeEvent(NavigationEvent.PCASE);
				CaseInfoComponent.this.fireNewCaseEvent(true);
			}
		});

		this.btnEditCaseData.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;
			@Override
			public void buttonClick(ClickEvent event) {
				CaseInfoComponent.this.fireUIActivationEvent(false);
				CaseInfoComponent.this.fireComponentChangeEvent(NavigationEvent.PCASE);
			}
		});
	}

	@Override
	public void pCaseItemChange(Object itemId) {
		EntityItem<PCase> entityItem = this.dataAccess.getPCaseContainer().getItem(itemId);
		if (entityItem != null) {
			PCase item = entityItem.getEntity();
			this.lblAssignment.setValue(item.getAssignment());
			this.lblDateCaseClosed.setValue(ValueConverter.convertDate(item.getDateCaseClosed()));
			this.lblDateCaseOpended.setValue(ValueConverter.convertDate(item.getDateCaseOpened()));
			this.lblDegreeOfDanger.setValue(item.getDegreeOfDanger());
			this.lblGoOutStatus.setValue(item.getGoOutStatus());
			this.lblJudicialStatus.setValue(item.getJudicialStatus());
			this.lblOrderOfPatient.setValue(ValueConverter.convertString(item.getOrderOfPatient()));
			this.lblReanimationStatus.setValue(ValueConverter.convertString(item.getReanimationStatus()));
			this.lblSanction.setValue(item.getSanction());
			this.lblSuicidalTendency.setValue(item.getSuicidalTendency());
			this.lblVacation.setValue(item.getVacation());
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
		
		// btnEditCaseData
		btnEditCaseData = new Button();
		btnEditCaseData.setCaption("Fallinfo bearbeiten");
		btnEditCaseData.setImmediate(true);
		btnEditCaseData.setWidth("140px");
		btnEditCaseData.setHeight("-1px");
		mainLayout.addComponent(btnEditCaseData, "top:20.0px;left:20.0px;");
		
		// btnNewCase
		btnNewCase = new Button();
		btnNewCase.setCaption("Neuer Fall");
		btnNewCase.setImmediate(true);
		btnNewCase.setWidth("-1px");
		btnNewCase.setHeight("-1px");
		mainLayout.addComponent(btnNewCase, "top:20.0px;left:180.0px;");
		
		// lblReanimationStatus
		lblReanimationStatus = new Label();
		lblReanimationStatus.setCaption("Reanimationsstatus: ");
		lblReanimationStatus.setImmediate(false);
		lblReanimationStatus.setWidth("-1px");
		lblReanimationStatus.setHeight("18px");
		lblReanimationStatus.setValue("Label");
		mainLayout.addComponent(lblReanimationStatus,
				"top:100.0px;left:20.0px;");
		
		// lblAssignment
		lblAssignment = new Label();
		lblAssignment.setCaption("Zuweiser: ");
		lblAssignment.setImmediate(false);
		lblAssignment.setWidth("-1px");
		lblAssignment.setHeight("18px");
		lblAssignment.setValue("Label");
		mainLayout.addComponent(lblAssignment, "top:100.0px;left:200.0px;");
		
		// lblSuicidalTendency
		lblSuicidalTendency = new Label();
		lblSuicidalTendency.setCaption("Suizidalität: ");
		lblSuicidalTendency.setImmediate(false);
		lblSuicidalTendency.setWidth("-1px");
		lblSuicidalTendency.setHeight("18px");
		lblSuicidalTendency.setValue("Label");
		mainLayout.addComponent(lblSuicidalTendency,
				"top:100.0px;left:380.0px;");
		
		// lblOrderOfPatient
		lblOrderOfPatient = new Label();
		lblOrderOfPatient.setCaption("Patientenverfügung vorhanden: ");
		lblOrderOfPatient.setImmediate(false);
		lblOrderOfPatient.setWidth("-1px");
		lblOrderOfPatient.setHeight("18px");
		lblOrderOfPatient.setValue("Label");
		mainLayout.addComponent(lblOrderOfPatient, "top:220.0px;left:20.0px;");
		
		// lblVacation
		lblVacation = new Label();
		lblVacation.setCaption("Urlaub: ");
		lblVacation.setImmediate(false);
		lblVacation.setWidth("-1px");
		lblVacation.setHeight("18px");
		lblVacation.setValue("Label");
		mainLayout.addComponent(lblVacation, "top:160.0px;left:200.0px;");
		
		// lblJudicialStatus
		lblJudicialStatus = new Label();
		lblJudicialStatus.setCaption("Juristischer Status: ");
		lblJudicialStatus.setImmediate(false);
		lblJudicialStatus.setWidth("-1px");
		lblJudicialStatus.setHeight("18px");
		lblJudicialStatus.setValue("Label");
		mainLayout.addComponent(lblJudicialStatus, "top:160.0px;left:380.0px;");
		
		// lblGoOutStatus
		lblGoOutStatus = new Label();
		lblGoOutStatus.setCaption("Ausgang: ");
		lblGoOutStatus.setImmediate(false);
		lblGoOutStatus.setWidth("-1px");
		lblGoOutStatus.setHeight("18px");
		lblGoOutStatus.setValue("Label");
		mainLayout.addComponent(lblGoOutStatus, "top:160.0px;left:20.0px;");
		
		// lblDateCaseOpended
		lblDateCaseOpended = new Label();
		lblDateCaseOpended.setCaption("Datum Falleröffung: ");
		lblDateCaseOpended.setImmediate(false);
		lblDateCaseOpended.setWidth("-1px");
		lblDateCaseOpended.setHeight("18px");
		lblDateCaseOpended.setValue("Label");
		mainLayout
				.addComponent(lblDateCaseOpended, "top:220.0px;left:200.0px;");
		
		// lblDateCaseClosed
		lblDateCaseClosed = new Label();
		lblDateCaseClosed.setCaption("Datum Fallabschluss: ");
		lblDateCaseClosed.setImmediate(false);
		lblDateCaseClosed.setWidth("-1px");
		lblDateCaseClosed.setHeight("18px");
		lblDateCaseClosed.setValue("Label");
		mainLayout.addComponent(lblDateCaseClosed, "top:220.0px;left:380.0px;");
		
		// lblDegreeOfDanger
		lblDegreeOfDanger = new Label();
		lblDegreeOfDanger.setCaption("Fremdgefährtung: ");
		lblDegreeOfDanger.setImmediate(false);
		lblDegreeOfDanger.setWidth("-1px");
		lblDegreeOfDanger.setHeight("18px");
		lblDegreeOfDanger.setValue("Label");
		mainLayout.addComponent(lblDegreeOfDanger, "top:100.0px;left:560.0px;");
		
		// lblSanction
		lblSanction = new Label();
		lblSanction.setCaption("Zwangsmassnahmen: ");
		lblSanction.setImmediate(false);
		lblSanction.setWidth("-1px");
		lblSanction.setHeight("18px");
		lblSanction.setValue("Label");
		mainLayout.addComponent(lblSanction, "top:160.0px;left:560.0px;");
		
		return mainLayout;
	}

}
