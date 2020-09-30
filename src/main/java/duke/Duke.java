package duke;

import duke.exceptions.DukeException;

import java.util.Scanner;

/**
 * The Duke class is the main class which runs, and is able to take in commands like todo and find,
 * which helps the user record and manipulate tasks.
 */
public class Duke {
    private static final String SAVE_FOLDER = "data";
    private static final String SAVE_FILE = "duke.txt";

    private Ui ui;
    private TaskList taskList;
    private Parser parser;
    private Storage storage;

    /**
     * Creates a Duke object which references Ui, TaskList, Parser, and Storage objects.
     */
    public Duke() {
        ui = new Ui();
        taskList = new TaskList();
        parser = new Parser(taskList, ui);
        storage = new Storage(SAVE_FOLDER, SAVE_FILE, taskList);
    }

    /**
     * Initializes a Duke object then runs the bulk of the code.
     * @param args
     */
    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.runProgram();
    }

    /**
     * Runs the methods required for the program to work, which mainly consists of taking in and executing
     * user input, then subsequently saving it.
     */
    public void runProgram() {
        ui.welcomeMessage();
        Scanner input = new Scanner(System.in);

        while(true) {
            try {
                parser.executeCommand(input);
                storage.saveToFile();
            } catch (DukeException e) {
                e.getErrorMessage();
            }
        }
    }






}


