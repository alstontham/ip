import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String userInput;
        System.out.println("Hey there! I'm Duke\n" + "What would you like to do?");

        //this do-while loop asks users for input and echoes until it receives a specific string
        do {
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();
            echoString(userInput);
        } while (!userInput.equals("bye"));

        System.out.println("Bye, see you soon!");
    }

    //this function outputs the same string as the user inputs
    public static void echoString(String userInput) {
        System.out.println(userInput + "\n");
    }
}


