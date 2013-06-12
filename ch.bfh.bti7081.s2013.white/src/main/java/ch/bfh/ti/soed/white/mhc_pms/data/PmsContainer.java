package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;

/**
 * This container establishes a connection to a table in the database. The data
 * can be manipulated and fetched through this container. It is a subclass of
 * the vaadin JPA container class.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public class PmsContainer<E> extends JPAContainer<E> {

	private static final long serialVersionUID = -287883752877854160L;

	private Object currentItemId;

	/**
	 * 
	 * @param clazz
	 *            entity class object
	 */
	public PmsContainer(Class<E> clazz) {
		super(clazz);
		this.setEntityProvider(new CachingBatchableLocalEntityProvider<E>(
				clazz,
				JPAContainerFactory
						.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.getPersistenceUnit())));
		this.setAutoCommit(true);
		this.refresh();

		this.currentItemId = this.firstItemId();

		// TODO Filter für isDEleted
	}

	/**
	 * @return the currentItemId or null if the container is empty
	 */
	public Object getCurrentItemId() {
		return this.currentItemId;
	}

	/**
	 * @param currentItemId
	 *            the currentItemId to set
	 */
	public void setCurrentItemId(Object currentItemId) {
		this.currentItemId = currentItemId;
	}

	/**
	 * This method decrements the current item id by one. It searches the
	 * previous valid item id before the current item id. Decrementing the first
	 * valid item id results in the last current item id.
	 * 
	 * @return the previous valid item before the current item id
	 */
	public Object decrementCurrentItemId() {
		if (this.size() > 1) {
			Object id = null;
			
			if (this.isFirstId(this.getCurrentItemId())) {
				id = this.lastItemId();
			} else {
				id = this.prevItemId(this.getCurrentItemId());
			}
			
			this.setCurrentItemId(id);
			return id;
		} else {
			return this.getCurrentItemId();
		}
	}

	/**
	 * 
	 * This method increments the current item id by one. It searches the
	 * next valid item id after the current item id. Incrementing the last
	 * valid item id results in the first current item id.
	 * 
	 * @return the next valid item after the current item id
	 */
	public Object incrementCurrentItemId() {
		if (this.size() > 1) {
			Object id = null;
			
			if (this.isLastId(this.getCurrentItemId())) {
				id = this.firstItemId();
			} else {
				id = this.nextItemId(this.getCurrentItemId());
			}
			
			this.setCurrentItemId(id);
			return id;
		} else {
			return this.getCurrentItemId();
		}
	}

	/**
	 * Adds a new item to this container. The current item id is set to the added item id.
	 * 
	 * @param item the item that will be added to this container
	 * 
	 * @return the item id of the added item
	 */
	@Override
	public Object addEntity(E item) {
		this.currentItemId = super.addEntity(item);
		this.refresh();
		return this.currentItemId;
	}

	/**
	 * 
	 * Returns the current item of this container or null if this container is empty.
	 * 
	 * @return the current item of this container or null if this container is empty
	 */
	public E getCurrentItem() {
		EntityItem<E> entityItem = this.getItem(this.getCurrentItemId());
		return entityItem != null ? entityItem.getEntity() : null;
	}

}
