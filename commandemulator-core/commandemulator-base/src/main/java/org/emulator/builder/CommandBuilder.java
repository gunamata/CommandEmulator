package org.emulator.builder;

import org.emulator.command.Command;

public interface CommandBuilder  {

	Command<?> build();

	CommandBuilder join(Command<?> command);
	
	@Override
	String toString();
}
