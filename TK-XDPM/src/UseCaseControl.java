
class UseCaseControl {
  private final MathOperation operation;
  private final UIConsoleOutput output;

  public UseCaseControl(MathOperation operation, UIConsoleOutput output) {
      this.operation = operation;
      this.output = output;
  }

  public void execute(RequestData requestData) {
      double result = operation.operate(requestData.number1, requestData.number2);
      ResponseData responseData = new ResponseData(result);
      output.output(responseData);    
  }
} 