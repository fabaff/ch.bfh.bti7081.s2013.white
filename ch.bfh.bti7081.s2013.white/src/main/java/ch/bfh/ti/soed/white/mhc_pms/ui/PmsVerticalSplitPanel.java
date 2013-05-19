package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

public class PmsVerticalSplitPanel extends VerticalSplitPanel implements View {

	private static final long serialVersionUID = -5935506035403174654L;

	@Override
	public void enter(ViewChangeEvent event) {
//		if (this.getUI() != null) {
//			this.getUI().addWindow(
//					new Window("new: "
//							+ event.getNewView().getClass().toString()));
//			this.getUI().addWindow(
//					new Window("old: "
//							+ event.getOldView().getClass().toString()));
//		}
	}

}
