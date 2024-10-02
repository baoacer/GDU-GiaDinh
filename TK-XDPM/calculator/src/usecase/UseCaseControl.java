package usecase;

import commandProcessor.Command;
import commandProcessor.CommandFactory;
import commandProcessor.ICommandProcessor;
import dtos.IRequestData;
import dtos.IResponseData;
import view.IInput;
import view.IOutput;

public class UseCaseControl implements IInput {
    private CommandFactory commandFactory;
    private IOutput IOutput;
    private IResponseData response;
    private ICommandProcessor processor;
    
    public UseCaseControl(CommandFactory commandFactory, IOutput IOutput,
                          IResponseData response, ICommandProcessor processor) {
        this.commandFactory = commandFactory;
        this.IOutput = IOutput;
        this.response = response;
        this.processor = processor;
    }
    
    @Override
    public void execute(IRequestData request) {
        String strNumber1 = request.getNumber1();
        String strNumber2 = request.getNumber2();
        String commandType = request.getOperation();

        if(isThamDinh(strNumber1) && isThamDinh(strNumber2)){
            try {
                Command command = commandFactory.createCommand(commandType, request);
                processor.executeCommand(command);
                double result = command.getResult();
                response.setContent(Double.toString(result));
                IOutput.present(response);
            } catch (IllegalArgumentException e) {
                response.setContent("ERROR_UNKNOWN_COMMAND");
                IOutput.error(response);
            }
        } else {
            response.setContent("ERROR_INPUT");
            IOutput.error(response);
        }
    }
    
    private boolean isThamDinh(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
