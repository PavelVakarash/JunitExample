package de.ait;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TranslatorTest {

    private Translator translator;

    @Mock
    private Dictionary dictionary;

    @BeforeEach
    void setUp() {

        this.translator = new Translator(dictionary);

    }

    @Test
    public void from_english() {
        when(dictionary.fromEnglish("Bird")).thenReturn("Птица");
        when(dictionary.fromEnglish("Cow")).thenReturn("Корова");
        when(dictionary.fromEnglish("Milk")).thenThrow(IllegalArgumentException.class);

        String expected = "Птица Milk Корова ";
        String actual = translator.fromEnglish("Bird Milk Cow");
        assertEquals(expected, actual);
    }

    @Test
    public void from_russian() {
        when(dictionary.fromRussian("Птица")).thenReturn("Bird");
        when(dictionary.fromRussian("Корова")).thenReturn("Cow");
        when(dictionary.fromRussian("Молоко")).thenThrow(IllegalArgumentException.class);

        String expected = "Bird Молоко Cow ";
        String actual = translator.fromRussian("Птица Молоко Корова");
        assertEquals(expected, actual);
    }
}

