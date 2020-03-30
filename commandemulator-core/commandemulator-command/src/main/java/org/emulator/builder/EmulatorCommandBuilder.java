package org.emulator.builder;

import org.emulator.line.SimpleLine;
import org.emulator.unix.Mim;

public interface EmulatorCommandBuilder extends CommandBuilder,
		Mim.Interface<EmulatorCommandBuilder> {

	/* ------------------ mim ------------------ */

	@Override
	EmulatorCommandBuilder mim(String... args);

	@Override
	EmulatorCommandBuilder mim(SimpleLine line, String options);
}
