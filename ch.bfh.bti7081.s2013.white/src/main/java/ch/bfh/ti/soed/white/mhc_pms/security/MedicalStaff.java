package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;

// e.g. nurse
class MedicalStaff extends MhcPmsUser {

	protected <E extends MedicalStaff> MedicalStaff(Class<E> clazz) {
		super(clazz);
	}

	protected MedicalStaff() {
		this(MedicalStaff.class);
	}
	
	public <E extends MhcPmsItem> boolean  incrementCurrentItem(Class<E> clazz) {
		return this.dataAccess.getCurrentContainer(clazz).incrementCurrentItem();
	}

	public <E extends MhcPmsItem> boolean decrementCurrentItem(Class<E> clazz) {
		return this.dataAccess.getCurrentContainer(clazz).decrementCurrentItem();
	}

	public <E extends MhcPmsItem> boolean setCurrentItem(Class<E> clazz, Object value) {
		return this.dataAccess.getCurrentContainer(clazz).setCurrentItem(value);
	}
}
