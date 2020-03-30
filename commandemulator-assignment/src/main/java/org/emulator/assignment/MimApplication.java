package org.emulator.assignment;

import java.io.IOException;

import org.emulator.Emulator;
import org.emulator.line.SimpleLine;


public class MimApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SimpleLine line;
		
		String commandInputText = ConsoleInputReader.getInstance().readCommandInputText();
		line = new SimpleLine(commandInputText);
		while(true) {			
			String commandOptions = ConsoleInputReader.getInstance().readCommandOptions();
			if(commandOptions.equalsIgnoreCase("exit"))
				break;
			line = Emulator.mim(line,commandOptions).build().executeCommand();
			System.out.println("Output: " + line.getText());
		}
		
	}
	
    
}
