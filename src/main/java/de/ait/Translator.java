package de.ait;

public class Translator {

    private final Dictionary dictionary;

    public Translator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String fromEnglish(String text) {
        String[] words = text.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String translate;
            try {
                translate = dictionary.fromEnglish(word);
            } catch (IllegalArgumentException e) {
                translate = word;
            }
            result.append(translate).append(" ");
        }
        return result.toString();
    }

    public String fromRussian(String text) {
        String[] words = text.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String translate;
            try {
                translate = dictionary.fromRussian(word);
            } catch (IllegalArgumentException e) {
                translate = word;
            }
            result.append(translate).append(" ");
        }
        return result.toString();
    }
}


