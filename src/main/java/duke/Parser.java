package duke;

import duke.commands.Deadline;
import duke.commands.Event;
import duke.commands.Task;
import duke.commands.Todo;
import duke.exceptions.*;

import java.util.Scanner;

/**
 * The Parser class makes sense of the various commands that the user may input into the program and
 * executes those commands.
 */
public class Parser {
    private static final String TODO_COMMAND = "todo";
    private static final String DEADLINE_COMMAND = "deadline";
    private static final String EVENT_COMMAND = "event";
    private static final String LIST_COMMAND = "list";
    private static final String DONE_COMMAND = "done";
    private static final String DELETE_COMMAND = "delete";
    private static final String BYE_COMMAND = "bye";

    private static final String DEADLINE_SIGNIFIER = "/by";
    private static final String EVENT_SIGNIFIER = "/at";

    private static final String WHITESPACE = "\\s";
    private static final int TASK_DESCRIPTION_INDEX = 0;
    private static final int TASK_DATE_INDEX = 1;

    private TaskList taskList;
    private Ui ui;

    public Parser(TaskList taskList, Ui ui) {
        this.taskList = taskList;
        this.ui = ui;
    }

    public void executeCommand(Scanner input) throws DukeCommandMissingDescriptionException, DukeDeadlineMissingByException, DukeEventMissingAtException, DukeTaskListEmptyException, DukeInvalidIndexException {
        String userInput = input.nextLine();
        String userCommand = userInput.split(WHITESPACE, 2)[0];

        if (userCommand.equals(TODO_COMMAND)) {
            addTodo(userInput);
        } else if (userCommand.equals(DEADLINE_COMMAND)) {
            addDeadline(userInput);
        } else if (userCommand.equals(EVENT_COMMAND)) {
            addEvent(userInput);
        } else if (userInput.equals(LIST_COMMAND)) {
            listTasks();
        } else if (userCommand.equals(DONE_COMMAND)) {
            markDone(userInput);
        } else if (userCommand.equals(DELETE_COMMAND)) {
            deleteTask(userInput);
        } else if (userCommand.equals(BYE_COMMAND)) {
            exitProgram();
        } else {
            new DukeInvalidCommandException();
        }
    }

    private void addTodo(String userInput) throws DukeCommandMissingDescriptionException {
        try {
            String taskDetails = userInput.split(WHITESPACE, 2)[1];
            Task newTask = new Todo(taskDetails);
            taskList.addTask(newTask);
            ui.printNewTask(newTask, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeCommandMissingDescriptionException();
        }
    }

    private void addDeadline(String userInput) throws DukeDeadlineMissingByException, DukeCommandMissingDescriptionException {
        if (!userInput.contains(DEADLINE_SIGNIFIER)) {
            throw new DukeDeadlineMissingByException();
        }
        try {
            String taskDetails = userInput.split(WHITESPACE, 2)[1];
            Task newTask = new Deadline(obtainDeadlineDescription(taskDetails), obtainDeadlineDate(taskDetails));
            taskList.addTask(newTask);
            ui.printNewTask(newTask, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeCommandMissingDescriptionException();
        }
    }

    private void addEvent(String userInput) throws DukeEventMissingAtException, DukeCommandMissingDescriptionException {
        if (!userInput.contains(EVENT_SIGNIFIER)) {
            throw new DukeEventMissingAtException();
        }
        try {
            String taskDetails = userInput.split(WHITESPACE, 2)[1];
            Task newTask = new Event(obtainEventDescription(taskDetails), obtainEventDate(taskDetails));
            taskList.addTask(newTask);
            ui.printNewTask(newTask, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeCommandMissingDescriptionException();
        }
    }

    private void listTasks() throws DukeTaskListEmptyException {
        if (taskList.isEmpty()) {
            throw new DukeTaskListEmptyException();
        }
        ui.printTaskList(taskList);
    }

    private void markDone(String userInput) throws DukeInvalidIndexException {
        try {
            int taskNum = Integer.parseInt(userInput.split(WHITESPACE, 2)[1]) - 1;
            taskList.getTask(taskNum).setDone(true);
            ui.printCompletedTask(taskList.getTask(taskNum));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidIndexException();
        }
    }

    private void deleteTask(String userInput) throws DukeInvalidIndexException {
        try {
            int taskNum = Integer.parseInt(userInput.split(WHITESPACE, 2)[1]) - 1;
            ui.printDeletedTask(taskList.getTask(taskNum));
            taskList.deleteTask(taskNum);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidIndexException();
        }
    }

    private void exitProgram() {
        System.out.println("Bye, see you soon!");
        System.exit(0);
    }

    private String obtainDeadlineDescription(String description) {
        return (description.split(DEADLINE_SIGNIFIER, 2)[TASK_DESCRIPTION_INDEX]).trim();
    }

    private String obtainDeadlineDate(String description) {
        return (description.split(DEADLINE_SIGNIFIER, 2)[TASK_DATE_INDEX]).trim();
    }

    private String obtainEventDescription(String description) {
        return (description.split(EVENT_SIGNIFIER, 2)[TASK_DESCRIPTION_INDEX]).trim();
    }

    private String obtainEventDate(String description) {
        return (description.split(EVENT_SIGNIFIER, 2)[TASK_DATE_INDEX]).trim();
    }
}
