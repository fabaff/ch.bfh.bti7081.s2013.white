package ch.bfh.ti.soed.white.mhc_pms.controller;

import java.util.ArrayList;
import java.util.List;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * Entity implementation class for Entity: PmsComponentController
 */
public abstract class PmsComponentController extends CustomComponent implements View {

	private static final long serialVersionUID = -4631009926765712866L;

	private List<PmsComponentListener> pmsComponentListeners;
	
	private List<ComponentChangeListener> componentChangeListeners;
	
	private List<UIActivationListener> uiActivationListeners;
	
	private List<NewItemListener> newCaseListeners;
	
	protected PmsComponentController() {
		this.pmsComponentListeners = new ArrayList<>();
		this.componentChangeListeners = new ArrayList<>();
		this.uiActivationListeners = new ArrayList<>();
		this.newCaseListeners = new ArrayList<>();
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
	
	public void addNewCaseListener(NewItemListener listener) {
		this.newCaseListeners.add(listener);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {}
	
	protected void firePCaseItemChangeEvent() {
		for (PmsComponentListener listener : this.pmsComponentListeners) {
			listener.pCaseItemChange();
		}
	}
	
	protected void fireComponentChangeEvent(NavigationEvent event) {
		for (ComponentChangeListener listener : this.componentChangeListeners) {
			listener.componentChange(event);
		}
	}
	
	protected void fireUIActivationEvent(boolean value) {
		for (UIActivationListener listener : this.uiActivationListeners) {
			listener.enableUIComponents(value);
		}
	}
	
	protected void fireNewCaseEvent(boolean value) {
		for (NewItemListener listener : this.newCaseListeners) {
			listener.setNewItem(value);
		}
	}
	
}
