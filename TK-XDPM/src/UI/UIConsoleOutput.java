import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class UIConsoleOutput {
    private final PrintWriter stdOut;
    private final String filePath;
  
    public UIConsoleOutput(String filePath) {
        this.stdOut = new PrintWriter(System.out, true);
        this.filePath = filePath;
    }
  
    public void output(ResponseData responseData) {
        stdOut.println("Result: " + responseData.result);
        writeToFile(responseData.result);
    }
  
    private void writeToFile(double result) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("Calculated result: " + result + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
  }
