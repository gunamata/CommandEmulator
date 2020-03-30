package org.emulator.line;

public class SimpleLine {
	private String text;
	private int cursorLocation;
	private int startParenthesisIndex;
	private int endParenthesisIndex;
	
	public SimpleLine(String content, int cursorLocation, int startParenthesisIndex, int endParenthesisIndex) {
		this.text = content;
		this.cursorLocation = cursorLocation;
		this.startParenthesisIndex = startParenthesisIndex;
		this.endParenthesisIndex = endParenthesisIndex;
	}
	
	public SimpleLine(String content) {
		this.text = content;
		this.cursorLocation = 1;
		this.startParenthesisIndex = -1;
		this.endParenthesisIndex = -1;
	}

	public String getText() {
		return text;
	}

	public void setText(String content) {
		this.text = content;
	}

	public int getCursorLocation() {
		return cursorLocation;
	}

	public void setCursorLocation(int cursorLocation) {
		this.cursorLocation = cursorLocation;
	}
	
	public int getStartParanthesisIndex() {
		return(this.startParenthesisIndex);
	}	
	
	public void setStartParanthesisIndex(int index) {
		this.startParenthesisIndex = index;
	}
	
	public int getEndParanthesisIndex() {
		return(this.endParenthesisIndex);
	}	
		
	public void setEndParanthesisIndex(int index) {
		this.endParenthesisIndex = index;
	}
	
	public void removeParanthesis() {
		if( startParenthesisIndex != -1 &&
				endParenthesisIndex != -1)
		{			
			removeCharAtIndex(endParenthesisIndex);
			removeCharAtIndex(startParenthesisIndex);
			
			startParenthesisIndex = -1;
			endParenthesisIndex = -1;
		}		
	}
	
	public 	void addStartParenthesisAtIndex(int index) {
		addCharAtIndex('[',index);
		startParenthesisIndex = index;
	}
	
	public 	void addEndParenthesisAtIndex(int index) {
		addCharAtIndex(']',index);
		endParenthesisIndex = index;		
	}	
	
	public void appendEndParenthesis() {
		text = text + "]";
		endParenthesisIndex = text.length() - 1;
	}	
	
	private void removeCharAtIndex(int index) {
		  StringBuilder sb = new StringBuilder();
		  if (index > 0) {
		    sb.append(text, 0, index);
		  }
		  if (index < text.length() - 1) {
		    sb.append(text, index + 1, text.length());
		  }
		  text = sb.toString();
	}
	
	private void addCharAtIndex(char ch, int index) {
	    int len = text.length();
	    char[] updatedArr = new char[len + 1];
	    text.getChars(0, index, updatedArr, 0);
	    updatedArr[index] = ch;
	    text.getChars(index, len, updatedArr, index + 1);
	    text = new String(updatedArr);
	}
	

	public int getIndexOfMatchingCharFromCursorLoc(char ch) {
		for(int i=cursorLocation;i<text.length();i++) {
			if(text.toUpperCase().charAt(i) == ch ||
					text.toLowerCase().charAt(i) == ch) 
				return(i);
		}
		return(-1);
	}		
	
	public int getIndexOfEndOfWordFromCursorLoc() {
		//Check if already at the end of a word
		//if Yes, then move cursor till beginning of next word
		int newCursorLoc = cursorLocation;
		if(cursorLocation == text.length())
			return(text.length() - 1);
		
		if(text.charAt(cursorLocation) == ' ') {
			for(int i=cursorLocation+1;i<text.length();i++) {
				if(text.charAt(i) != ' ') 
					newCursorLoc = i;
			}
		}
			
		for(int i=newCursorLoc;i<text.length();i++) {
			if(text.charAt(i) == ' ') 
				return(i-1);
		}
		return(text.length() - 1);
	}	
}
