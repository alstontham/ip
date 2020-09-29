package duke;

import duke.commands.Deadline;
import duke.commands.Event;
import duke.commands.Task;
import duke.commands.Todo;
import duke.exceptions.DukeTaskConvertException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private static final String DATA_DELIMITER = ",";
    private static final int TASK_DESCRIPTION_INDEX = 0;
    private static final int TASK_DATE_INDEX = 1;
    private static final String PROJECT_DIRECTORY = "user.dir";

    private String saveDirectory;
    private TaskList taskList;
    private String saveFilePath;

    public Storage(String saveDirectory, String saveFile, TaskList taskList) {
        this.taskList = taskList;
        this.saveDirectory = saveDirectory;
        ensureSaveDirectory();
        this.saveFilePath = "/" + saveDirectory + "/" + saveFile;
        readFromFile();

    }

    public void ensureSaveDirectory() {
        File dataDirectory = new File(saveDirectory);
        if (!dataDirectory.exists()) {
            dataDirectory.mkdir();
        }
    }

    public void readFromFile() {
        try {
            Scanner sc = new Scanner(new File(System.getProperty(PROJECT_DIRECTORY) + saveFilePath));
            while (sc.hasNextLine()) {
                String newTaskLine = sc.nextLine();
                Task newTask = convertToTask(newTaskLine);
                taskList.addTask(newTask);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A save file could not be found. " +
                    "You may either start from scratch or load an existing save file");
        } catch (DukeTaskConvertException e) {
            System.out.println("There was an error converting the save file.");
        }
    }

    private Task convertToTask(String taskData) throws DukeTaskConvertException {
        String[] taskComponents = taskData.split(DATA_DELIMITER,3);
        String taskType = taskComponents[0];
        boolean isDone = Boolean.parseBoolean(taskComponents[1]);
        String taskDescription = taskComponents[2];
        switch(taskType) {
            case("T"):
                return new Todo(taskDescription, isDone);
            case("D"):
                String deadlineDescription = taskDescription.split(DATA_DELIMITER)[TASK_DESCRIPTION_INDEX];
                String deadlineDate = taskDescription.split(DATA_DELIMITER)[TASK_DATE_INDEX];
                return new Deadline(deadlineDescription, deadlineDate, isDone);
            case("E"):
                String eventDescription = taskDescription.split(DATA_DELIMITER)[TASK_DESCRIPTION_INDEX];
                String eventDate = taskDescription.split(DATA_DELIMITER)[TASK_DATE_INDEX];
                return new Event(eventDescription, eventDate, isDone);
            default:
                throw new DukeTaskConvertException();
        }
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(System.getProperty(PROJECT_DIRECTORY) + saveFilePath);
            for (Task task : taskList.getTaskList()) {
                fw.write(task.insertComma() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("An error has occurred while saving data to file. Please try again later.");
        }
    }
}
