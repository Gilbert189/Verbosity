package com.maximumverbosity.post.java.code.words;

import com.maximumverbosity.post.java.code.words.interfaces.PhraseBuilder;

/**
 * Defines a modifier to a noun or a verb. 
 * <p>
 * Applies to words like "ugly".
 * 
 * @author gilbertdlo
 */
public class Adjective extends Word implements PhraseBuilder{
	private enum AdjectiveType {
		/**
		 * Returns the plain text when building.
		 */
		PLAIN,
		/**
		 * Places adverb after the target when building.
		 */
		ATTRIBUTIVE,
		/**
		 * Inserts the adjective to the end of a predicate when building.
		 */
		PREDICATIVE,
		/**
		 * Places adverb before the target when building.
		 */
		POSTPOSITIVE
	}
	protected Noun target; 
	private Verb supplementaryVerb;
	private AdjectiveType type = AdjectiveType.PLAIN;
	
	/**
	 * This format sets the adjective type to plain.
	 * @param adjective The adjective.
	 * @param target    The target to said adjective.
	 */
	public Adjective(String adjective) {
		// Store the verb into the words variable inherited from Words
		super(adjective);
		this.type = AdjectiveType.PLAIN;
	}
	
	/**
	 * This format sets the adjective type to attributive.
	 * @param adjective The adjective.
	 * @param target    The target to said adjective.
	 */
	public Adjective(String adjective, Noun target) {
		// Store the verb into the words variable inherited from Words
		super(adjective);
		this.target = target;
		this.type = AdjectiveType.ATTRIBUTIVE;
	}
	
	/**
	 * This format sets the adjective type to predicative.
	 * @param adjective     The adjective.
	 * @param target        The target to said adjective.
	 * @param supplementary The supplementary verb.
	 */
	public Adjective(Noun target, Verb supplementary, String adjective) {
		// Store the verb into the words variable inherited from Words
		super(adjective);
		this.target = target;
		this.supplementaryVerb = supplementary;
		this.type = AdjectiveType.PREDICATIVE;
	}
	
	/**
	 * This format sets the adjective type to post-positive.
	 * @param adjective The adjective.
	 * @param target    The target to said adjective.
	 */
	public Adjective(Noun target, String adjective) {
		// Store the verb into the words variable inherited from Words
		super(adjective);
		this.target = target;
		this.type = AdjectiveType.POSTPOSITIVE;
	}
	
	public Adjective() {super();}
	
	/**
	 * Build the phrase from this adjective.
	 * @return The phrase.
	 */
	public Phrase buildPhrase() {
		// Check type
		// We could use switch for this, but verbosity :)
		Word word = new Word(super.build());
		if (this.type == AdjectiveType.ATTRIBUTIVE) {
			return new Phrase(word, this.target);
		}
		else if (this.type == AdjectiveType.PREDICATIVE) {
			return new Phrase(this.target, this.supplementaryVerb, word);
		}
		else if (this.type == AdjectiveType.POSTPOSITIVE) {
			return new Phrase(this.target, word);
		}
		else if (this.type == AdjectiveType.PLAIN) {
			return new Phrase(word);
		}
		else return new Phrase();
	}
	
	public String build() {
		return this.buildPhrase().build();
	}
}