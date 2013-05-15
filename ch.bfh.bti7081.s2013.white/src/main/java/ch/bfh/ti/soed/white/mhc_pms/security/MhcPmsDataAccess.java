package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsContainer;
import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;
import ch.bfh.ti.soed.white.mhc_pms.data.Patient;

import com.vaadin.data.Container;

public final class MhcPmsDataAccess {

	static {
		instance = new MhcPmsDataAccess();
	}
	
	private static MhcPmsDataAccess instance;
	
	public static MhcPmsDataAccess getInstance() {
		return instance;
	}
	
	public <E extends MhcPmsItem> Container getCurrentContainer(Class<E> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected <E extends MhcPmsItem> MhcPmsContainer<E> getCurrentMhcPmsContainer(Class<E> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	private MhcPmsDataAccess() {}

}
