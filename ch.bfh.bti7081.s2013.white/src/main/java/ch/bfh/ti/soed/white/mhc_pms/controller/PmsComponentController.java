package ch.bfh.ti.soed.white.mhc_pms.controller;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;

/**
 * This is the controller base class for all UI components. Listeners could be
 * added and instances of this class could fire events. Subclasses must
 * implement the View interface. All subclasses can be used as the destination
 * of a navigator.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public abstract class PmsComponentController extends CustomComponent implements
		View {

	private static final long serialVersionUID = -4631009926765712866L;
	private List<ComponentChangeListener> componentChangeListeners;
	private List<NewItemListener> newCaseListeners;
	private List<PmsComponentListener> pmsComponentListeners;
	private List<PmsDiagnosisListener> pmsDiagnosisListeners;
	private List<UIActivationListener> uiActivationListeners;
	private List<InitListener> initListeners;

	protected PmsComponentController() {
		this.pmsComponentListeners = new ArrayList<>();
		this.componentChangeListeners = new ArrayList<>();
		this.uiActivationListeners = new ArrayList<>();
		this.newCaseListeners = new ArrayList<>();
		this.initListeners = new ArrayList<>();
		this.pmsDiagnosisListeners = new ArrayList<>();
	}

	/**
	 * Listener for Component changes
	 * 
	 * @param listener
	 */
	public void addComponentChangeListener(ComponentChangeListener listener) {
		this.componentChangeListeners.add(listener);
	}

	/**
	 * Listener for New Case
	 * 
	 * @param listener
	 */
	public void addNewCaseListener(NewItemListener listener) {
		this.newCaseListeners.add(listener);
	}

	/**
	 * Listener for PmsComponent
	 * 
	 * @param listener
	 */
	public void addPmsComponentListener(PmsComponentListener listener) {
		this.pmsComponentListeners.add(listener);
	}

	/**
	 * Listener for UI actions
	 * 
	 * @param listener
	 */
	public void addUIActivationListener(UIActivationListener listener) {
		this.uiActivationListeners.add(listener);
	}
	
	/**
	 * Listener for Init action
	 * 
	 * @param listener
	 */
	public void addInitListener(InitListener listener) {
		this.initListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public void addPmsDiagnosisListener(PmsDiagnosisListener listener) {
		this.pmsDiagnosisListeners.add(listener);
	}
	
	/**
	 * Listener for Change event
	 * 
	 * @param event
	 */
	protected void fireComponentChangeEvent(NavigationEvent event) {
		for (ComponentChangeListener listener : this.componentChangeListeners) {
			listener.componentChange(event);
		}
	}

	protected void firePmsDiagnosisEvent() {
		for (PmsDiagnosisListener listener : this.pmsDiagnosisListeners) {
			listener.diagnosisItemChange();
		}
	}
	
	/**
	 * Listener for Case event
	 * 
	 * @param value
	 */
	protected void fireNewCaseEvent(boolean value) {
		for (NewItemListener listener : this.newCaseListeners) {
			listener.setNewItem(value);
		}
	}

	/**
	 * Listener for PCase event
	 */
	protected void firePCaseItemChangeEvent() {
		for (PmsComponentListener listener : this.pmsComponentListeners) {
			listener.pCaseItemChange();
		}
	}

	/**
	 * Listener for UI actions
	 * 
	 * @param value
	 */
	protected void fireUIActivationEvent(boolean value) {
		for (UIActivationListener listener : this.uiActivationListeners) {
			listener.enableUIComponents(value);
		}
	}

	/**
	 * Listener for Init actions
	 */
	protected void fireInitEvent() {
		for (InitListener listener : this.initListeners) {
			listener.initialize();
		}
	}
}
