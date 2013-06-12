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
 * This utility class creates dummy data for simpler database handling.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *
 */
public final class DummyDataCreator {

	/**
	 * This static method creates a dummy user with user name "user" and password "password".
	 */
	public static void createDummyUser() {
		JPAContainer<PmsUser> jpaContainer = new JPAContainer<>(PmsUser.class);
		jpaContainer
				.setEntityProvider(new CachingBatchableLocalEntityProvider<PmsUser>(
						PmsUser.class,
						JPAContainerFactory
								.createEntityManagerForPersistenceUnit(PmsDataAccessCreator.getPersistenceUnit())));
		jpaContainer.setAutoCommit(true);

		Filter userFilter = Filters.eq("userName", PmsDataAccessCreator.DUMMY_USER);
		Filter passwordFilter = Filters.eq("password", Hash.MD5(PmsDataAccessCreator.DUMMY_PASSWORD));
		jpaContainer.addContainerFilter(userFilter);
		jpaContainer.addContainerFilter(passwordFilter);
		Object id = jpaContainer.firstItemId();
		jpaContainer.removeContainerFilters(userFilter);
		jpaContainer.removeContainerFilters(passwordFilter);

		if (id == null) {
			PmsUser dummyUser = new PmsUser();
			dummyUser.setUserName(PmsDataAccessCreator.DUMMY_USER);
			dummyUser.setPassword(Hash.MD5(PmsDataAccessCreator.DUMMY_PASSWORD));
			dummyUser.setUserGroup(UserGroup.PSYCHIATRIST);
			jpaContainer.addEntity(dummyUser);
		}
	}

}
