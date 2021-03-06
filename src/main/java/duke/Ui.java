package duke;

import duke.commands.Task;

import java.util.ArrayList;

/**
 * The Ui class handles all of what the user sees as the output on the command line.
 */
public class Ui {
    public Ui() {

    }

    /**
     * Prints the welcome message when the user launches the application.
     */
    public void welcomeMessage() {
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?" + "\n");
    }

    /**
     * String that is printed before the program lists out the user's tasks.
     */
    public void printTaskListStarter() {
        System.out.println("I've printed your list of tasks below!\n");
    }
  
    /**
     * Prints out the TaskList, one task at a time.
     * @param tasks The TaskList.
     */
    public void printTaskList(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.print("\n");
    }

    /**
     * Calls the other constructor which takes in an ArrayList.
     * @param tasks List of tasks.
     */
    public void printTaskList(TaskList tasks) {
        printTaskList(tasks.getTaskList());
    }

    /**
     * Prints a message when the user adds a new task.
     * @param task The new task that was just added.
     * @param totalTasks The total number of tasks in the list.
     */
    public void printNewTask(Task task, int totalTasks) {
        System.out.println("Ok! I've added the following task:\n" + task + "\n" + "You now have "
                + totalTasks + " task(s) in the list." + "\n");
    }

    /**
     * Prints a message when the user marks a task as done.
     * @param task The task that the user marks as done.
     */
    public void printCompletedTask(Task task) {
        System.out.println("Ok! I've marked this task as complete!\n" + task + "\n");
    }

    /**
     * Prints a message when the user deletes a task.
     * @param task the task that the user wants to delete.
     */
    public void printDeletedTask(Task task) {
        System.out.println("Alright! I've deleted this task as requested!\n" + task + "\n");
    }

    /**
     * Prints an exit message then exits the program.
     */
    public void exitProgram() {
        System.out.println("Bye, see you soon!");
        System.exit(0);
    }

    /**
     * String that is printed before the list containing tasks with the keyword specified by the user.
     * @param searchWord Keyword that the user was looking for.
     */
    public void printFilteredListStarter(String searchWord) {
        System.out.println("I've printed out the tasks that contain \'" + searchWord + "\' below!\n");
    }
}
