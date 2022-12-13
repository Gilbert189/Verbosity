package com.maximumverbosity.post.java.code.words.interfaces;

import com.maximumverbosity.post.java.code.words.Phrase;

/**
 * An interface allowing objects to build {@link #Phrase}.
 * @author gilbertdlo
 *
 */
public interface PhraseBuilder {
	/**
	 * Build this object into a {@link #Phrase}.
	 * @return The phrase.
	 */
	public Phrase buildPhrase();
}