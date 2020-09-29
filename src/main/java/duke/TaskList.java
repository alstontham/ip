package duke;

import duke.commands.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int taskNum) {
        taskList.remove(taskNum);
    }

    public Task getTask(int taskIndex) {
        return taskList.get(taskIndex);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public int size() {
        return taskList.size();
    }

    public boolean isEmpty() {
        if (taskList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
