

public class MulCommand extends Command
{
     private IRequestData request;
    private MulEntity mulEntity;

    public MulCommand(IRequestData request, MulEntity mulEntity) {
        this.request = request; 
        this.mulEntity = mulEntity;
    }

    @Override
    public void execute() {
        result = mulEntity.mul(request);
    }
}
