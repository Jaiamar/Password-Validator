package com.example.passwordvalidator;

/**
 * Standalone runner for PasswordValidator test suite.
 */
public class RunTests {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       RUNNING PASSWORD VALIDATOR TEST SUITE       ");
        System.out.println("==================================================");

        PasswordValidator validator = new PasswordValidator();
        int passed = 0;
        int failed = 0;

        // Test 1: Valid password
        if (validator.isValid("Str0ng!Pass")) {
            System.out.println("[PASS] testValidPassword");
            passed++;
        } else {
            System.out.println("[FAIL] testValidPassword");
            failed++;
        }

        // Test 2: Another valid password
        if (validator.isValid("MySecure1@")) {
            System.out.println("[PASS] testAnotherValidPassword");
            passed++;
        } else {
            System.out.println("[FAIL] testAnotherValidPassword");
            failed++;
        }

        // Test 3: Null password
        if (!validator.isValid(null)) {
            System.out.println("[PASS] testNullPassword");
            passed++;
        } else {
            System.out.println("[FAIL] testNullPassword");
            failed++;
        }

        // Test 4: Too short password
        if (!validator.isValid("Ab1!xy")) {
            System.out.println("[PASS] testTooShortPassword");
            passed++;
        } else {
            System.out.println("[FAIL] testTooShortPassword");
            failed++;
        }

        // Test 5: Missing uppercase
        if (!validator.isValid("weak1!pass")) {
            System.out.println("[PASS] testMissingUppercase");
            passed++;
        } else {
            System.out.println("[FAIL] testMissingUppercase");
            failed++;
        }

        // Test 6: Missing lowercase
        if (!validator.isValid("WEAK1!PASS")) {
            System.out.println("[PASS] testMissingLowercase");
            passed++;
        } else {
            System.out.println("[FAIL] testMissingLowercase");
            failed++;
        }

        // Test 7: Missing digit
        if (!validator.isValid("NoDigits!Here")) {
            System.out.println("[PASS] testMissingDigit");
            passed++;
        } else {
            System.out.println("[FAIL] testMissingDigit");
            failed++;
        }

        // Test 8: Missing special character
        if (!validator.isValid("NoSpecial123")) {
            System.out.println("[PASS] testMissingSpecialCharacter");
            passed++;
        } else {
            System.out.println("[FAIL] testMissingSpecialCharacter");
            failed++;
        }

        // Test 9: Empty password
        if (!validator.isValid("")) {
            System.out.println("[PASS] testEmptyPassword");
            passed++;
        } else {
            System.out.println("[FAIL] testEmptyPassword");
            failed++;
        }

        // Test 10: Boundary 8 chars valid
        if (validator.isValid("Ab1!abcd")) {
            System.out.println("[PASS] testExactMinimumLengthValid");
            passed++;
        } else {
            System.out.println("[FAIL] testExactMinimumLengthValid");
            failed++;
        }

        // Test 11: Boundary 7 chars fail
        if (!validator.isValid("Ab1!abc")) {
            System.out.println("[PASS] testBelowMinimumLengthBoundary");
            passed++;
        } else {
            System.out.println("[FAIL] testBelowMinimumLengthBoundary");
            failed++;
        }

        // Test 12: Validation message for null
        String msgNull = validator.getValidationMessage(null);
        if (msgNull != null && msgNull.toLowerCase().contains("null")) {
            System.out.println("[PASS] testValidationMessageForNull");
            passed++;
        } else {
            System.out.println("[FAIL] testValidationMessageForNull");
            failed++;
        }

        // Test 13: Validation message for valid password
        String msgValid = validator.getValidationMessage("Str0ng!Pass");
        if (msgValid != null && msgValid.toLowerCase().contains("valid")) {
            System.out.println("[PASS] testValidationMessageForValidPassword");
            passed++;
        } else {
            System.out.println("[FAIL] testValidationMessageForValidPassword");
            failed++;
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Test Results: %d Passed, %d Failed, Total %d\n", passed, failed, (passed + failed));
        System.out.println("==================================================");
    }
}
