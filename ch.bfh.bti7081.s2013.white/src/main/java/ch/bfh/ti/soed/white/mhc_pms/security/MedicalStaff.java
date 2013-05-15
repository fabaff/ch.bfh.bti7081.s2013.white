package ch.bfh.ti.soed.white.mhc_pms.security;

// e.g. nurse
class MedicalStaff extends MhcPmsUser {

	protected <E extends MedicalStaff> MedicalStaff(Class<E> clazz) {
		super(clazz);
	}

}
