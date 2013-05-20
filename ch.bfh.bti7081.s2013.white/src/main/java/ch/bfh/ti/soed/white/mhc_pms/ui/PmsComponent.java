package ch.bfh.ti.soed.white.mhc_pms.ui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

class PmsComponent extends CustomComponent implements View {

	private static final long serialVersionUID = -4631009926765712866L;

	private List<PmsComponentListener> pmsComponentListeners;
	
	protected PmsComponent() {
		this.pmsComponentListeners = new ArrayList<>();
	}
	
	protected void addPmsComponentListener(PmsComponentListener listener) {
		this.pmsComponentListeners.add(listener);
	}
	
	protected void firePCaseItemChangeEvent(Object itemId) {
		for (PmsComponentListener listener : this.pmsComponentListeners) {
			listener.pCaseItemChange(itemId);
		}
	}
	
	@Override
	public void enter(ViewChangeEvent event) {}

}
