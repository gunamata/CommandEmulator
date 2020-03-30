package org.emulator.command;

import org.emulator.line.SimpleLine;

/**
 * A composite command joining two commands. The output of the
 * {@link #getFirst() first} command is joined to the input of the
 * {@link #getSecond() second} command.
 */
public class JoinedCommand<A extends Arguments<A>> implements Command<A> {

	private final Command<A> first;
	private final Command<?> second;

	public JoinedCommand(Command<A> first, Command<?> second) {
		if (first == null) {
			throw new NullPointerException("first command cannot be null");
		}
		if (second == null) {
			throw new NullPointerException("second command cannot be null");
		}
		this.first = first;
		this.second = second;
	}

	public static <A extends Arguments<A>> JoinedCommand<A> join(Command<A> first, Command<?> second) {
		return new JoinedCommand<A>(first, second);
	}

	public Command<A> getFirst() {
		return first;
	}


	public Command<?> getSecond() {
		return second;
	}

	/**
	 * Returns the joined command names, a string like "echo | grep"
	 * 
	 * @return the joined command names, a string like "echo | grep"
	 */
	@Override
	public String getName() {
		return getFirst().getName() + " | " + getSecond().getName();
	}

	@Override
	public A getArguments() {
		return getFirst().getArguments();
	}

	@Override
	public Command<?> join(Command<?> next) {
		return JoinedCommand.join(getFirst(), getSecond().join(next));
	}

	@Override
	public String toString() {
		return first + " | " + second;
	}

	@Override
	public SimpleLine executeCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
