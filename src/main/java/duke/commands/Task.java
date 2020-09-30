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

    public Task(String description, String taskType) {
        this.description = description;
        this.taskType = taskType;
        this.isDone = false;
    }

    public Task(String description, String taskType, boolean isDone) {
        this.description = description;
        this.taskType = taskType;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? DONE : NOT_DONE); //return tick or X symbols
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

    public String insertComma() {
        return taskType + "," + isDone + "," + description;
    }
}
