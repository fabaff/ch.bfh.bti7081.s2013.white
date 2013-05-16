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
		MhcPmsContainer<Patient> patContainer = new MhcPmsContainer<Patient>(Patient.class);
		MhcPmsContainer<PCase> caseContainer = new MhcPmsContainer<PCase>(PCase.class);

		this.containerMap.put(Patient.class.getName(), patContainer);
		this.containerMap.put(PCase.class.getName(), caseContainer);
		// TODO restliche Container-Klassen ergänzen
	}

	public <E extends MhcPmsItem> MhcPmsContainer<? extends MhcPmsItem> getCurrentContainer(
			Class<E> clazz) {
		return this.containerMap.get(clazz.getName());
	}

	public <E extends MhcPmsItem> void setCurrentContainer(Class<E> clazz,
			MhcPmsContainer<E> mhcPmsContainer) {
		this.containerMap.put(clazz.getName(), mhcPmsContainer);
	}

}
