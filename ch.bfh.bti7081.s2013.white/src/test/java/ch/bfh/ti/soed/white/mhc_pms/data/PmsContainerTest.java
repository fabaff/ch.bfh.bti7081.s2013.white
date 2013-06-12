package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
import ch.bfh.ti.soed.white.mhc_pms.util.DummyDataCreator;
import ch.bfh.ti.soed.white.mhc_pms.util.Hash;

/**
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *
 */
public class PmsContainerTest {

	private static  PmsDataAccess dataAccess;
	
	private static PmsUser user;
	
	private static PCase pCaseItem1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		PmsDataAccessCreator.setPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT_TEST);
		DummyDataCreator.createDummyUsers();
		dataAccess = PmsDataAccessCreator.getDataAccess();
		
		PmsUser user = new PmsUser();
		user.setFirstName("Hans");
		user.setLastName("Meier");
		user.setUserGroup(UserGroup.PSYCHIATRIST);
		user.setUserName("drMeier");
		user.setPassword(Hash.MD5("meier10"));
		
		PCase pCaseItem1 = new PCase(user);
	}

	@After
	public void tearDown() throws Exception {
		PmsDataAccessCreator.setDataAccess(new PmsDataAccess(PmsDataAccessCreator.DUMMY_USER));
		dataAccess = PmsDataAccessCreator.getDataAccess();
		
		Collection<Object> ids = dataAccess.getPmsUserContainer().getItemIds();
		for (Object id : ids) {
			dataAccess.getPmsUserContainer().removeItem(id);
		}
	}

	@Test
	public final void testPmsContainer() {
		assertEquals(0, dataAccess.getPCaseContainer().size());
		assertNull(dataAccess.getPCaseContainer().getCurrentItem());
		assertNull(dataAccess.getPCaseContainer().getCurrentItemId());
	}

	@Test
	public final void testGetSetCurrentItemId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDecrementCurrenItemId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIncrementCurrenItemId() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddEntity() {
//		fail("Not yet implemented"); // TODO
	}

}
