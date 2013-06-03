package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		
		JPAContainer<PmsUser> jpaContainer = new JPAContainer<>(PmsUser.class);
		jpaContainer.setEntityProvider(new CachingBatchableLocalEntityProvider<PmsUser>(PmsUser.class,
				JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccess.PERSISTENCE_UNIT)));
		
		System.out.println("size before filter: " + jpaContainer.size());
		Filter filter = Filters.eq("userName", "user");
		jpaContainer.addContainerFilter(filter);
		System.out.println("size with filter: " + jpaContainer.size());
		PmsUser user;
		if (jpaContainer.size() != 0) {
			user = jpaContainer.getItem(jpaContainer.firstItemId()).getEntity();
			System.out.println(user);
		}
		
		jpaContainer.removeContainerFilter(filter);
		System.out.println("size after filter: " + jpaContainer.size());
		
		JPAContainer<PCase> jpaContainer2 = new JPAContainer<>(PCase.class);
		jpaContainer2.setEntityProvider(new CachingBatchableLocalEntityProvider<PCase>(PCase.class,
				JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccess.PERSISTENCE_UNIT)));
		
		System.out.println("First id: " + jpaContainer2.firstItemId());
		
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
