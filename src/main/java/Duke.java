import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?" + "\n");

        List<Task> taskList = new ArrayList<>();

        //Takes user input
        Scanner input = new Scanner(System.in);

        //this do-while loop asks users for input, can add items to lists and print the list
        while (!input.hasNext("bye")) {
            String userInput = input.nextLine();
            String userCommand = userInput.split("\\s", 2)[0];
            int stringLen = userInput.length();

            //adds a todo item to the list
            if (userCommand.equals("todo")) {
                String noCommand = userInput.split("\\s", 2)[1];
                Task newTask = new Todo(noCommand);
                taskList.add(newTask);
                printNewTask(newTask, taskList.size());
            }

            //adds a deadline item to the list
            if (userCommand.equals("deadline")) {
                String noCommand = userInput.split("\\s", 2)[1];
                Task newTask = new Deadline(obtainDLDesc(noCommand), obtainDLDate(noCommand));
                taskList.add(newTask);
                printNewTask(newTask, taskList.size());
            }

            //adds and event item to the list
            if (userCommand.equals("event")) {
                String noCommand = userInput.split("\\s", 2)[1];
                Task newTask = new Event(obtainEventDesc(noCommand), obtainEventDate(noCommand));
                taskList.add(newTask);
                printNewTask(newTask, taskList.size());
            }

            //lists out respective tasks
            if (userInput.equals("list")) {
                printTaskList(taskList);
            }

            //marks a task as done
            if (userCommand.equals("done")) {
                int i = Integer.parseInt(userInput.substring(5, stringLen)) - 1;
                taskList.get(i).setDone(true);
                printDone(taskList.get(i));
            }
        }

        System.out.println("Bye, see you soon!");
    }

    private static String obtainDLDesc(String description) {
        return description.split("/by", 2)[0];
    }

    private static String obtainEventDesc(String description) {
        return description.split("/at", 2)[0];
    }

    private static String obtainDLDate(String description) {
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

    private static void printDone(Task task) {
        System.out.println("Ok! I've marked this task as complete!\n" + task + "\n");
    }

}


