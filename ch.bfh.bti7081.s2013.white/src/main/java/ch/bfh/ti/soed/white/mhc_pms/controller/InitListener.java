package ch.bfh.ti.soed.white.mhc_pms.controller;

/**
 * The observer pattern is used. A class can implement this interface, if it
 * will be notified when a new data initialization is needed.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public interface InitListener {

	/**
	 * The listener initializes the data source.
	 */
	void initialize();
}
