package com.maximumverbosity.post.java.code.words;

import com.maximumverbosity.post.java.code.words.interfaces.PhraseBuilder;
import com.maximumverbosity.post.java.code.words.Phrase.PhraseType;

/**
 * Defines a determiner of the object.
 * @author gilbertdlo
 *
 */
public class Determiner extends Word implements PhraseBuilder{
	public enum DeterminerType {
		REFERRED("the"),
		SINGULAR("a");
				
		private Word word;
		private DeterminerType(String word){
			this.word = new Word(word);
		}
		
		/**
		 * Gets the word of the determiner type.
		 * @return
		 */
		public Word getWord() {
			return this.word;
		}
	}
	
	DeterminerType type;
	Word noun = null;
	
	/**
	 * 
	 * @param type The type.
	 */
	public Determiner(DeterminerType type) {
		super();
		this.type = type;
	}
	
	/**
	 * @param type The type.
	 * @param noun The noun to determine.
	 */
	public Determiner(DeterminerType type, Noun noun) {
		super();
		this.type = type;
		this.noun = noun;
	}
	
	/**
	 * @param type The type.
	 * @param noun The noun to determine.
	 */
	public Determiner(DeterminerType type, Phrase noun) {
		super();
		assert noun.getType() == PhraseType.NOUN;
		this.type = type;
		this.noun = noun;
	}
	
	public Word getWord() {
		return this.type.getWord();
	}
	
	/**
	 * Build the phrase from this determiner.
	 * @return The phrase.
	 */
	public Phrase buildPhrase() {
		if (this.noun != null) {
			Phrase phrase = new Phrase(this.getWord(), this.noun);
			return phrase;
		}
		else return new Phrase(this.getWord());
	}
	
	public String build() {
		return this.buildPhrase().build();
	}
}