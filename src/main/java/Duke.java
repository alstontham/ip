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
            int stringLen = userInput.length();

            //adds a todo item to the list
            if (userInput.startsWith("todo")) {
                TaskType tasktype = TaskType.T;
                String todoString = userInput.substring(5, stringLen);
                taskList.add(new Todo(todoString));
                int listSize = taskList.size();
                System.out.println("Ok! I've added the following task:\n" + "[" + tasktype +"]" + "[\u2718] "
                        + todoString + "\n" + "You now have " + listSize + " task(s) in the list." + "\n");
            }

            //adds a deadline item to the list
            if (userInput.startsWith("deadline")) {
                TaskType tasktype = TaskType.D;
                String noTaskString = userInput.split("\\s", 2)[1];
                String descString = noTaskString.split("/by", 2)[0];
                String dueDate = noTaskString.split("/by", 2)[1];
                taskList.add(new Deadline(descString, dueDate));
                int listSize = taskList.size();
                System.out.println("Ok! I've added the following task:\n" + "[" + tasktype +"]" + "[\u2718] "
                        + descString + " (by:" + dueDate + ")" + "\n" + "You now have " + listSize
                        + " task(s) in the list." + "\n");
            }

            //adds and event item to the list
            if (userInput.startsWith("event")) {
                TaskType tasktype = TaskType.E;
                String noTaskString = userInput.split("\\s", 2)[1];
                String descString = noTaskString.split("/at", 2)[0];
                String eventDate = noTaskString.split("/at", 2)[1];
                taskList.add(new Event(descString, eventDate));
                int listSize = taskList.size();
                System.out.println("Ok! I've added the following task:\n" + "[" + tasktype +"]" + "[\u2718] "
                        + descString + " (at:" + eventDate + ")" + "\n" + "You now have " + listSize
                        + " task(s) in the list." + "\n");
            }

            //lists out respective tasks
            if (userInput.equals("list")) {
                //goes through each item in the array and lists them out
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i) instanceof Todo ) {
                        System.out.println((i + 1) + ". [T] " + "[" + taskList.get(i).getStatusIcon() + "] "
                                + taskList.get(i).getDescription());
                    }
                    if (taskList.get(i) instanceof Deadline) {
                        System.out.println((i + 1) + ". [D] " + "[" + taskList.get(i).getStatusIcon() + "] "
                                + taskList.get(i).getDescription());
                    }
                    if (taskList.get(i) instanceof Event) {
                        System.out.println((i + 1) + ". [E] " + "[" + taskList.get(i).getStatusIcon() + "] "
                                + taskList.get(i).getDescription());
                    }
                }
                System.out.print("\n");
            }

            //marks a task as done
            if (userInput.startsWith("done")) {
                int i = Integer.parseInt(userInput.substring(5, stringLen)) - 1;
                taskList.get(i).setDone(true);

                if (taskList.get(i) instanceof Todo ) {
                    System.out.println("Ok! I've marked this task as complete!\n" + "[T] [\u2713] "
                            + taskList.get(i).getDescription() + "\n");
                }
                if (taskList.get(i) instanceof Deadline) {
                    System.out.println("Ok! I've marked this task as complete!\n" + "[D] [\u2713] "
                            + taskList.get(i).getDescription() + "\n");
                }
                if (taskList.get(i) instanceof Event) {
                    System.out.println("Ok! I've marked this task as complete!\n" + "[E] [\u2713] "
                            + taskList.get(i).getDescription() + "\n");
                }
            }
        }

        System.out.println("Bye, see you soon!");
    }

}


