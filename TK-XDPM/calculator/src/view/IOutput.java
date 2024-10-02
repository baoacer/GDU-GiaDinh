package view;

import dtos.IResponseData;

public interface IOutput {
    void present(IResponseData responseData);
    void error(IResponseData responseData);
}
