package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.controller.UIActivationListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.FilterEnum;
import ch.bfh.ti.soed.white.mhc_pms.util.ValueConverter;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.Reindeer;

/**
 * UI Class for layout header
 *  
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
class TitleBarComponent extends PmsComponentController implements
		PmsComponentListener, UIActivationListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = 1148948780923578333L;
	@AutoGenerated
	private Button btnLogout;
	@AutoGenerated
	private ComboBox cmbFilter;
	@AutoGenerated
	private Label lblDateOfBirth;
	@AutoGenerated
	private Label lblFullName;
	@AutoGenerated
	private Label lblGender;
	@AutoGenerated
	private Label lblKindOfTreatment;
	@AutoGenerated
	private Label lblStatus;
	@AutoGenerated
	private Label lblUser;
	@AutoGenerated
	private AbsoluteLayout mainLayout;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public TitleBarComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.initFilterCombo();
		this.pCaseItemChange();
		this.cmbFilter.setImmediate(true);
		
		// Add style to UI elements
		this.lblUser.addStyleName(Reindeer.LABEL_SMALL);
		this.lblFullName.addStyleName(Reindeer.LABEL_H1);

		this.addLogoutButtonClickListener();
		this.addComboValueChangeListener();
	}

	private void addComboValueChangeListener() {
		this.cmbFilter
				.addValueChangeListener(new Property.ValueChangeListener() {
					private static final long serialVersionUID = -7229281357206546755L;

					@Override
					public void valueChange(ValueChangeEvent event) {
						if (event.getProperty().getValue() != null) {
							try {
								String value = event.getProperty().getValue()
										.toString();
								
								if (value.equals(FilterEnum.CURRENT.toString())) {
									PmsDataAccessCreator.getDataAccess()
											.getPCaseContainer()
											.enableCaseFilter(true);
								}
								if (value.equals(FilterEnum.ALL.toString())) {
									PmsDataAccessCreator.getDataAccess()
									.getPCaseContainer()
									.enableCaseFilter(false);
								}
								
								TitleBarComponent.this.firePCaseItemChangeEvent();
							} catch (UnknownUserException e) {
								Notification.show(e.getInvalidUserMessage(),
										Notification.Type.HUMANIZED_MESSAGE);Notification.show(e.getInvalidUserMessage(),
												Notification.Type.HUMANIZED_MESSAGE);
							}
						}
						
					}
				});
	}

	private void addLogoutButtonClickListener() {
		this.btnLogout.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -7445511110217678724L;

			@Override
			public void buttonClick(ClickEvent event) {
				TitleBarComponent.this
						.fireComponentChangeEvent(NavigationEvent.LOGOUT);
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
		
		// lblFullName
		lblFullName = new Label();
		lblFullName.setImmediate(false);
		lblFullName.setWidth("-1px");
		lblFullName.setHeight("-1px");
		lblFullName.setValue("fullname");
		mainLayout.addComponent(lblFullName, "top:15.0px;left:20.0px;");
		
		// lblDateOfBirth
		lblDateOfBirth = new Label();
		lblDateOfBirth.setCaption("Geburtsdatum:");
		lblDateOfBirth.setImmediate(false);
		lblDateOfBirth.setWidth("-1px");
		lblDateOfBirth.setHeight("-1px");
		lblDateOfBirth.setValue("XYZ");
		mainLayout.addComponent(lblDateOfBirth, "top:60.0px;left:20.0px;");
		
		// lblGender
		lblGender = new Label();
		lblGender.setCaption("Geschlecht:");
		lblGender.setImmediate(false);
		lblGender.setWidth("-1px");
		lblGender.setHeight("-1px");
		lblGender.setValue("XYZ");
		mainLayout.addComponent(lblGender, "top:60.0px;left:120.0px;");
		
		// lblKindOfTreatment
		lblKindOfTreatment = new Label();
		lblKindOfTreatment.setCaption("Behandlungsart:");
		lblKindOfTreatment.setImmediate(false);
		lblKindOfTreatment.setWidth("-1px");
		lblKindOfTreatment.setHeight("-1px");
		lblKindOfTreatment.setValue("XYZ");
		mainLayout.addComponent(lblKindOfTreatment, "top:60.0px;left:200.0px;");
		
		// btnLogout
		btnLogout = new Button();
		btnLogout.setCaption("Logout");
		btnLogout.setImmediate(true);
		btnLogout.setWidth("-1px");
		btnLogout.setHeight("-1px");
		mainLayout.addComponent(btnLogout, "top:40.0px;right:24.0px;");
		
		// lblStatus
		lblStatus = new Label();
		lblStatus.setCaption("Status:");
		lblStatus.setImmediate(false);
		lblStatus.setWidth("-1px");
		lblStatus.setHeight("18px");
		lblStatus.setValue("XYZ");
		mainLayout.addComponent(lblStatus, "top:60.0px;left:320.0px;");
		
		// cmbFilter
		cmbFilter = new ComboBox();
		cmbFilter.setCaption("Fälle filtern");
		cmbFilter.setImmediate(false);
		cmbFilter.setWidth("-1px");
		cmbFilter.setHeight("-1px");
		mainLayout.addComponent(cmbFilter, "top:40.0px;right:100.0px;");
		
		// lblUser
		lblUser = new Label();
		lblUser.setCaption("Benutzer:");
		lblUser.setEnabled(false);
		lblUser.setImmediate(false);
		lblUser.setVisible(false);
		lblUser.setWidth("-1px");
		lblUser.setHeight("-1px");
		lblUser.setValue("Label");
		mainLayout.addComponent(lblUser, "top:15.0px;right:100.0px;");
		
		return mainLayout;
	}

	@Override
	public void enableUIComponents(boolean value) {
		this.cmbFilter.setEnabled(value);
		this.btnLogout.setEnabled(value);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	private void initFilterCombo() {
		this.cmbFilter.addItem(FilterEnum.CURRENT);
		this.cmbFilter.addItem(FilterEnum.ALL);
		this.cmbFilter.setValue(FilterEnum.CURRENT);
	}

	@Override
	public void pCaseItemChange() {
		try {
			PCase item = PmsDataAccessCreator.getDataAccess()
					.getPCaseContainer().getCurrentItem();

			if (item == null) {
				item = new PCase(PmsDataAccessCreator.getDataAccess()
						.getLoginUser());
			}

			// Those are fields besides the name are in the lower area
			// of the title bar, check the layout before adding a new one.
			// The space is limited!
			this.lblFullName.setValue(item.getFirstName() + " "
					+ item.getLastName());
			this.lblDateOfBirth.setValue(ValueConverter.convertDate(item
					.getDateOfBirth()));
			this.lblGender.setValue(ValueConverter.convertString(item
					.getGender()));
			this.lblStatus.setValue(ValueConverter.convertString(item
					.getCaseStatus()));
			this.lblKindOfTreatment.setValue(ValueConverter.convertString(item
					.getKindOfTreatment()));
			/*this.lblUser.setValue(PmsDataAccessCreator.getDataAccess()
					.getLoginUser().getLastName()
					+ " "
					+ PmsDataAccessCreator.getDataAccess().getLoginUser()
							.getLastName());*/
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

}
