package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.EditEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.data.PCase;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.Gender;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;

/**
 * @author		Gruppe White, I2p, BFH Bern, https://github.com/fabaff/ch.bfh.bti7081.s2013.white
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * 
 */
public class NewPatientComponent extends PmsComponentController {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private TextField txtFamilyDoctorPostalCode;
	@AutoGenerated
	private TextField txtFamilyDoctorFax;
	@AutoGenerated
	private TextField txtFamilyDoctorLocation;
	@AutoGenerated
	private TextField txtFamilyDoctorFirstName;
	@AutoGenerated
	private TextField txtFamilyDoctorLastName;
	@AutoGenerated
	private TextField txtFamilyDoctorAddress;
	@AutoGenerated
	private TextField txtNextOfKinFirstName;
	@AutoGenerated
	private TextField txtNextOfKinLastName;
	@AutoGenerated
	private TextField txtNextOfKinAddress;
	@AutoGenerated
	private TextField txtNextOfKinPhone;
	@AutoGenerated
	private TextField txtNextOfKinHomeLocation;
	@AutoGenerated
	private TextField txtNextOfKinPostalCode;
	@AutoGenerated
	private TextField txtPostalCode;
	@AutoGenerated
	private TextField txtHomeLocation;
	@AutoGenerated
	private TextField txtCountry;
	@AutoGenerated
	private TextField txtMobilePhone;
	@AutoGenerated
	private TextField txtPhoneBusiness;
	@AutoGenerated
	private TextField txtEmail;
	@AutoGenerated
	private TextField txtNextOfKin;
	@AutoGenerated
	private TextField txtPhonePrivate;
	@AutoGenerated
	private TextField txtAddress;
	@AutoGenerated
	private TextField txtReligion;
	@AutoGenerated
	private TextField txtCommuncationLanguage;
	@AutoGenerated
	private TextField txtNationality;
	@AutoGenerated
	private TextField txtCivilStatus;
	@AutoGenerated
	private TextField txtFirstName;
	@AutoGenerated
	private ComboBox cmbGender;
	@AutoGenerated
	private PopupDateField dateFieldDateOfBirth;
	@AutoGenerated
	private TextField txtLastName;
	@AutoGenerated
	private TextField txtMotherLanguage;
	@AutoGenerated
	private Button btnCancel;
	@AutoGenerated
	private Button btnAddPatient;
	private static final long serialVersionUID = 611645331656829049L;

	private BeanFieldGroup<PCase> fieldGroup;
	
	private PmsDataAccess dataAccess;
	
	private BeanItem<PCase> newPatientItem;

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

		this.dataAccess = PmsDataAccess.getInstance();
		this.dataAccess.getPCaseContainer().refresh();
		this.fieldGroup = new BeanFieldGroup<PCase>(PCase.class);
		
		// TODO bearbeitung sperren
		this.cmbGender.addItem(Gender.Weiblich);
		this.cmbGender.addItem(Gender.Männlich);
		this.cmbGender.setValue(Gender.Weiblich);
		
