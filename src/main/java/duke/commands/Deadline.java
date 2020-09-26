package duke.commands;

public class Deadline extends Task {

    private String deadlineDate;

    public Deadline(String description, String deadlineDate) {
        super(description, "D");
        this.deadlineDate = deadlineDate;
    }

    public Deadline(String description, String deadlineDate, boolean isDone) {
        super(description, "D", isDone);
        this.deadlineDate = deadlineDate;
    }

    @Override
    public String toString() {
        return "[" + taskType + "] " + super.toString() + " (by:" + deadlineDate + ")";
    }

    @Override
    public String insertDecimal() {
        return taskType + ".." + isDone + ".." + description + ".." + deadlineDate;
    }
}
