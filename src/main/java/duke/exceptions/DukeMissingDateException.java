package duke.exceptions;

public class DukeMissingDateException extends DukeException{
    public DukeMissingDateException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Please specify a date for your task!\n");
    }
}
