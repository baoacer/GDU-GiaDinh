public class App {
  public static void main(String[] args) throws Exception {
    String filePath = "calculation_results.txt";

    System.out.println("================= Add ================");
    UIConsoleOutput output = new UIConsoleOutput(filePath);
    UseCaseControl caseControl = new UseCaseControl(new AddEntity(), output);
    UIConsolseInput input = new UIConsolseInput(caseControl);
    input.input();

    System.out.println("================= Subtract ================");
    UseCaseControl subControl = new UseCaseControl(new SubtractEntity(), output);
    UIConsolseInput subInput = new UIConsolseInput(subControl);
    subInput.input();

    System.out.println("================= Multiply ================");
    UseCaseControl multiplyControl = new UseCaseControl(new MultiplyEntity(), output);
    UIConsolseInput multiplyInput = new UIConsolseInput(multiplyControl);
    multiplyInput.input();

    System.out.println("================= Divide ================");
    UseCaseControl divideControl = new UseCaseControl(new DivideEntity(), output);
    UIConsolseInput divideInput = new UIConsolseInput(divideControl);
    divideInput.input();
}
}
