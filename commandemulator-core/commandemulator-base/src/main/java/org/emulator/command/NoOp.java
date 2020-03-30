package org.emulator.command;

import org.emulator.builder.CommandBuilder;
import org.emulator.line.SimpleLine;

/**
 * A command that performs no operation. Useful as initial command in a
 * {@link CommandBuilder}. The {@link #join(Command)} method returns the joined
 * command only, that is, this {@code nop} command is eliminated.
 */
public class NoOp extends AbstractCommand<NoOp.Args> {

	/**
	 * Arguments for NoOp.
	 */
	public static final class Args implements Arguments<Args> {
		@Override
		public Args getAll() {
			return this;//no arguments, hence the same for all contexts
		}
	}

	/**
	 * The "nop" command name. 
	 */
	public static final String NAME = "nop";
	/**
	 * The singleton instance.
	 */
	public static final NoOp INSTANCE = new NoOp();
	
	/**
	 * Private constructor for singleton {@link #INSTANCE}.
	 */
	private NoOp() {
		super(NAME, new Args());
	}
	
	@Override
	public Command<?> join(Command<?> next) {
		return next;
	}	


	@Override
	public SimpleLine executeCommand() {
		// TODO Auto-generated method stub
		return null;
	}
}
