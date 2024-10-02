
public class DivCommand extends Command 
{ 
     private IRequestData request;
    private DivEntity divEntity;

    public DivCommand(IRequestData request, DivEntity divEntity) {
        this.request = request; 
        this.divEntity = divEntity;
    }

    @Override
    public void execute() {
        result = divEntity.div(request);
    }
}
