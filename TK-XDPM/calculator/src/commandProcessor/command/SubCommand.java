package commandProcessor.command;

import commandProcessor.Command;
import dtos.IRequestData;
import entity.SubEntity;

public class SubCommand extends Command
{
    private final IRequestData request;
    private final SubEntity subEntity;

    public SubCommand(IRequestData request, SubEntity subEntity) {
        this.request = request; 
        this.subEntity = subEntity;
    }

    @Override
    public void execute() {
        result = subEntity.sub(request);
    }
}
