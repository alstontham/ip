package duke.exceptions;

public class DukeTaskListEmptyException extends DukeException{
    public DukeTaskListEmptyException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Your task list is currently empty! Add some first before you view them!\n");
    }
}
