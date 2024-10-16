package view;

import dtos.ResponseData;

public interface OutputBoundary {
    void present(ResponseData responseData);
    void error(ResponseData responseData);
}