		this.bindFields();
		this.addListeners();
	}

	private void bindFields() {
		// TODO propertyId dynamisch auslesen
		// TODO Eingabevalidierung
		this.newPatientItem = new BeanItem<PCase>(new PCase(this.dataAccess.getUser()));
		this.fieldGroup.setItemDataSource(this.newPatientItem);
		this.fieldGroup.bind(this.txtFirstName, "firstName");
		this.fieldGroup.bind(this.txtLastName, "lastName");
		this.fieldGroup.bind(this.cmbGender, "gender");
		this.fieldGroup.bind(this.dateFieldDateOfBirth, "dateOfBirth");
		this.fieldGroup.bind(this.txtMotherLanguage, "motherLanguage");
		this.fieldGroup.bind(this.txtCommuncationLanguage, "communcationLanguage");
		this.fieldGroup.bind(this.txtCivilStatus, "civilStatus");
		this.fieldGroup.bind(this.txtNationality, "nationality");
		this.fieldGroup.bind(this.txtReligion, "religion");
		this.fieldGroup.bind(this.txtAddress, "address");
		this.fieldGroup.bind(this.txtHomeLocation, "homeLocation");
		this.fieldGroup.bind(this.txtPostalCode, "postalCode");
		this.fieldGroup.bind(this.txtCountry, "country");
		this.fieldGroup.bind(this.txtPhonePrivate, "phonePrivate");
		this.fieldGroup.bind(this.txtPhoneBusiness, "phoneBusiness");
		this.fieldGroup.bind(this.txtMobilePhone, "mobilePhone");
		this.fieldGroup.bind(this.txtEmail, "eMail");
		
		this.fieldGroup.bind(this.txtNextOfKin, "nextOfKin");
		this.fieldGroup.bind(this.txtNextOfKinFirstName, "nextOfKinFirstName");
		this.fieldGroup.bind(this.txtNextOfKinLastName, "nextOfKinLastName");
		this.fieldGroup.bind(this.txtNextOfKinAddress, "nextOfKinAddress");
		this.fieldGroup.bind(this.txtNextOfKinHomeLocation, "nextOfKinHomeLocation");
		this.fieldGroup.bind(this.txtNextOfKinPostalCode, "nextOfKinPostalCode");
		this.fieldGroup.bind(this.txtNextOfKinPhone, "nextOfKinPhone");
		
		this.fieldGroup.bind(this.txtFamilyDoctorFirstName, "familyDoctorFirstName");
		this.fieldGroup.bind(this.txtFamilyDoctorLastName, "familyDoctorLastName");
		this.fieldGroup.bind(this.txtFamilyDoctorAddress, "familyDoctorAddress");
		this.fieldGroup.bind(this.txtFamilyDoctorLocation, "familyDoctorLocation");
		this.fieldGroup.bind(this.txtFamilyDoctorPostalCode, "familyDoctorPostalCode");
		this.fieldGroup.bind(this.txtFamilyDoctorFax, "familyDoctorFax");
	}

	private void addListeners() {
		
		this.btnAddPatient.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					NewPatientComponent.this.fieldGroup.commit();
					
					// TODO bessere Trennung Model und View
					Object id = NewPatientComponent.this.dataAccess.getPCaseContainer().addEntity(NewPatientComponent.this.newPatientItem.getBean());
					NewPatientComponent.this.dataAccess.getPCaseContainer().commit();
					NewPatientComponent.this.dataAccess.getPCaseContainer().refresh();
					
					NewPatientComponent.this.bindFields();
					NewPatientComponent.this.fireUIActivationEvent(true);
					NewPatientComponent.this.fireComponentChangeEvent(EditEvent.PATIENT_BACK);
					NewPatientComponent.this.firePCaseItemChangeEvent(id);
				} catch (CommitException e) {
					// TODO Exception Handling
				}
			}
		});

		this.btnCancel.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				NewPatientComponent.this.fieldGroup.discard();
				NewPatientComponent.this.fireUIActivationEvent(true);
				NewPatientComponent.this.fireComponentChangeEvent(EditEvent.PATIENT_BACK);
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
		
		// btnAddPatient
		btnAddPatient = new Button();
		btnAddPatient.setCaption("Patient hinzufügen");
		btnAddPatient.setImmediate(true);
		btnAddPatient.setWidth("140px");
		btnAddPatient.setHeight("-1px");
		mainLayout.addComponent(btnAddPatient, "top:580.0px;left:20.0px;");
		
		// btnCancel
		btnCancel = new Button();
		btnCancel.setCaption("Abbrechen");
		btnCancel.setImmediate(true);
		btnCancel.setWidth("-1px");
		btnCancel.setHeight("-1px");
		mainLayout.addComponent(btnCancel, "top:580.0px;left:200.0px;");
		
		// txtMotherLanguage
		txtMotherLanguage = new TextField();
		txtMotherLanguage.setCaption("Muttersprache: ");
		txtMotherLanguage.setImmediate(false);
		txtMotherLanguage.setWidth("160px");
		txtMotherLanguage.setHeight("-1px");
		mainLayout.addComponent(txtMotherLanguage, "top:100.0px;left:20.0px;");
		
		// txtLastName
		txtLastName = new TextField();
		txtLastName.setCaption("Nachname: ");
		txtLastName.setImmediate(false);
		txtLastName.setWidth("160px");
		txtLastName.setHeight("-1px");
		mainLayout.addComponent(txtLastName, "top:40.0px;left:220.0px;");
		
		// dateFieldDateOfBirth
		dateFieldDateOfBirth = new PopupDateField();
		dateFieldDateOfBirth.setCaption("Geburtsdatum: ");
		dateFieldDateOfBirth.setImmediate(false);
		dateFieldDateOfBirth.setWidth("160px");
		dateFieldDateOfBirth.setHeight("-1px");
		mainLayout.addComponent(dateFieldDateOfBirth,
				"top:40.0px;left:620.0px;");
		
		// cmbGender
		cmbGender = new ComboBox();
		cmbGender.setCaption("Geschlecht: ");
		cmbGender.setImmediate(false);
		cmbGender.setWidth("160px");
		cmbGender.setHeight("-1px");
		mainLayout.addComponent(cmbGender, "top:40.0px;left:420.0px;");
		
		// txtFirstName
		txtFirstName = new TextField();
		txtFirstName.setCaption("Vorname: ");
		txtFirstName.setImmediate(false);
		txtFirstName.setWidth("160px");
		txtFirstName.setHeight("-1px");
		mainLayout.addComponent(txtFirstName, "top:40.0px;left:20.0px;");
		
		// txtCivilStatus
		txtCivilStatus = new TextField();
		txtCivilStatus.setCaption("Zivilstand: ");
		txtCivilStatus.setImmediate(false);
		txtCivilStatus.setWidth("160px");
		txtCivilStatus.setHeight("-1px");
		mainLayout.addComponent(txtCivilStatus, "top:100.0px;left:420.0px;");
		
		// txtNationality
		txtNationality = new TextField();
		txtNationality.setCaption("Nationalität: ");
		txtNationality.setImmediate(false);
		txtNationality.setWidth("160px");
		txtNationality.setHeight("-1px");
		mainLayout.addComponent(txtNationality, "top:100.0px;left:620.0px;");
		
		// txtCommuncationLanguage
		txtCommuncationLanguage = new TextField();
		txtCommuncationLanguage.setCaption("Verständigung: ");
		txtCommuncationLanguage.setImmediate(false);
		txtCommuncationLanguage.setWidth("160px");
		txtCommuncationLanguage.setHeight("-1px");
		mainLayout.addComponent(txtCommuncationLanguage,
				"top:100.0px;left:220.0px;");
		
		// txtReligion
		txtReligion = new TextField();
		txtReligion.setCaption("Religion: ");
		txtReligion.setImmediate(false);
		txtReligion.setWidth("160px");
		txtReligion.setHeight("-1px");
		mainLayout.addComponent(txtReligion, "top:160.0px;left:20.0px;");
		
		// txtAddress
		txtAddress = new TextField();
		txtAddress.setCaption("Adresse: ");
		txtAddress.setImmediate(false);
		txtAddress.setWidth("160px");
		txtAddress.setHeight("-1px");
		mainLayout.addComponent(txtAddress, "top:160.0px;left:220.0px;");
		
		// txtPhonePrivate
		txtPhonePrivate = new TextField();
		txtPhonePrivate.setCaption("Telefon Privat: ");
		txtPhonePrivate.setImmediate(false);
		txtPhonePrivate.setWidth("160px");
		txtPhonePrivate.setHeight("-1px");
		mainLayout.addComponent(txtPhonePrivate, "top:220.0px;left:220.0px;");
		
		// txtNextOfKin
		txtNextOfKin = new TextField();
		txtNextOfKin.setCaption("Angehöriger: ");
		txtNextOfKin.setImmediate(false);
		txtNextOfKin.setWidth("160px");
		txtNextOfKin.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKin, "top:340.0px;left:20.0px;");
		
		// txtEmail
		txtEmail = new TextField();
		txtEmail.setCaption("E-Mail: ");
		txtEmail.setImmediate(false);
		txtEmail.setWidth("160px");
		txtEmail.setHeight("-1px");
		mainLayout.addComponent(txtEmail, "top:280.0px;left:20.0px;");
		
		// txtPhoneBusiness
		txtPhoneBusiness = new TextField();
		txtPhoneBusiness.setCaption("Telefon Geschäft: ");
		txtPhoneBusiness.setImmediate(false);
		txtPhoneBusiness.setWidth("160px");
		txtPhoneBusiness.setHeight("-1px");
		mainLayout.addComponent(txtPhoneBusiness, "top:220.0px;left:420.0px;");
		
		// txtMobilePhone
		txtMobilePhone = new TextField();
		txtMobilePhone.setCaption("Handy: ");
		txtMobilePhone.setImmediate(false);
		txtMobilePhone.setWidth("160px");
		txtMobilePhone.setHeight("-1px");
		mainLayout.addComponent(txtMobilePhone, "top:220.0px;left:620.0px;");
		
		// txtCountry
		txtCountry = new TextField();
		txtCountry.setCaption("Land: ");
		txtCountry.setImmediate(false);
		txtCountry.setWidth("160px");
		txtCountry.setHeight("-1px");
		mainLayout.addComponent(txtCountry, "top:220.0px;left:20.0px;");
		
		// txtHomeLocation
		txtHomeLocation = new TextField();
		txtHomeLocation.setCaption("Ort: ");
		txtHomeLocation.setImmediate(false);
		txtHomeLocation.setWidth("160px");
		txtHomeLocation.setHeight("-1px");
		mainLayout.addComponent(txtHomeLocation, "top:160.0px;left:620.0px;");
		
		// txtPostalCode
		txtPostalCode = new TextField();
		txtPostalCode.setCaption("Postleitzahl: ");
		txtPostalCode.setImmediate(false);
		txtPostalCode.setWidth("160px");
		txtPostalCode.setHeight("-1px");
		mainLayout.addComponent(txtPostalCode, "top:160.0px;left:420.0px;");
		
		// txtNextOfKinPostalCode
		txtNextOfKinPostalCode = new TextField();
		txtNextOfKinPostalCode.setCaption("Postleitzahl: ");
		txtNextOfKinPostalCode.setImmediate(false);
		txtNextOfKinPostalCode.setWidth("160px");
		txtNextOfKinPostalCode.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKinPostalCode,
				"top:400.0px;left:20.0px;");
		
		// txtNextOfKinHomeLocation
		txtNextOfKinHomeLocation = new TextField();
		txtNextOfKinHomeLocation.setCaption("Ort: ");
		txtNextOfKinHomeLocation.setImmediate(false);
		txtNextOfKinHomeLocation.setWidth("160px");
		txtNextOfKinHomeLocation.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKinHomeLocation,
				"top:400.0px;left:220.0px;");
		
		// txtNextOfKinPhone
		txtNextOfKinPhone = new TextField();
		txtNextOfKinPhone.setCaption("Telefon: ");
		txtNextOfKinPhone.setImmediate(false);
		txtNextOfKinPhone.setWidth("160px");
		txtNextOfKinPhone.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKinPhone, "top:400.0px;left:420.0px;");
		
		// txtNextOfKinAddress
		txtNextOfKinAddress = new TextField();
		txtNextOfKinAddress.setCaption("Adresse: ");
		txtNextOfKinAddress.setImmediate(false);
		txtNextOfKinAddress.setWidth("160px");
		txtNextOfKinAddress.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKinAddress,
				"top:340.0px;left:620.0px;");
		
		// txtNextOfKinLastName
		txtNextOfKinLastName = new TextField();
		txtNextOfKinLastName.setCaption("Nachname: ");
		txtNextOfKinLastName.setImmediate(false);
		txtNextOfKinLastName.setWidth("160px");
		txtNextOfKinLastName.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKinLastName,
				"top:340.0px;left:420.0px;");
		
		// txtNextOfKinFirstName
		txtNextOfKinFirstName = new TextField();
		txtNextOfKinFirstName.setCaption("Vorname: ");
		txtNextOfKinFirstName.setImmediate(false);
		txtNextOfKinFirstName.setWidth("160px");
		txtNextOfKinFirstName.setHeight("-1px");
		mainLayout.addComponent(txtNextOfKinFirstName,
				"top:340.0px;left:220.0px;");
		
		// txtFamilyDoctorAddress
		txtFamilyDoctorAddress = new TextField();
		txtFamilyDoctorAddress.setCaption("Adresse Hausarzt: ");
		txtFamilyDoctorAddress.setImmediate(false);
		txtFamilyDoctorAddress.setWidth("160px");
		txtFamilyDoctorAddress.setHeight("-1px");
		mainLayout.addComponent(txtFamilyDoctorAddress,
				"top:460.0px;left:420.0px;");
		
		// txtFamilyDoctorLastName
		txtFamilyDoctorLastName = new TextField();
		txtFamilyDoctorLastName.setCaption("Nachname Hausarzt: ");
		txtFamilyDoctorLastName.setImmediate(false);
		txtFamilyDoctorLastName.setWidth("160px");
		txtFamilyDoctorLastName.setHeight("-1px");
		mainLayout.addComponent(txtFamilyDoctorLastName,
				"top:460.0px;left:220.0px;");
		
		// txtFamilyDoctorFirstName
		txtFamilyDoctorFirstName = new TextField();
		txtFamilyDoctorFirstName.setCaption("Vorname Hausarzt:");
		txtFamilyDoctorFirstName.setImmediate(false);
		txtFamilyDoctorFirstName.setWidth("160px");
		txtFamilyDoctorFirstName.setHeight("-1px");
		mainLayout.addComponent(txtFamilyDoctorFirstName,
				"top:460.0px;left:20.0px;");
		
		// txtFamilyDoctorLocation
		txtFamilyDoctorLocation = new TextField();
		txtFamilyDoctorLocation.setCaption("Ort Hausarzt: ");
		txtFamilyDoctorLocation.setImmediate(false);
		txtFamilyDoctorLocation.setWidth("160px");
		txtFamilyDoctorLocation.setHeight("-1px");
		mainLayout.addComponent(txtFamilyDoctorLocation,
				"top:520.0px;left:20.0px;");
		
		// txtFamilyDoctorFax
		txtFamilyDoctorFax = new TextField();
		txtFamilyDoctorFax.setCaption("Fax Hausarzt: ");
		txtFamilyDoctorFax.setImmediate(false);
		txtFamilyDoctorFax.setWidth("160px");
		txtFamilyDoctorFax.setHeight("-1px");
		mainLayout
				.addComponent(txtFamilyDoctorFax, "top:520.0px;left:220.0px;");
		
		// txtFamilyDoctorPostalCode
		txtFamilyDoctorPostalCode = new TextField();
		txtFamilyDoctorPostalCode.setCaption("Postleitzahl Hausarzt: ");
		txtFamilyDoctorPostalCode.setImmediate(false);
		txtFamilyDoctorPostalCode.setWidth("160px");
		txtFamilyDoctorPostalCode.setHeight("-1px");
		mainLayout.addComponent(txtFamilyDoctorPostalCode,
				"top:460.0px;left:620.0px;");
		
		return mainLayout;
	}

}
