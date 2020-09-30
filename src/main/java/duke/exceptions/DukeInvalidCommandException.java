package duke.exceptions;

/**
 * This class is an extension of the DukeException class and prints an error message when the user tries
 * to enter an invalid command that is not recognized by Duke.
 */
public class DukeInvalidCommandException extends DukeException {
    public DukeInvalidCommandException() {
        super();
    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please enter a valid command!\n");
    }
}
