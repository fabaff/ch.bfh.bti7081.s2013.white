package ch.bfh.ti.soed.white.mhc_pms.security;


class Psychiatrist extends Therapist {

	protected Psychiatrist() {
		this(Psychiatrist.class);
	}
	
	protected <E extends Psychiatrist> Psychiatrist(Class<E> clazz) {
		super(clazz);
	}
	
}
