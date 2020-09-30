package duke;

import duke.commands.Task;

import java.util.ArrayList;

/**
 * The TaskList class handles modifications to the list of tasks that the user creates.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Constructor for the TaskList.
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Adds a task to the TaskList.
     * @param task The task to add.
     */
    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Removes a task from the TaskList.
     * @param taskNum Index of the task to be removed.
     */
    public void deleteTask(int taskNum) {
        taskList.remove(taskNum);
    }

    /**
     * Identifies the task at a certain index.
     * @param taskIndex Index of the specified task.
     * @return The task.
     */
    public Task getTask(int taskIndex) {
        return taskList.get(taskIndex);
    }

    /**
     * Obtains the list as an ArrayList.
     * @return The ArrayList.
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Gets the size of the TaskList.
     * @return Size.
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Checks if the TaskList is empty.
     * @return True if TaskList is empty, otherwise false.
     */
    public boolean isEmpty() {
        if (taskList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
