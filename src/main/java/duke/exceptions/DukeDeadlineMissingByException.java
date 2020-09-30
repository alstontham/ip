package duke.exceptions;

/**
 * This class is an extension of the DukeException class and prints an error message when the user wants
 * to create a Deadline object but does not use the signifier "by" to specify the due date of the task.
 */
public class DukeDeadlineMissingByException extends DukeException{
    public DukeDeadlineMissingByException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Remember to put 'by' when specifying a deadline!\n");
    }
}
