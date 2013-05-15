package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsContainer;
import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;

// e.g. nurse
class MedicalStaff extends MhcPmsUser {

	protected <E extends MedicalStaff> MedicalStaff(Class<E> clazz) {
		super(clazz);
	}

	protected MedicalStaff() {
		this(MedicalStaff.class);
	}

	public <E extends MhcPmsItem> boolean incrementCurrentItem(Class<E> clazz) {
		MhcPmsContainer<? extends MhcPmsItem> container = this.dataAccess
				.getCurrentContainer(clazz);
		if (container != null) {
			return container.incrementCurrentItem();
		} else {
			return false;
		}
	}

	public <E extends MhcPmsItem> boolean decrementCurrentItem(Class<E> clazz) {
		MhcPmsContainer<? extends MhcPmsItem> container = this.dataAccess
				.getCurrentContainer(clazz);
		if (container != null) {
			return container.decrementCurrentItem();
		} else {
			return false;
		}

	}

	public <E extends MhcPmsItem> boolean setCurrentItem(Class<E> clazz,
			Object value) {
		MhcPmsContainer<? extends MhcPmsItem> container = this.dataAccess
				.getCurrentContainer(clazz);
		if (container != null) {
			return container.setCurrentItem(value);
		} else {
			return false;
		}
	}

}
