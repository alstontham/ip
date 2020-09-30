package duke.exceptions;

/**
 * This class is an extension of the DukeException class and prints an error message when the user tries
 * to list out the tasks when there are no items in the TaskList.
 */
public class DukeTaskListEmptyException extends DukeException{
    public DukeTaskListEmptyException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Your task list is currently empty! Add some first before you view them!\n");
    }
}
