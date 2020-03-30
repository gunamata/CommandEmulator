package org.emulator.unix.mim;

import org.emulator.command.Option;

public enum MimOption implements Option {

	/**
	 * Option <b>{@code --SELECT}</b>, <b>{@code -s}</b>:
	 * Select characters
	 */
	SELECT('v'),
	/**
	 * Option <b>{@code --TO_FIRST_CHAR}</b>, <b>{@code -z}</b>:
	 * Move/Select to/upto first character.
	 */
	TO_FIRST_CHAR('0'),
	/**
	 * Option <b>{@code --TO_LAST_CHAR}</b>, <b>{@code -d}</b>:
	 * Move/Select to/upto last character
	 */
	TO_LAST_CHAR('$'),
	/**
	 * Option <b>{@code --UNTIL_A_CHAR}</b>, <b>{@code -t}</b>:
	 * Move/Select until a character
	 */
	UNTIL_A_CHAR('t'),
	/**
	 * Option <b>{@code --TO_END_OF_WORD}</b>, <b>{@code -e}</b>:
	 * Move/Select to/till end of word
	 */
	TO_END_OF_WORD('e');

	private final char acronym;
	private MimOption(char acronym) {
		this.acronym = acronym;
	}
	/**
	 * Returns the option with the given {@code acronym}, or {@code null} if no
	 * such option is found.
	 *
	 * @param acronym the option {@link #acronym() acronym}
	 * @return	the option with the given {@code acronym} or {@code null} if it
	 * 			is not found
	 */
	public static MimOption findByAcronym(char acronym) {
		for (final MimOption opt : values()) {
			if (opt.acronym() == acronym) return opt;
		}
		return null;
	}
	
	public char acronym() {
		return acronym;
	}
}
