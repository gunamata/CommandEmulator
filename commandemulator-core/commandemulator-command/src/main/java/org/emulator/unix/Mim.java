package org.emulator.unix;

import org.emulator.command.CommandInterface;
import org.emulator.line.SimpleLine;
import org.emulator.unix.mim.MimFactory;

public final class Mim {
	/**
	 * The "mim" command name.
	 */
	public static final String NAME = "mim";

	public static interface Interface<R> extends CommandInterface<R> {		
		R mim(String... args);

		R mim(SimpleLine line, String options);
	}

	public static final MimFactory Factory = MimFactory.INSTANCE;

	// no instances
	private Mim() {
		super();
	}
}
