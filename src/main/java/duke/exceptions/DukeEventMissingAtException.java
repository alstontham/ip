package duke.exceptions;

public class DukeEventMissingAtException extends DukeException{
    public DukeEventMissingAtException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Remember to put 'at' in your event command!\n");
    }
}
