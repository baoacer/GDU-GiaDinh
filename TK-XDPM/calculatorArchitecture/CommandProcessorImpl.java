public class CommandProcessorImpl implements ICommandProcessor{
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
