// TODO: Finish writing Validator

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator{
    static String Errors = "";

    static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        );
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            Errors = "Invalid email";
            return false;
        }
        return true;
    }

    static boolean userExists(String name) {
        return true;
    }

    static boolean emailExists(String email){
        return true;
    }

    static boolean validatePassword(String pwd){
        return true;
    }

    static boolean verifyUserCred(String email, String pwd) {
        return true;
    }
}