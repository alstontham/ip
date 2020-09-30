package duke.exceptions;

/**
 * This class is an extension of the DukeException class and prints an error message when task commands
 * that require an additional description are missing one.
 */
public class DukeCommandMissingDescriptionException extends DukeException{
    public DukeCommandMissingDescriptionException() {
        super();
    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please enter a valid description!\n");
    }
}
