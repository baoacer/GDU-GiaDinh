import java.io.BufferedReader;
import java.io.InputStreamReader;

class UIConsolseInput {
    private final UseCaseControl caseControl;
    private final BufferedReader stdIn;
  
    public UIConsolseInput(UseCaseControl caseControl) {
        this.caseControl = caseControl;
        this.stdIn = new BufferedReader(new InputStreamReader(System.in));
    }
  
    public void input() throws Exception {
        System.out.print("Enter first number: ");
        double number1 = Integer.parseInt(stdIn.readLine());
        System.out.print("Enter second number: ");
        double number2 = Integer.parseInt(stdIn.readLine());
        RequestData requestData = new RequestData(number1, number2);
        caseControl.execute(requestData);
    }
  }
