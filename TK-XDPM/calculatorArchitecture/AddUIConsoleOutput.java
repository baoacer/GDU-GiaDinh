public class AddUIConsoleOutput implements OutputBoundary {
    private AddUIConsoleInput uiInput;

    public AddUIConsoleOutput(AddUIConsoleInput uiInput) {
        this.uiInput = uiInput;
    }
    
    public AddUIConsoleOutput(){}
    
    @Override
    public void present(IResponseData response) {
        String result = response.getContent();
        uiInput.showResult(result);  // Hiển thị kết quả trên giao diện
    }

    @Override
    public void error(IResponseData response) {
        String errorMessage = response.getContent();
        uiInput.showResult("Error: " + errorMessage);  // Hiển thị lỗi trên giao diện
    }
    
    public void setAddUIConsoleInput(AddUIConsoleInput input){
        uiInput = input;
    }
}
