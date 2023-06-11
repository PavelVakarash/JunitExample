package de.ait;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("DictionarySwitchCaseImpl is working...")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DictionaryTest {

    private DictionarySwitchCaseImpl dictionary;

    @BeforeEach
    public void setUp() {
        this.dictionary = new DictionarySwitchCaseImpl();
    }

    @DisplayName("fromEnglish() is working")
    @Nested
    class ForFromEnglish {

        @ParameterizedTest(name = "{0} in russian - {1}")
        @CsvSource(value = {"Cat, Кошка",
                            "Developer, Разработчик",
                            "Dog, Собака"})
        public void from_english(String english, String russian) {
            assertEquals(russian, dictionary.fromEnglish(english));
        }

        @ParameterizedTest(name = "throws exception on word - {0}")
        @ValueSource(strings = {"Table", "Bird", "Apple"})
        public void from_english_bad_words(String english) {
            assertThrows(IllegalArgumentException.class, () -> dictionary.fromEnglish(english));
        }
    }

    @DisplayName("fromRussian() is working")
    @Nested
    class ForFromRussian {

        @ParameterizedTest(name = "{0} in english - {1}")
//        @CsvSource(value = {"Кошка, Cat",
//                "Разработчик, Developer",
//                "Собака, Dog"})
        @CsvFileSource(resources = "/russian.csv", numLinesToSkip = 1)
        public void from_russian(String russian, String english) {
            assertEquals(english, dictionary.fromRussian(russian));
        }

        @ParameterizedTest(name = "throws exception on word - {0}")
        @ValueSource(strings = {"Таблица", "Птица", "Яблоко"})
        public void from_russian_bad_words(String russian) {
            assertThrows(IllegalArgumentException.class, () -> dictionary.fromRussian(russian));
        }
    }

    // TODO: test fromRussian через CsvFile

}