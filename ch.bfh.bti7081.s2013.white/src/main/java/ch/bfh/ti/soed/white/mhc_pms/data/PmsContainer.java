package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * Entity implementation class for Entity: PmsContainer
 */
public class PmsContainer<E> extends JPAContainer<E> {

	private static final long serialVersionUID = -287883752877854160L;

	private Object currentPCaseId;

	public PmsContainer(Class<E> clazz) {
		super(clazz);
		this.setEntityProvider(new CachingBatchableLocalEntityProvider<E>(clazz,
						JPAContainerFactory.createEntityManagerForPersistenceUnit(PmsDataAccess.PERSISTENCE_UNIT)));
		this.setAutoCommit(true);
		this.currentPCaseId = this.firstItemId();
	}

	/**
	 * @return the currentPCaseId
	 */
	public Object getCurrentPCaseId() {
		return this.currentPCaseId;
	}

	/**
	 * @param currentPCaseId
	 *            the currentPCaseId to set
	 */
	public void setCurrentPCaseId(Object currentPCaseId) {
		this.currentPCaseId = currentPCaseId;
	}

	public Object decrementCurrentPCaseItemId() {
		if (this.size() > 1) {
			Object id = null;
			if (this.isFirstId(this.getCurrentPCaseId())) {
				id = this.lastItemId();
			} else {
				id = this.prevItemId(this.getCurrentPCaseId());
			}
			this.setCurrentPCaseId(id);
			return id;
		} else {
			return this.getCurrentPCaseId();
		}
	}

	public Object incrementCurrentPCaseItemId() {
		if (this.size() > 1) {
			Object id = null;
			if (this.isLastId(this.getCurrentPCaseId())) {
				id = this.firstItemId();
			} else {
				id = this.nextItemId(this.getCurrentPCaseId());
			}
			this.setCurrentPCaseId(id);
			return id;
		} else {
			return this.getCurrentPCaseId();
		}
	}

	public Object addEntity(E item) {
		this.currentPCaseId = super.addEntity(item);
		this.refresh();
		return this.currentPCaseId;
	}

}
