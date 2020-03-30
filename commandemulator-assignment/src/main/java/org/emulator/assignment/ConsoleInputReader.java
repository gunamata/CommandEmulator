package org.emulator.assignment;

import java.util.Scanner;

public class ConsoleInputReader {
	
	private static ConsoleInputReader instance = null;
	
	public static ConsoleInputReader getInstance() {
		if(instance == null)
			instance = new ConsoleInputReader();
		
		return(instance);
	}
    
    String readCommandInputText() {
        Scanner in = new Scanner(System.in);      
        System.out.print("Input Text: ");
        String inputText = in.nextLine();     
        return(inputText);
    }
    
    String readCommandOptions() {
        Scanner in = new Scanner(System.in);      
        System.out.print("Command: ");
        String inputText = in.nextLine();  
        return(inputText);
    }    
}
