package ch.bfh.ti.soed.white.mhc_pms.util;

/**
 * Class for hashing the user's password into MD5.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0 
 */
public class Hash {
	/**
	 * Hash function for strings
	 * 
	 * @param String A string which has to be hashed.
	 * @return The hashed string.
	 */
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return null;
	}
}
