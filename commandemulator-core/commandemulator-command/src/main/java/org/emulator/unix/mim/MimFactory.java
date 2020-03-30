package org.emulator.unix.mim;

import org.emulator.line.SimpleLine;
import org.emulator.unix.Mim;

/**
 * Factory for the {@link Mim mim} command returning 
 * a new command instance from every signature method.
 */
public final class MimFactory implements Mim.Interface<MimCommand> {
	
	/**
	 * The singleton instance of this factory.
	 */
	public static final MimFactory INSTANCE = new MimFactory();

	/**
	 * Private, only used to create singleton instance.
	 */
	private MimFactory() {
		super();
	}

	@Override
	public MimCommand mim(String... args) {
		final MimArguments mimArgs = new MimArguments(args);
		return new MimCommand(mimArgs);
	}
	
	@Override
	public MimCommand mim(SimpleLine line, String options) {
		final MimArguments mimArgs = new MimArguments(line, options);
		return new MimCommand(mimArgs);
	}	

}
