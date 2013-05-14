package ch.bfh.ti.soed.white.mhc_pms.security;

class UserFactory {

	static MhcPmsUser createUser() {
		// TODO erstelltes objekt ist abhängig vom authentifizierten User
		return new Psychiatrist();
	}

	private UserFactory() {}
}
