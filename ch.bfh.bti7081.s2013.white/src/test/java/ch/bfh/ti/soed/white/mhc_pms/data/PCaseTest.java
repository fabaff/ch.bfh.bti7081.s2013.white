package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.KindOfTreatment;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.OrderOfPatient;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.ReanimationStatus;
//import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
//import ch.bfh.ti.soed.white.mhc_pms.util.Hash;

/**
 * Test class for patient case
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
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
		PmsUser user = new PmsUser();
		user.setUserName("drMeier");
		PCase pCase = new PCase(user);
		
		assertEquals(0, pCase.getPcid());
		assertNull(pCase.getDateCaseClosed());
		assertNull(pCase.getCaseStatus());
		assertNull(pCase.getReanimationStatus());
		assertNull(pCase.getKindOfTreatment());
		assertNull(pCase.getKindOfTreatment());
		assertNull(pCase.getDateCaseOpened());
		
		assertEquals("drMeier", pCase.getTherapist().getUserName());
	}

	@Test
	public void testCloseCase() {
		PCase pCase = new PCase(new PmsUser());
		pCase.closeCase();
		
		assertEquals(0, pCase.getPcid());
		assertNotNull(pCase.getDateCaseClosed());
		assertEquals(CaseStatus.CLOSED, pCase.getCaseStatus());
		assertNull(pCase.getReanimationStatus());
		assertNull(pCase.getKindOfTreatment());
		assertNull(pCase.getOrderOfPatient());
		assertNull(pCase.getDateCaseOpened());
	}
	
	@Test
	public void testSetNewCase() {
		PCase pCase = new PCase(new PmsUser());
		pCase.setNewCase();
		
		assertEquals(0, pCase.getPcid());
		assertNull(pCase.getDateCaseClosed());
		assertEquals(CaseStatus.ACTIVE, pCase.getCaseStatus());
		assertEquals(ReanimationStatus.YES, pCase.getReanimationStatus());
		assertNotNull(pCase.getDateCaseOpened());
		assertEquals(KindOfTreatment.INPATIENT, pCase.getKindOfTreatment());
		assertEquals(OrderOfPatient.NO, pCase.getOrderOfPatient());
	}
	
	@Test
	public void testClone() {
		PmsUser user = new PmsUser();
		user.setUserName("drMeier");
		PCase pCase = new PCase(user);
		pCase.setPcid(10);
		pCase.setFirstName("Hans");
		
		PCase pCaseClone = (PCase) pCase.clone();
		
		assertNotNull(pCaseClone);
		assertNotSame(pCase, pCaseClone);
		assertSame(pCase.getTherapist(), pCaseClone.getTherapist());
		assertEquals(pCase.getFirstName(), pCaseClone.getFirstName());
		assertFalse(pCase.getPcid() == pCaseClone.getPcid());
	}
}
