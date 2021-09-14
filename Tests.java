import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    PasswordChecker passwordChecker;
    PhoneValidator phoneValidator;
    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
    }

    @Test
    void TestIfPasswordLengthIsAtLeastX() {
        assertTrue(passwordChecker.isAtLeastX("pass12345", 5));
    }

    @Test
    void TestIfPasswordHasUppercaseSymbols() {
        assertTrue(passwordChecker.hasUppercaseSymbols("Pass12345"));
    }

    @Test
    void TestIfPasswordHasSpecialSymbols() {
        assertTrue(passwordChecker.hasSpecialSymbols("Pass-12345"));
    }

    @Test
    void TestIfPhoneNumberHasOnlyNumbers() {
        assertTrue(phoneValidator.hasOnlyNumbers("911"));
    }

    @Test
    void TestIfPhoneNumberBeginsWithEight() {
        assertTrue(phoneValidator.beginsWithEight("861122333"));
    }

    @Test
    void TestIfPhoneNumberBelongsToSelectedCountry() {
        assertTrue(phoneValidator.belongsToSelectedCountry("+49301234567"));
    }

    @Test
    void TestIfEmailHasAtSign() {
        assertTrue(emailValidator.hasAtSign("name.surname@gmail.com"));
    }

    @Test
    void TestIfEmailHasInvalidCharacters() {
        assertFalse(emailValidator.hasInvalidCharacters("name.surname@gmail.com"));
    }

    @Test
    void TestIfEmailHasCorrectDomainAndTLD() {
        assertTrue(emailValidator.hasCorrectDomainAndTDL("name.surname@gmail.com"));
    }

}
