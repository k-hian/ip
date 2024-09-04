package rotodo.commands;

import rotodo.processes.Storage;
import rotodo.processes.Ui;
import rotodo.tasklist.TaskList;

/**
 * The FindCommand class encapsulates the specific
 * type of Command that executes a find action.
 *
 * @author Ng Kay Hian
 * @version CS2103T AY24/25 Semester 1
 */
public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tl, Ui ui, Storage st) {
        ui.addMessage(tl.findString(keyword));
    }
}
