# 🔒 Password Validator

A clean, robust, and fully tested Java application designed to validate user passwords against modern security rules. It includes comprehensive JUnit 5 unit tests, detailed human-readable validation feedback, and an interactive CLI console.

---

## ✨ Features

- **Rule Enforcement**:
  - Minimum length of **8 characters**.
  - At least **1 uppercase letter** (`A-Z`).
  - At least **1 lowercase letter** (`a-z`).
  - At least **1 numerical digit** (`0-9`).
  - At least **1 special character** (`!@#$%^&*()-_=+[]{}|;:'",.<>/?`~\\`).
  - Handles `null` and empty inputs gracefully.
- **Detailed Feedback**: Provides clear, actionable error messages explaining why a password failed validation.
- **Interactive CLI & Command-Line Runner**: Validate individual passwords via command-line flags or launch an interactive terminal console.
- **Comprehensive Unit Testing**: Includes unit tests covering edge cases, boundary conditions, and parameterized test suites.

---

## 📁 Project Structure

```text
password-validator/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/java/com/example/passwordvalidator/
    │   ├── PasswordValidator.java    # Core validation logic & message builder
    │   └── Main.java                 # Interactive CLI & CLI args entry point
    └── test/java/com/example/passwordvalidator/
        ├── PasswordValidatorTest.java # JUnit 5 test suite
        └── RunTests.java              # Standalone test runner (no Maven required)
```

---

## 🚀 Quick Start & Usage

### 1. Compile the Project
```bash
javac -d target/classes src/main/java/com/example/passwordvalidator/*.java
javac -cp target/classes -d target/test-classes src/test/java/com/example/passwordvalidator/RunTests.java
```

### 2. Run Password Validation (CLI Arguments)
Pass one or more passwords to validate them instantly:
```bash
java -cp target/classes com.example.passwordvalidator.Main "Str0ng!Pass2026" "weak" "NoDigits!Here"
```

**Output:**
```text
Password: "Str0ng!Pass2026"    -> [VALID PASS]
  Feedback: Password is valid.
Password: "weak"               -> [INVALID FAIL]
  Feedback: Password must be at least 8 characters long. Password must contain at least one uppercase letter. Password must contain at least one digit. Password must contain at least one special character.
```

### 3. Run Interactive Console
Launch the interactive terminal validator:
```bash
java -cp target/classes com.example.passwordvalidator.Main
```

### 4. Run Test Suite
Execute the full test suite directly:
```bash
java -cp "target/classes;target/test-classes" com.example.passwordvalidator.RunTests
```

Or run via Maven (if Maven is installed):
```bash
mvn test
```

---

## 🧪 Validation Rules Summary

| Rule | Requirement | Example Valid | Example Invalid |
| :--- | :--- | :--- | :--- |
| **Length** | $\ge 8$ characters | `Ab1!abcd` | `Ab1!abc` (7 chars) |
| **Uppercase** | $\ge 1$ Uppercase (`A-Z`) | `Pass123!` | `pass123!` |
| **Lowercase** | $\ge 1$ Lowercase (`a-z`) | `PASS123!a` | `PASS123!` |
| **Digit** | $\ge 1$ Digit (`0-9`) | `Password1!` | `Password!!` |
| **Special Char**| $\ge 1$ Special (`@,#,!,...`)| `Password1!` | `Password12` |

---

## 📄 License
This project is open-source and available under the [MIT License](LICENSE).