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


