package ch.bfh.ti.soed.white.mhc_pms.controller;

import java.util.ArrayList;
import java.util.List;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public abstract class PmsComponentController extends CustomComponent implements View {

	private static final long serialVersionUID = -4631009926765712866L;

	private List<PmsComponentListener> pmsComponentListeners;
	
	private List<ComponentChangeListener> componentChangeListeners;
	
	private List<UIActivationListener> uiActivationListeners;
	
	protected PmsComponentController() {
		this.pmsComponentListeners = new ArrayList<>();
		this.componentChangeListeners = new ArrayList<>();
		this.uiActivationListeners = new ArrayList<>();
	}
	
	public void addPmsComponentListener(PmsComponentListener listener) {
		this.pmsComponentListeners.add(listener);
	}
	
	public void addComponentChangeListener(ComponentChangeListener listener) {
		this.componentChangeListeners.add(listener);
	}
	
	public void addUIActivationListener(UIActivationListener listener) {
		this.uiActivationListeners.add(listener);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {}
	
	
	protected void firePCaseItemChangeEvent(Object itemId) {
		for (PmsComponentListener listener : this.pmsComponentListeners) {
			listener.pCaseItemChange(itemId);
		}
	}
	
	protected void fireComponentChangeEvent(EditEvent event) {
		for (ComponentChangeListener listener : this.componentChangeListeners) {
			listener.componentChange(event);
		}
	}
	
	protected void fireUIActivationEvent(boolean value) {
		for (UIActivationListener listener : this.uiActivationListeners) {
			listener.enableUIComponents(value);
		}
	}
	
}