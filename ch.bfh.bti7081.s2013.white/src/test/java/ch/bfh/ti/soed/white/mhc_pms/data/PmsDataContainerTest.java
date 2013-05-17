/**
 * 
 */
package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.TextField;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsDataAccess;
import ch.bfh.ti.soed.white.mhc_pms.data.Patient;

/**
 * @author Patrick Kofmel
 *
 */
public class PmsDataContainerTest {

	private static MhcPmsContainer<? extends MhcPmsItem> patContainer;
	
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
		patContainer =  MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetCurrentItem() {
		// TODO Test für getID und getItemId
//		assertEquals(1, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.setCurrentItem(2));
//		assertEquals(2, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.setCurrentItem(3));
//		assertEquals(3, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.setCurrentItem(1));
//		assertEquals(1, patContainer.getCurrentItem().getItemId());
	}
	
	@Test
	public void testIncrementCurrentItem() {
//		assertEquals(1, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.incrementCurrentItem());
//		assertEquals(2, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.incrementCurrentItem());
//		assertEquals(3, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.incrementCurrentItem());
//		assertEquals(1, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.incrementCurrentItem());
//		assertEquals(2, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.incrementCurrentItem());
//		assertEquals(3, patContainer.getCurrentItem().getItemId());
//		assertTrue(patContainer.incrementCurrentItem());
//		assertEquals(1, patContainer.getCurrentItem().getItemId());
	}
	
	/**
	 * Test method for {@link com.vaadin.addon.jpacontainer.JPAContainer#addItem(java.lang.Object)}.
	 */
	@Test
	public void testAddItemObject() {
//		MhcPmsContainer<Patient> cont = (MhcPmsContainer<Patient>) patContainer;
		MhcPmsContainer<Patient> cont = (MhcPmsContainer<Patient>) MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class);
//		Patient pat = new Patient();
//		TextField txtFirstName = new TextField();
//		txtFirstName.setValue("öljjkl");
//		TextField txtLastName = new TextField();
//		txtLastName.setValue("öökljöklj");
//		TextField txtCivilStatus = new TextField();
//		txtCivilStatus.setValue("öaaaaöö");
//		
//		System.out.println(txtFirstName.getValue());
//		System.out.println(txtLastName.getValue());
//		System.out.println(txtCivilStatus.getValue());
//		
//		pat.setCivilStatus(txtCivilStatus.getValue());
//		pat.setFirstName(txtFirstName.getValue());
//		pat.setLastName(txtLastName.getValue());
//		cont.addEntity(pat);
//		System.out.println(cont.isAutoCommit());
		cont.addEntity(new Patient());
		
//		DateFormat.getDateInstance(DateFormat.MEDIUM).format(null);
		
//		BeanItem<Patient> newPatientItem = new BeanItem<Patient>(pat);
//		FieldGroup fieldGroup = new FieldGroup(newPatientItem);
//		fieldGroup.bind(txtFirstName, "firstName");
//		fieldGroup.bind(txtLastName, "lastName");
//		fieldGroup.bind(txtCivilStatus, "civilStatus");
//		
//		fieldGroup.setItemDataSource(newPatientItem);
//		
//		try {
//			fieldGroup.commit();
//		} catch (CommitException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Patient pat = new Patient();
		
//		pat.setFirstName("Hans");
//		pat.setLastName("Muster");
//		pat.setGender("mänlich");
//		pat.setKindOfTreatment("ambulant");
		//cont.addEntity(pat);
		
		

//		try {
//			fieldGroup.commit();
//		} catch (CommitException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println("Test");
//		System.out.println(fieldGroup.isBuffered());
//		Collection<?> coll = newPatientItem.getItemPropertyIds();
//		System.out.println("size: " + coll.size());
//		System.out.println(coll.iterator().next());
//		System.out.println("Value: " + newPatientItem.getItemProperty("civilStatus").getValue());
		
//		assertEquals("Peter", pat.getFirstName());
//		assertEquals("Müller", pat.getLastName());
//		assertEquals("ledig", pat.getCivilStatus());
		
		
		
		
//		System.out.println(((Patient) MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class).getCurrentItem().getEntity()).getId());
		
//		Map<String, MhcPmsContainer<? extends MhcPmsItem>> containerMap =  new HashMap<String, MhcPmsContainer<? extends MhcPmsItem>>();
//		MhcPmsContainer<Patient> patients = new MhcPmsContainer<>(Patient.class);	
//		patients.refresh();
//		containerMap.put(Patient.class.getName(), patients);		
//		Collection<?> collection = patients.getItemIds();
//		System.out.println(collection.size());
		
//		System.out.println(MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class));
//		System.out.println(MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class).getCurrentItem());
//		Patient pat = (Patient) MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class).getCurrentItem();
		
//		MhcPmsContainer<? extends MhcPmsItem> container = MhcPmsDataAccess.getInstance().getCurrentContainer(Patient.class);
//		System.out.println(((Patient) container.getItem(1).getEntity()).getFirstName());
//		System.out.println(((Patient) container.getItem(2).getEntity()).getFirstName());
//		System.out.println(((Patient) container.getItem(3).getEntity()).getFirstName());
//		System.out.println("count:" + container.size());
//		System.out.println(((Patient) container.getCurrentItem()).getFirstName());
//		System.out.println(((Patient) container.getCurrentItem()).getId());
//		System.out.println(container.incrementCurrentItem());
//		System.out.println(((Patient) container.getCurrentItem()).getId());
//		System.out.println(container.incrementCurrentItem());
//		System.out.println(((Patient) container.getCurrentItem()).getId());
//		System.out.println(container.incrementCurrentItem());
//		System.out.println(((Patient) container.getCurrentItem()).getId());
//		System.out.println(container.incrementCurrentItem());
//		System.out.println(((Patient) container.getCurrentItem()).getId());
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
