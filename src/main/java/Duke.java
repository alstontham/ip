import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String userInput;
        String[] listOfItems = new String[100];
        int listItemNum = 0;
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?" + "\n");

        //this do-while loop asks users for input, can add items to lists and print the list
        do {
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();
            if (userInput.equals("list")) {
                //goes through each item in the array and lists them out
                for (int i = 0; i < listItemNum; i++) {
                    System.out.println((i + 1) + ". " + listOfItems[i]);
                }
                System.out.print("\n");
            } else if (userInput.equals("bye")) {
                //exits the do-while loop and exits the program
                break;
            } else {
                //prints out items that users want to add to a list then adds it to the list
                System.out.println("added: " + userInput + "\n");
                listOfItems[listItemNum] = userInput;
                listItemNum++;
            }
        } while (true);

        System.out.println("Bye, see you soon!");
    }

}


