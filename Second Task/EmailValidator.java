public class EmailValidator {

    private final String email;
    private char[] forbiddenSymbols;

    public EmailValidator() {
        email = "name.surname@gmail.com";
    }

    public boolean isValid(String email) {
        return checkAtSign(email) && checkDomain(email) && !checkForbiddenSymbols(email, forbiddenSymbols) && checkTLD(email);
    }

    private boolean checkAtSign(String email) {
        if (email == null || email.isEmpty()) return false;
        return email.contains("@");
    }

    private boolean checkForbiddenSymbols(String email, char[] forbiddenSymbols) {
        forbiddenSymbols = new char[] {'&', '$'};
        if (email == null || email.isEmpty()) return false;
        for (char forbiddenSymbol : forbiddenSymbols) {
            if (email.contains(Character.toString(forbiddenSymbol))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDomain(String email) {
        if (email == null || email.isEmpty()) return false;
        String[] emailParts = email.split("@");
        if (emailParts.length < 2) return false;

        String domainPart = emailParts[1];
        String[] domains = domainPart.split("\\.");

        for (String domain : domains) {
            for (int j = 0; j < domain.length(); j++) {
                char c = domain.charAt(j);
                if (c == '-') {
                    if (j == 0) return false;
                    if (j == domain.length() - 1) return false;
                } else if (!Character.isLetter(c) &&
                        !Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkTLD(String email) {
        forbiddenSymbols = new char[]{
                ',', '(', ')', '~', '[', ']', '\"', '"', ',', ':', ';', '>', '<', '@', '-',
                '!', '#', '$', '%', '&', '\'', '*', '+', '/', '=', '?', '^', '_', '`', '{', '|', '}'};
        String domainName;
        String domainTLD;

        if (email.contains("@") && email.substring(email.indexOf("@")).contains(".")) {
            domainTLD = email.substring(email.lastIndexOf('.') + 1);
            domainName = email.substring(email.indexOf('@') + 1, email.lastIndexOf('.'));
        } else return true;

        return domainName.length() > 253
                || domainName.length() == 0
                || checkForbiddenSymbols(domainName, forbiddenSymbols)
                || !checkLowercase(domainTLD)
                || checkForbiddenSymbols(domainTLD, forbiddenSymbols)
                || checkInt(domainName);
    }

    private boolean checkLowercase(String domainTLD){

        char[] charArray = domainTLD.toCharArray();

        for (char c : charArray) {
            if (!Character.isLowerCase(c))
                return false;
        }
        return true;
    }

    public boolean checkInt(String email) {
        String str = email.replace(".", "");

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public void setForbiddenSymbols(char[] forbiddenSymbols) {
        char[] chosenSymbols = {'&', '=', '>', '=', '/'};
        forbiddenSymbols = chosenSymbols;
    }
}
