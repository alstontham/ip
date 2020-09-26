package duke.commands;

public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    private final String DONE = "\u2713";
    private final String NOT_DONE = "\u2718";

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

    public String insertDecimal() {
        return taskType + ".." + isDone + ".." + description;
    }
}
