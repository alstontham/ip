package duke.exceptions;

/**
 * This class is an extension of the DukeException class and prints an error message when the user tries
 * to delete or mark task that does not exist as done, according to index number.
 */
public class DukeInvalidIndexException extends DukeException {
    public DukeInvalidIndexException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please enter a valid index number for the command!\n");
    }
}
