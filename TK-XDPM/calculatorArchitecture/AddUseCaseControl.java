public class AddUseCaseControl implements InputBoundary {
   private CommandFactory commandFactory;
    private OutputBoundary IOutput;
    private IResponseData response;
    private ICommandProcessor processor;
    
    public AddUseCaseControl(CommandFactory commandFactory, OutputBoundary IOutput,
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
