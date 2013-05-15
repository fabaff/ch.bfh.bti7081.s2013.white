/**
 * 
 */
package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.Patient;

/**
 * @author Patrick Kofmel
 *
 */
public class PmsDataContainerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.vaadin.addon.jpacontainer.JPAContainer#addItem(java.lang.Object)}.
	 */
	@Test
	public void testAddItemObject() {
//		Map<String, MhcPmsContainer<? extends MhcPmsItem>> containerMap =  new HashMap<String, MhcPmsContainer<? extends MhcPmsItem>>();
//		MhcPmsContainer<Patient> patients = new MhcPmsContainer<>(Patient.class);	
//		patients.refresh();
//		containerMap.put(Patient.class.getName(), patients);		
//		Collection<?> collection = patients.getItemIds();
//		System.out.println(collection.size());
		
		System.out.println(MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class));
		System.out.println(MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class).getCurrentItem());
		Patient pat = (Patient) MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class).getCurrentItem();
		System.out.println(pat.getFirstName());
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.vaadin.addon.jpacontainer.JPAContainer#addItem()}.
	 */
	@Test
	public void testAddItem() {
//		fail("Not yet implemented");
	}

}
