package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
import ch.bfh.ti.soed.white.mhc_pms.util.DummyDataCreator;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.filter.Filters;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.TextField;

public class PCaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPCase() {
//		fail("Not yet implemented");
	}

	@Test
	public void testPCaseUser() throws CommitException {
		// TODO vollständiger Test
		
//		private void addTestClickListener() {
//		this.btnTest.addClickListener(new Button.ClickListener() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void buttonClick(ClickEvent event) {
//                Notification.show("Test notification", Notification.Type.HUMANIZED_MESSAGE);
//
//			}
//		});
//	}
		
	
		
//		JPAContainer<PmsUser> jpaContainer = new JPAContainer<>(PmsUser.class);
//		jpaContainer.setEntityProvider(new CachingBatchableLocalEntityProvider<PmsUser>(PmsUser.class,
//				JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT)));
//		jpaContainer.setAutoCommit(true);
//		
//		Filter userFilter = Filters.eq("userName", "user");
//		
//		jpaContainer.addContainerFilter(userFilter);
//		Object id = jpaContainer.firstItemId();
//		jpaContainer.removeContainerFilters(userFilter);
//		
//		System.out.println("id: " + id );
//		
//		if (id == null) {
//			PmsUser dummyUser = new PmsUser();
//			dummyUser.setUserName("user");
//			dummyUser.setPassword("");
//			dummyUser.setUserGroup(UserGroup.PSYCHOLOGIST);
//			jpaContainer.addEntity(dummyUser);
//			jpaContainer.refresh();
//		}
		
//		DummyDataCreator.createDummyUsers();
//		
//		PmsUserContainer userContainer = new PmsUserContainer(PmsUser.class);
//		System.out.println(userContainer.size());
//		
//		Filter filter1 = Filters.eq("userName", "user");
//		Filter filter2 = Filters.eq("password", "password");
//		
//		userContainer.addContainerFilter(filter1);
//		userContainer.addContainerFilter(filter2);
//		Object id = userContainer.firstItemId();
//		System.out.println(userContainer.size());
//		userContainer.removeContainerFilters(filter1);
//		userContainer.removeContainerFilters(filter2);
//		
//		System.out.println(userContainer.checkLogin("user", ""));
		
	
		
		
//		System.out.println("size before filter: " + jpaContainer.size());
//		Filter filter = Filters.eq("userName", "user");
//		jpaContainer.addContainerFilter(filter);
//		System.out.println("size with filter: " + jpaContainer.size());
//		PmsUser user;
//		if (jpaContainer.size() != 0) {
//			user = jpaContainer.getItem(jpaContainer.firstItemId()).getEntity();
//			System.out.println(user);
//		}
//		
//		jpaContainer.removeContainerFilter(filter);
//		System.out.println("size after filter: " + jpaContainer.size());
//		
		
//		JPAContainer<PCase> jpaContainer2 = new JPAContainer<>(PCase.class);
//		jpaContainer2.setEntityProvider(new CachingBatchableLocalEntityProvider<PCase>(PCase.class,
//				JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT)));
//
//		System.out.println(jpaContainer2.getItem(jpaContainer2.firstItemId()).getEntity().getFirstName());
//		jpaContainer2.getItem(jpaContainer2.firstItemId()).getEntity().setFirstName("Peter");
//		System.out.println(jpaContainer2.getItem(jpaContainer2.firstItemId()).getEntity().getFirstName());
		
		
//		System.out.println("First id: " + jpaContainer2.firstItemId());
//		
//		JPAContainer<Diagnosis> jpaContainerDiag = new JPAContainer<>(Diagnosis.class);
//		jpaContainerDiag.setEntityProvider(new CachingBatchableLocalEntityProvider<Diagnosis>(Diagnosis.class,
//				JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT)));
//		
//		PmsUser pmsUser = new PmsUser();
//		PCase pCase = new PCase(pmsUser);
//		Diagnosis diag = new Diagnosis(pCase);
//		
//		jpaContainer.addEntity(pmsUser);
//		jpaContainer2.addEntity(pCase);
//		jpaContainerDiag.addEntity(diag);
//		jpaContainer.commit();
//		jpaContainer2.commit();
//		jpaContainerDiag.commit();
//		
//		System.out.println("jpaContainerDiag: " + jpaContainerDiag.size());
//		Collection<?> collIds = jpaContainerDiag.getItemIds();
//		System.out.println("collIds.size(): " + collIds.size());
//		Collection<?> coll = jpaContainerDiag.getItem(collIds.toArray()[2]).getItemPropertyIds();
//		System.out.println("Diag container size: " + coll.size());
//		for (Object object : coll) {
//			System.out.println(object);
//		}
//		Diagnosis diagResult = jpaContainerDiag.getItem(collIds.toArray()[2]).getEntity();
//		System.out.println(diagResult.getpCase().getPcid());
//	
//		filter = Filters.eq("pCase.pcid", 2);
//		jpaContainerDiag.addContainerFilter(filter);
//		System.out.println("size with filter: " + jpaContainerDiag.size());
//		if (jpaContainerDiag.size() != 0) {
//			diagResult = jpaContainerDiag.getItem(jpaContainerDiag.firstItemId()).getEntity();
//			System.out.println(diagResult.getDid());
//		}
//		jpaContainerDiag.removeContainerFilter(filter);
//		System.out.println("size after filter: " + jpaContainer.size());
		
		
		
//		TextField txtFirstName = new TextField();
//		txtFirstName.setValue("Hans");
//		TextField txtLastName = new TextField();
//		txtLastName.setValue("Muster");
//		TextField txtCivilStatus = new TextField();
//		txtCivilStatus.setValue("UNMARRIED");
//		
//		System.out.println("Value1: " + txtFirstName.getValue());
//		
//		PCase pat = new PCase();
//		pat.setFirstName("Peter");
//		BeanItem<PCase> newPatientItem = new BeanItem<PCase>(pat);
//		FieldGroup fieldGroup = new FieldGroup(newPatientItem);
//		fieldGroup.bind(txtFirstName, "firstName");
//		fieldGroup.bind(txtLastName, "lastName");
//		fieldGroup.bind(txtCivilStatus, "civilStatus");
//		
//		System.out.println("Value2: " + txtFirstName.getValue());
//		System.out.println("Bind1: " + newPatientItem.getBean().getFirstName());
//		
//		txtFirstName.setValue("Flipsi");
//		fieldGroup.commit();
//		
//		System.out.println("Bind2: " + newPatientItem.getBean().getFirstName());
//		
		
		
//		JPAContainer<PCase> pCases = JPAContainerFactory.make(PCase.class, "ch.bfh.bti7081.s2013.white");
//		JPAContainer<PmsUser> users = JPAContainerFactory.make(PmsUser.class, "ch.bfh.bti7081.s2013.white");
//		users.addEntity(new PmsUser());
//		PmsUser user = users.getItem(users.firstItemId()).getEntity();
//		PCase pCase = new PCase(user);
//		pCases.addEntity(pCase);
		
//		UIPermissionInstance.registerNewPermission(Therapist.class, new TherapistPermission());
//		NursePermission therapistPermission = UIPermissionInstance.createUIState(Therapist.class);
//		assertNotNull(therapistPermission);
//		assertTrue(therapistPermission.isNewDiagnosisAllowed);
//		assertFalse(therapistPermission.isNewMedicationAllowed);
//		
//		MhcPmsUserDeprecated user = new Therapist();
//		therapistPermission = user.getUIPermission();
//		assertNotNull(therapistPermission);
//		assertTrue(therapistPermission.isNewDiagnosisAllowed);
//		assertFalse(therapistPermission.isNewMedicationAllowed);
		
//		System.out.println(UIPermissionInstance.permissionsMap.size());
//		MhcPmsUserDeprecated user = UserSingleton.getUser();
//		assertNotNull(user);
//		NursePermission therapistPermission = user.getUIPermission();
//		assertNotNull(therapistPermission);
//		assertTrue(therapistPermission.isNewDiagnosisAllowed);
//		assertFalse(therapistPermission.isNewMedicationAllowed);
	}

}
