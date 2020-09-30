package duke.commands;

/**
 * The Event class is an extension of the Task class and creates Event objects, marked by their
 * signature "at" keyword.
 */
public class Event extends Task{

    private String eventDate;

    /**
     * Event constructor.
     * @param description Description of the event task.
     * @param eventDate Date of the event task.
     */
    public Event (String description, String eventDate) {
        super(description, "E");
        this.eventDate = eventDate;
    }

    /**
     * Event constructor.
     * @param description Description of the event task.
     * @param eventDate Date of the event task.
     * @param isDone Whether is the task is done.
     */
    public Event (String description, String eventDate, boolean isDone) {
        super(description, "E", isDone);
        this.eventDate = eventDate;
    }

    /**
     * Overrides the default Task method, includes date of the event.
     * @return The formatted string based on the data.
     */
    @Override
    public String toString() {
        return "[" + taskType + "] " + super.toString() + " (at: " + eventDate + ")";
    }

    /**
     * Overrides the default Task method, includes date of event.
     * @return The string created by adding commas.
     */
    @Override
    public String insertComma() {
        return taskType + "," + isDone + "," + description + "," + eventDate;
    }
}
