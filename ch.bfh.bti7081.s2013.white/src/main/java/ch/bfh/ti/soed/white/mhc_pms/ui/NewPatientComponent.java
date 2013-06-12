package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.CivilStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.Gender;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.Reindeer;

/**
 * UI Class for a new patient
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 * 
 */
public class NewPatientComponent extends PmsComponentController {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label lblView;
	@AutoGenerated
	private Button btnAddPatient;
	@AutoGenerated
	private Panel panMaster;
	@AutoGenerated
	private GridLayout gridLayout_2;
	@AutoGenerated
	private Panel panFamDoc;
	@AutoGenerated
	private FormLayout formLayout_5;
	@AutoGenerated
	private TextField txtFamilyDoctorFax;
	@AutoGenerated
	private TextField txtFamilyDoctorLocation;
	@AutoGenerated
	private TextField txtFamilyDoctorPostalCode;
	@AutoGenerated
	private TextField txtFamilyDoctorAddress;
	@AutoGenerated
	private TextField txtFamilyDoctorLastName;
	@AutoGenerated
	private TextField txtFamilyDoctorFirstName;
	@AutoGenerated
	private Panel panFamily;
	@AutoGenerated
	private FormLayout formLayout_4;
	@AutoGenerated
	private TextField txtNextOfKinPhone;
	@AutoGenerated
	private TextField txtNextOfKinHomeLocation;
	@AutoGenerated
	private TextField txtNextOfKinPostalCode;
	@AutoGenerated
	private TextField txtNextOfKinAddress;
	@AutoGenerated
	private TextField txtNextOfKinLastName;
	@AutoGenerated
	private TextField txtNextOfKinFirstName;
	@AutoGenerated
	private TextField txtNextOfKin;
	@AutoGenerated
	private Panel panComm;
	@AutoGenerated
	private FormLayout formLayout_3;
	@AutoGenerated
	private Panel panAddress;
	@AutoGenerated
	private FormLayout formLayout_1;
	@AutoGenerated
	private TextField txtEmail;
	@AutoGenerated
	private TextField txtMobilePhone;
	@AutoGenerated
	private TextField txtPhoneBusiness;
	@AutoGenerated
	private TextField txtPhonePrivate;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private TextField txtCountry;
	@AutoGenerated
	private TextField txtHomeLocation;
	@AutoGenerated
	private TextField txtPostalCode;
	@AutoGenerated
	private TextField txtAddress;
	@AutoGenerated
	private Panel panGeneral;
	@AutoGenerated
	private FormLayout formLayout_2;
	@AutoGenerated
	private TextField txtMotherLanguage;
	@AutoGenerated
	private TextField txtCommuncationLanguage;
	@AutoGenerated
	private TextField txtNationality;
	@AutoGenerated
	private TextField txtReligion;
	@AutoGenerated
	private ComboBox cmbCivilStatus;
	@AutoGenerated
	private ComboBox cmbGender;
	@AutoGenerated
	private PopupDateField dateFieldDateOfBirth;
	@AutoGenerated
	private TextField txtLastName;
	@AutoGenerated
	private TextField txtFirstName;
	@AutoGenerated
	private Button btnCancel;
	private static final long serialVersionUID = 611645331656829049L;

	private BeanFieldGroup<PCase> fieldGroup;

