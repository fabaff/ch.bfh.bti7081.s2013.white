package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
import ch.bfh.ti.soed.white.mhc_pms.util.DummyDataCreator;

/**
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *
 */
public class PmsContainerTest {

	private static PmsContainer<PCase> pCaseContainer;
	
	private static PmsUser user;
	
	private static PCase pCaseItem1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PmsDataAccessCreator.setPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT_TEST);
		DummyDataCreator.createDummyUser();
		pCaseContainer = PmsDataAccessCreator.getDataAccess().getPCaseContainer();
		PmsUser user = new PmsUser();
		PCase pCaseItem1 = new PCase(user);
		
		user.setFirstName("Hans");
		user.setLastName("Meier");
		user.setUserGroup(UserGroup.PSYCHIATRIST);
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
	public final void testPmsContainer() {
		assertEquals(0, pCaseContainer.size());
		assertNull(pCaseContainer.getCurrentItem());
		assertNull(pCaseContainer.getCurrentItemId());
	}

	@Test
	public final void testGetCurrentPCaseId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetCurrentPCaseId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDecrementCurrentPCaseItemId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIncrementCurrentPCaseItemId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddEntity() {
//		fail("Not yet implemented"); // TODO
	}

}
