package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;

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
	
	private PmsDataAccess() {
//		this.pCaseContainer = JPAContainerFactory.make(PCase.class, PERSISTENCE_UNIT);
		this.pCaseContainer = new JPAContainer<>(PCase.class);
		this.pCaseContainer.setEntityProvider(new CachingBatchableLocalEntityProvider<PCase>(
				PCase.class, JPAContainerFactory.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT)));
		this.pCaseContainer.setAutoCommit(false);
	}

	public JPAContainer<PCase> getPCaseContainer() {
		return this.pCaseContainer;
	}
	
	
}
