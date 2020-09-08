package duke.exceptions;

public class DukeCommandMissingDescriptionException extends DukeException{
    public DukeCommandMissingDescriptionException() {
        super();
    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please enter a valid description!\n");
    }
}
