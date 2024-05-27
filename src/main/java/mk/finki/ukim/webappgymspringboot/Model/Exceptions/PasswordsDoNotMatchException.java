package mk.finki.ukim.webappgymspringboot.Model.Exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{

    public PasswordsDoNotMatchException() {
        super("The Password and Repeat password fields do not match.");
    }
}
