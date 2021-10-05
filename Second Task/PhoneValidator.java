public class PhoneValidator {

    private int minimumLength;
    private int maximumLength;

    PhoneValidator() {
        minimumLength = 9;
        maximumLength = 12;
    }

    public boolean checkLength(String number) {
        if ((number == null || number.isEmpty())) return false;
        return number.length() >= minimumLength && number.length() < maximumLength;
    }

    public boolean checkOnlyNumbers(String number) {
        if ((number == null || number.isEmpty())) return false;
        for (char character : number.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPrefix(String number) {
        String[] allowedPrefixes = new String[]{"+370", "8"};
        if (number == null || number.isEmpty()) return false;
        for (int i = 0; i < number.length(); i++) {
            for (String allowedPrefix : allowedPrefixes) {
                if (number.startsWith(allowedPrefix)) return true;
            }
        }
        return false;
    }

    public String checkCode(String number) {
        if (number == null || number.isEmpty()) return "";
        if (checkPrefix(number)) {
            if (number.startsWith("8")) {
                return "+370" + number.substring(1);
            }
        }
        return number;
    }

    public boolean isValid(String number) {
        return checkPrefix(number) && checkLength(number) && checkOnlyNumbers(number);
    }

    public void setMinimumLength(int chosenMinLength) {
        minimumLength = chosenMinLength;
    }

    public void setMaximumLength(int chosenMaxLength) {
        maximumLength = chosenMaxLength;
    }

    public void setAllowedPrefixes(String[] allowedPrefixes) {
        String[] newAllowedPrefixes = new String[]{"+77", "+88", "77", "88"};
        allowedPrefixes = newAllowedPrefixes;
    }
}
