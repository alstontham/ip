package duke;

import duke.exceptions.DukeException;

import java.util.Scanner;

public class Duke {
    private static final String SAVE_FOLDER = "data";
    private static final String SAVE_FILE = "duke.txt";

    private Ui ui;
    private TaskList taskList;
    private Parser parser;
    private Storage storage;

    public Duke() {
        ui = new Ui();
        taskList = new TaskList();
        parser = new Parser(taskList, ui);
        storage = new Storage(SAVE_FOLDER, SAVE_FILE, taskList);
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.runProgram();
    }

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


