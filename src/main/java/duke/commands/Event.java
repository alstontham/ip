package duke.commands;

/**
 * The Event class is an extension of the Task class and creates Event objects, marked by their
 * signature "at" keyword.
 */
public class Event extends Task{

    private String eventDate;

    public Event (String description, String eventDate) {
        super(description, "E");
        this.eventDate = eventDate;
    }

    public Event (String description, String eventDate, boolean isDone) {
        super(description, "E", isDone);
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "[" + taskType + "] " + super.toString() + " (at: " + eventDate + ")";
    }

    @Override
    public String insertComma() {
        return taskType + "," + isDone + "," + description + "," + eventDate;
    }
}
