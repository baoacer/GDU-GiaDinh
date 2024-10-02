public class Main {
    public static void main(String[] args) {
        // Phần business logic
        ResponseData response = new ResponseData();
        RequestData request = new RequestData();
        AddEntity addEntity = new AddEntity();
        SubEntity subEntity = new SubEntity();
        DivEntity divEntity = new DivEntity();
        MulEntity mulEntity = new MulEntity();
        ICommandProcessor processor = new CommandProcessorImpl();
        CommandFactory commandFactory = new CommandFactory(addEntity, subEntity, mulEntity, divEntity);
        
        AddUIConsoleOutput consoleOutput = new AddUIConsoleOutput();

        // Phần control, nơi logic xử lý business và output tách biệt
        AddUseCaseControl useCaseControl = new AddUseCaseControl(commandFactory, consoleOutput,
        response, processor);
      
        // Phần UI input (Details)
        AddUIConsoleInput consoleInput = new AddUIConsoleInput(useCaseControl, request);
        consoleOutput.setAddUIConsoleInput(consoleInput);
        
          
    }
}
