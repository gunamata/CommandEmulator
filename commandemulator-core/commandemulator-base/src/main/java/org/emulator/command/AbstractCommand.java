package org.emulator.command;

abstract public class AbstractCommand<A extends Arguments<A>> implements Command<A> {

	private final String name;
	private final A arguments;

	public AbstractCommand(String name, A arguments) {
		this.name = name;
		this.arguments = arguments;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public A getArguments() {
		return arguments.getAll();
	}
	
	@Override
	public Command<?> join(Command<?> next) {
		return JoinedCommand.join(this, next);
	}	
	
	@Override
	public String toString() {
		final String args = getArguments().toString();
		return args.isEmpty() ? getName() : getName() + " " + args;
	}
}
