package ch.bfh.ti.soed.white.mhc_pms.controller;

/**
 * This listener will be notified if a component will navigate to
 * an other component. The observer pattern will be used.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public interface ComponentChangeListener {

	/**
	 * This method will be called if the subject needs to navigate to an other component.
	 * 
	 * @param event specifies the navigation target
	 */
	void componentChange(NavigationEvent event);

}