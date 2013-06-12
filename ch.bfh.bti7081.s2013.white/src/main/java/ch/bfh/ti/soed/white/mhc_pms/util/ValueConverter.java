package ch.bfh.ti.soed.white.mhc_pms.util;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 * Converter and formatting helper for various elements.
 */
public final class ValueConverter {

	/**
	 * Converter for strings
	 * 
	 * @param object An object which needs a conversation to string.
	 * @return The object as string.
	 */
	public static String convertString(Object object) {
		return object != null ? object.toString() : "";
	}

	/**
	 * Date formatter
	 * 
	 * @param date Date to format
	 * @return The date transformed into the wished format.
	 */
	public static String convertDate(Date date) {
		return date != null ? DateFormat.getDateInstance(DateFormat.SHORT).format(date) : "";
	}

}
