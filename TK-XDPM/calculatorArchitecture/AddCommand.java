public class AddCommand extends Command {
    private IRequestData request;
    private AddEntity addEntity;

    public AddCommand(IRequestData request, AddEntity addEntity) {
        this.request = request; 
        this.addEntity = addEntity;
    }

    @Override
    public void execute() {
        result = addEntity.add(request);
    }
}