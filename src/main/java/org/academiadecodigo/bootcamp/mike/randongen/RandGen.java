package org.academiadecodigo.bootcamp.mike.randongen;

/**
 * This is a utility class, inspired by Pedro Antoninho @ Graveyard Shifts for the gang at <Academia de Codigo_>,
 * that can be used to generate random weird stuff on the fly...
 * Enjoy!
 *
 * Created by ita on 30/01/2016.
 */
public class RandGen {

    // First names array.
    private static String[] firstName = {
            "Rui", "Nuno", "Pedro", "Catarina", "Núria", "Joana", "Paulo", "Mariana", "Miguel", "Milena", "Itamar",
            "Jairson", "João", "Filipe", "Sérgio", "André", "Tiago", "Mafalda"
    };
    // Last names array.
    private static String[] lastName = {
            "Ferrão", "Campelo", "Antoninho", "Campino", "Pinto", "Falcão", "Pereira", "Carvalho", "Araújo", "Baeza",
            "Peixoto", "Monteiro", "Chambel", "Lourenço", "Souza", "Romero", "Vasconcelos", "Jorge", "Gouveia",
            "Santos", "Pires", "Carvalho"
    };

    // Homage to Antoninho's balls!
    private static String[] ballWords = {
            "bola", "bolinha", "bolazinha", "bolona", "bolalhona", "bolão", "bolalhão", "ball", "ballz", "balle",
            "ballon", "bal", "top", "pilota", "lopta", "mpira", "qiú", "gong", "boul", "bold", "pilko", "pallo",
            "pêl", "gend", "pob", "labda", "rogodo", "liathróid", "bolti", "palla", "tama", "werni", "ban", "pila",
            "bumba", "kamuolys", "topka", "pant", "baolina", "bala", "minge", "myach", "kubada", "boll", "pantu",
            "koptok"
    }; // btw, pila é bola em Latim!!! :X...
    // some funny quotes
    private static String[] quotes = {
            "The best thing about a boolean is even if you are wrong, you are only off by a bit.",
            "Without requirements or design, programming is the art of adding bugs to an empty text file.",
            "All my life I thought air was free, until I bought a bag of chips.",
            "God please give me patience, if you give me strength I will just punch them in the face.",
            "When I said that I cleaned my room, I just meant I made a path from the doorway to my bed.",
            "I consider myself a crayon, I might not be your favorite color but one day you'll need me to complete your picture.",
            "I love everyone! I love to be around some people, I love to stay away from others, and some I'd just love to punch right in the face!",
            "Before software can be reusable it first has to be usable.",
            "I'm old enough to know better, but young enough to do it anyway.",
            "If we were on a sinking ship, and there was only one life vest... I would miss you so much.",
            "I changed my password everywhere to 'incorrect.' That way when I forget it, it always reminds me, 'Your password is incorrect'.",
            "I think Microsoft named .Net so it wouldn’t show up in a Unix directory listing.",
            "There are two ways to write error-free programs; only the third one works.",
            "It’s not a bug – it’s an undocumented feature.",
            "One man’s crappy software is another man’s full time job.",
            "A good programmer is someone who always looks both ways before crossing a one-way street.",
            "Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.",
            "Programming is like sex. One mistake and you have to support it for the rest of your life.",
            "Deleted code is debugged code.",
            "Walking on water and developing software from a specification are easy if both are frozen.",
            "If debugging is the process of removing software bugs, then programming must be the process of putting them in.",
            "Software undergoes beta testing shortly before it’s released. Beta is Latin for 'still doesn’t work'.",
            "There are only two kinds of programming languages: those people always bitch about and those nobody uses.",
            "In order to understand recursion, one must first understand recursion.",
            "The best performance improvement is the transition from the nonworking state to the working state.",
            "The trouble with programmers is that you can never tell what a programmer is doing until it’s too late.",
            "Don’t worry if it doesn’t work right. If everything did, you’d be out of a job."
    };

    /**
     * Gives a random number between, and including, zero and the given number [0 - number].
     *
     * @param upperLimit integer representing the upper limit.
     * @return random integer between zero and given number.
     */
    public static int randomInt(int upperLimit) {
        return ((int) (Math.random() * (upperLimit + 1)));
    }

    /**
     * Gives a random number between, and including, the given numbers [lowerLimit - upperLimit].
     *
     * @param lowerLimit integer representing the lower limit.
     * @param upperLimit integer representing the upper limit.
     * @return random integer between the given numbers, or 0 in case of error.
     */
    public static int randomInt(int lowerLimit, int upperLimit) {
        if (lowerLimit >= upperLimit) {
            return 0;
        }
        return lowerLimit + (int)(Math.random() * ((upperLimit - lowerLimit) + 1));
    }
    /**
     * Gives a random word from the ballWords array.
     *
     * @return String representing the random.
     */
    public static String randomWord() {
        return ballWords[randomInt(ballWords.length - 1)];
    }
    /**
     * Gives a random constructed phrase, with a random number of words, from the ballWords array.
     *
     * @return String representing the random constructed phrase, with at least 2 words.
     */
    public static String randomPhrase() {
        int numberOfWords = randomInt(ballWords.length - 1);
        if (numberOfWords < 2) {
            numberOfWords = 2;
        }
        String phrase = "";

        for (int i = 0; i < numberOfWords; i++) {
            phrase += randomWord();

            if (i < numberOfWords - 1) {
                phrase += " ";
            }
        }
        return phrase;
    }

    /**
     * Gives a random constructed phrase, with a given number of words, from the ballWords array.
     *
     * @param numberOfWords integer representing the number of words in the phrase.
     * @return String representing the random constructed phrase, with at least 2 words.
     */
    public static String randomPhrase(int numberOfWords) {
        if (numberOfWords < 2) {
            numberOfWords = 2;
        }
        String phrase = "";

        for (int i = 0; i < numberOfWords; i++) {
            phrase += randomWord();

            if (i < numberOfWords - 1) {
                phrase += " ";
            }
        }
        return phrase;
    }

    /**
     * Gives a random (first) name from the firstName array.
     *
     * @return String representing the name.
     */
    public static String randomFirstName() {
        return firstName[randomInt(firstName.length - 1)];
    }

    /**
     * Gives a random (last) name from the lastName array.
     *
     * @return String representing the name.
     */
    public static String randomLastName() {
        return lastName[randomInt(lastName.length - 1)];
    }

    /**
     * Gives a random constructed name, with first and last names.
     *
     * @return String representing the constructed name.
     */
    public static String randomName() {
        return firstName[randomInt(firstName.length - 1)] + " " + lastName[randomInt(lastName.length - 1)];
    }

    /**
     * Gives a random quote from the quotes array.
     *
     * @return String representing the quote.
     */
    public static String randomQuote() {
        return quotes[randomInt(quotes.length - 1)];
    }

    /**
     * Gives a random constructed talk between two random names, using random phrase and names.
     *
     * @return String representing the talk.
     */
    public static String randomBallTalk() {
        String name1 = randomName();
        String name2 = randomName();

        return (name1 + " is walking down the street when " + name2 + " appears.\n" + name1 + " asks, " + randomPhrase() +
                "?\nTo which " + name2 + " replies, " + randomPhrase() + "!");
    }

    /**
     * Gives a random constructed talk between two random names, using random quotes and names.
     *
     * @return String representing the talk.
     */
    public static String randomQuoteTalk() {
        String name1 = randomName();
        String name2 = randomName();

        return (name1 + " is coding like mad when " + name2 + " pops up.\n" + name1 + " says, " + randomQuote() +
                "\n" + name2 + " looks up and replies, " + randomQuote());
    }
}
