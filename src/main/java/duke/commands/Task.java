package duke.commands;

public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;

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
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
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
