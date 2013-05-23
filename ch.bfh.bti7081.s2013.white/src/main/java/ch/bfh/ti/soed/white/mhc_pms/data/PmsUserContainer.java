package ch.bfh.ti.soed.white.mhc_pms.data;

public class PmsUserContainer extends PmsContainer<PmsUser> {

	private static final long serialVersionUID = -6061413589999422421L;

	public PmsUserContainer(Class<PmsUser> clazz) {
		super(clazz);
	}

	public PmsUser getCurrentUser(String userName) {
		// TODO current user from db
		return new PmsUser();
	}

}