	private PmsDataAccess pmsDataAccess;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public NewPatientComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		try {
			this.pmsDataAccess = PmsDataAccessCreator.getDataAccess();
			this.fieldGroup = new BeanFieldGroup<PCase>(PCase.class);

			this.initComboBoxes();
			this.lblView.addStyleName(Reindeer.LABEL_H2);
			this.lblView.setValue("Neuer Patient");

			this.addNewPatientButtonListener();
			this.addCancelPatientButtonListener();

			// TODO validation of input values
			this.dateFieldDateOfBirth.setRequiredError("Kein gültiges Datum!");
			// this.txtFirstName.setRequiredError("Kein gültiger Vorname!");
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	private void initComboBoxes() {
		this.cmbGender.addItem(Gender.FEMALE);
		this.cmbGender.addItem(Gender.MALE);

		this.cmbCivilStatus.addItem(CivilStatus.UNMARRIED);
		this.cmbCivilStatus.addItem(CivilStatus.MARRIED);
		this.cmbCivilStatus.addItem(CivilStatus.DIVORCED);
		this.cmbCivilStatus.addItem(CivilStatus.WIDOWED);
	}

	private void bindFields() {
		this.fieldGroup.setItemDataSource(new BeanItem<PCase>(new PCase(
				this.pmsDataAccess.getLoginUser())));

		this.bindBasicPatientFields();
		this.bindNextOfKinFields();
		this.bindFamilyDoctorFields();
	}

	private void addCancelPatientButtonListener() {
		this.btnCancel.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				NewPatientComponent.this.fieldGroup.discard();
				NewPatientComponent.this.fireUIActivationEvent(true);
				NewPatientComponent.this
						.fireComponentChangeEvent(NavigationEvent.PATIENT_BACK);
			}
		});
	}

	private void addNewPatientButtonListener() {
		this.btnAddPatient.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				NewPatientComponent.this.addPatient();
			}
		});
	}

	private void addPatient() {
		try {
			this.fieldGroup.commit();
			BeanItem<PCase> beanItem = this.fieldGroup.getItemDataSource();

			if (beanItem != null) {
				PCase pCaseItem = beanItem.getBean();
				pCaseItem.setNewCase();
				this.pmsDataAccess.getPCaseContainer().addEntity(pCaseItem);

				Notification.show("Patient gespeichert",
						Notification.Type.HUMANIZED_MESSAGE);
				this.fireUIActivationEvent(true);
				this.fireComponentChangeEvent(NavigationEvent.PATIENT_BACK);
				this.fireComponentChangeEvent(NavigationEvent.PCASE_BACK);
				this.firePCaseItemChangeEvent();
			}
		} catch (CommitException e) {
			Notification.show(
					"Bitte alle mit * markierten Felder korrekt ausfüllen!",
					Notification.Type.HUMANIZED_MESSAGE);
		} catch (Exception e) {
			Notification
					.show("Beim Speichern eines Patienten ist ein Fehler aufgetreten! Kontaktieren Sie den Systemadministrator.",
							Notification.Type.HUMANIZED_MESSAGE);
		}
	}

	private void bindFamilyDoctorFields() {
		this.fieldGroup.bind(this.txtFamilyDoctorFirstName,
				"familyDoctorFirstName");
		this.fieldGroup.bind(this.txtFamilyDoctorLastName,
				"familyDoctorLastName");
		this.fieldGroup
				.bind(this.txtFamilyDoctorAddress, "familyDoctorAddress");
		this.fieldGroup.bind(this.txtFamilyDoctorLocation,
				"familyDoctorLocation");
		this.fieldGroup.bind(this.txtFamilyDoctorPostalCode,
				"familyDoctorPostalCode");
		this.fieldGroup.bind(this.txtFamilyDoctorFax, "familyDoctorFax");
	}

	private void bindNextOfKinFields() {
		this.fieldGroup.bind(this.txtNextOfKin, "nextOfKin");
		this.fieldGroup.bind(this.txtNextOfKinFirstName, "nextOfKinFirstName");
		this.fieldGroup.bind(this.txtNextOfKinLastName, "nextOfKinLastName");
		this.fieldGroup.bind(this.txtNextOfKinAddress, "nextOfKinAddress");
		this.fieldGroup.bind(this.txtNextOfKinHomeLocation,
				"nextOfKinHomeLocation");
		this.fieldGroup
				.bind(this.txtNextOfKinPostalCode, "nextOfKinPostalCode");
		this.fieldGroup.bind(this.txtNextOfKinPhone, "nextOfKinPhone");
	}

	private void bindBasicPatientFields() {
		this.fieldGroup.bind(this.txtFirstName, "firstName");
		this.fieldGroup.bind(this.txtLastName, "lastName");
		this.fieldGroup.bind(this.cmbGender, "gender");
		this.fieldGroup.bind(this.cmbCivilStatus, "civilStatus");
		this.fieldGroup.bind(this.dateFieldDateOfBirth, "dateOfBirth");
		this.fieldGroup.bind(this.txtMotherLanguage, "motherLanguage");
		this.fieldGroup.bind(this.txtCommuncationLanguage,
				"communicationLanguage");
		this.fieldGroup.bind(this.txtNationality, "nationality");
		this.fieldGroup.bind(this.txtReligion, "religion");
		this.fieldGroup.bind(this.txtAddress, "address");
		this.fieldGroup.bind(this.txtHomeLocation, "homeLocation");
		this.fieldGroup.bind(this.txtPostalCode, "postalCode");
		this.fieldGroup.bind(this.txtCountry, "country");
		this.fieldGroup.bind(this.txtPhonePrivate, "phonePrivate");
		this.fieldGroup.bind(this.txtPhoneBusiness, "phoneBusiness");
		this.fieldGroup.bind(this.txtMobilePhone, "phoneMobile");
		this.fieldGroup.bind(this.txtEmail, "eMail");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController#enter(
	 * com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		try {
			this.pmsDataAccess = PmsDataAccessCreator.getDataAccess();
			this.pmsDataAccess.getPCaseContainer().refresh();
			this.bindFields();
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
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

		// btnCancel
		btnCancel = new Button();
		btnCancel.setCaption("Abbrechen");
		btnCancel.setImmediate(true);
		btnCancel.setWidth("-1px");
		btnCancel.setHeight("-1px");
		mainLayout.addComponent(btnCancel, "top:20.0px;left:390.0px;");

		// panMaster
		panMaster = buildPanMaster();
		mainLayout.addComponent(panMaster,
				"top:60.0px;right:20.0px;bottom:20.0px;left:20.0px;");

		// btnAddPatient
		btnAddPatient = new Button();
		btnAddPatient.setCaption("Patient hinzufügen");
		btnAddPatient.setImmediate(true);
		btnAddPatient.setWidth("-1px");
		btnAddPatient.setHeight("-1px");
		mainLayout.addComponent(btnAddPatient, "top:20.0px;left:250.0px;");

		// lblView
		lblView = new Label();
		lblView.setImmediate(false);
		lblView.setWidth("-1px");
		lblView.setHeight("-1px");
		lblView.setValue("Label");
		mainLayout.addComponent(lblView, "top:20.0px;left:21.0px;");

		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanMaster() {
		// common part: create layout
		panMaster = new Panel();
		panMaster.setImmediate(false);
		panMaster.setWidth("100.0%");
		panMaster.setHeight("100.0%");

		// gridLayout_2
		gridLayout_2 = buildGridLayout_2();
		panMaster.setContent(gridLayout_2);

		return panMaster;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_2() {
		// common part: create layout
		gridLayout_2 = new GridLayout();
		gridLayout_2.setImmediate(false);
		gridLayout_2.setWidth("-1px");
		gridLayout_2.setHeight("-1px");
		gridLayout_2.setMargin(false);
		gridLayout_2.setSpacing(true);
		gridLayout_2.setColumns(3);
		gridLayout_2.setRows(2);

		// panGeneral
		panGeneral = buildPanGeneral();
		gridLayout_2.addComponent(panGeneral, 0, 0);

		// panAddress
		panAddress = buildPanAddress();
		gridLayout_2.addComponent(panAddress, 1, 0);

		// panComm
		panComm = buildPanComm();
		gridLayout_2.addComponent(panComm, 2, 0);

		// panFamily
		panFamily = buildPanFamily();
		gridLayout_2.addComponent(panFamily, 0, 1);

		// panFamDoc
		panFamDoc = buildPanFamDoc();
		gridLayout_2.addComponent(panFamDoc, 1, 1);

		return gridLayout_2;
	}

	@AutoGenerated
	private Panel buildPanGeneral() {
		// common part: create layout
		panGeneral = new Panel();
		panGeneral.setCaption("Persönliche Angaben");
		panGeneral.setImmediate(false);
		panGeneral.setWidth("-1px");
		panGeneral.setHeight("-1px");

		// formLayout_2
		formLayout_2 = buildFormLayout_2();
		panGeneral.setContent(formLayout_2);

		return panGeneral;
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

		// txtFirstName
		txtFirstName = new TextField();
		txtFirstName.setCaption("Vorname: ");
		txtFirstName.setImmediate(false);
		txtFirstName.setWidth("160px");
		txtFirstName.setHeight("-1px");
		txtFirstName.setRequired(true);
		formLayout_2.addComponent(txtFirstName);

		// txtLastName
		txtLastName = new TextField();
		txtLastName.setCaption("Nachname: ");
		txtLastName.setImmediate(false);
		txtLastName.setWidth("160px");
		txtLastName.setHeight("-1px");
		txtLastName.setRequired(true);
		formLayout_2.addComponent(txtLastName);

		// dateFieldDateOfBirth
		dateFieldDateOfBirth = new PopupDateField();
		dateFieldDateOfBirth.setCaption("Geburtsdatum: ");
		dateFieldDateOfBirth.setImmediate(false);
		dateFieldDateOfBirth.setWidth("160px");
		dateFieldDateOfBirth.setHeight("-1px");
		dateFieldDateOfBirth.setRequired(true);
		formLayout_2.addComponent(dateFieldDateOfBirth);

		// cmbGender
		cmbGender = new ComboBox();
		cmbGender.setCaption("Geschlecht: ");
		cmbGender.setImmediate(false);
		cmbGender.setWidth("160px");
		cmbGender.setHeight("-1px");
		cmbGender.setRequired(true);
		formLayout_2.addComponent(cmbGender);

		// cmbCivilStatus
		cmbCivilStatus = new ComboBox();
		cmbCivilStatus.setCaption("Zivilstand:");
		cmbCivilStatus.setImmediate(false);
		cmbCivilStatus.setWidth("-1px");
		cmbCivilStatus.setHeight("-1px");
		formLayout_2.addComponent(cmbCivilStatus);

		// txtReligion
		txtReligion = new TextField();
		txtReligion.setCaption("Religion: ");
		txtReligion.setImmediate(false);
		txtReligion.setWidth("-1px");
		txtReligion.setHeight("-1px");
		formLayout_2.addComponent(txtReligion);

		// txtNationality
		txtNationality = new TextField();
		txtNationality.setCaption("Nationalität: ");
		txtNationality.setImmediate(false);
		txtNationality.setWidth("160px");
		txtNationality.setHeight("-1px");
		formLayout_2.addComponent(txtNationality);

		// txtCommuncationLanguage
		txtCommuncationLanguage = new TextField();
		txtCommuncationLanguage.setCaption("Verständigung:");
		txtCommuncationLanguage.setImmediate(false);
		txtCommuncationLanguage.setWidth("-1px");
		txtCommuncationLanguage.setHeight("-1px");
		formLayout_2.addComponent(txtCommuncationLanguage);

		// txtMotherLanguage
		txtMotherLanguage = new TextField();
		txtMotherLanguage.setCaption("Muttersprache: ");
		txtMotherLanguage.setImmediate(false);
		txtMotherLanguage.setWidth("160px");
		txtMotherLanguage.setHeight("-1px");
		formLayout_2.addComponent(txtMotherLanguage);

		return formLayout_2;
	}

	@AutoGenerated
	private Panel buildPanAddress() {
		// common part: create layout
		panAddress = new Panel();
		panAddress.setCaption("Adresse & Kommunikation");
		panAddress.setImmediate(false);
		panAddress.setWidth("-1px");
		panAddress.setHeight("-1px");

		// formLayout_1
		formLayout_1 = buildFormLayout_1();
		panAddress.setContent(formLayout_1);

		return panAddress;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_1() {
		// common part: create layout
		formLayout_1 = new FormLayout();
		formLayout_1.setImmediate(false);
		formLayout_1.setWidth("320px");
		formLayout_1.setHeight("100.0%");
		formLayout_1.setMargin(true);
		formLayout_1.setSpacing(true);

		// txtAddress
		txtAddress = new TextField();
		txtAddress.setCaption("Adresse: ");
		txtAddress.setImmediate(false);
		txtAddress.setWidth("160px");
		txtAddress.setHeight("-1px");
		formLayout_1.addComponent(txtAddress);

		// txtPostalCode
		txtPostalCode = new TextField();
		txtPostalCode.setCaption("Postleitzahl: ");
		txtPostalCode.setImmediate(false);
		txtPostalCode.setWidth("160px");
		txtPostalCode.setHeight("-1px");
		formLayout_1.addComponent(txtPostalCode);

		// txtHomeLocation
		txtHomeLocation = new TextField();
		txtHomeLocation.setCaption("Ort: ");
		txtHomeLocation.setImmediate(false);
		txtHomeLocation.setWidth("160px");
		txtHomeLocation.setHeight("-1px");
		formLayout_1.addComponent(txtHomeLocation);

		// txtCountry
		txtCountry = new TextField();
		txtCountry.setCaption("Land: ");
		txtCountry.setImmediate(false);
		txtCountry.setWidth("160px");
		txtCountry.setHeight("-1px");
		formLayout_1.addComponent(txtCountry);

		// label_2
		label_2 = new Label();
		label_2.setCaption("  ");
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("  ");
		formLayout_1.addComponent(label_2);

		// txtPhonePrivate
		txtPhonePrivate = new TextField();
		txtPhonePrivate.setCaption("Telefon p: ");
		txtPhonePrivate.setImmediate(false);
		txtPhonePrivate.setWidth("160px");
		txtPhonePrivate.setHeight("-1px");
		formLayout_1.addComponent(txtPhonePrivate);

		// txtPhoneBusiness
		txtPhoneBusiness = new TextField();
		txtPhoneBusiness.setCaption("Telefon g: ");
		txtPhoneBusiness.setImmediate(false);
		txtPhoneBusiness.setWidth("160px");
		txtPhoneBusiness.setHeight("-1px");
		formLayout_1.addComponent(txtPhoneBusiness);

		// txtMobilePhone
		txtMobilePhone = new TextField();
		txtMobilePhone.setCaption("Mobil: ");
		txtMobilePhone.setImmediate(false);
		txtMobilePhone.setWidth("160px");
		txtMobilePhone.setHeight("-1px");
		formLayout_1.addComponent(txtMobilePhone);

		// txtEmail
		txtEmail = new TextField();
		txtEmail.setCaption("E-Mail: ");
		txtEmail.setImmediate(false);
		txtEmail.setWidth("160px");
		txtEmail.setHeight("-1px");
		formLayout_1.addComponent(txtEmail);

		return formLayout_1;
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

		// formLayout_3
		formLayout_3 = new FormLayout();
		formLayout_3.setEnabled(false);
		formLayout_3.setImmediate(false);
		formLayout_3.setVisible(false);
		formLayout_3.setWidth("320px");
		formLayout_3.setHeight("100.0%");
		formLayout_3.setMargin(true);
		formLayout_3.setSpacing(true);
		panComm.setContent(formLayout_3);

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

		// formLayout_4
		formLayout_4 = buildFormLayout_4();
		panFamily.setContent(formLayout_4);

		return panFamily;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_4() {
		// common part: create layout
		formLayout_4 = new FormLayout();
		formLayout_4.setImmediate(false);
		formLayout_4.setWidth("320px");
		formLayout_4.setHeight("100.0%");
		formLayout_4.setMargin(true);
		formLayout_4.setSpacing(true);

		// txtNextOfKin
		txtNextOfKin = new TextField();
		txtNextOfKin.setCaption("Angehöriger: ");
		txtNextOfKin.setImmediate(false);
		txtNextOfKin.setWidth("160px");
		txtNextOfKin.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKin);

		// txtNextOfKinFirstName
		txtNextOfKinFirstName = new TextField();
		txtNextOfKinFirstName.setCaption("Vorname: ");
		txtNextOfKinFirstName.setImmediate(false);
		txtNextOfKinFirstName.setWidth("160px");
		txtNextOfKinFirstName.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKinFirstName);

		// txtNextOfKinLastName
		txtNextOfKinLastName = new TextField();
		txtNextOfKinLastName.setCaption("Nachname: ");
		txtNextOfKinLastName.setImmediate(false);
		txtNextOfKinLastName.setWidth("160px");
		txtNextOfKinLastName.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKinLastName);

		// txtNextOfKinAddress
		txtNextOfKinAddress = new TextField();
		txtNextOfKinAddress.setCaption("Adresse: ");
		txtNextOfKinAddress.setImmediate(false);
		txtNextOfKinAddress.setWidth("160px");
		txtNextOfKinAddress.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKinAddress);

		// txtNextOfKinPostalCode
		txtNextOfKinPostalCode = new TextField();
		txtNextOfKinPostalCode.setCaption("Postleitzahl: ");
		txtNextOfKinPostalCode.setImmediate(false);
		txtNextOfKinPostalCode.setWidth("160px");
		txtNextOfKinPostalCode.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKinPostalCode);

		// txtNextOfKinHomeLocation
		txtNextOfKinHomeLocation = new TextField();
		txtNextOfKinHomeLocation.setCaption("Ort: ");
		txtNextOfKinHomeLocation.setImmediate(false);
		txtNextOfKinHomeLocation.setWidth("160px");
		txtNextOfKinHomeLocation.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKinHomeLocation);

		// txtNextOfKinPhone
		txtNextOfKinPhone = new TextField();
		txtNextOfKinPhone.setCaption("Telefon: ");
		txtNextOfKinPhone.setImmediate(false);
		txtNextOfKinPhone.setWidth("160px");
		txtNextOfKinPhone.setHeight("-1px");
		formLayout_4.addComponent(txtNextOfKinPhone);

		return formLayout_4;
	}

	@AutoGenerated
	private Panel buildPanFamDoc() {
		// common part: create layout
		panFamDoc = new Panel();
		panFamDoc.setCaption("Hausarzt");
		panFamDoc.setImmediate(false);
		panFamDoc.setWidth("320px");
		panFamDoc.setHeight("-1px");

		// formLayout_5
		formLayout_5 = buildFormLayout_5();
		panFamDoc.setContent(formLayout_5);

		return panFamDoc;
	}

	@AutoGenerated
	private FormLayout buildFormLayout_5() {
		// common part: create layout
		formLayout_5 = new FormLayout();
		formLayout_5.setImmediate(false);
		formLayout_5.setWidth("100.0%");
		formLayout_5.setHeight("100.0%");
		formLayout_5.setMargin(true);
		formLayout_5.setSpacing(true);

		// txtFamilyDoctorFirstName
		txtFamilyDoctorFirstName = new TextField();
		txtFamilyDoctorFirstName.setCaption("Vorname:");
		txtFamilyDoctorFirstName.setImmediate(false);
		txtFamilyDoctorFirstName.setWidth("160px");
		txtFamilyDoctorFirstName.setHeight("-1px");
		formLayout_5.addComponent(txtFamilyDoctorFirstName);

		// txtFamilyDoctorLastName
		txtFamilyDoctorLastName = new TextField();
		txtFamilyDoctorLastName.setCaption("Nachname: ");
		txtFamilyDoctorLastName.setImmediate(false);
		txtFamilyDoctorLastName.setWidth("160px");
		txtFamilyDoctorLastName.setHeight("-1px");
		formLayout_5.addComponent(txtFamilyDoctorLastName);

		// txtFamilyDoctorAddress
		txtFamilyDoctorAddress = new TextField();
		txtFamilyDoctorAddress.setCaption("Adresse: ");
		txtFamilyDoctorAddress.setImmediate(false);
		txtFamilyDoctorAddress.setWidth("160px");
		txtFamilyDoctorAddress.setHeight("-1px");
		formLayout_5.addComponent(txtFamilyDoctorAddress);

		// txtFamilyDoctorPostalCode
		txtFamilyDoctorPostalCode = new TextField();
		txtFamilyDoctorPostalCode.setCaption("Postleitzahl: ");
		txtFamilyDoctorPostalCode.setImmediate(false);
		txtFamilyDoctorPostalCode.setWidth("160px");
		txtFamilyDoctorPostalCode.setHeight("-1px");
		formLayout_5.addComponent(txtFamilyDoctorPostalCode);

		// txtFamilyDoctorLocation
		txtFamilyDoctorLocation = new TextField();
		txtFamilyDoctorLocation.setCaption("Ort: ");
		txtFamilyDoctorLocation.setImmediate(false);
		txtFamilyDoctorLocation.setWidth("160px");
		txtFamilyDoctorLocation.setHeight("-1px");
		formLayout_5.addComponent(txtFamilyDoctorLocation);

		// txtFamilyDoctorFax
		txtFamilyDoctorFax = new TextField();
		txtFamilyDoctorFax.setCaption("Telefon: ");
		txtFamilyDoctorFax.setImmediate(false);
		txtFamilyDoctorFax.setWidth("160px");
		txtFamilyDoctorFax.setHeight("-1px");
		formLayout_5.addComponent(txtFamilyDoctorFax);

		return formLayout_5;
	}

}
