package org.emulator.unix.mim;

import org.emulator.line.SimpleLine;

public class MimCommandProcessor  {
	
	private MimArguments args;
	public MimCommandProcessor(MimArguments args) {
		this.args = args;
	}

	public SimpleLine processLine() {
		// TODO Auto-generated method stub 
		int currentStartParanthesisIndex = args.getInput().getStartParanthesisIndex();
		int currentEndParanthesisIndex = args.getInput().getEndParanthesisIndex();
		args.getInput().removeParanthesis();
		if(args.isOptionSet(MimOption.TO_LAST_CHAR)) {
			toLastChar(args.getInput());
		} else if(args.isOptionSet(MimOption.TO_FIRST_CHAR)) {
			toFirstChar(args.getInput());
		} else if(args.isOptionSet(MimOption.TO_END_OF_WORD)) {
			toEndOfWord(args.getInput());
		} else if(args.isOptionSet(MimOption.UNTIL_A_CHAR)) {
			untilTheMatchingCharacter(args.getInput(),args.getSearchCharacter(), currentStartParanthesisIndex, currentEndParanthesisIndex);
		}
		return(args.getInput());
	}
	
	void untilTheMatchingCharacter(SimpleLine ln, char ch, int sp, int ep) {
		int indexOfMatchingChar = ln.getIndexOfMatchingCharFromCursorLoc(ch);
		if(indexOfMatchingChar!=-1) {
			if(args.isOptionSet(MimOption.SELECT))
				ln.addStartParenthesisAtIndex(Integer.max(0, sp));
			else
				ln.addStartParenthesisAtIndex(indexOfMatchingChar-1);
			ln.addEndParenthesisAtIndex(indexOfMatchingChar+1);
			ln.setCursorLocation(indexOfMatchingChar);			
		} else {
			ln.addStartParenthesisAtIndex(sp);
			ln.addEndParenthesisAtIndex(ep);		
		}
	}

	void  toEndOfWord(SimpleLine ln) {
		int endOfWordIndex = ln.getIndexOfEndOfWordFromCursorLoc();
		if(endOfWordIndex == ln.getText().length() - 1) {
			toLastChar(ln);
		} else {
			if(args.isOptionSet(MimOption.SELECT))
				ln.addStartParenthesisAtIndex(ln.getCursorLocation()-1);
			else
				ln.addStartParenthesisAtIndex(endOfWordIndex);
			ln.addEndParenthesisAtIndex(endOfWordIndex+2);
			ln.setCursorLocation(endOfWordIndex+1);
		}
	}
	
	void  toFirstChar(SimpleLine ln) {
		ln.addStartParenthesisAtIndex(0);
		if(args.isOptionSet(MimOption.SELECT))
			ln.addEndParenthesisAtIndex(ln.getCursorLocation()+1);
		else
			ln.addEndParenthesisAtIndex(2);
		ln.setCursorLocation(1);		
	}	

	void  toLastChar(SimpleLine ln) {
		if(args.isOptionSet(MimOption.SELECT)) 
			ln.addStartParenthesisAtIndex(ln.getCursorLocation()-1);
	    else
			ln.addStartParenthesisAtIndex(ln.getText().length()-1);
		ln.appendEndParenthesis();
		ln.setCursorLocation(ln.getText().length()-2);
	}	
}
