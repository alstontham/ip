package duke;

import duke.commands.Deadline;
import duke.commands.Event;
import duke.commands.Task;
import duke.commands.Todo;
import duke.exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        readFromFile();
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?" + "\n");

        //Takes user input
        Scanner input = new Scanner(System.in);

        while(true) {
            try {
                executeCommand(input);
            } catch (DukeException e) {
                e.getErrorMessage();
            }
        }
    }

    private static void executeCommand(Scanner input) throws DukeException {
        //this do-while loop asks users for input, can add items to lists and print the list
        String userInput = input.nextLine();
        String userCommand = userInput.split("\\s", 2)[0];
        int stringLen = userInput.length();

        //adds a todo item to the list
        if (userCommand.equals("todo")) {
            try {
                String taskDetails = userInput.split("\\s", 2)[1];
                Task newTask = new Todo(taskDetails);
                taskList.add(newTask);
                printNewTask(newTask, taskList.size());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeCommandMissingDescriptionException();
            }
        }

        //adds a deadline event to the list
        else if (userCommand.equals("deadline")) {
            if (!userInput.contains(" /by ")) {
                throw new DukeDeadlineMissingByException();
            }
            try {
                String taskDetails = userInput.split("\\s", 2)[1];
                Task newTask = new Deadline(obtainDeadlineDescription(taskDetails), obtainDeadlineDate(taskDetails));
                taskList.add(newTask);
                printNewTask(newTask, taskList.size());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeCommandMissingDescriptionException();
            }
        }

        //adds an event item to the list
        else if (userCommand.equals("event")) {
            if (!userInput.contains(" /at ")) {
                throw new DukeEventMissingAtException();
            }
            try {
                String taskDetails = userInput.split("\\s", 2)[1];
                Task newTask = new Event(obtainEventDescription(taskDetails), obtainEventDate(taskDetails));
                taskList.add(newTask);
                printNewTask(newTask, taskList.size());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeCommandMissingDescriptionException();
            }
        }

        //lists out respective tasks
        else if (userInput.equals("list")) {
            if (taskList.isEmpty()) {
                throw new DukeTaskListEmptyException();
            }
            printTaskList(taskList);
        }

        //marks a task as done
        else if (userCommand.equals("done")) {
            try {
                int taskNum  = Integer.parseInt(userInput.split("\\s", 2)[1]) - 1;
                taskList.get(taskNum).setDone(true);
                printCompletedTask(taskList.get(taskNum));
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidIndexException();
            }
        }

        else if (userCommand.equals("delete")) {
            try {
                int taskNum  = Integer.parseInt(userInput.split("\\s", 2)[1]) - 1;
                printRemovedTask(taskList.get(taskNum));
                taskList.remove(taskNum);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidIndexException();
            }
        }

        else if (userCommand.equals("bye")) {
            System.out.println("Bye, see you soon!");
            System.exit(0);
        }

        //handles the case for when an invalid command is entered
        else {
            throw new DukeInvalidCommandException();
        }
        saveToFile();
    }
    private static String obtainDeadlineDescription(String description) {
        return description.split("/by", 2)[0];
    }

    private static String obtainEventDescription(String description) {
        return description.split("/at", 2)[0];
    }

    private static String obtainDeadlineDate(String description) {
        return description.split("/by", 2)[1];
    }

    private static String obtainEventDate(String description) {
        return description.split("/at", 2)[1];
    }

    private static void printNewTask(Task task, int totalTasks) {
        System.out.println("Ok! I've added the following task:\n" + task + "\n" + "You now have "
                + totalTasks + " task(s) in the list." + "\n");
    }

    private static void printTaskList(List<Task> tasks) {
        System.out.println("I've printed your list of tasks below!\n");

        //goes through each item in the array and lists them out
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.print("\n");
    }

    private static void printCompletedTask(Task task) {
        System.out.println("Ok! I've marked this task as complete!\n" + task + "\n");
    } 

    private static void printRemovedTask(Task task) {
        System.out.println("Alright! I've removed this task as requested!\n" + task + "\n");
    }

    private static void saveToFile() {
        try {
            //new File( System.getProperty("user.dir") + "/data").mkdir();
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/data/duke.txt");
            for (Task task : taskList) {
                fw.write(task.insertDecimal() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("An error has occurred while saving data to file. Please try again later.");
        }
    }

    private static void readFromFile() {
        File dataDirectory = new File("data");
        if (!dataDirectory.exists()) {
            dataDirectory.mkdir();
        }
        try {
            Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/data/duke.txt"));
            while (sc.hasNextLine()) {
                String newTaskLine = sc.nextLine();
                Task newTask = convertToTask(newTaskLine);
                taskList.add(newTask);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A save file could not be found. " +
                    "You may either start from scratch or load an existing save file");
        } catch (DukeTaskConvertException e) {
            System.out.println("There was an error converting the save file.");
        }
    }

    private static Task convertToTask(String taskData) throws DukeTaskConvertException {
        String[] taskComponents = taskData.split("\\.\\.");
        String taskType = taskComponents[0];
        boolean isDone = Boolean.parseBoolean(taskComponents[1]);
        String taskDescription = taskComponents[2];
        switch(taskType) {
            case("T"):
                return new Todo(taskDescription, isDone);
            case("D"):
                String deadlineDescription = taskDescription.split("\\.\\.")[0];
                String deadlineDate = taskDescription.split("\\.\\.")[1];
                return new Deadline(deadlineDescription, deadlineDate, isDone);
            case("E"):
                String eventDescription = taskDescription.split("\\.\\.")[0];
                String eventDate = taskDescription.split("\\.\\.")[1];
                return new Event(eventDescription, eventDate, isDone);
            default:
                throw new DukeTaskConvertException();
        }
    }

}


