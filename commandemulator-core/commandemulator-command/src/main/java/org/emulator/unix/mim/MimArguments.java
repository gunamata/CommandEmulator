package org.emulator.unix.mim;

import java.util.ArrayList;
import java.util.List;

import org.emulator.command.Arguments;
import org.emulator.line.SimpleLine;

public final class MimArguments implements Arguments<MimArguments> {

	private final SimpleLine input;
	private final List<MimOption> optionsList;
	private char searchCharacter;
	
	public MimArguments(String... args) {
		this.input = null;
		this.optionsList = null;
		this.searchCharacter = 0;
		// TODO Auto-generated constructor stub
	}
	
	public MimArguments(String line, String options) {
		this.input = new SimpleLine(line);
		this.optionsList = getOptions(options);
		this.searchCharacter = getSearchCharacter(options);
	}
	
	public MimArguments(SimpleLine line, String options) {
		this.input = line;
		this.optionsList = getOptions(options);
		this.searchCharacter = getSearchCharacter(options);
	}

	private List<MimOption> getOptions(String options) {
		List<MimOption> retList = new ArrayList<MimOption>();
		
		for(char c : options.toCharArray()) {
			if(MimOption.findByAcronym(c)!=null) {
				retList.add(MimOption.findByAcronym(c));
			}
		}
		
		return(retList);
	}
	
	private char getSearchCharacter(String options) {
		String ch = "t";
		if(options.contains(ch)) {
			if(options.indexOf(ch) < options.length()-1)
				return(options.charAt( options.indexOf(ch) + 1 ));
			return '\0';
		} else
			return '\0';
	}	
	
	public SimpleLine getInput() {
		return input;
	}

	public List<MimOption> getOptionsList() {
		return optionsList;
	}
	
	public char getSearchCharacter() {
		return searchCharacter;
	}
	
    boolean isOptionSet(MimOption opt) {
    	
    	for(MimOption o : optionsList) {
    		if(o.acronym() == opt.acronym())
    			return(true);
    	}
    	
    	return(false);
    }
    
  

	@Override
	public MimArguments getAll() {
		// TODO Auto-generated method stub
		return this;
	}
}
