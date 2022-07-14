package StudentsManagement.AppUntils;

import java.util.regex.Pattern;

public class Regex {
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";

    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }


}
