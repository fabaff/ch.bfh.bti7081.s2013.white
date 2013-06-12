package ch.bfh.ti.soed.white.mhc_pms.data;


import com.vaadin.addon.jpacontainer.filter.Filters;

/**
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
	
	private Filter currentFilter;

	public PmsEntityContainer(Class<E> clazz) {
		super(clazz);
	}

	public void resetCurrentItemFilter() {
		if (this.currentFilter != null) {
			this.removeContainerFilters(this.currentFilter);
		}
	}

	public void setCurrentItemFilter(Object pCaseItemId) {
		if (pCaseItemId != null) {
			this.resetCurrentItemFilter();
			this.currentFilter = Filters.eq(PCASE_ITEM_FILTER_PROPERTY_ID, pCaseItemId);
			this.addContainerFilter(this.currentFilter);
		}
	}

}
