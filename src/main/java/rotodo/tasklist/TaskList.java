package rotodo.tasklist;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rotodo.exception.InvalidInputException;

/**
 * This class implements the TaskList. The list can
 * be interacted and modified through provided functions.
 *
 * @author Ng Kay Hian
 * @version CS2103T AY24/25 Semester 1
 */
public class TaskList {
    private boolean nextStatus;

    /**
     * List of tasks.
     */
    private List<Task> list;

    /**
     * Initialise tasklist
     */
    public TaskList() {
        list = new ArrayList<>();
        nextStatus = false;
    }

    /**
     * Mark the i'th Task as 'done'.
     *
     * @param i task index
     * @return i'th task state
     */
    public String markDone(int i) throws InvalidInputException {
        if (i >= list.size() || i < 0) {
            throw new InvalidInputException("Task number doesn't exist\u001B[0m\n"
                + "type 'list' to view tasklist");
        }
        Task done = list.get(i);
        return done.markAsDone();
    }

    /**
     * Unmark the i'th Task as 'done'.
     *
     * @param i task index
     * @return i'th task state
     */
    public String unmarkDone(int i) throws InvalidInputException {
        if (i >= list.size() || i < 0) {
            throw new InvalidInputException("Task number doesn't exist\u001B[0m\n"
                + "type 'list' to view tasklist");
        }
        Task done = list.get(i);
        return done.unmarkAsDone();
    }

    public void setNextStatus(boolean status) {
        nextStatus = status;
    }

    /**
     * Add new Todo task to tasklist
     *
     * @param value description of task
     * @return status to be printed by Ui
     */
    public String addTask(String value) {
        Task toAdd = new Todo(value, nextStatus);
        nextStatus = false;
        list.add(toAdd);
        return "Good good! RoTodo is happy to add:\n  " + toAdd
            + "\nNow you have " + list.size() + " tasks in the list.";
    }

    /**
     * Add new Deadline task to tasklist
     *
     * @param value description of task
     * @param by datetime
     * @return
     */
    public String addTask(String value, LocalDateTime by) {
        Task toAdd = new Deadline(value, by, nextStatus);
        nextStatus = false;
        list.add(toAdd);
        return "Good good! RoTodo is happy to add:\n  " + toAdd
            + "\nNow you have " + list.size() + " tasks in the list.";
    }

    /**
     * Add new Event task to tasklist.
     *
     * @param value description of task
     * @param from datetime
     * @param to datetime
     * @return status to be printed by Ui
     */
    public String addTask(String value, LocalDateTime from, LocalDateTime to) {
        Task toAdd = new Event(value, from, to, nextStatus);
        nextStatus = false;
        list.add(toAdd);
        return " Good good! RoTodo is happy to add:\n  " + toAdd
            + "\n Now you have " + list.size() + " tasks in the list.";
    }

    /**
     * Deletes the i'th task.
     *
     * @param i task index
     * @return status to be printed by Ui
     * @throws InvalidInputException
     */
    public String deleteTask(int i) throws InvalidInputException {
        if (i >= list.size() || i < 0) {
            throw new InvalidInputException("Task number doesn't exist\u001B[0m\n"
                + "type 'list' to view tasklist");
        }
        Task removed = list.remove(i);
        return "Deleting task? That's cheating... but whatever... removed:\n  " + removed
            + "\nNow you have " + list.size() + " tasks in the list.";
    }

    /**
     * Retrieves the saveString format of all task in
     * tasklist.
     *
     * @return saveString format of the TaskList
     * @throws IOException
     */
    public String saveList() throws IOException {
        String output = "";
        for (Task t : list) {
            output += t.saveString() + "\n";
        }
        return output.strip();
    }

    /**
     * String representation of TaskList.
     *
     * @return The list of tasks
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += "" + (i + 1) + "." + list.get(i) + "\n";
        }
        if (output == "") {
            output = "Nothing here. Go find more task to do!";
        }
        return output.stripTrailing();
    }
}
