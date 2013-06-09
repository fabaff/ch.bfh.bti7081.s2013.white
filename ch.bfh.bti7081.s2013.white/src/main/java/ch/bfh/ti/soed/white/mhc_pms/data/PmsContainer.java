package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 */
public class PmsContainer<E> extends JPAContainer<E> {

	private static final long serialVersionUID = -287883752877854160L;
	
	private Object currentItemId;
	
	public PmsContainer(Class<E> clazz) {
		super(clazz);
		this.setEntityProvider(new CachingBatchableLocalEntityProvider<E>(clazz,
						JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT)));
		this.setAutoCommit(true);
		
		this.currentItemId = this.firstItemId();
	}

	/**
	 * @return the currentItemId
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

	public Object addEntity(E item) {
		this.currentItemId = super.addEntity(item);
		this.refresh();
		return this.currentItemId;
	}

	public E getCurrentItem() {
		EntityItem<E> entityItem = this.getItem(this.getCurrentItemId());
		return entityItem != null ? entityItem.getEntity() : null;
	}

}
