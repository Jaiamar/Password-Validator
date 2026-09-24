package com.example.passwordvalidator;

/**
 * Validates passwords against a set of security rules:
 * <ol>
 *   <li>Must contain at least 8 characters</li>
 *   <li>Must contain at least one uppercase letter</li>
 *   <li>Must contain at least one lowercase letter</li>
 *   <li>Must contain at least one digit</li>
 *   <li>Must contain at least one special character</li>
 *   <li>Null passwords are invalid</li>
 * </ol>
 */
public class PasswordValidator {

    private static final int MIN_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?`~\\";

    /**
     * Validates the given password against all rules.
     *
     * @param password the password to validate (may be null)
     * @return true if the password satisfies every rule, false otherwise
     */
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_LENGTH) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.indexOf(c) >= 0) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    /**
     * Returns a human-readable explanation of which rules the password fails.
     * Useful for providing feedback to users beyond a simple boolean result.
     *
     * @param password the password to check (may be null)
     * @return a message describing validation failures, or a success message
     */
    public String getValidationMessage(String password) {
        if (password == null) {
            return "Password cannot be null.";
        }

        StringBuilder errors = new StringBuilder();

        if (password.length() < MIN_LENGTH) {
            errors.append("Password must be at least ").append(MIN_LENGTH).append(" characters long. ");
        }
        if (password.chars().noneMatch(Character::isUpperCase)) {
            errors.append("Password must contain at least one uppercase letter. ");
        }
        if (password.chars().noneMatch(Character::isLowerCase)) {
            errors.append("Password must contain at least one lowercase letter. ");
        }
        if (password.chars().noneMatch(Character::isDigit)) {
            errors.append("Password must contain at least one digit. ");
        }
        if (password.chars().noneMatch(c -> SPECIAL_CHARACTERS.indexOf(c) >= 0)) {
            errors.append("Password must contain at least one special character. ");
        }

        return errors.length() == 0 ? "Password is valid." : errors.toString().trim();
    }
}
