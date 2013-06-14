package ch.bfh.ti.soed.white.mhc_pms.data;

//import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.Gender;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
import ch.bfh.ti.soed.white.mhc_pms.util.DummyDataCreator;
import ch.bfh.ti.soed.white.mhc_pms.util.Hash;

/**
 * This class tests the entity container.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */

public class PmsEntityContainerTest {

	private static PmsDataAccess dataAccess;

	private static PmsUser user;

	private static PCase pCaseItem1;
	private static PCase pCaseItem2;

	private static Diagnosis diagItem1;
	private static Diagnosis diagItem2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		PmsDataAccessCreator
				.setPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT_TEST);
		DummyDataCreator.createDummyUsers();
		dataAccess = PmsDataAccessCreator.getDataAccess();

		user = new PmsUser();
		user.setFirstName("Hans");
		user.setLastName("Meier");
		user.setUserGroup(UserGroup.PSYCHIATRIST);
		user.setUserName("drMeier");
		user.setPassword(Hash.MD5("meier10"));

		pCaseItem1 = new PCase();
		pCaseItem1.setFirstName("Peter");
		pCaseItem1.setLastName("Muster");
		pCaseItem1.setGender(Gender.MALE);
		pCaseItem1.setCaseStatus(CaseStatus.ACTIVE);

		pCaseItem2 = new PCase();
		pCaseItem2.setFirstName("Peter2");
		pCaseItem2.setLastName("Muster2");
		pCaseItem2.setGender(Gender.FEMALE);
		pCaseItem2.setCaseStatus(CaseStatus.ACTIVE);

		diagItem1 = new Diagnosis();
		diagItem1.setDiagnosisName("Diagnosis XYZ");
		diagItem1.setIcdCode("A20");
		diagItem1.setDiagnosisComment("Diagnosis Comment");

		diagItem2 = new Diagnosis();
		diagItem2.setDiagnosisName("Diagnosis XYZ2");
		diagItem2.setIcdCode("A202");
		diagItem2.setDiagnosisComment("Diagnosis Comment2");
	}

	@After
	public void tearDown() throws Exception {
		PmsDataAccessCreator.setDataAccess(new PmsDataAccess(
				PmsDataAccessCreator.DUMMY_USER));
		dataAccess = PmsDataAccessCreator.getDataAccess();

		Collection<Object> ids = dataAccess.getDiagnosisContainer()
				.getItemIds();
		for (Object id : ids) {
			dataAccess.getDiagnosisContainer().removeItem(id);
		}

		ids = dataAccess.getPCaseContainer().getItemIds();
		for (Object id : ids) {
			dataAccess.getPCaseContainer().removeItem(id);
		}

		ids = dataAccess.getPmsUserContainer().getItemIds();
		for (Object id : ids) {
			dataAccess.getPmsUserContainer().removeItem(id);
		}

		dataAccess.getPCaseContainer().setCurrentItemId(null);
		dataAccess.getDiagnosisContainer().setCurrentItemId(null);
	}

	@Test
	public final void testPmsEntityContainer() {
		assertEquals(0, dataAccess.getDiagnosisContainer().size());
		assertNull(dataAccess.getDiagnosisContainer().getCurrentItem());
		assertNull(dataAccess.getDiagnosisContainer().getCurrentItemId());

		Object itemId0 = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId0).getEntity());
		Object itemId1 = dataAccess.getPCaseContainer().addEntity(pCaseItem1);
		diagItem1.setpCase(dataAccess.getPCaseContainer().getItem(itemId1)
				.getEntity());
		Object itemId2 = dataAccess.getDiagnosisContainer()
				.addEntity(diagItem1);

		assertEquals(1, dataAccess.getDiagnosisContainer().size());
		assertNotNull(dataAccess.getDiagnosisContainer().getCurrentItem());
		assertNotNull(dataAccess.getDiagnosisContainer().getCurrentItemId());
		assertTrue(itemId2 == dataAccess.getDiagnosisContainer()
				.getCurrentItemId());
		assertTrue((Integer) itemId1 == dataAccess.getDiagnosisContainer()
				.getCurrentItem().getpCase().getPcid());
		assertTrue((Integer) itemId0 == dataAccess.getDiagnosisContainer()
				.getCurrentItem().getpCase().getTherapist().getUid());
	}

	@Test
	public final void testSetResetCurrentPCaseFilter() {
		assertEquals(0, dataAccess.getDiagnosisContainer().size());
		assertNull(dataAccess.getDiagnosisContainer().getCurrentItem());
		assertNull(dataAccess.getDiagnosisContainer().getCurrentItemId());

		dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getCurrentItem());
		pCaseItem2.setTherapist(dataAccess.getPmsUserContainer()
				.getCurrentItem());

		Object pCaseItemId1 = dataAccess.getPCaseContainer().addEntity(
				pCaseItem1);
		diagItem1.setpCase(dataAccess.getPCaseContainer().getCurrentItem());
		Object pCaseItemId2 = dataAccess.getPCaseContainer().addEntity(
				pCaseItem2);
		diagItem2.setpCase(dataAccess.getPCaseContainer().getCurrentItem());
		dataAccess.getDiagnosisContainer().addEntity(diagItem1);
		dataAccess.getDiagnosisContainer().addEntity(diagItem2);

		assertEquals(2, dataAccess.getDiagnosisContainer().size());
		
		dataAccess.getDiagnosisContainer().setCurrentPCaseFilter(pCaseItemId1);
		assertEquals(1, dataAccess.getDiagnosisContainer().size());
		assertEquals(
				diagItem1.getDiagnosisName(),
				dataAccess
						.getDiagnosisContainer()
						.getItem(
								dataAccess.getDiagnosisContainer()
										.firstItemId()).getEntity().getDiagnosisName());
		
		dataAccess.getDiagnosisContainer().setCurrentPCaseFilter(pCaseItemId2);
		assertEquals(1, dataAccess.getDiagnosisContainer().size());
		assertEquals(
				diagItem2.getDiagnosisName(),
				dataAccess
				.getDiagnosisContainer()
				.getItem(
						dataAccess.getDiagnosisContainer()
						.firstItemId()).getEntity().getDiagnosisName());
		
		dataAccess.getDiagnosisContainer().resetCurrentPCaseFilter();
		assertEquals(2, dataAccess.getDiagnosisContainer().size());
	}
	
	@Test
	public final void testDeleteFilterFilter() {
		assertEquals(0, dataAccess.getDiagnosisContainer().size());
		assertNull(dataAccess.getDiagnosisContainer().getCurrentItem());
		assertNull(dataAccess.getDiagnosisContainer().getCurrentItemId());

		dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getCurrentItem());
		pCaseItem2.setTherapist(dataAccess.getPmsUserContainer()
				.getCurrentItem());

		Object id = dataAccess.getPCaseContainer().addEntity(
				pCaseItem1);
		diagItem1.setpCase(dataAccess.getPCaseContainer().getCurrentItem());
		dataAccess.getPCaseContainer().addEntity(
				pCaseItem2);
		diagItem2.setpCase(dataAccess.getPCaseContainer().getCurrentItem());
		dataAccess.getDiagnosisContainer().addEntity(diagItem1);
		dataAccess.getDiagnosisContainer().addEntity(diagItem2);

		assertEquals(2, dataAccess.getDiagnosisContainer().size());
		assertEquals(false, dataAccess.getDiagnosisContainer().getCurrentItem().isDeleted());
		dataAccess.getDiagnosisContainer().enableDeleteFilter(true);
		assertEquals(2, dataAccess.getDiagnosisContainer().size());
		dataAccess.getDiagnosisContainer().enableDeleteFilter(false);
		assertEquals(2, dataAccess.getDiagnosisContainer().size());
		
		Diagnosis diag = dataAccess.getDiagnosisContainer().getCurrentItem();
		diag.setDeleted(true);
		dataAccess.getDiagnosisContainer().addEntity(diag);
		assertEquals(2, dataAccess.getDiagnosisContainer().size());
		dataAccess.getDiagnosisContainer().enableDeleteFilter(true);
		assertEquals(1, dataAccess.getDiagnosisContainer().size());
		dataAccess.getDiagnosisContainer().setCurrentPCaseFilter(id);
		assertEquals(1, dataAccess.getDiagnosisContainer().size());
		dataAccess.getDiagnosisContainer().enableDeleteFilter(false);
		assertEquals(2, dataAccess.getDiagnosisContainer().size());
	}
}
