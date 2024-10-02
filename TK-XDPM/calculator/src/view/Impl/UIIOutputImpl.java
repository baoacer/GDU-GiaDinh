package view.Impl;

import dtos.IResponseData;
import view.IOutput;

public class UIIOutputImpl implements IOutput {
    private UIInputImpl uiInputImpl;

    public UIIOutputImpl(UIInputImpl uiInputImpl) {
        this.uiInputImpl = uiInputImpl;
    }
    
    public UIIOutputImpl(){}
    
    @Override
    public void present(IResponseData response) {
        String result = response.getContent();
        uiInputImpl.showResult(result);  // Hiển thị kết quả trên giao diện
    }

    @Override
    public void error(IResponseData response) {
        String errorMessage = response.getContent();
        uiInputImpl.showResult("Error: " + errorMessage);  // Hiển thị lỗi trên giao diện
    }
    
    public void setAddUIConsoleInput(UIInputImpl input){
        uiInputImpl = input;
    }
}
