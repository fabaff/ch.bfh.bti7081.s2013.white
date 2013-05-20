package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

class CaseInfoComponent extends PmsComponent implements PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblZwangsmassnahmen;
	@AutoGenerated
	private Label lblFremdgefaehrtung;
	@AutoGenerated
	private Label lblDateCaseClosed;
	@AutoGenerated
	private Label lblDateCaseOpended;
	@AutoGenerated
	private Label lblAusgang;
	@AutoGenerated
	private Label lblJuristischerStatus;
	@AutoGenerated
	private Label lblUrlaub;
	@AutoGenerated
	private Label lblPatVerfuegung;
	@AutoGenerated
	private Label lblSuizidal;
	@AutoGenerated
	private Label lblZuweiser;
	@AutoGenerated
	private Label lblReanimationsstatus;
	@AutoGenerated
	private Button btnNewCase;
	@AutoGenerated
	private Button btnEditCaseData;
	private static final long serialVersionUID = -1488922640521851182L;


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


//		NursePermission permission = UserSingleton.getUser().getUIPermission();
//		this.btnNewCase.setEnabled(permission.isNewCaseAllowed());
//		this.btnEditCaseData.setEnabled(permission.isEditCaseDataAllowed());

		this.btnNewCase.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;

			@Override
			public void buttonClick(ClickEvent event) {
				changeUI();
			}
		});

		this.btnEditCaseData.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 8636612818445844248L;

			@Override
			public void buttonClick(ClickEvent event) {
				changeUI();
			}
		});

		this.updateComponentDataSource();
	}

	private void changeUI() {
//		Component title = this.mainComponent.getTitleBarComponent();
//		Component detail = this.mainComponent.getEditCaseInfoComponent();
//		this.mainComponent.setActiveComponents(title, detail);
//		this.mainComponent.enableMenuBar(false);
	}

	protected void updateComponentDataSource() {
//		EntityItem<? extends MhcPmsItem> itemP = PmsDataAccess.getInstance()
//				.getCurrentContainer(PCase.class).getCurrentItem();
//		if (itemP != null && itemP.getEntity() instanceof PCase) {
//			PCase pCase = (PCase) itemP.getEntity();
//			this.lblAusgang.setValue(pCase.getAusgang());
//			this.lblDateCaseClosed.setValue(DateFormat.getDateInstance(DateFormat.MEDIUM).format(pCase.getDateCaseClosed()));
//			this.lblDateCaseOpended.setValue(DateFormat.getDateInstance(DateFormat.MEDIUM).format(pCase.getDateCaseOpened()));
//			this.lblFremdgefaehrtung.setValue(pCase.getFremdgefaerdung());
//			this.lblJuristischerStatus.setValue(pCase.getJuristischerStatus());
//			this.lblPatVerfuegung.setValue(pCase.getPatVerfuegung());
//			this.lblReanimationsstatus.setValue(pCase.getReanimationsstatus());
//			this.lblSuizidal.setValue(pCase.getSuizidal());
//			this.lblUrlaub.setValue(pCase.getUrlaub());
//			this.lblZuweiser.setValue(pCase.getZuweiser());
//			this.lblZwangsmassnahmen.setValue(pCase.getZwangsmassnahmen());
//		}
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
		
		// lblReanimationsstatus
		lblReanimationsstatus = new Label();
		lblReanimationsstatus.setCaption("Reanimationsstatus: ");
		lblReanimationsstatus.setImmediate(false);
		lblReanimationsstatus.setWidth("-1px");
		lblReanimationsstatus.setHeight("18px");
		lblReanimationsstatus.setValue("Label");
		mainLayout.addComponent(lblReanimationsstatus,
				"top:100.0px;left:20.0px;");
		
		// lblZuweiser
		lblZuweiser = new Label();
		lblZuweiser.setCaption("Zuweiser: ");
		lblZuweiser.setImmediate(false);
		lblZuweiser.setWidth("-1px");
		lblZuweiser.setHeight("18px");
		lblZuweiser.setValue("Label");
		mainLayout.addComponent(lblZuweiser, "top:100.0px;left:200.0px;");
		
		// lblSuizidal
		lblSuizidal = new Label();
		lblSuizidal.setCaption("Suizidalität: ");
		lblSuizidal.setImmediate(false);
		lblSuizidal.setWidth("-1px");
		lblSuizidal.setHeight("18px");
		lblSuizidal.setValue("Label");
		mainLayout.addComponent(lblSuizidal, "top:100.0px;left:380.0px;");
		
		// lblPatVerfuegung
		lblPatVerfuegung = new Label();
		lblPatVerfuegung.setCaption("Patientenverfügung vorhanden: ");
		lblPatVerfuegung.setImmediate(false);
		lblPatVerfuegung.setWidth("-1px");
		lblPatVerfuegung.setHeight("18px");
		lblPatVerfuegung.setValue("Label");
		mainLayout.addComponent(lblPatVerfuegung, "top:220.0px;left:20.0px;");
		
		// lblUrlaub
		lblUrlaub = new Label();
		lblUrlaub.setCaption("Urlaub: ");
		lblUrlaub.setImmediate(false);
		lblUrlaub.setWidth("-1px");
		lblUrlaub.setHeight("18px");
		lblUrlaub.setValue("Label");
		mainLayout.addComponent(lblUrlaub, "top:160.0px;left:200.0px;");
		
		// lblJuristischerStatus
		lblJuristischerStatus = new Label();
		lblJuristischerStatus.setCaption("Juristischer Status: ");
		lblJuristischerStatus.setImmediate(false);
		lblJuristischerStatus.setWidth("-1px");
		lblJuristischerStatus.setHeight("18px");
		lblJuristischerStatus.setValue("Label");
		mainLayout.addComponent(lblJuristischerStatus,
				"top:160.0px;left:380.0px;");
		
		// lblAusgang
		lblAusgang = new Label();
		lblAusgang.setCaption("Ausgang: ");
		lblAusgang.setImmediate(false);
		lblAusgang.setWidth("-1px");
		lblAusgang.setHeight("18px");
		lblAusgang.setValue("Label");
		mainLayout.addComponent(lblAusgang, "top:160.0px;left:20.0px;");
		
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
		
		// lblFremdgefaehrtung
		lblFremdgefaehrtung = new Label();
		lblFremdgefaehrtung.setCaption("Fremdgefährtung: ");
		lblFremdgefaehrtung.setImmediate(false);
		lblFremdgefaehrtung.setWidth("-1px");
		lblFremdgefaehrtung.setHeight("18px");
		lblFremdgefaehrtung.setValue("Label");
		mainLayout.addComponent(lblFremdgefaehrtung,
				"top:100.0px;left:560.0px;");
		
		// lblZwangsmassnahmen
		lblZwangsmassnahmen = new Label();
		lblZwangsmassnahmen.setCaption("Zwangsmassnahmen: ");
		lblZwangsmassnahmen.setImmediate(false);
		lblZwangsmassnahmen.setWidth("-1px");
		lblZwangsmassnahmen.setHeight("18px");
		lblZwangsmassnahmen.setValue("Label");
		mainLayout.addComponent(lblZwangsmassnahmen,
				"top:160.0px;left:560.0px;");
		
		return mainLayout;
	}

	@Override
	public void pCaseItemChange(Object itemId) {
		// TODO Auto-generated method stub
		
	}

}
