package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;

// e.g. MedAdmin
class ExtendedMedicalStaff extends MedicalStaff {

	protected <E extends ExtendedMedicalStaff> ExtendedMedicalStaff(Class<E> clazz) {
		super(clazz);
	}

	public <E extends MhcPmsItem> void  incrementCurrentItem(Class<E> clazz) {
		this.dataAccess.getCurrentMhcPmsContainer(clazz).incrementCurrentItem();
	}

	public <E extends MhcPmsItem> void decrementCurrentItem(Class<E> clazz) {
		this.dataAccess.getCurrentMhcPmsContainer(clazz).decrementCurrentItem();
	}

	public <E extends MhcPmsItem> void setCurrentItem(Class<E> clazz, Object value) {
		this.dataAccess.getCurrentMhcPmsContainer(clazz).setCurrentItem(value);
	}
}
