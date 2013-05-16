package ch.bfh.ti.soed.white.mhc_pms.security;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UIPermissionFactoryTest {

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
	public final void testCreateUIState() {
//		UIPermissionFactory.registerNewPermission(Therapist.class, new TherapistPermission());
//		UIPermission therapistPermission = UIPermissionFactory.createUIState(Therapist.class);
//		assertNotNull(therapistPermission);
//		assertTrue(therapistPermission.isNewDiagnosisAllowed);
//		assertFalse(therapistPermission.isNewMedicationAllowed);
//		// TODO vollständiger Test
//		
//		MhcPmsUser user = new Therapist();
//		therapistPermission = user.getUIPermission();
//		assertNotNull(therapistPermission);
//		assertTrue(therapistPermission.isNewDiagnosisAllowed);
//		assertFalse(therapistPermission.isNewMedicationAllowed);
		
//		System.out.println(UIPermissionFactory.permissionsMap.size());
		MhcPmsUser user = UserSingleton.getUser();
		assertNotNull(user);
		UIPermission therapistPermission = user.getUIPermission();
		assertNotNull(therapistPermission);
		assertTrue(therapistPermission.isNewDiagnosisAllowed);
		assertFalse(therapistPermission.isNewMedicationAllowed);
	}


}
