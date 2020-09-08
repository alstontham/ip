package duke.exceptions;

public class DukeDeadlineMissingByException extends DukeException{
    public DukeDeadlineMissingByException() {

    }

    @Override
    public void getErrorMessage() {
        System.out.println("Remember to put 'by' when specifying a deadline!\n");
    }
}
