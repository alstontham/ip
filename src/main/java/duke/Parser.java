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

    /**
     * Initializes a Parser object, which references TaskList and Ui.
     * @param taskList The TaskList that the tasks will be stored in.
     * @param ui The object that handles the messages that the user will see.
     */
    public Parser(TaskList taskList, Ui ui) {
        this.taskList = taskList;
        this.ui = ui;
    }

    /**
     * Splits the raw user input and executes a command based on the command input.
     * @param input Raw user input.
     * @throws DukeCommandMissingDescriptionException Exception if the command that requries an extra
     * description is missing one.
     * @throws DukeDeadlineMissingByException Exception if the user wants to add a deadline but does not
     * include the "by" signifier.
     * @throws DukeEventMissingAtException Exception if the user wants to add an event but does not include
     * the "at" signifier.
     * @throws DukeTaskListEmptyException Exception if the user tries to print out the list of tasks but
     * does not have any in the TaskList.
     * @throws DukeInvalidIndexException Exception if the user tries to reference a task index that does
     * not contain a task.
     */
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
            ui.exitProgram();
        } else {
            new DukeInvalidCommandException();
        }
    }

    /**
     * Add a todo task into the TaskList.
     * @param userInput The raw user input.
     * @throws DukeCommandMissingDescriptionException Exception if the command that requires an extra
     * description is missing one.
     */
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

    /**
     * Adds a deadline task into the TaskList.
     * @param userInput The raw user input.
     * @throws DukeDeadlineMissingByException Exception if the user wants to add a deadline but does not
     * include the "by" signifier.
     * @throws DukeCommandMissingDescriptionException Exception if the command that requries an extra
     * description is missing one.
     */
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

    /**
     * Adds an event task into the TaskList.
     * @param userInput The raw user input.
     * @throws DukeEventMissingAtException Exception if the user wants to add an event but does not include
     * the "at" signifier.
     * @throws DukeCommandMissingDescriptionException Exception if the command that requries an extra
     * description is missing one.
     */
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

    /**
     * Lists the tasks in the TaskList.
     * @throws DukeTaskListEmptyException Exception if the user tries to print out the list of tasks but
     * does not have any in the TaskList.
     */
    private void listTasks() throws DukeTaskListEmptyException {
        if (taskList.isEmpty()) {
            throw new DukeTaskListEmptyException();
        }
        ui.printTaskList(taskList);
    }

    /**
     * Marks a task in the TaskList as done.
     * @param userInput The raw user input.
     * @throws DukeInvalidIndexException Exception if the user tries to reference a task index that does
     * not contain a task.
     */
    private void markDone(String userInput) throws DukeInvalidIndexException {
        try {
            int taskNum = Integer.parseInt(userInput.split(WHITESPACE, 2)[1]) - 1;
            taskList.getTask(taskNum).setDone(true);
            ui.printCompletedTask(taskList.getTask(taskNum));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidIndexException();
        }
    }

    /**
     * Deletes a task in the TaskList.
     * @param userInput The raw user input.
     * @throws DukeInvalidIndexException Exception if the user tries to reference a task index that does
     * not contain a task.
     */
    private void deleteTask(String userInput) throws DukeInvalidIndexException {
        try {
            int taskNum = Integer.parseInt(userInput.split(WHITESPACE, 2)[1]) - 1;
            ui.printDeletedTask(taskList.getTask(taskNum));
            taskList.deleteTask(taskNum);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidIndexException();
        }
    }

    /**
     * Obtains description details of the deadline based on the raw user input without the command word.
     * @param description The raw user input without the command.
     * @return The details of the deadline.
     */
    private String obtainDeadlineDescription(String description) {
        return (description.split(DEADLINE_SIGNIFIER, 2)[TASK_DESCRIPTION_INDEX]).trim();
    }

    /**
     * Obtains date of the deadline based on the raw user input without the command word.
     * @param description The raw user input without the command.
     * @return The details of when the deadline is.
     */
    private String obtainDeadlineDate(String description) {
        return (description.split(DEADLINE_SIGNIFIER, 2)[TASK_DATE_INDEX]).trim();
    }

    /**
     * Obtains description details of the event based on the raw user input without the command word.
     * @param description The raw user input without the command.
     * @return The details of the event.
     */
    private String obtainEventDescription(String description) {
        return (description.split(EVENT_SIGNIFIER, 2)[TASK_DESCRIPTION_INDEX]).trim();
    }

    /**
     * Obtains date of the event based on the raw user input without the command word.
     * @param description The raw user input without the command.
     * @return The details of when the event is.
     */
    private String obtainEventDate(String description) {
        return (description.split(EVENT_SIGNIFIER, 2)[TASK_DATE_INDEX]).trim();
    }
}
