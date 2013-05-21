package ch.bfh.ti.soed.white.mhc_pms.util;

import java.text.DateFormat;
import java.util.Date;

public final class ValueConverter {

	public static String convertString(Object object) {
		return object != null ? object.toString() : "";
	}

	public static String convertDate(Date date) {
		return date != null ? DateFormat.getDateInstance(DateFormat.SHORT).format(date) : "";
	}

}
