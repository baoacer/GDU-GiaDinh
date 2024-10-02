package commandProcessor.command;

import commandProcessor.Command;
import dtos.IRequestData;
import entity.AddEntity;

public class AddCommand extends Command {
    private final IRequestData request;
    private final AddEntity addEntity;

    public AddCommand(IRequestData request, AddEntity addEntity) {
        this.request = request; 
        this.addEntity = addEntity;
    }

    @Override
    public void execute() {
        result = addEntity.add(request);
    }
}