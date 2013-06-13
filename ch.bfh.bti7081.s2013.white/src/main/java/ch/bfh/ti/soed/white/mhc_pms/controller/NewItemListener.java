package ch.bfh.ti.soed.white.mhc_pms.controller;

/**
 * The observer pattern is used. A class can implement this interface if the
 * class needs information about: a new item should be added or an existing item should be edited.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public interface NewItemListener {

	/**
	 * The listener receives information if a new item should be added or an existing item should be edited.
	 * 
	 * @param value add new item (true) or edit existing item (false)
	 */
	void setNewItem(boolean value);
}
