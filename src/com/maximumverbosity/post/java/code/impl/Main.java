package com.maximumverbosity.post.java.code.impl;

import com.maximumverbosity.post.java.code.words.Determiner;
import com.maximumverbosity.post.java.code.words.Determiner.DeterminerType;
import com.maximumverbosity.post.java.code.words.Adjective;
import com.maximumverbosity.post.java.code.words.Noun;
import com.maximumverbosity.post.java.code.words.Verb;
import com.maximumverbosity.post.java.code.words.Word;
import com.maximumverbosity.post.java.code.words.Adverb;
import com.maximumverbosity.post.java.code.words.Adverb.AdverbType;
import com.maximumverbosity.post.java.code.words.Phrase;
import com.maximumverbosity.post.java.code.words.Clause;

//TODO: The following source code that's used to be written in the Python programming language is too short and concise, defeating the purpose of this activity that one engages in for amusement or fun. A decision has been made to port this code to Java for maximum verbosity, but this might not be enough. Please, I implore you my dear reader to transform this code into something expressed in more words than are needed.

public class Main {

	public static void main(String[] args) {
		Adjective subjectAdjective = new Adjective("above");
		Noun subjectNoun = new Noun("post");
		Phrase subject = new Phrase(subjectAdjective, subjectNoun);
		Determiner determiner = new Determiner(DeterminerType.REFERRED, subject);
		Phrase subjectPhrase = determiner.buildPhrase();
		
		Verb verb = new Verb("is");
		Adverb adverb = new Adverb(new Word("too"), verb, AdverbType.POSTPOSITIVE);
		Adjective predicateAdjective = new Adjective("verbose");
		
		Phrase predicate = new Phrase(adverb, predicateAdjective);
		Clause sentence = new Clause(subjectPhrase, predicate);
		
		String result = sentence.build();
		System.out.println(result);
	}

}