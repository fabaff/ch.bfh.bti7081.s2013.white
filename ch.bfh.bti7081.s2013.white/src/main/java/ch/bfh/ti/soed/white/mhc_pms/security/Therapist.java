package ch.bfh.ti.soed.white.mhc_pms.security;

class Therapist extends ExtendedMedicalStaff {

	protected <E extends Therapist> Therapist(Class<E> clazz) {
		super(clazz);
	}

	protected Therapist() {
		this(Therapist.class);
	}

}
