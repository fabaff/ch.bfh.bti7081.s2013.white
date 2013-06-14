package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;

/**
 * A container class for direct sub entities of the PCase entity. This class
 * provides a filter for a given PCase item id.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 * @param <E>
 */
public class PmsEntityContainer<E> extends PmsContainer<E> {

	private static final long serialVersionUID = 1027872825311274323L;

	private static Object PCASE_ITEM_FILTER_PROPERTY_ID = "pCase.pcid";

	private static Object DELETE_FILTER_PROPERTY_ID = "isDeleted";

	private Filter currentPCaseFilter;

	private Filter deleteFilter;

	/**
	 * @param clazz
	 *            entity class object
	 */
	public PmsEntityContainer(Class<E> clazz) {
		super(clazz);

	}

	/**
	 * Removes the PCase filter form this container.
	 */
	public void resetCurrentPCaseFilter() {
		if (this.currentPCaseFilter != null) {
			this.removeContainerFilters(this.currentPCaseFilter);
		}
	}

	/**
	 * Sets a new PCase filter for this container and restes the current item
	 * id.
	 * 
	 * @param pCaseItemId
	 */
	public void setCurrentPCaseFilter(Object pCaseItemId) {
		if (pCaseItemId != null) {
			this.resetCurrentPCaseFilter();
			this.currentPCaseFilter = Filters.eq(PCASE_ITEM_FILTER_PROPERTY_ID,
					pCaseItemId);
			this.addContainerFilter(this.currentPCaseFilter);
			this.setCurrentItemId(this.firstItemId());
		}
	}

	/**
	 * Enable delete filter: items with isDeleted flags are ignored in the
	 * container.
	 * 
	 * @param value
	 */
	public void enableDeleteFilter(boolean value) {
		if (value) {
			if (this.deleteFilter != null) {
				this.removeContainerFilters(this.deleteFilter);
			}
			this.deleteFilter = Filters.eq(DELETE_FILTER_PROPERTY_ID, false);
			this.addContainerFilter(this.deleteFilter);
		} else {
			this.removeContainerFilters(this.deleteFilter);
		}
	}

}
