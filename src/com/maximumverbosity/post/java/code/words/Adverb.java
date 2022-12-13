package com.maximumverbosity.post.java.code.words;

import com.maximumverbosity.post.java.code.words.interfaces.PhraseBuilder;

/**
 * Defines a modifier to a verb. 
 * <p>
 * Applies to words like "quite".
 * 
 * @author gilbertdlo
 */
public class Adverb extends Word implements PhraseBuilder{
	/**
	 * The types of available adverbs.
	 * @author gilbertdlo
	 *
	 */
	public enum AdverbType {
		/**
		 * Returns the plain text when building.
		 */
		PLAIN,
		/**
		 * Injects an adverb noun to use the -ly suffix when building.
		 */
		INJECTIVE, 
		/**
		 * Places adverb after the target when building.
		 */
		ATTRIBUTIVE,
		/**
		 * Places adverb before the target when building.
		 */
		POSTPOSITIVE,
	}

	protected AdverbType type = AdverbType.PLAIN;
	protected Word target;
	
	/**
	 * @param adjective The adjective.
	 * @param target    The target to said adjective.
	 */
	public Adverb(Word adverb, Word target, AdverbType type) {
		super(adverb.build());
		this.type = type;
		this.target = target;
	}
	
	public Adverb() {super();}
	
	/**
	 * Build the phrase from this adverb.
	 * @return The phrase.
	 */
	public Phrase buildPhrase() {
		// Check type
		// We could use switch for this, but verbosity :)
		Word word = new Word(super.build());
		if (this.type == AdverbType.ATTRIBUTIVE) {
			return new Phrase(word, this.target);
		}
		else if (this.type == AdverbType.INJECTIVE) {
			Word adverb = new Word(word.build() + "ly");
			return new Phrase(this.target, adverb);
		}
		else if (this.type == AdverbType.POSTPOSITIVE) {
			return new Phrase(this.target, word);
		}
		else if (this.type == AdverbType.PLAIN) {
			return new Phrase(word);
		}
		else return new Phrase();
	}
	
	public String build() {
		return this.buildPhrase().build();
	}
}