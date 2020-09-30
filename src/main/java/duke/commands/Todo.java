package duke.commands;

/**
 * The Todo class is an extension of the Task class and creates Todo objects.
 */
public class Todo extends Task{
    /**
     * Todo constructor.
     * @param description Description of the todo task.
     */
    public Todo(String description) {
        super(description, "T");
    }

    /**
     * Todo constructor.
     * @param description Description of the todo task.
     * @param isDone Whether is the task is done.
     */
    public Todo(String description, boolean isDone) {
        super(description, "T", isDone);
    }

    /**
     * Overrides the default Task method
     * @return The formatted string based on the data.
     */
    @Override
    public String toString() {
        return "[" + taskType + "] " + super.toString();
    }
}
