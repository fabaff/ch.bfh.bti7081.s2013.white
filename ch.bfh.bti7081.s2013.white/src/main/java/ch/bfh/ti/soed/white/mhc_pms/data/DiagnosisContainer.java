package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;

public class DiagnosisContainer extends PmsContainer<Diagnosis> {

	private static final long serialVersionUID = -5073391160883748556L;

	private Filter currentFilter;
	
	public DiagnosisContainer(Class<Diagnosis> clazz) {
		super(clazz);
	}

	public void setPCaseFilter(Object pCaseItemId) {
		// TODO korrekte propertyId  verwenden
		this.resetPCaseFilter();
//		this.currentFilter = Filters.eq("propertyId", pCaseItemId);
//		this.addContainerFilter(this.currentFilter);
	}

	public void resetPCaseFilter() {
		if (this.currentFilter != null) {
			this.removeContainerFilters(this.currentFilter);
		}
	}
}
