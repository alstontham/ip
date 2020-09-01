public class Deadline extends Task{

    protected String dlDate;

    public Deadline(String description, String dlDate) {
        super(description);
        this.dlDate = dlDate;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by:" + dlDate + ")";
    }
}
