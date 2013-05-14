package ch.bfh.ti.soed.white.mhc_pms.security;

abstract class MedicalStaff extends MhcPmsUser {

	protected <E extends MedicalStaff> MedicalStaff(Class<E> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

}
