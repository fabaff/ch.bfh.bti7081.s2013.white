package ch.bfh.ti.soed.white.mhc_pms.ui;

import ch.bfh.ti.soed.white.mhc_pms.controller.NavigationEvent;
import ch.bfh.ti.soed.white.mhc_pms.controller.PmsComponentController;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.UnknownUserException;
import ch.bfh.ti.soed.white.mhc_pms.util.Hash;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * UI Class for login process.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public class LoginComponent extends PmsComponentController {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = -1300264546034541484L;
	@AutoGenerated
	private Button btnLogin;
	@AutoGenerated
	private FormLayout formLayout_2;
	@AutoGenerated
	private Label lblTitle;
	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private Panel panMaster;
	@AutoGenerated
	private PasswordField txtPassword;
	@AutoGenerated
	private TextField txtUser;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public LoginComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		this.addLoginButtonClickListener();

		// Static UI elements
		this.lblTitle.addStyleName(Reindeer.LABEL_H1);

		// If security is not a concern, this helpers should be activated.
		// this.txtUser.setRequiredError("Bitte Benutzernamen eingeben");
		// this.txtPassword.setRequiredError("Bitte Passwort eingeben");
	}

	private void addLoginButtonClickListener() {
		this.btnLogin.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 3995263810421104513L;

			@Override
			public void buttonClick(ClickEvent event) {
				LoginComponent.this.startLogin();
			}
		});
	}

	
	@AutoGenerated
	private FormLayout buildFormLayout_2() {
		// common part: create layout
		formLayout_2 = new FormLayout();
		formLayout_2.setImmediate(false);
		formLayout_2.setWidth("-1px");
		formLayout_2.setHeight("-1px");
		formLayout_2.setMargin(false);
		formLayout_2.setSpacing(true);

		// txtUser
		txtUser = new TextField();
		txtUser.setCaption("Benutzername:");
		txtUser.setImmediate(false);
		txtUser.setWidth("-1px");
		txtUser.setHeight("-1px");
		txtUser.setRequired(true);
		formLayout_2.addComponent(txtUser);

		// txtPassword
		txtPassword = new PasswordField();
		txtPassword.setCaption("Password: ");
		txtPassword.setImmediate(false);
		txtPassword.setWidth("-1px");
		txtPassword.setHeight("-1px");
		txtPassword.setRequired(true);
		formLayout_2.addComponent(txtPassword);

		return formLayout_2;
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setColumns(3);
		mainLayout.setRows(3);

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// panMaster
		panMaster = buildPanMaster();
		mainLayout.addComponent(panMaster, 1, 1);

		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanMaster() {
		// common part: create layout
		panMaster = new Panel();
		panMaster.setImmediate(false);
		panMaster.setWidth("-1px");
		panMaster.setHeight("-1px");

		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		panMaster.setContent(verticalLayout_1);

		return panMaster;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("100.0%");
		verticalLayout_1.setMargin(true);
		verticalLayout_1.setSpacing(true);

		// lblTitle
		lblTitle = new Label();
		lblTitle.setImmediate(false);
		lblTitle.setWidth("-1px");
		lblTitle.setHeight("-1px");
		lblTitle.setValue("Anmeldung MHC PMS");
		verticalLayout_1.addComponent(lblTitle);

		// formLayout_2
		formLayout_2 = buildFormLayout_2();
		verticalLayout_1.addComponent(formLayout_2);

		// btnLogin
		btnLogin = new Button();
		btnLogin.setCaption("Login");
		btnLogin.setImmediate(true);
		btnLogin.setWidth("-1px");
		btnLogin.setHeight("-1px");
		verticalLayout_1.addComponent(btnLogin);

		return verticalLayout_1;
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
		if (event.getOldView() != null) {
			try {
				this.getUI().getSession().close();
				Notification.show(PmsDataAccessCreator.getDataAccess()
						.getLoginUser().getUserName()
						+ " wurde abgemeldet!",
						Notification.Type.HUMANIZED_MESSAGE);
			} catch (UnknownUserException e) {
				Notification.show(e.getInvalidUserMessage(),
						Notification.Type.HUMANIZED_MESSAGE);
			}
		}
	}

	/**
	 * GUI and database interaction. Get values from the input field, 
	 * hash the password, check the database entries for valid information, 
	 * and 
	 * 
	 * @return the loginOK boolean
	 */
	private String login() throws UnknownUserException {
		String userName = txtUser.getValue().toUpperCase();
		String password = Hash.MD5(txtPassword.getValue());
		boolean loginOK = PmsDataAccessCreator.getDataAccess()
				.getPmsUserContainer().checkLogin(userName, password);
		// For DEBUG purposes only
		//boolean loginOK = PmsDataAccessCreator.getDataAccess()
		//		.getPmsUserContainer().checkLogin("hans.muster", "MD5 hash of the password");	
		// Return user name (login OK) or an empty string (login failed)
		return loginOK ? userName : "";
	}

	/**
	 * Move to the main panel if login is OK and gives feedback to
	 * the user with notifications.
	 */
	private void startLogin() {
		try {
			String userName = this.login();

			if (!userName.isEmpty()) {
				PmsDataAccessCreator.setDataAccess(new PmsDataAccess(userName));
				PmsDataAccessCreator.getDataAccess().enableDeleteFilters(true);
				this.fireInitEvent();
				
				Notification.show("Anmeldung erfolgreich!",
						Notification.Type.HUMANIZED_MESSAGE);
				this.fireComponentChangeEvent(NavigationEvent.LOGIN);
			} else {
				Notification.show("Anmeldung fehlgeschlagen!",
						Notification.Type.HUMANIZED_MESSAGE);
			}
		} catch (UnknownUserException e) {
			Notification.show(e.getInvalidUserMessage(),
					Notification.Type.HUMANIZED_MESSAGE);
		}
	}
}
