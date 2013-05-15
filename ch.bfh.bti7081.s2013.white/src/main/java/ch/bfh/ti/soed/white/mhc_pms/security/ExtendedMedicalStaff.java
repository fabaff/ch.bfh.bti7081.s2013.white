package ch.bfh.ti.soed.white.mhc_pms.security;


// e.g. MedAdmin
class ExtendedMedicalStaff extends MedicalStaff {

	protected <E extends ExtendedMedicalStaff> ExtendedMedicalStaff(Class<E> clazz) {
		super(clazz);
	}
	
	protected ExtendedMedicalStaff() {
		this(ExtendedMedicalStaff.class);
	}

}
