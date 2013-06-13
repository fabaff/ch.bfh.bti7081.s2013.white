package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentListener;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Operation;
import ch.bfh.ti.soed.white.mhc_pms.util.ValueConverter;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * UI Class for patient information
 * 
 * @author Group White, I2p, BFH Berne, <a ref="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
class PatientInfoComponent extends PmsComponentController implements
		PmsComponentListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblView;
	@AutoGenerated
	private Panel panMaster;
	@AutoGenerated
	private VerticalLayout verticalLayout_5;
	@AutoGenerated
	private GridLayout gridLayout_1;
	@AutoGenerated
	private Panel panFamDoc;
	@AutoGenerated
	private FormLayout formLayout_1;
	@AutoGenerated
	private Label lblFamilyDoctorFax;
	@AutoGenerated
	private Label lblFamilyDoctorLocation;
	@AutoGenerated
	private Label lblFamilyDoctorPostalCode;
	@AutoGenerated
	private Label lblFamilyDoctorAddress;
	@AutoGenerated
	private Label lblFamilyDoctorLastName;
	@AutoGenerated
	private Label lblFamilyDoctorFirstName;
	@AutoGenerated
	private Panel panFamily;
	@AutoGenerated
	private FormLayout formLayout_2;
	@AutoGenerated
	private Label lblNextOfKinPhone;
	@AutoGenerated
	private Label lblNextOfKinHomeLocation;
	@AutoGenerated
	private Label lblNextOfKinPostalCode;
	@AutoGenerated
	private Label lblNextOfKinAddress;
	@AutoGenerated
	private Label lblNextOfKinLastName;
	@AutoGenerated
	private Label lblNextOfKinFirstName;
	@AutoGenerated
	private Label lblNextOfKin;
	@AutoGenerated
	private Panel panComm;
	@AutoGenerated
	private FormLayout formLayout_4;
	@AutoGenerated
	private Panel panAddress;
	@AutoGenerated
	private FormLayout formLayout_3;
	@AutoGenerated
	private Label lblEmail;
	@AutoGenerated
	private Label lblMobilePhone;
	@AutoGenerated
	private Label lblPhoneBusiness;
	@AutoGenerated
	private Label lblPhonePrivate;
	@AutoGenerated
	private Label lblSpacer;
	@AutoGenerated
	private Label lblCountry;
	@AutoGenerated
	private Label lblHomeLocation;
	@AutoGenerated
	private Label lblPostalCode;
	@AutoGenerated
	private Label lblAddress;
	@AutoGenerated
	private Panel panGeneral;
	@AutoGenerated
	private FormLayout formLayout_5;
	@AutoGenerated
	private Label lblCommuncationLanguage;
	@AutoGenerated
	private Label lblMotherLanguage;
	@AutoGenerated
	private Label lblNationality;
	@AutoGenerated
	private Label lblReligion;
	@AutoGenerated
	private Label lblGender;
	@AutoGenerated
	private Label lblCivilStatus;
	@AutoGenerated
	private Label lblDateOfBirth;
	@AutoGenerated
	private Label lblLastName;
	@AutoGenerated
	private Label lblFirstName;
	@AutoGenerated
	private Button btnNewPatient;
	private static final long serialVersionUID = -6090834279643277087L;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public PatientInfoComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.pCaseItemChange();
		this.lblView.addStyleName(Reindeer.LABEL_H2);
		this.lblView.setValue("Patient Details");
		this.addListeners();
	}

	// private void setPermissions() {
	// this.btnNewPatient.setEnabled(permission
	// .hasPermission(Operation.NEW_PATIENT));
	// }

	private void addListeners() {
		this.btnNewPatient.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				PatientInfoComponent.this.fireUIActivationEvent(false);
				PatientInfoComponent.this
						.fireComponentChangeEvent(NavigationEvent.PATIENT);
			}
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	private void setPermissions() throws UnknownUserException {
		Object pCaseItemId = PmsDataAccessCreator.getDataAccess()
				.getPCaseContainer().getCurrentItemId();
		
		this.btnNewPatient.setEnabled(PmsDataAccessCreator.getDataAccess()
				.getPermission().hasPermission(Operation.NEW_PATIENT)
				&& pCaseItemId != null);
	}

	@Override
	public void pCaseItemChange() {
		try {
			PmsDataAccessCreator.getDataAccess().getPCaseContainer().refresh();
			PCase item = PmsDataAccessCreator.getDataAccess()
					.getPCaseContainer().getCurrentItem();
			this.setPermissions();
			
			if (item == null) {
				item = new PCase(PmsDataAccessCreator.getDataAccess()
						.getLoginUser());
			}
			this.setBasicPatientInfoValues(item);
			this.setNextOfKinValues(item);
			this.setFamilyDoctorValues(item);
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	private void setFamilyDoctorValues(PCase item) {
		this.lblFamilyDoctorFirstName.setValue(item.getFamilyDoctorFirstName());
		this.lblFamilyDoctorLastName.setValue(item.getFamilyDoctorLastName());
		this.lblFamilyDoctorAddress.setValue(item.getFamilyDoctorAddress());
		this.lblFamilyDoctorPostalCode.setValue(item
				.getFamilyDoctorPostalCode());
		this.lblFamilyDoctorLocation.setValue(item.getFamilyDoctorLocation());
		this.lblFamilyDoctorFax.setValue(item.getFamilyDoctorFax());
	}

	private void setNextOfKinValues(PCase item) {
		this.lblNextOfKin.setValue(item.getNextOfKin());
		this.lblNextOfKinFirstName.setValue(item.getNextOfKinFirstName());
		this.lblNextOfKinLastName.setValue(item.getNextOfKinLastName());
		this.lblNextOfKinAddress.setValue(item.getNextOfKinAddress());
		this.lblNextOfKinPostalCode.setValue(item.getNextOfKinPostalCode());
		this.lblNextOfKinHomeLocation.setValue(item.getNextOfKinHomeLocation());
		this.lblNextOfKinPhone.setValue(item.getNextOfKinPhone());
	}

	private void setBasicPatientInfoValues(PCase item) {
		this.lblFirstName.setValue(item.getFirstName());
		this.lblLastName.setValue(item.getLastName());
		this.lblDateOfBirth.setValue(ValueConverter.convertDate(item
				.getDateOfBirth()));
		this.lblGender.setValue(ValueConverter.convertString(item.getGender()));
		this.lblMotherLanguage.setValue(item.getMotherLanguage());
		this.lblCommuncationLanguage.setValue(item.getCommunicationLanguage());
		this.lblCivilStatus.setValue(ValueConverter.convertString(item
				.getCivilStatus()));
		this.lblNationality.setValue(item.getNationality());
		this.lblReligion.setValue(item.getReligion());
		this.lblAddress.setValue(item.getAddress());
		this.lblPostalCode.setValue(item.getPostalCode());
		this.lblHomeLocation.setValue(item.getHomeLocation());
		this.lblCountry.setValue(item.getCountry());
		this.lblPhonePrivate.setValue(item.getPhonePrivate());
		this.lblPhoneBusiness.setValue(item.getPhoneBusiness());
		this.lblMobilePhone.setValue(item.getPhoneMobile());
		this.lblEmail.setValue(item.geteMail());
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
		btnNewPatient.setImmediate(true);
		btnNewPatient.setWidth("-1px");
		btnNewPatient.setHeight("-1px");
		mainLayout.addComponent(btnNewPatient, "top:20.0px;left:250.0px;");

		// panMaster
		panMaster = buildPanMaster();
		mainLayout.addComponent(panMaster, "top:60.0px;left:20.0px;");

		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("Patient");
		mainLayout.addComponent(lblView, "top:20.0px;left:20.0px;");

		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanMaster() {
		// common part: create layout
		panMaster = new Panel();
		panMaster.setImmediate(false);
		panMaster.setWidth("-1px");
		panMaster.setHeight("-1px");

		// verticalLayout_5
		verticalLayout_5 = buildVerticalLayout_5();
		panMaster.setContent(verticalLayout_5);

		return panMaster;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_5() {
		// common part: create layout
		verticalLayout_5 = new VerticalLayout();
		verticalLayout_5.setImmediate(false);
		verticalLayout_5.setWidth("100.0%");
		verticalLayout_5.setHeight("100.0%");
		verticalLayout_5.setMargin(false);

		// gridLayout_1
		gridLayout_1 = buildGridLayout_1();
		verticalLayout_5.addComponent(gridLayout_1);

		return verticalLayout_5;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_1() {
		// common part: create layout
		gridLayout_1 = new GridLayout();
		gridLayout_1.setImmediate(false);
		gridLayout_1.setWidth("-1px");
		gridLayout_1.setHeight("-1px");
		gridLayout_1.setMargin(false);
		gridLayout_1.setSpacing(true);
		gridLayout_1.setColumns(3);
		gridLayout_1.setRows(2);

		// panGeneral
		panGeneral = buildPanGeneral();
		gridLayout_1.addComponent(panGeneral, 0, 0);

		// panAddress
		panAddress = buildPanAddress();
		gridLayout_1.addComponent(panAddress, 1, 0);

		// panComm
		panComm = buildPanComm();
		gridLayout_1.addComponent(panComm, 2, 0);

		// panFamily
		panFamily = buildPanFamily();
		gridLayout_1.addComponent(panFamily, 0, 1);

		// panFamDoc
		panFamDoc = buildPanFamDoc();
		gridLayout_1.addComponent(panFamDoc, 1, 1);

		return gridLayout_1;
	}

	@AutoGenerated
	private Panel buildPanGeneral() {
		// common part: create layout
		panGeneral = new Panel();
		panGeneral.setCaption("Persönliche Angaben");
		panGeneral.setImmediate(false);
		panGeneral.setWidth("-1px");
		panGeneral.setHeight("-1px");

		// formLayout_5
		formLayout_5 = buildFormLayout_5();
		panGeneral.setContent(formLayout_5);

		return panGeneral;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_5() {
		// common part: create layout
		formLayout_5 = new FormLayout();
		formLayout_5.setImmediate(false);
		formLayout_5.setWidth("320px");
		formLayout_5.setHeight("-1px");
		formLayout_5.setMargin(true);
		formLayout_5.setSpacing(true);

		// lblFirstName
		lblFirstName = new Label();
		lblFirstName.setCaption("Vorname:");
		lblFirstName.setImmediate(false);
		lblFirstName.setWidth("-1px");
		lblFirstName.setHeight("-1px");
		lblFirstName.setValue("Label");
		formLayout_5.addComponent(lblFirstName);

		// lblLastName
		lblLastName = new Label();
		lblLastName.setCaption("Nachname:");
		lblLastName.setImmediate(false);
		lblLastName.setWidth("-1px");
		lblLastName.setHeight("-1px");
		lblLastName.setValue("Label");
		formLayout_5.addComponent(lblLastName);

		// lblDateOfBirth
		lblDateOfBirth = new Label();
		lblDateOfBirth.setCaption("Geburtstag:");
		lblDateOfBirth.setImmediate(false);
		lblDateOfBirth.setWidth("-1px");
		lblDateOfBirth.setHeight("-1px");
		lblDateOfBirth.setValue("Label");
		formLayout_5.addComponent(lblDateOfBirth);

		// lblCivilStatus
		lblCivilStatus = new Label();
		lblCivilStatus.setCaption("Zivilstand: ");
		lblCivilStatus.setImmediate(false);
		lblCivilStatus.setWidth("-1px");
		lblCivilStatus.setHeight("-1px");
		lblCivilStatus.setValue("Label");
		formLayout_5.addComponent(lblCivilStatus);

		// lblGender
		lblGender = new Label();
		lblGender.setCaption("Geschlecht:");
		lblGender.setImmediate(false);
		lblGender.setWidth("-1px");
		lblGender.setHeight("-1px");
		lblGender.setValue("Label");
		formLayout_5.addComponent(lblGender);

		// lblReligion
		lblReligion = new Label();
		lblReligion.setCaption("Religion: ");
		lblReligion.setImmediate(false);
		lblReligion.setWidth("-1px");
		lblReligion.setHeight("-1px");
		lblReligion.setValue("Label");
		formLayout_5.addComponent(lblReligion);

		// lblNationality
		lblNationality = new Label();
		lblNationality.setCaption("Nationalität: ");
		lblNationality.setImmediate(false);
		lblNationality.setWidth("-1px");
		lblNationality.setHeight("-1px");
		lblNationality.setValue("Label");
		formLayout_5.addComponent(lblNationality);

		// lblMotherLanguage
		lblMotherLanguage = new Label();
		lblMotherLanguage.setCaption("Muttersprache: ");
		lblMotherLanguage.setImmediate(false);
		lblMotherLanguage.setWidth("-1px");
		lblMotherLanguage.setHeight("-1px");
		lblMotherLanguage.setValue("Label");
		formLayout_5.addComponent(lblMotherLanguage);

		// lblCommuncationLanguage
		lblCommuncationLanguage = new Label();
		lblCommuncationLanguage.setCaption("Verständigung: ");
		lblCommuncationLanguage.setImmediate(false);
		lblCommuncationLanguage.setWidth("-1px");
		lblCommuncationLanguage.setHeight("18px");
		lblCommuncationLanguage.setValue("Label");
		formLayout_5.addComponent(lblCommuncationLanguage);

		return formLayout_5;
	}

	@AutoGenerated
	private Panel buildPanAddress() {
		// common part: create layout
		panAddress = new Panel();
		panAddress.setCaption("Adresse & Kommunikation");
		panAddress.setImmediate(false);
		panAddress.setWidth("-1px");
		panAddress.setHeight("-1px");

		// formLayout_3
		formLayout_3 = buildFormLayout_3();
		panAddress.setContent(formLayout_3);

		return panAddress;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_3() {
		// common part: create layout
		formLayout_3 = new FormLayout();
		formLayout_3.setImmediate(false);
		formLayout_3.setWidth("320px");
		formLayout_3.setHeight("-1px");
		formLayout_3.setMargin(true);
		formLayout_3.setSpacing(true);

		// lblAddress
		lblAddress = new Label();
		lblAddress.setCaption("Adresse: ");
		lblAddress.setImmediate(false);
		lblAddress.setWidth("-1px");
		lblAddress.setHeight("-1px");
		lblAddress.setValue("Label");
		formLayout_3.addComponent(lblAddress);

		// lblPostalCode
		lblPostalCode = new Label();
		lblPostalCode.setCaption("Postleitzahl: ");
		lblPostalCode.setImmediate(false);
		lblPostalCode.setWidth("-1px");
		lblPostalCode.setHeight("-1px");
		lblPostalCode.setValue("Label");
		formLayout_3.addComponent(lblPostalCode);

		// lblHomeLocation
		lblHomeLocation = new Label();
		lblHomeLocation.setCaption("Ort: ");
		lblHomeLocation.setImmediate(false);
		lblHomeLocation.setWidth("-1px");
		lblHomeLocation.setHeight("-1px");
		lblHomeLocation.setValue("Label");
		formLayout_3.addComponent(lblHomeLocation);

		// lblCountry
		lblCountry = new Label();
		lblCountry.setCaption("Land: ");
		lblCountry.setImmediate(false);
		lblCountry.setWidth("-1px");
		lblCountry.setHeight("-1px");
		lblCountry.setValue("Label");
		formLayout_3.addComponent(lblCountry);

		// lblSpacer
		lblSpacer = new Label();
		lblSpacer.setCaption("  ");
		lblSpacer.setImmediate(false);
		lblSpacer.setWidth("-1px");
		lblSpacer.setHeight("-1px");
		lblSpacer.setValue("  ");
		formLayout_3.addComponent(lblSpacer);

		// lblPhonePrivate
		lblPhonePrivate = new Label();
		lblPhonePrivate.setCaption("Telefon p: ");
		lblPhonePrivate.setImmediate(false);
		lblPhonePrivate.setWidth("-1px");
		lblPhonePrivate.setHeight("-1px");
		lblPhonePrivate.setValue("Label");
		formLayout_3.addComponent(lblPhonePrivate);

		// lblPhoneBusiness
		lblPhoneBusiness = new Label();
		lblPhoneBusiness.setCaption("Telefon g: ");
		lblPhoneBusiness.setImmediate(false);
		lblPhoneBusiness.setWidth("-1px");
		lblPhoneBusiness.setHeight("-1px");
		lblPhoneBusiness.setValue("Label");
		formLayout_3.addComponent(lblPhoneBusiness);

		// lblMobilePhone
		lblMobilePhone = new Label();
		lblMobilePhone.setCaption("Mobil: ");
		lblMobilePhone.setImmediate(false);
		lblMobilePhone.setWidth("-1px");
		lblMobilePhone.setHeight("-1px");
		lblMobilePhone.setValue("Label");
		formLayout_3.addComponent(lblMobilePhone);

		// lblEmail
		lblEmail = new Label();
		lblEmail.setCaption("E-Mail:");
		lblEmail.setImmediate(false);
		lblEmail.setWidth("-1px");
		lblEmail.setHeight("-1px");
		lblEmail.setValue("Label");
		formLayout_3.addComponent(lblEmail);

		return formLayout_3;
	}

	@AutoGenerated
	private Panel buildPanComm() {
		// common part: create layout
		panComm = new Panel();
		panComm.setCaption("Kommunikation");
		panComm.setEnabled(false);
		panComm.setImmediate(false);
		panComm.setVisible(false);
		panComm.setWidth("-1px");
		panComm.setHeight("-1px");

		// formLayout_4
		formLayout_4 = new FormLayout();
		formLayout_4.setEnabled(false);
		formLayout_4.setImmediate(false);
		formLayout_4.setVisible(false);
		formLayout_4.setWidth("320px");
		formLayout_4.setHeight("-1px");
		formLayout_4.setMargin(false);
		formLayout_4.setSpacing(true);
		panComm.setContent(formLayout_4);

		return panComm;
	}

	@AutoGenerated
	private Panel buildPanFamily() {
		// common part: create layout
		panFamily = new Panel();
		panFamily.setCaption("Angehörige");
		panFamily.setImmediate(false);
		panFamily.setWidth("-1px");
		panFamily.setHeight("-1px");

		// formLayout_2
		formLayout_2 = buildFormLayout_2();
		panFamily.setContent(formLayout_2);

		return panFamily;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_2() {
		// common part: create layout
		formLayout_2 = new FormLayout();
		formLayout_2.setImmediate(false);
		formLayout_2.setWidth("320px");
		formLayout_2.setHeight("-1px");
		formLayout_2.setMargin(true);
		formLayout_2.setSpacing(true);

		// lblNextOfKin
		lblNextOfKin = new Label();
		lblNextOfKin.setCaption("Angehöriger: ");
		lblNextOfKin.setImmediate(false);
		lblNextOfKin.setWidth("-1px");
		lblNextOfKin.setHeight("-1px");
		lblNextOfKin.setValue("Label");
		formLayout_2.addComponent(lblNextOfKin);

		// lblNextOfKinFirstName
		lblNextOfKinFirstName = new Label();
		lblNextOfKinFirstName.setCaption("Vorname: ");
		lblNextOfKinFirstName.setImmediate(false);
		lblNextOfKinFirstName.setWidth("-1px");
		lblNextOfKinFirstName.setHeight("-1px");
		lblNextOfKinFirstName.setValue("Label");
		formLayout_2.addComponent(lblNextOfKinFirstName);

		// lblNextOfKinLastName
		lblNextOfKinLastName = new Label();
		lblNextOfKinLastName.setCaption("Nachname:");
		lblNextOfKinLastName.setImmediate(false);
		lblNextOfKinLastName.setWidth("-1px");
		lblNextOfKinLastName.setHeight("-1px");
		lblNextOfKinLastName.setValue("Label");
		formLayout_2.addComponent(lblNextOfKinLastName);

		// lblNextOfKinAddress
		lblNextOfKinAddress = new Label();
		lblNextOfKinAddress.setCaption("Adresse: ");
		lblNextOfKinAddress.setImmediate(false);
		lblNextOfKinAddress.setWidth("-1px");
		lblNextOfKinAddress.setHeight("-1px");
		lblNextOfKinAddress.setValue("Label");
		formLayout_2.addComponent(lblNextOfKinAddress);

		// lblNextOfKinPostalCode
		lblNextOfKinPostalCode = new Label();
		lblNextOfKinPostalCode.setCaption("Postleitzahl: ");
		lblNextOfKinPostalCode.setImmediate(false);
		lblNextOfKinPostalCode.setWidth("-1px");
		lblNextOfKinPostalCode.setHeight("-1px");
		lblNextOfKinPostalCode.setValue("Label");
		formLayout_2.addComponent(lblNextOfKinPostalCode);

		// lblNextOfKinHomeLocation
		lblNextOfKinHomeLocation = new Label();
		lblNextOfKinHomeLocation.setCaption("Ort: ");
		lblNextOfKinHomeLocation.setImmediate(false);
		lblNextOfKinHomeLocation.setWidth("-1px");
		lblNextOfKinHomeLocation.setHeight("-1px");
		lblNextOfKinHomeLocation.setValue("Label");
		formLayout_2.addComponent(lblNextOfKinHomeLocation);

		// lblNextOfKinPhone
		lblNextOfKinPhone = new Label();
		lblNextOfKinPhone.setCaption("Telefon: ");
		lblNextOfKinPhone.setImmediate(false);
		lblNextOfKinPhone.setWidth("-1px");
		lblNextOfKinPhone.setHeight("-1px");
		lblNextOfKinPhone.setValue("Label");
		formLayout_2.addComponent(lblNextOfKinPhone);

		return formLayout_2;
	}

	@AutoGenerated
	private Panel buildPanFamDoc() {
		// common part: create layout
		panFamDoc = new Panel();
		panFamDoc.setCaption("Hausarzt");
		panFamDoc.setImmediate(false);
		panFamDoc.setWidth("-1px");
		panFamDoc.setHeight("-1px");

		// formLayout_1
		formLayout_1 = buildFormLayout_1();
		panFamDoc.setContent(formLayout_1);

		return panFamDoc;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_1() {
		// common part: create layout
		formLayout_1 = new FormLayout();
		formLayout_1.setImmediate(false);
		formLayout_1.setWidth("320px");
		formLayout_1.setHeight("-1px");
		formLayout_1.setMargin(true);
		formLayout_1.setSpacing(true);

		// lblFamilyDoctorFirstName
		lblFamilyDoctorFirstName = new Label();
		lblFamilyDoctorFirstName.setCaption("Vorname:");
		lblFamilyDoctorFirstName.setImmediate(false);
		lblFamilyDoctorFirstName.setWidth("-1px");
		lblFamilyDoctorFirstName.setHeight("-1px");
		lblFamilyDoctorFirstName.setValue("Label");
		formLayout_1.addComponent(lblFamilyDoctorFirstName);

		// lblFamilyDoctorLastName
		lblFamilyDoctorLastName = new Label();
		lblFamilyDoctorLastName.setCaption("Nachname: ");
		lblFamilyDoctorLastName.setImmediate(false);
		lblFamilyDoctorLastName.setWidth("-1px");
		lblFamilyDoctorLastName.setHeight("-1px");
		lblFamilyDoctorLastName.setValue("Label");
		formLayout_1.addComponent(lblFamilyDoctorLastName);

		// lblFamilyDoctorAddress
		lblFamilyDoctorAddress = new Label();
		lblFamilyDoctorAddress.setCaption("Adresse: ");
		lblFamilyDoctorAddress.setImmediate(false);
		lblFamilyDoctorAddress.setWidth("-1px");
		lblFamilyDoctorAddress.setHeight("-1px");
		lblFamilyDoctorAddress.setValue("Label");
		formLayout_1.addComponent(lblFamilyDoctorAddress);

		// lblFamilyDoctorPostalCode
		lblFamilyDoctorPostalCode = new Label();
		lblFamilyDoctorPostalCode.setCaption("Postleitzahl: ");
		lblFamilyDoctorPostalCode.setImmediate(false);
		lblFamilyDoctorPostalCode.setWidth("-1px");
		lblFamilyDoctorPostalCode.setHeight("-1px");
		lblFamilyDoctorPostalCode.setValue("Label");
		formLayout_1.addComponent(lblFamilyDoctorPostalCode);

		// lblFamilyDoctorLocation
		lblFamilyDoctorLocation = new Label();
		lblFamilyDoctorLocation.setCaption("Ort: ");
		lblFamilyDoctorLocation.setImmediate(false);
		lblFamilyDoctorLocation.setWidth("-1px");
		lblFamilyDoctorLocation.setHeight("-1px");
		lblFamilyDoctorLocation.setValue("Label");
		formLayout_1.addComponent(lblFamilyDoctorLocation);

		// lblFamilyDoctorFax
		lblFamilyDoctorFax = new Label();
		lblFamilyDoctorFax.setCaption("Telefon: ");
		lblFamilyDoctorFax.setImmediate(false);
		lblFamilyDoctorFax.setWidth("-1px");
		lblFamilyDoctorFax.setHeight("-1px");
		lblFamilyDoctorFax.setValue("Label");
		formLayout_1.addComponent(lblFamilyDoctorFax);

		return formLayout_1;
	}

}
