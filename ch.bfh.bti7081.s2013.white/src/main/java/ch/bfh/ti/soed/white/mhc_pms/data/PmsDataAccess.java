package ch.bfh.ti.soed.white.mhc_pms.data;

import ch.bfh.ti.soed.white.mhc_pms.security.UIPermissionInstance;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * 
 */

public class PmsDataAccess {

	private static final String PERSISTENCE_UNIT = "ch.bfh.bti7081.s2013.white";

	private static PmsDataAccess instance;

	public static PmsDataAccess getInstance() {
		if (instance == null) {
			instance = new PmsDataAccess();
		}
		return instance;
	}

	private JPAContainer<PCase> pCaseContainer;

	private Object currentPCaseId;
	
	private PmsUser currentUser;
	
	private boolean isNewCaseActivated;

	private PmsDataAccess() {
		this.isNewCaseActivated = true;
		
		// this.pCaseContainer = JPAContainerFactory.make(PCase.class,
		// PERSISTENCE_UNIT);
		this.pCaseContainer = new JPAContainer<>(PCase.class);
		this.pCaseContainer
				.setEntityProvider(new CachingBatchableLocalEntityProvider<PCase>(
						PCase.class,
						JPAContainerFactory
								.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT)));
		this.pCaseContainer.setAutoCommit(true);

		this.currentPCaseId = this.pCaseContainer.firstItemId();
		// TODO Get current user from DB
		this.currentUser = new PmsUser(UIPermissionInstance.getPermission().getUserName());
	}

	public JPAContainer<PCase> getPCaseContainer() {
		return this.pCaseContainer;
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
		if (this.pCaseContainer.size() > 1) {
			Object id = null;
			if (this.pCaseContainer.isFirstId(this.getCurrentPCaseId())) {
				id = this.pCaseContainer.lastItemId();
			} else {
				id = this.pCaseContainer.prevItemId(this.getCurrentPCaseId());
			}
			this.setCurrentPCaseId(id);
			return id;
		} else {
			return this.getCurrentPCaseId();
		}
	}

	public Object incrementCurrentPCaseItemId() {
		if (this.pCaseContainer.size() > 1) {
			Object id = null;
			if (this.pCaseContainer.isLastId(this.getCurrentPCaseId())) {
				id = this.pCaseContainer.firstItemId();
			} else {
				id = this.pCaseContainer.nextItemId(this.getCurrentPCaseId());
			}
			this.setCurrentPCaseId(id);
			return id;
		} else {
			return this.getCurrentPCaseId();
		}
	}

	public PmsUser getUser() {
		return this.currentUser;
	}

	public void setNewCaseActivated(boolean value) {
		this.isNewCaseActivated = value;
	}

	/**
	 * @return the isNewCaseActivated
	 */
	public boolean isNewCaseActivated() {
		return this.isNewCaseActivated;
	}

}
