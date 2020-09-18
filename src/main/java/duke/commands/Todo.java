package duke.commands;

public class Todo extends Task{
    public Todo(String description) {
        super(description, "T");
    }

    public Todo(String description, boolean isDone) {
        super(description, "T", isDone);
    }

    @Override
    public String toString() {
        return "[" + taskType + "] " + super.toString();
    }
}
