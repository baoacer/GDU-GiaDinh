package commandProcessor.command;

import commandProcessor.Command;
import dtos.IRequestData;
import entity.DivEntity;

public class DivCommand extends Command
{ 
     private final IRequestData request;
    private final DivEntity divEntity;

    public DivCommand(IRequestData request, DivEntity divEntity) {
        this.request = request; 
        this.divEntity = divEntity;
    }

    @Override
    public void execute() {
        result = divEntity.div(request);
    }
}
