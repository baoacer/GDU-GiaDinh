
public interface OutputBoundary {
    void present(IResponseData responseData);
    void error(IResponseData responseData);
}
