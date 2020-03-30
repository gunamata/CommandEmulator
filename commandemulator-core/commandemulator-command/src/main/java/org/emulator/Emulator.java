package org.emulator;

import org.emulator.builder.DefaultEmulatorCommandBuilder;
import org.emulator.builder.EmulatorCommandBuilder;
import org.emulator.line.SimpleLine;

public final class Emulator {

	public static EmulatorCommandBuilder builder() {
		return new DefaultEmulatorCommandBuilder();
	}

	public static EmulatorCommandBuilder mim(String... args) {
		return builder().mim(args);
	}
	
	public static EmulatorCommandBuilder mim(SimpleLine line, String options) {
		return builder().mim(line, options);
	}	
	
	// no instances
	private Emulator() {
		super();
	}
}
