package com.maximumverbosity.post.java.code.words;

import com.maximumverbosity.post.java.code.words.interfaces.PhraseBuilder;

/**
 * Defines a clause.
 * @author gilbertdlo
 *
 */
public class Clause extends Phrase implements PhraseBuilder{
	private Phrase subject, predicate;
	public Clause(Phrase subject, Phrase predicate) {
		this.subject = subject;
		this.predicate = predicate;
	}
	
	/**
	 * Build the phrase from this clause.
	 * @return The phrase.
	 */
	public Phrase buildPhrase() {
		Phrase phrase = new Phrase();
		phrase.getWords().addAll(subject.getWords());
		phrase.getWords().addAll(predicate.getWords());
		return phrase;
	}

	public String build() {
		return this.buildPhrase().build();
	}
}