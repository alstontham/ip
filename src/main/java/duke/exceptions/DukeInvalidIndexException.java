package duke.exceptions;

public class DukeInvalidIndexException extends DukeException {
    public DukeInvalidIndexException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please enter a valid index number for the command!\n");
    }
}
