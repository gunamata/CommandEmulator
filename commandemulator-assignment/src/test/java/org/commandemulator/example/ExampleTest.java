package org.commandemulator.example;

import static org.junit.Assert.assertEquals;

import org.emulator.Emulator;
import org.emulator.line.SimpleLine;
import org.junit.Test;


public class ExampleTest {
	
	@Test
	public void testMimMoveToEndOfWord() {
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "e";
		assertEquals("Hell[o] World", Emulator.mim(sl,c).build().executeCommand().getText());
	}
	
	@Test
	public void testMimMoveToLastCharacter() {
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "$";
		assertEquals("Hello Worl[d]", Emulator.mim(sl,c).build().executeCommand().getText());
	}	
	
	@Test
	public void testMimSelectToLastCharacter() {
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "v$";
		assertEquals("[Hello World]", Emulator.mim(sl,c).build().executeCommand().getText());
	}	
	
	@Test
	public void testMimMoveToACharacter() {
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "tW";
		assertEquals("Hello[ ]World", Emulator.mim(sl,c).build().executeCommand().getText());
	}
	
	@Test
	public void testMimGoToEndOfWordAndSearchNonExistingChar() {
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "e";
		sl = Emulator.mim(sl,c).build().executeCommand();
		c = "tz";

		assertEquals("Hell[o] World", Emulator.mim(sl,c).build().executeCommand().getText());
	}
	
	@Test
	public void testMimGoToEndOfWordAndMoveToFirstChar() {
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "e";
		sl = Emulator.mim(sl,c).build().executeCommand();
		c = "0";

		assertEquals("[H]ello World", Emulator.mim(sl,c).build().executeCommand().getText());
	}	
	
	@Test
	public void testMimGoToEndOfWordAndSelectToFirstChar() { 
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "e";
		sl = Emulator.mim(sl,c).build().executeCommand();
		c = "v0";

		assertEquals("[Hello] World", Emulator.mim(sl,c).build().executeCommand().getText());
	}	
	
	@Test
	public void testMimMoveToEndOfWordFromLastWord() { 
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "tr";
		sl = Emulator.mim(sl,c).build().executeCommand();
		c = "e";

		assertEquals("Hello Worl[d]", Emulator.mim(sl,c).build().executeCommand().getText());
	}
	
	@Test
	public void testMimSelectToEndOfWord() { 
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "ve";

		assertEquals("[Hello] World", Emulator.mim(sl,c).build().executeCommand().getText());
	}	
	
	@Test
	public void testMimSelectUntilACharacter() { 
		SimpleLine sl = new SimpleLine("Hello World");
		String c = "vtw";

		assertEquals("[Hello ]World", Emulator.mim(sl,c).build().executeCommand().getText());
	}	
	
}
