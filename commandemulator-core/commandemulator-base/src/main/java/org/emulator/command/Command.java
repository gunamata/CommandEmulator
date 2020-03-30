package org.emulator.command;

import org.emulator.line.SimpleLine;


public interface Command<A extends Arguments<A>> {

	String getName();

	A getArguments();
	
	SimpleLine executeCommand();
	
	Command<?> join(Command<?> next);

	@Override
	String toString();
}
