package ch.bfh.ti.soed.white.mhc_pms.util;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author		Gruppe White, I2p, BFH Bern, https://github.com/fabaff/ch.bfh.bti7081.s2013.white
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * 
 */
public final class ValueConverter {

	public static String convertString(Object object) {
		return object != null ? object.toString() : "";
	}

	public static String convertDate(Date date) {
		return date != null ? DateFormat.getDateInstance(DateFormat.SHORT).format(date) : "";
	}

}
