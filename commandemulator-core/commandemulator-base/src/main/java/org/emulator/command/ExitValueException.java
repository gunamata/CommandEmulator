package org.emulator.command;

/**
 * An exception thrown when a command terminates with an error; in Unix, the
 * command would return a value different from zero. Note that the Java VM does
 * NOT terminate and exit if such an exception occurs.
 */
public class ExitValueException extends RuntimeException {

	private static final long serialVersionUID = 2153738224794893827L;

	private final int exitValue;

	public ExitValueException(String message, int exitValue) {
		super(message);
		if (exitValue == 0) {
			throw new IllegalArgumentException("exit value must be a non-zero value");
		}
		this.exitValue = exitValue;
	}

	/**
	 * Constructor with message, a non-zero exit value and a causing exception.
	 * 
	 * @param message
	 *            the error message
	 * @param exitValue
	 *            the exit value, must be different from zero
	 * @param cause
	 *            the exception that caused the error termination of the command
	 * @throws IllegalArgumentException
	 *             if {@code exitValue==0}
	 */
	public ExitValueException(String message, int exitValue, Throwable cause) {
		super(message, cause);
		if (exitValue == 0) {
			throw new IllegalArgumentException("exit value must be a non-zero value");
		}
		this.exitValue = exitValue;
	}

	/**
	 * Returns the exit value, an int value or error code different from zero
	 * that was passed to the constructor of this exception.
	 * 
	 * @return the non-zero exit or error code value
	 */
	public int getExitValue() {
		return exitValue;
	}

}
