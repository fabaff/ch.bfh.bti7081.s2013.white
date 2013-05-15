package ch.bfh.ti.soed.white.mhc_pms.data;

import java.util.HashMap;
import java.util.Map;


public final class MhcPmsDataAccess {

	private static MhcPmsDataAccess instance;

	public static MhcPmsDataAccess getInstance() {
		if (instance == null) {
			instance = new MhcPmsDataAccess();
		}
		return instance;
	}

	private Map<String, MhcPmsContainer<? extends MhcPmsItem>> containerMap;
	
	private MhcPmsDataAccess() {
		this.containerMap = new HashMap<String, MhcPmsContainer<? extends MhcPmsItem>>();
		MhcPmsContainer<Patient> patients = new MhcPmsContainer<Patient>(Patient.class, this);
		
		this.containerMap.put(Patient.class.getName(), patients);
		// TODO restliche Container-Klassen ergänzen
	}

	public <E extends MhcPmsItem> MhcPmsContainer<? extends MhcPmsItem> getCurrentContainer(
			Class<E> clazz) {
		return this.containerMap.get(clazz.getName());
	}


}
