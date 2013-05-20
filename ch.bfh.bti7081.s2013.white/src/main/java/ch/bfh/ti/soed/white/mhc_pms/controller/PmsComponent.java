package ch.bfh.ti.soed.white.mhc_pms.controller;

import java.util.ArrayList;
import java.util.List;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public class PmsComponent extends CustomComponent implements View {

	private static final long serialVersionUID = -4631009926765712866L;

	private List<PmsComponentListener> pmsComponentListeners;
	
	private List<ComponentChangeListener> detailComponentChangeListeners;
	
	protected PmsComponent() {
		this.pmsComponentListeners = new ArrayList<>();
		this.detailComponentChangeListeners = new ArrayList<>();
	}
	
	public void addPmsComponentListener(PmsComponentListener listener) {
		this.pmsComponentListeners.add(listener);
	}
	
	protected void firePCaseItemChangeEvent(Object itemId) {
		for (PmsComponentListener listener : this.pmsComponentListeners) {
			listener.pCaseItemChange(itemId);
		}
	}
	
	public void addNewPatientComponentChangeListener(ComponentChangeListener listener) {
		this.detailComponentChangeListeners.add(listener);
	}
	
	protected void fireNewPatientComponentChangeEvent() {
		for (ComponentChangeListener listener : this.detailComponentChangeListeners) {
			listener.newPatientComponentChangeListener();
		}
	}
	
	@Override
	public void enter(ViewChangeEvent event) {}

}
