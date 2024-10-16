package view.Impl;

import dtos.ResponseData;
import view.OutputBoundary;

public class OutputBoundaryBoundary implements OutputBoundary {
    private InputBoundary inputBoundary;

    public OutputBoundaryBoundary(InputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
    
    public OutputBoundaryBoundary(){}
    
    @Override
    public void present(ResponseData response) {
        String result = response.getContent();
        inputBoundary.showResult(result);  // Hiển thị kết quả trên giao diện
    }

    @Override
    public void error(ResponseData response) {
        String errorMessage = response.getContent();
        inputBoundary.showResult("Error: " + errorMessage);  // Hiển thị lỗi trên giao diện
    }
    
    public void setAddUIConsoleInput(InputBoundary input){
        inputBoundary = input;
    }
}
