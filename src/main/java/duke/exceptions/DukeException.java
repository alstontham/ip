package duke.exceptions;

/**
 * This class is the parent Exception class for the Duke program and serves as a template for all the
 * other Exception classes.
 */
public class DukeException extends Exception{
    public DukeException() {

    }

    public void getErrorMessage() {
        System.out.println("An error has occurred.\n");
    }
}
