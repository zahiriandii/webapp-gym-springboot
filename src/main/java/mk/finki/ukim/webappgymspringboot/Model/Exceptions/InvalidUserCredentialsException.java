package mk.finki.ukim.webappgymspringboot.Model.Exceptions;

public class InvalidUserCredentialsException extends Exception{
    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }

}
