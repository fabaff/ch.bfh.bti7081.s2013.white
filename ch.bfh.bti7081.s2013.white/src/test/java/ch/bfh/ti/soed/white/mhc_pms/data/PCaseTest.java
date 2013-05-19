package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

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
	public void testPCaseUser() {
		JPAContainer<PCase> pCases = JPAContainerFactory.make(PCase.class, "ch.bfh.bti7081.s2013.white");
		JPAContainer<PmsUser> users = JPAContainerFactory.make(PmsUser.class, "ch.bfh.bti7081.s2013.white");
		users.addEntity(new PmsUser());
		PmsUser user = users.getItem(users.firstItemId()).getEntity();
		PCase pCase = new PCase(user);
		pCases.addEntity(pCase);
	}

}
