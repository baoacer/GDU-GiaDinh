package commandProcessor.command;

import commandProcessor.Command;
import dtos.IRequestData;
import entity.MulEntity;

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
