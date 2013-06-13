package ch.bfh.ti.soed.white.mhc_pms.controller;

/**
 * The observer pattern is used. A class can implement this interface if it will
 * be notified when it should enable or disable certain UI elements.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public interface UIActivationListener {

	/**
	 * Notification, if some UI elements should be enabled or disabled.
	 * 
	 * @param value enable (true) or disable (false) some UI elements.
	 */
	void enableUIComponents(boolean value);
}
