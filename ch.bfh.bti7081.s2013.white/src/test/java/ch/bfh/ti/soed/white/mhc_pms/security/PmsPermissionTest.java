package ch.bfh.ti.soed.white.mhc_pms.security;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission.Operation;

/**
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public class PmsPermissionTest {

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
	public final void testHasPermissionPSYCHIATRIST() {
		PmsPermission permission = new PmsPermission(UserGroup.PSYCHIATRIST);
		
		assertTrue(permission.hasPermission(Operation.DELETE_DIAGNOSIS));
		assertTrue(permission.hasPermission(Operation.DELETE_MEDICATION));
		assertTrue(permission.hasPermission(Operation.DELETE_PATIENT_PROGRESS_ENTRY));
		assertTrue(permission.hasPermission(Operation.EDIT_CASE));
		assertTrue(permission.hasPermission(Operation.EDIT_DIAGNOSIS));
		assertTrue(permission.hasPermission(Operation.EDIT_MEDICATION));
		assertTrue(permission.hasPermission(Operation.EDIT_PATIENT_PROGRESS_ENTRY));
		assertTrue(permission.hasPermission(Operation.NEW_CASE));
		assertTrue(permission.hasPermission(Operation.NEW_DIAGNOSIS));
		assertTrue(permission.hasPermission(Operation.NEW_MEDICATION));
		assertTrue(permission.hasPermission(Operation.NEW_PATIENT));
		assertTrue(permission.hasPermission(Operation.NEW_PATIENT_PROGRESS_ENTRY));
	}
	
	@Test
	public final void testHasPermissionPSYCHOLOGIST() {
		PmsPermission permission = new PmsPermission(UserGroup.PSYCHOLOGIST);
		
		assertTrue(permission.hasPermission(Operation.DELETE_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.DELETE_MEDICATION));
		assertTrue(permission.hasPermission(Operation.DELETE_PATIENT_PROGRESS_ENTRY));
		assertTrue(permission.hasPermission(Operation.EDIT_CASE));
		assertTrue(permission.hasPermission(Operation.EDIT_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.EDIT_MEDICATION));
		assertTrue(permission.hasPermission(Operation.EDIT_PATIENT_PROGRESS_ENTRY));
		assertTrue(permission.hasPermission(Operation.NEW_CASE));
		assertTrue(permission.hasPermission(Operation.NEW_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.NEW_MEDICATION));
		assertTrue(permission.hasPermission(Operation.NEW_PATIENT));
		assertTrue(permission.hasPermission(Operation.NEW_PATIENT_PROGRESS_ENTRY));
	}
	
	@Test
	public final void testHasPermissionADMIN_STAFF() {
		PmsPermission permission = new PmsPermission(UserGroup.ADMIN_STAFF);
		
		assertFalse(permission.hasPermission(Operation.DELETE_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.DELETE_MEDICATION));
		assertFalse(permission.hasPermission(Operation.DELETE_PATIENT_PROGRESS_ENTRY));
		assertFalse(permission.hasPermission(Operation.EDIT_CASE));
		assertFalse(permission.hasPermission(Operation.EDIT_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.EDIT_MEDICATION));
		assertFalse(permission.hasPermission(Operation.EDIT_PATIENT_PROGRESS_ENTRY));
		assertTrue(permission.hasPermission(Operation.NEW_CASE));
		assertFalse(permission.hasPermission(Operation.NEW_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.NEW_MEDICATION));
		assertTrue(permission.hasPermission(Operation.NEW_PATIENT));
		assertFalse(permission.hasPermission(Operation.NEW_PATIENT_PROGRESS_ENTRY));
	}
	
	@Test
	public final void testHasPermissionNURSE() {
		PmsPermission permission = new PmsPermission(UserGroup.NURSE);
		
		assertFalse(permission.hasPermission(Operation.DELETE_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.DELETE_MEDICATION));
		assertFalse(permission.hasPermission(Operation.DELETE_PATIENT_PROGRESS_ENTRY));
		assertFalse(permission.hasPermission(Operation.EDIT_CASE));
		assertFalse(permission.hasPermission(Operation.EDIT_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.EDIT_MEDICATION));
		assertFalse(permission.hasPermission(Operation.EDIT_PATIENT_PROGRESS_ENTRY));
		assertFalse(permission.hasPermission(Operation.NEW_CASE));
		assertFalse(permission.hasPermission(Operation.NEW_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.NEW_MEDICATION));
		assertFalse(permission.hasPermission(Operation.NEW_PATIENT));
		assertFalse(permission.hasPermission(Operation.NEW_PATIENT_PROGRESS_ENTRY));
	}
	
	@Test
	public final void testHasPermissionMEDICAL_STAFF() {
		PmsPermission permission = new PmsPermission(UserGroup.MEDICAL_STAFF);
		
		assertFalse(permission.hasPermission(Operation.DELETE_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.DELETE_MEDICATION));
		assertFalse(permission.hasPermission(Operation.DELETE_PATIENT_PROGRESS_ENTRY));
		assertFalse(permission.hasPermission(Operation.EDIT_CASE));
		assertFalse(permission.hasPermission(Operation.EDIT_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.EDIT_MEDICATION));
		assertFalse(permission.hasPermission(Operation.EDIT_PATIENT_PROGRESS_ENTRY));
		assertFalse(permission.hasPermission(Operation.NEW_CASE));
		assertFalse(permission.hasPermission(Operation.NEW_DIAGNOSIS));
		assertFalse(permission.hasPermission(Operation.NEW_MEDICATION));
		assertFalse(permission.hasPermission(Operation.NEW_PATIENT));
		assertFalse(permission.hasPermission(Operation.NEW_PATIENT_PROGRESS_ENTRY));
	}

}
