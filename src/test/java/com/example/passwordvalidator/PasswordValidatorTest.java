package com.example.passwordvalidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit 5 test suite for {@link PasswordValidator}.
 * Covers valid passwords, and invalid passwords for each individual rule violation.
 */
class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    @DisplayName("Valid password meeting all rules should pass")
    void testValidPassword() {
        assertTrue(validator.isValid("Str0ng!Pass"));
    }

    @Test
    @DisplayName("Another valid password with different special character should pass")
    void testAnotherValidPassword() {
        assertTrue(validator.isValid("MySecure1@"));
    }

    @Test
    @DisplayName("Null password should be invalid")
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    @DisplayName("Password shorter than 8 characters should be invalid")
    void testTooShortPassword() {
        assertFalse(validator.isValid("Ab1!xy"));
    }

    @Test
    @DisplayName("Password missing an uppercase letter should be invalid")
    void testMissingUppercase() {
        assertFalse(validator.isValid("weak1!pass"));
    }

    @Test
    @DisplayName("Password missing a lowercase letter should be invalid")
    void testMissingLowercase() {
        assertFalse(validator.isValid("WEAK1!PASS"));
    }

    @Test
    @DisplayName("Password missing a digit should be invalid")
    void testMissingDigit() {
        assertFalse(validator.isValid("NoDigits!Here"));
    }

    @Test
    @DisplayName("Password missing a special character should be invalid")
    void testMissingSpecialCharacter() {
        assertFalse(validator.isValid("NoSpecial123"));
    }

    @Test
    @DisplayName("Empty string password should be invalid")
    void testEmptyPassword() {
        assertFalse(validator.isValid(""));
    }

    @Test
    @DisplayName("Password with exactly 8 valid characters should pass (boundary test)")
    void testExactMinimumLengthValid() {
        assertTrue(validator.isValid("Ab1!abcd"));
    }

    @Test
    @DisplayName("Password with only 7 characters should fail (boundary test)")
    void testBelowMinimumLengthBoundary() {
        assertFalse(validator.isValid("Ab1!abc"));
    }

    @ParameterizedTest
    @DisplayName("Various invalid passwords should all fail validation")
    @ValueSource(strings = {
            "alllowercase1!",   // no uppercase
            "ALLUPPERCASE1!",   // no lowercase
            "NoNumberHere!",    // no digit
            "NoSpecialChar123", // no special char
            "Short1!"           // too short
    })
    void testInvalidPasswordsParameterized(String password) {
        assertFalse(validator.isValid(password));
    }

    @ParameterizedTest
    @DisplayName("Null and blank-like inputs should be invalid")
    @NullSource
    void testNullSourceParameterized(String password) {
        assertFalse(validator.isValid(password));
    }

    @Test
    @DisplayName("Validation message for null password should mention null")
    void testValidationMessageForNull() {
        String message = validator.getValidationMessage(null);
        assertTrue(message.toLowerCase().contains("null"));
    }

    @Test
    @DisplayName("Validation message for valid password should confirm success")
    void testValidationMessageForValidPassword() {
        String message = validator.getValidationMessage("Str0ng!Pass");
        assertTrue(message.toLowerCase().contains("valid"));
    }
}
