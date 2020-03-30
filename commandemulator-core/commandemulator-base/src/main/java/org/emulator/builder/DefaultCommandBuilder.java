package org.emulator.builder;

import org.emulator.command.Command;
import org.emulator.command.ExitValueException;
import org.emulator.command.NoOp;

/**
 * Default implementation for a {@link CommandBuilder}. Builds a {@link NoOp}
 * command if no command is {@link #join(Command) joined} to the command chain
 * of this builder.
 */
public class DefaultCommandBuilder implements CommandBuilder {

	private Command<?> command = NoOp.INSTANCE;

	@Override
	public Command<?> build() {
		return command;
	}
	
	@Override
	public CommandBuilder join(Command<?> command) {
		if (command == null) {
			throw new NullPointerException("command argument cannot be null");
		}
		this.command = this.command.join(command);
		return this;
	}	

}
