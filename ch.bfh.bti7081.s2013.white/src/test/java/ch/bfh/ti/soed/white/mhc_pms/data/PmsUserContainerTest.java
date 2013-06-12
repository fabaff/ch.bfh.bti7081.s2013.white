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
import ch.bfh.ti.soed.white.mhc_pms.util.Hash;

/**
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *
 */
public class PmsUserContainerTest {

	private static PmsDataAccess dataAccess;
	
	private static PmsUser user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		PmsDataAccessCreator.setPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT_TEST);
		DummyDataCreator.createDummyUser();
		dataAccess = PmsDataAccessCreator.getDataAccess();
		user = new PmsUser();
		
		user.setFirstName("Hans");
		user.setLastName("Meier");
		user.setUserGroup(UserGroup.PSYCHIATRIST);
		user.setUserName("drMeier");
		user.setPassword(Hash.MD5("meier10"));
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
	public final void testUnknownUserException() {
		try {
			new PmsDataAccess("unknown");
			fail("UnknownUserException expected!");
		} catch (UnknownUserException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public final void testDummyUser() {
		PmsUser dummy = dataAccess.getLoginUser();
		
		assertEquals("", dummy.getFirstName());
		assertEquals("", dummy.getLastName());
		assertEquals(UserGroup.PSYCHIATRIST, dummy.getUserGroup());
		assertEquals(PmsDataAccessCreator.DUMMY_USER, dummy.getUserName());
		assertEquals(Hash.MD5(PmsDataAccessCreator.DUMMY_PASSWORD), dummy.getPassword());
	}
	
	@Test
	public final void testGetLoginUser() throws UnknownUserException {
		Object userItemId = dataAccess.getPmsUserContainer().addEntity(user);
		PmsDataAccessCreator.setDataAccess(new PmsDataAccess("drMeier"));
		dataAccess = PmsDataAccessCreator.getDataAccess();
		PmsUser loginUser = dataAccess.getLoginUser();
		
		assertEquals("Hans", loginUser.getFirstName());
		assertEquals("Meier", loginUser.getLastName());
		assertEquals(UserGroup.PSYCHIATRIST, loginUser.getUserGroup());
		assertEquals("drMeier", loginUser.getUserName());
		assertEquals(Hash.MD5("meier10"), loginUser.getPassword());
		
		assertTrue(dataAccess.getPmsUserContainer().removeItem(userItemId));
		assertEquals(1, dataAccess.getPmsUserContainer().size());
	}
	

	@Test
	public final void testGetUser() {
		// fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCheckLogin() {
		// fail("Not yet implemented"); // TODO
	}

}
