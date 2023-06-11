package de.ait;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new DictionarySwitchCaseImpl();
        Translator translator = new Translator(dictionary);

        System.out.println(translator.fromEnglish("Cat Dog Hello Bye Developer"));
        System.out.println(translator.fromRussian("Кошка Собака Привет Пока Разработчик"));
    }
}