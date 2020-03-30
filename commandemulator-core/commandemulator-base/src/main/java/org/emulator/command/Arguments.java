package org.emulator.command;

public interface Arguments<A extends Arguments<A>> {

	A getAll();


	@Override
	String toString();
}
