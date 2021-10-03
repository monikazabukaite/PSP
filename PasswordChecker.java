public class PasswordChecker {

    private int minimumLength;
    private int maximumLength;
    private char[] specialPasswordSymbols;
    private int chosenMinLength;
    private int chosenMaxLength;

    public PasswordChecker() {
        minimumLength = 6;
        maximumLength = 50;
        specialPasswordSymbols = new char[]{'$'};
        chosenMinLength = 10;
        chosenMaxLength = 5;
    }

    public boolean checkLength(String password) {
        return password.length() >= minimumLength;
    }

    public boolean isNull(String password) {
        return ((password == null));
    }

    public boolean checkUppercase(String password)
    {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
            return false;
    }

    public boolean checkSpecialSymbols(String password) {
        for (char specialSymbol : specialPasswordSymbols) {
            if (password.contains(Character.toString(specialSymbol))) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid(String password) {
        if (!checkLength(password)) return false;
        if (isNull(password)) return false;
        if (!checkUppercase(password)) return false;
        if (!checkSpecialSymbols(password)) return false;
        return true;
    }

    public void setMinimumLength(int chosenMinLength) {
        minimumLength = chosenMinLength;
    }

    public void setMaximumLength(int chosenMaxLength) {
        maximumLength = chosenMaxLength;
    }

    public void setSpecialSymbols(char[] chars) {
        specialPasswordSymbols = chars;
    }
}
