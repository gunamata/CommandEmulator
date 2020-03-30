package org.emulator.unix.mim;

public class StringHelper {
	
	public String removeByIndex(String str, int index) {
		  StringBuilder sb = new StringBuilder();
		  if (index > 0) {
		    sb.append(str, 0, index);
		  }
		  if (index < str.length() - 1) {
		    sb.append(str, index + 1, str.length());
		  }
		  return sb.toString();
	}
	
}
