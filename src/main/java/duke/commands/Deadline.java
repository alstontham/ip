package duke.commands;

/**
 * The Deadline class is an extension of the Task class and creates Deadline objects, marked by their
 * signature "by" keyword.
 */
public class Deadline extends Task {

    private String deadlineDate;

    /**
     * Deadline constructor.
     * @param description Description of the deadline task.
     * @param deadlineDate Due date of the deadline task.
     */
    public Deadline(String description, String deadlineDate) {
        super(description, "D");
        this.deadlineDate = deadlineDate;
    }

    /**
     * Deadline constructor.
     * @param description Description of the deadline task.
     * @param deadlineDate Due date of the deadline task.
     * @param isDone Whether is the task is done.
     */
    public Deadline(String description, String deadlineDate, boolean isDone) {
        super(description, "D", isDone);
        this.deadlineDate = deadlineDate;
    }

    /**
     * Overrides the default Task method, includes due date of deadline.
     * @return The formatted string based on the data.
     */
    @Override
    public String toString() {
        return "[" + taskType + "] " + super.toString() + " (by: " + deadlineDate + ")";
    }

    /**
     * Overrides the default Task method, includes due date of deadline.
     * @return The string created by adding commas.
     */
    @Override
    public String insertComma() {
        return taskType + "," + isDone + "," + description + "," + deadlineDate;
    }
}
