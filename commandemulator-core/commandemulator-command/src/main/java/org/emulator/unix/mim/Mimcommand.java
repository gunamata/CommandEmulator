package org.emulator.unix.mim;

import org.emulator.command.AbstractCommand;
import org.emulator.line.SimpleLine;
import org.emulator.unix.Mim;

class MimCommand extends AbstractCommand<MimArguments> {
	public MimCommand( MimArguments arguments) {
		super(Mim.NAME, arguments);
	}

	@Override
	public SimpleLine executeCommand() {
		final MimArguments args = getArguments();
		SimpleLine ret = args.getInput();
		MimCommandProcessor cp;
		
		if(areArgumentsValid(args)) {			
			cp = new MimCommandProcessor(args);
			ret = cp.processLine();				
		}
		return ret;
	}

	private boolean areArgumentsValid(MimArguments args) {
		if(args.getOptionsList().size() > 2 ) {
			System.out.println("Command cannot have more than 2 option cards! Please try with a correct command");
			return(false);
		}
		
		if(args.isOptionSet(MimOption.UNTIL_A_CHAR) && 
				args.getSearchCharacter() == '\0')
		{
			System.out.println("Search charater to be provided with 't' option");
			printUsage();
			return(false);
		}
		
		if(args.getOptionsList().size() == 0) {
			printUsage();
			return(false);
		}
		
		return true;
	}
	
	private void printUsage() {
		System.out.println("Invalid Command!!");
		System.out.println("0   -  Move to the first character");
		System.out.println("$   -  Move to the last character");
		System.out.println("e   -  Move to the [e]nd of the word");
		System.out.println("tw  -  Move un[t]il the next matching character");
		System.out.println("ve  -  [v]isually select until the [e]nd of the word");
		System.out.println("v$  -  [v]isually select until the last character");
		System.out.println("vtw -  [v]isually select un[t]il the character 'w'");		
	}
}
