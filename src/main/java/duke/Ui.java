package duke;

import duke.commands.Task;

import java.util.ArrayList;

public class Ui {
    public Ui() {

    }
    public void welcomeMessage() {
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?" + "\n");
    }

    public void printTaskListStarter() {
        System.out.println("I've printed your list of tasks below!\n");
    }

    public void printTaskList(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.print("\n");
    }

    public void printTaskList(TaskList tasks) {
        printTaskList(tasks.getTaskList());
    }

    public void printNewTask(Task task, int totalTasks) {
        System.out.println("Ok! I've added the following task:\n" + task + "\n" + "You now have "
                + totalTasks + " task(s) in the list." + "\n");
    }

    public void printCompletedTask(Task task) {
        System.out.println("Ok! I've marked this task as complete!\n" + task + "\n");
    }

    public void printDeletedTask(Task task) {
        System.out.println("Alright! I've deleted this task as requested!\n" + task + "\n");
    }

    public void printFilteredListStarter(String searchWord) {
        System.out.println("I've printed out the tasks that contain \'" + searchWord + "\' below!\n");
    }
}
