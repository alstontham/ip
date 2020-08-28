import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        String userInput;
        int listItemNum = 0;
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?" + "\n");

        List<Task> taskList = new ArrayList<>();

        //Takes user input
        Scanner input = new Scanner(System.in);

        //this do-while loop asks users for input, can add items to lists and print the list
        while (!input.hasNext("bye")) {
            userInput = input.nextLine();
            if (userInput.equals("list")) {
                //goes through each item in the array and lists them out
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println((i + 1) + ". [" + taskList.get(i).getStatusIcon() + "] "
                            + taskList.get(i).getDescription());
                }
                System.out.print("\n");
            } else if (userInput.startsWith("done")) {
                int stringLen = userInput.length();
                int i = Integer.parseInt(userInput.substring(5, stringLen)) - 1;
                taskList.get(i).setDone(true);

                System.out.println("Ok! I've marked this task as complete!\n" + "[\u2713] "
                        + taskList.get(i).getDescription() + "\n");

            } else {
                //prints out items that users want to add to a list then adds it to the list
                System.out.println("added: " + userInput + "\n");
                taskList.add(new Task(userInput));
            }
        }

        System.out.println("Bye, see you soon!");
    }

}


