package ch.bfh.ti.soed.white.mhc_pms.ui;

import com.vaadin.ui.Component;

public interface ImhcPmsComponent {

	void setActiveComponents(Component title, Component detail);

	void updateComponentDataSource();

	Component getHomeTitleBarComponent();

	Component getNewPatientComponent();

	void enableMenuBar(boolean b);

	Component getEditCaseInfoComponent();

	Component getPatientInfoComponent();

	Component getCaseInfoComponent();

	Component getTitleBarComponent();
}
