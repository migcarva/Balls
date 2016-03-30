package org.academiadecodigo.bootcamp.mike.randongen;

/**
 * Created by oakman on 1/30/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Give me a random number up to 15: " + RandGen.randomInt(15));
        System.out.println("Give me a random number from 10 to 25: " + RandGen.randomInt(10, 25));
        System.out.println("Give me a random word: " + RandGen.randomWord());
        System.out.println("Give me a random phrase: " + RandGen.randomPhrase());
        System.out.println("Give me a random phrase with exactly 7 words: " + RandGen.randomPhrase(7));
        System.out.println("Give me a random first name: " + RandGen.randomFirstName());
        System.out.println("Give me a random last name: " + RandGen.randomLastName());
        System.out.println("Give me a random name: " + RandGen.randomName());
        System.out.println("Give me a random quote: " + RandGen.randomQuote());
        System.out.println();
        System.out.println("Give me a random ball talk:\n" + RandGen.randomBallTalk());
        System.out.println();
        System.out.println("Give me a random quote talk:\n" + RandGen.randomQuoteTalk());
    }
}
