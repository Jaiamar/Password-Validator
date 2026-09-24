package com.example.passwordvalidator;

import java.util.Scanner;

/**
 * Main application entry point for the Password Validator.
 * Supports interactive validation via console and quick demo validation.
 */
public class Main {

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        System.out.println("==================================================");
        System.out.println("            PASSWORD VALIDATOR SYSTEM             ");
        System.out.println("==================================================");

        if (args.length > 0) {
            System.out.println("\n--- Validating Command-Line Passwords ---");
            for (String pwd : args) {
                printResult(validator, pwd);
            }
            return;
        }

        System.out.println("\n--- Demo Passwords Validation ---");
        String[] samplePasswords = {
            "Str0ng!Pass2026",
            "weak",
            "NoDigits!Here",
            "NODIGITORSPECIAL",
            "valid1@Password",
            "Short1!"
        };

        for (String pwd : samplePasswords) {
            printResult(validator, pwd);
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("Starting Interactive Console (press Ctrl+C or type 'exit' to quit):");
        System.out.println("--------------------------------------------------");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nEnter password to test > ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input.trim()) || "quit".equalsIgnoreCase(input.trim())) {
                    System.out.println("Exiting Password Validator. Goodbye!");
                    break;
                }
                printResult(validator, input);
            }
        }
    }

    private static void printResult(PasswordValidator validator, String password) {
        boolean valid = validator.isValid(password);
        String message = validator.getValidationMessage(password);

        System.out.printf("Password: %-20s -> %s\n", "\"" + password + "\"", valid ? "[VALID PASS]" : "[INVALID FAIL]");
        System.out.println("  Feedback: " + message);
    }
}
