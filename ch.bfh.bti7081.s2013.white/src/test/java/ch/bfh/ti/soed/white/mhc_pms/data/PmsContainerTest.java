package ch.bfh.ti.soed.white.mhc_pms.data;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.TextField;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.Gender;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;
import ch.bfh.ti.soed.white.mhc_pms.util.DummyDataCreator;
import ch.bfh.ti.soed.white.mhc_pms.util.Hash;

/**
 * Class for PmsContainer test
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public class PmsContainerTest {

	private static PmsDataAccess dataAccess;

	private static PmsUser user;

	private static PCase pCaseItem1;
	private static PCase pCaseItem2;
	private static PCase pCaseItem3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		PmsDataAccessCreator
				.setPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT_TEST);
		DummyDataCreator.createDummyUsers();
		dataAccess = PmsDataAccessCreator.getDataAccess();

		user = new PmsUser();
		user.setFirstName("Hans");
		user.setLastName("Meier");
		user.setUserGroup(UserGroup.PSYCHIATRIST);
		user.setUserName("drMeier");
		user.setPassword(Hash.MD5("meier10"));

		pCaseItem1 = new PCase();
		pCaseItem1.setFirstName("Peter");
		pCaseItem1.setLastName("Muster");
		pCaseItem1.setGender(Gender.MALE);
		pCaseItem1.setCaseStatus(CaseStatus.ACTIVE);
		pCaseItem2 = new PCase();
		pCaseItem2.setFirstName("Peter2");
		pCaseItem2.setLastName("Muster2");
		pCaseItem2.setGender(Gender.FEMALE);
		pCaseItem2.setCaseStatus(CaseStatus.CLOSED);
		pCaseItem3 = new PCase();
		pCaseItem3.setFirstName("Peter3");
		pCaseItem3.setLastName("Muster3");
		pCaseItem3.setGender(Gender.UNSET);
		pCaseItem3.setCaseStatus(CaseStatus.ACTIVE);
	}

	@After
	public void tearDown() throws Exception {
		PmsDataAccessCreator.setDataAccess(new PmsDataAccess(
				PmsDataAccessCreator.DUMMY_USER));
		dataAccess = PmsDataAccessCreator.getDataAccess();

		Collection<Object> ids = dataAccess.getPCaseContainer().getItemIds();
		for (Object id : ids) {
			dataAccess.getPCaseContainer().removeItem(id);
		}

		ids = dataAccess.getPmsUserContainer().getItemIds();
		for (Object id : ids) {
			dataAccess.getPmsUserContainer().removeItem(id);
		}

		dataAccess.getPCaseContainer().setCurrentItemId(null);
	}

	@Test
	public final void testPmsContainer() {
		assertEquals(0, dataAccess.getPCaseContainer().size());
		assertNull(dataAccess.getPCaseContainer().getCurrentItem());
		assertNull(dataAccess.getPCaseContainer().getCurrentItemId());
	}

	@Test
	public final void testGetSetCurrentItemId() {
		Object itemId = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		dataAccess.getPCaseContainer().addEntity(pCaseItem1);

		Object id = dataAccess.getPCaseContainer().addEntity(pCaseItem1);
		itemId = dataAccess.getPCaseContainer().getCurrentItemId();
		PCase item = dataAccess.getPCaseContainer().getCurrentItem();

		assertEquals(2, dataAccess.getPCaseContainer().size());
		assertNotNull(item);
		assertEquals(itemId, item.getPcid());
		assertEquals(id, itemId);

		dataAccess.getPCaseContainer().setCurrentItemId(null);
		itemId = dataAccess.getPCaseContainer().getCurrentItemId();
		item = dataAccess.getPCaseContainer().getCurrentItem();

		assertNull(item);
		assertNull(itemId);
	}

	@Test
	public final void testDecrementCurrenItemId() {
		assertNull(dataAccess.getPCaseContainer().decrementCurrentItemId());

		Object itemId = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		pCaseItem2.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		pCaseItem3.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		itemId = dataAccess.getPCaseContainer().addEntity(pCaseItem1);
		
		assertEquals(itemId, dataAccess.getPCaseContainer().decrementCurrentItemId());
		assertEquals(itemId, dataAccess.getPCaseContainer().decrementCurrentItemId());
		
		dataAccess.getPCaseContainer().addEntity(pCaseItem2);
		itemId = dataAccess.getPCaseContainer().addEntity(pCaseItem3);

		assertEquals(((Integer) itemId) - 1, dataAccess.getPCaseContainer()
				.decrementCurrentItemId());
		assertEquals(((Integer) itemId) - 2, dataAccess.getPCaseContainer()
				.decrementCurrentItemId());
		assertEquals(((Integer) itemId), dataAccess.getPCaseContainer()
				.decrementCurrentItemId());
		assertEquals(((Integer) itemId) - 1, dataAccess.getPCaseContainer()
				.decrementCurrentItemId());
		assertEquals(((Integer) itemId) - 2, dataAccess.getPCaseContainer()
				.decrementCurrentItemId());
	}

	@Test
	public final void testIncrementCurrenItemId() {
		assertNull(dataAccess.getPCaseContainer().incrementCurrentItemId());

		Object itemId = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		pCaseItem2.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		pCaseItem3.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		itemId = dataAccess.getPCaseContainer().addEntity(pCaseItem1);
		
		assertEquals(itemId, dataAccess.getPCaseContainer().decrementCurrentItemId());
		assertEquals(itemId, dataAccess.getPCaseContainer().decrementCurrentItemId());
		
		dataAccess.getPCaseContainer().addEntity(pCaseItem2);
		itemId = dataAccess.getPCaseContainer().addEntity(pCaseItem3);

		assertEquals(((Integer) itemId) - 2, dataAccess.getPCaseContainer()
				.incrementCurrentItemId());
		assertEquals(((Integer) itemId) - 1, dataAccess.getPCaseContainer()
				.incrementCurrentItemId());
		assertEquals(((Integer) itemId), dataAccess.getPCaseContainer()
				.incrementCurrentItemId());
		assertEquals(((Integer) itemId) - 2, dataAccess.getPCaseContainer()
				.incrementCurrentItemId());
		assertEquals(((Integer) itemId) - 1, dataAccess.getPCaseContainer()
				.incrementCurrentItemId());
	}

	@Test
	public final void testAddEntity() {
		assertEquals(0, dataAccess.getPCaseContainer().size());
		assertNull(dataAccess.getPCaseContainer().getCurrentItem());
		assertNull(dataAccess.getPCaseContainer().getCurrentItemId());

		Object itemId = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		dataAccess.getPCaseContainer().addEntity(pCaseItem1);

		assertEquals(1, dataAccess.getPCaseContainer().size());
		assertNotNull(dataAccess.getPCaseContainer().getCurrentItem());
		assertNotNull(dataAccess.getPCaseContainer().getCurrentItemId());
		assertNotSame(pCaseItem1, dataAccess.getPCaseContainer()
				.getCurrentItem());

		PCase pCase = dataAccess.getPCaseContainer().getCurrentItem();

		assertEquals("Peter", dataAccess.getPCaseContainer().getCurrentItem()
				.getFirstName());
		pCase.setFirstName("Hans");
		assertEquals("Hans", dataAccess.getPCaseContainer().getCurrentItem()
				.getFirstName());

		assertEquals("Muster", dataAccess.getPCaseContainer().getCurrentItem()
				.getLastName());
		pCaseItem1.setLastName("Maurer");
		assertEquals("Muster", dataAccess.getPCaseContainer().getCurrentItem()
				.getLastName());
		pCaseItem1.setLastName("Muster");

		itemId = dataAccess.getPCaseContainer().getCurrentItemId();
		PCase pCaseClone = (PCase) pCase.clone();
		pCaseClone.setLastName("Müller");
		assertEquals("Muster", dataAccess.getPCaseContainer().getItem(itemId)
				.getEntity().getLastName());

		Object itemId2 = dataAccess.getPCaseContainer().addEntity(pCaseClone);
		assertEquals(2, dataAccess.getPCaseContainer().size());
		assertFalse(itemId == itemId2);
		assertEquals("Muster", dataAccess.getPCaseContainer().getItem(itemId)
				.getEntity().getLastName());
		assertEquals("Müller", dataAccess.getPCaseContainer().getItem(itemId2)
				.getEntity().getLastName());
	}

	@Test
	public final void editItemTest() throws CommitException {
		Object itemId = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		itemId = dataAccess.getPCaseContainer().addEntity(pCaseItem1);
		BeanFieldGroup<PCase> fieldGroup = new BeanFieldGroup<PCase>(PCase.class); 
		TextField textField = new TextField();
		
		PCase item = dataAccess.getPCaseContainer().getCurrentItem();
		fieldGroup.setItemDataSource(item);
		fieldGroup.bind(textField, "firstName");
		
		assertEquals("Peter", item.getFirstName());
		textField.setValue("Kurt");
		assertEquals("Peter", item.getFirstName());
		assertEquals("Peter", dataAccess.getPCaseContainer().getCurrentItem().getFirstName());
		fieldGroup.commit();
		assertEquals("Kurt", item.getFirstName());
		assertEquals("Kurt", dataAccess.getPCaseContainer().getCurrentItem().getFirstName());
		assertEquals(1, dataAccess.getPCaseContainer().size());
		
		itemId = dataAccess.getPCaseContainer().addEntity(fieldGroup.getItemDataSource().getBean());
		assertEquals(1,  dataAccess.getPCaseContainer().size());
	}
	
	@Test
	public final void enableCaseFilterTest() {
		Object itemId = dataAccess.getPmsUserContainer().addEntity(user);
		pCaseItem1.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		pCaseItem2.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		pCaseItem3.setTherapist(dataAccess.getPmsUserContainer()
				.getItem(itemId).getEntity());
		
		dataAccess.getPCaseContainer().addEntity(pCaseItem1);
		dataAccess.getPCaseContainer().addEntity(pCaseItem2);
		dataAccess.getPCaseContainer().addEntity(pCaseItem3);
		
		assertEquals(3, dataAccess.getPCaseContainer().size());
		dataAccess.getPCaseContainer().enableCaseFilter(true);
		assertEquals(2, dataAccess.getPCaseContainer().size());
		assertEquals(CaseStatus.ACTIVE, dataAccess.getPCaseContainer().getItem(dataAccess.getPCaseContainer().firstItemId()).getEntity().getCaseStatus());
		assertEquals(CaseStatus.ACTIVE, dataAccess.getPCaseContainer().getItem(dataAccess.getPCaseContainer().lastItemId()).getEntity().getCaseStatus());
		dataAccess.getPCaseContainer().enableCaseFilter(false);
		assertEquals(3, dataAccess.getPCaseContainer().size());
	}
	
}
