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
 * This class tests the user container
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public class PmsUserContainerTest {

	private static final int USER_CONTAINER_SIZE = 6;
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
		DummyDataCreator.createDummyUsers();
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
		
		assertEquals("Peter", dummy.getFirstName());
		assertEquals("Müller", dummy.getLastName());
		assertEquals(UserGroup.PSYCHIATRIST, dummy.getUserGroup());
		assertEquals(PmsDataAccessCreator.DUMMY_USER, dummy.getUserName());
		assertEquals(Hash.MD5(PmsDataAccessCreator.DUMMY_PASSWORD), dummy.getPassword());
	}
	
	@Test
	public final void testGetLoginUser() throws UnknownUserException {
		assertEquals(USER_CONTAINER_SIZE, dataAccess.getPmsUserContainer().size());
		Object userItemId = dataAccess.getPmsUserContainer().addEntity(user);
		assertEquals(USER_CONTAINER_SIZE + 1, dataAccess.getPmsUserContainer().size());
		PmsDataAccessCreator.setDataAccess(new PmsDataAccess("drMeier"));
		dataAccess = PmsDataAccessCreator.getDataAccess();
		PmsUser loginUser = dataAccess.getLoginUser();
		
		assertEquals("Hans", loginUser.getFirstName());
		assertEquals("Meier", loginUser.getLastName());
		assertEquals(UserGroup.PSYCHIATRIST, loginUser.getUserGroup());
		assertEquals("drMeier", loginUser.getUserName());
		assertEquals(Hash.MD5("meier10"), loginUser.getPassword());
		
		assertTrue(dataAccess.getPmsUserContainer().removeItem(userItemId));
		assertEquals(USER_CONTAINER_SIZE, dataAccess.getPmsUserContainer().size());
	}

	@Test
	public final void testGetUser() {
		PmsUser dbUser = dataAccess.getPmsUserContainer().getUser(PmsDataAccessCreator.DUMMY_USER);
		
		assertNull(dataAccess.getPmsUserContainer().getUser("drMeier"));
		assertEquals("Peter", dbUser.getFirstName());
		assertEquals("Müller", dbUser.getLastName());
		assertEquals(UserGroup.PSYCHIATRIST, dbUser.getUserGroup());
		assertEquals(PmsDataAccessCreator.DUMMY_USER, dbUser.getUserName());
		assertEquals(Hash.MD5(PmsDataAccessCreator.DUMMY_PASSWORD), dbUser.getPassword());
		
		assertEquals(USER_CONTAINER_SIZE, dataAccess.getPmsUserContainer().size());
		Object userItemId = dataAccess.getPmsUserContainer().addEntity(user);
		assertEquals(USER_CONTAINER_SIZE + 1, dataAccess.getPmsUserContainer().size());
		
		dbUser = dataAccess.getPmsUserContainer().getUser("drMeier");
		
		assertNotNull(dbUser);
		assertEquals("Hans", dbUser.getFirstName());
		assertEquals("Meier", dbUser.getLastName());
		assertEquals(UserGroup.PSYCHIATRIST, dbUser.getUserGroup());
		assertEquals("drMeier", dbUser.getUserName());
		assertEquals(Hash.MD5("meier10"), dbUser.getPassword());
		
		assertTrue(dataAccess.getPmsUserContainer().removeItem(userItemId));
		assertEquals(USER_CONTAINER_SIZE, dataAccess.getPmsUserContainer().size());
	}

	@Test
	public final void testCheckLogin() {
		assertTrue(dataAccess.getPmsUserContainer().checkLogin(PmsDataAccessCreator.DUMMY_USER, Hash.MD5((PmsDataAccessCreator.DUMMY_PASSWORD))));
		assertFalse(dataAccess.getPmsUserContainer().checkLogin("drMeier", Hash.MD5(("meier10"))));
		
		assertEquals(USER_CONTAINER_SIZE, dataAccess.getPmsUserContainer().size());
		dataAccess.getPmsUserContainer().addEntity(user);
		assertEquals(USER_CONTAINER_SIZE + 1, dataAccess.getPmsUserContainer().size());
		
		assertTrue(dataAccess.getPmsUserContainer().checkLogin(PmsDataAccessCreator.DUMMY_USER, Hash.MD5((PmsDataAccessCreator.DUMMY_PASSWORD))));
		assertTrue(dataAccess.getPmsUserContainer().checkLogin("drMeier", Hash.MD5(("meier10"))));
	}
}
