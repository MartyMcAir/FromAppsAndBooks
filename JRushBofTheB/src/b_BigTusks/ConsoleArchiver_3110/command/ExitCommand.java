package b_BigTusks.ConsoleArchiver_3110.command;


import b_BigTusks.ConsoleArchiver_3110.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
