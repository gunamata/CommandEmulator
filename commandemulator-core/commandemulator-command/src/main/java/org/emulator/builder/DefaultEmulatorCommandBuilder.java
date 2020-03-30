package org.emulator.builder;

import org.emulator.command.NoOp;
import org.emulator.line.SimpleLine;
import org.emulator.unix.Mim;

/**
 * Default implementation for {@link Unix4jCommandBuilder}. Application code 
 * does usually not directly refer to this class but uses it indirectly through 
 * the static methods in {@link org.unix4j.Unix4j Unix4j}.
 */
public class DefaultEmulatorCommandBuilder extends DefaultCommandBuilder implements EmulatorCommandBuilder {

	/**
	 * Default constructor initialized with a {@link NoOp} command which will be 
	 * replaced by the first command joined to this builder's command chain. 
	 * Uses a {@link DefaultExecutionContext} to execute commands.
	 */
	public DefaultEmulatorCommandBuilder() {
		super();
	}

	/* ------------------ mim ------------------ */
	@Override
	public EmulatorCommandBuilder mim(String... args) {
		join(Mim.Factory.mim(args));
		return this;
	}
	
	@Override
	public EmulatorCommandBuilder mim(SimpleLine line, String options) {
		join(Mim.Factory.mim(line, options));
		return this;
	}	

}
