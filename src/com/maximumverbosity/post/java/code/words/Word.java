package com.maximumverbosity.post.java.code.words;


/**
 * An interface that defines a word.
 * This is used to define word classes like {@link #Verb}.
 *
 * @author gilbertdlo
 */
public class Word{
	/**
	 * The word.
	 */
	protected String word = "";
	
	/**
	 * Builds the word.
	 * @return The builded word.
	 */
	public String build() {
		return this.word;
	};
	
	/**
	 * @param word The word.
	 */
	public Word(String word) {
		this.word = word;
	}
	
	public Word() {};
}