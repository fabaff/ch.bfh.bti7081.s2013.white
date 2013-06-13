package ch.bfh.ti.soed.white.mhc_pms.data;

/**
 * Class for the unknown user exception
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public class UnknownUserException extends Exception {
	private static final long serialVersionUID = 8120420020283027077L;
	private String INVALID_USER_MESSAGE = "In dieser Anwendung ist ein Fehler aufgetreten! Unbekannter User: ";
	private String invalidUserName;
	
	/**
	 * Exception for invalid user data
	 * 
	 * @param message
	 * @param invalidUserName
	 */
	public UnknownUserException(String message, String invalidUserName) {
		super(message);
		this.invalidUserName = invalidUserName;
	}

	/**
	 * @return the invalidUserName
	 */
	public String getInvalidUserMessage() {
		return INVALID_USER_MESSAGE + this.invalidUserName;
	}
}
