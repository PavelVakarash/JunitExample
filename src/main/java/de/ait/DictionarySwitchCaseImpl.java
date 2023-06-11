package de.ait;

public class DictionarySwitchCaseImpl implements Dictionary {
    @Override
    public String fromEnglish(String word){
        switch (word) {
            case "Developer" -> {
                return "Разработчик";
            }
            case "Dog" -> {
                return "Собака";
            }
            case "Mouse" -> {
                return "Мышь";
            }
            case "Cat" -> {
                return "Кошка";
            }
            default -> throw new IllegalArgumentException("Слово не найдено");
        }
    }

    @Override
    public String fromRussian(String word){
        switch (word) {
            case "Разработчик" -> {
                return "Developer";
            }
            case "Собака"-> {
                return "Dog";
            }
            case "Мышь" -> {
                return "Mouse";
            }
            case "Кошка" -> {
                return "Cat";
            }
            default -> throw new IllegalArgumentException("Слово не найдено");
        }
    }
}
