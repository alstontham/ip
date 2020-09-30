package duke.exceptions;

/**
 * This class is an extension of the DukeException class and prints an error message when the user wants
 * to create an Event object but does not use the signifier "at" to specify when the event is taking place.
 */
public class DukeEventMissingAtException extends DukeException{
    public DukeEventMissingAtException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Remember to put 'at' in your event command!\n");
    }
}
