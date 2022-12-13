package com.maximumverbosity.post.java.code.words;

import java.util.ArrayList;

/**
 * Defines a phrase. 
 * 
 * @author gilbertdlo
 *
 */
public class Phrase extends Word{
	/**
	 * Defines types of phrases.
	 * @author gilbertdlo
	 *
	 */
	public enum PhraseType {
		NOUN,
		VERB,
		ADVERB,
		ADJECTIVE,
	}
	private ArrayList<Word> words = new ArrayList<Word>();
	private PhraseType type = null;
	
	/**
	 * 
	 * @param words Words.
	 */
	@SuppressWarnings("static-access")
	@SafeVarargs
	public <W extends Word> Phrase (W... words){
		super();
		this.words = new ArrayList<Word>();
		for (Word word : words) {
			this.words.add(word);
		}
		// Check phrase type
		if (this.words.size() > 0) {
			if (words[this.words.size() - 1] instanceof Noun) {
				this.type = PhraseType.NOUN;
			}
			else if (words[this.words.size() - 1] instanceof Adjective) {
				this.type = PhraseType.ADJECTIVE;
			}
			else if (words[this.words.size() - 1] instanceof Adverb) {
				this.type = PhraseType.ADVERB;
			}
			else if (words[0] instanceof Verb) {
				this.type = PhraseType.VERB;
			}
		}
	}
	
	public String build() {
		String result = ""; 
		for (Word word : this.getWords()) {
			result += word.build() + " ";
		}
		result = result.trim();
		return result;
	}
	
	public PhraseType getType() {
		return type;
	}

	public ArrayList<Word> getWords() {
		return words;
	}
}