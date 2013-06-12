package ch.bfh.ti.soed.white.mhc_pms.util;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.filter.Filters;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;
import com.vaadin.data.Container.Filter;

import ch.bfh.ti.soed.white.mhc_pms.data.PmsDataAccessCreator;
import ch.bfh.ti.soed.white.mhc_pms.data.PmsUser;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;

/**
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *
 */
public final class DummyDataCreator {

	public static void createDummyUsers() {
		JPAContainer<PmsUser> jpaContainer = new JPAContainer<>(PmsUser.class);
		jpaContainer
				.setEntityProvider(new CachingBatchableLocalEntityProvider<PmsUser>(
						PmsUser.class,
						JPAContainerFactory
								.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.PERSISTENCE_UNIT)));
		jpaContainer.setAutoCommit(true);

		Filter userFilter = Filters.eq("userName", "user");
		Filter passwordFilter = Filters.eq("password", Hash.MD5("password"));
		jpaContainer.addContainerFilter(userFilter);
		jpaContainer.addContainerFilter(passwordFilter);
		Object id = jpaContainer.firstItemId();
		jpaContainer.removeContainerFilters(userFilter);
		jpaContainer.removeContainerFilters(passwordFilter);

		if (id == null) {
			PmsUser dummyUser = new PmsUser();
			dummyUser.setUserName("user");
			dummyUser.setPassword(Hash.MD5("password"));
			dummyUser.setUserGroup(UserGroup.PSYCHOLOGIST);
			jpaContainer.addEntity(dummyUser);
		}
	}

}
