package com.maximumverbosity.post.java.code.words;

/**
 * Defines a (word) object. 
 * <p>
 * Applies to words like "book".
 * 
 * @author gilbertdlo
 */
public class Noun extends Word{
	/**
	 * @param noun The noun.
	 */
	public Noun(String noun) {
		super(noun);
	}
	
	public final String build() {
		return this.word;
	}
}