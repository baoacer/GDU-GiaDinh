package commandProcessor;

import commandProcessor.command.AddCommand;
import commandProcessor.command.DivCommand;
import commandProcessor.command.MulCommand;
import commandProcessor.command.SubCommand;
import dtos.IRequestData;
import entity.AddEntity;
import entity.DivEntity;
import entity.MulEntity;
import entity.SubEntity;

public class CommandFactory {
    private final AddEntity addEntity;
    private final SubEntity subEntity;
    private final MulEntity mulEntity;
    private final DivEntity divEntity;

    public CommandFactory(AddEntity addEntity, SubEntity subEntity, MulEntity mulEntity, DivEntity divEntity) {
        this.addEntity = addEntity;
        this.subEntity = subEntity;
        this.mulEntity = mulEntity;
        this.divEntity = divEntity;
    }

    public Command createCommand(String commandType, IRequestData request) {
        switch (commandType) {
            case "+":
                return new AddCommand(request, addEntity);
            case "-":
                return new SubCommand(request, subEntity);
            case "*":
                return new MulCommand(request, mulEntity);
            case "/":
                return new DivCommand(request, divEntity);
            default:
                throw new IllegalArgumentException("Unknown command type: " + commandType);
        }
    }
}
