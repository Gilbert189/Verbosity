package com.maximumverbosity.post.java.code.words;

/**
 * Defines an action. 
 * <p>
 * Applies to words like "run".
 * 
 * @author gilbertdlo
 */
public class Verb extends Word{
	/**
	 * @param verb The verb.
	 */
	public Verb(String verb) {
		super(verb);
	}
	
	public final String build() {
		return this.word;
	}
}