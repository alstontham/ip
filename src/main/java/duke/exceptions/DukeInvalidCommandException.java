package duke.exceptions;

public class DukeInvalidCommandException extends DukeException {
    public DukeInvalidCommandException() {
        super();
    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please enter a valid command!\n");
    }
}
