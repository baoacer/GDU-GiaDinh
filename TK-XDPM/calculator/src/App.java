import commandProcessor.CommandFactory;
import commandProcessor.CommandProcessorImpl;
import commandProcessor.ICommandProcessor;
import dtos.impl.RequestDataImpl;
import dtos.impl.ResponseDataImpl;
import entity.AddEntity;
import entity.DivEntity;
import entity.MulEntity;
import entity.SubEntity;
import usecase.UseCaseControl;
import view.Impl.UIInputImpl;
import view.Impl.UIIOutputImpl;

public class App {
    public static void main(String[] args) throws Exception {
        ResponseDataImpl response = new ResponseDataImpl();
        RequestDataImpl request = new RequestDataImpl();
        AddEntity addEntity = new AddEntity();
        SubEntity subEntity = new SubEntity();
        DivEntity divEntity = new DivEntity();
        MulEntity mulEntity = new MulEntity();
        ICommandProcessor processor = new CommandProcessorImpl();
        CommandFactory commandFactory = new CommandFactory(addEntity, subEntity, mulEntity, divEntity);
        
        UIIOutputImpl consoleOutput = new UIIOutputImpl();

        // Phần control, nơi logic xử lý business và output tách biệt
        UseCaseControl useCaseControl = new UseCaseControl(commandFactory, consoleOutput,
        response, processor);
      
        // Phần UI input (Details)
        UIInputImpl consoleInput = new UIInputImpl(useCaseControl, request);
        consoleOutput.setAddUIConsoleInput(consoleInput);
    }
}
