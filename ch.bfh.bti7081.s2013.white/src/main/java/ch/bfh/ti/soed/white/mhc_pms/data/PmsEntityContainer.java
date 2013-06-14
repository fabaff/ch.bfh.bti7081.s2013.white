package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;
import com.vaadin.data.util.filter.And;

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
	
	private And mainFilter;

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
		if (this.mainFilter != null) {
			this.removeContainerFilters(this.mainFilter);
		}
		
		this.currentPCaseFilter = null;
		if (this.deleteFilter != null) {
			this.mainFilter = Filters.and(this.deleteFilter);
			this.addContainerFilter(this.mainFilter);
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
			if (this.mainFilter != null) {
				this.removeContainerFilters(this.mainFilter);
			}
			
			this.currentPCaseFilter = Filters.eq(PCASE_ITEM_FILTER_PROPERTY_ID,
					pCaseItemId);
			if (this.deleteFilter != null) {
				this.mainFilter = Filters.and(this.currentPCaseFilter, this.deleteFilter);
			} else {
				this.mainFilter = Filters.and(this.currentPCaseFilter);
			}
			
			this.addContainerFilter(this.mainFilter);
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
			if (this.mainFilter != null) {
				this.removeContainerFilters(this.mainFilter);
			}
			
			this.deleteFilter = Filters.eq(DELETE_FILTER_PROPERTY_ID, false);
			if (this.currentPCaseFilter != null) {
				this.mainFilter = Filters.and(this.currentPCaseFilter, this.deleteFilter);
			} else {
				this.mainFilter = Filters.and(this.deleteFilter);
			}
			
			this.addContainerFilter(this.mainFilter);
		} else {
			this.removeContainerFilters(this.mainFilter);
			
			this.deleteFilter = null;
			if (this.currentPCaseFilter != null) {
				this.mainFilter = Filters.and(this.currentPCaseFilter);
				this.addContainerFilter(this.mainFilter);
			}
		}
	}

}
