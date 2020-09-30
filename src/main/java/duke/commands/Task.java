package duke.commands;

/**
 * The Task class creates Task objects which are stored in the TaskList. This class is the blueprint
 * for the various types of tasks that the user might want to create. As such, it contains the default
 * constructor class for the Task objects as well as methods that might be called.
 */
public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    private static final String DONE = "\u2713";
    private static final String NOT_DONE = "\u2718";

    /**
     * Constructor for the Task object which has a description and a type and by default is not marked
     * as done.
     * @param description The task description.
     * @param taskType The type of task: todo, deadline, event.
     */
    public Task(String description, String taskType) {
        this.description = description;
        this.taskType = taskType;
        this.isDone = false;
    }

    /**
     * Constructor for the Task object which has a description, type, and can be marked as done.
     * @param description The task description.
     * @param taskType The type of task: todo, deadline, event.
     * @param isDone Whether the task is done.
     */
    public Task(String description, String taskType, boolean isDone) {
        this.description = description;
        this.taskType = taskType;
        this.isDone = isDone;
    }

    /**
     * Displays a tick or X symbol based on if the task is done.
     * @return Tick or X.
     */
    public String getStatusIcon() {
        return (isDone ? DONE : NOT_DONE);
    }

    /**
     * Sets a task as done.
     * @param isDone True or false.
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Obtains the description of the task.
     * @return The description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Uses the status icon and description and converts them to a formatted string.
     * @return The string based on the status icon and description.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

    /**
     * Inserts a comma between data to be stored in the save file.
     * @return The string created by adding commas.
     */
    public String insertComma() {
        return taskType + "," + isDone + "," + description;
    }
}
