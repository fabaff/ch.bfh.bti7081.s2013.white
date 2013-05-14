package ch.bfh.ti.soed.white.mhc_pms.security;

public class UserSingleton {

	private static MhcPmsUser user;

	public static MhcPmsUser getUser() {
		if (user == null) {
			user = UserFactory.createUser();
		}
		return user;
	}

	private UserSingleton() {}
}
