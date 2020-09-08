package duke.exceptions;

//Parent Exception class for the duke.Duke program
public class DukeException extends Exception{
    public DukeException() {

    }

    public void getErrorMessage() {
        System.out.println("An error has occurred.\n");
    }
}
