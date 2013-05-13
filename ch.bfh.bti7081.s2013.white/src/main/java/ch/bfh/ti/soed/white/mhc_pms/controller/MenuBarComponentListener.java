package ch.bfh.ti.soed.white.mhc_pms.controller;


import java.util.HashMap;
import java.util.Map;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;


public class MenuBarComponentListener implements com.vaadin.ui.Button.ClickListener {

	/**
	 * @author Patrick Kofmel
	 *
	 */
	public enum MenuBarButtonEnum {
		HOME, PATIENT_INFO, CASE_INFO, PATIENT_PROGRESS, DIAGNOSIS, MEDICATION, BACK, FORWARD
	}
	
	private Map<MenuBarButtonEnum, Component[]> buttonMap;
	
	private static final long serialVersionUID = 3857586032943374364L;

	public MenuBarComponentListener() {
		this.buttonMap = new HashMap<>(MenuBarButtonEnum.values().length);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		event.getButton();
		
	}

	public void addButton(MenuBarButtonEnum button, Component header, Component main) {
		this.buttonMap.put(button, new Component[] { header, main });
	}

}
