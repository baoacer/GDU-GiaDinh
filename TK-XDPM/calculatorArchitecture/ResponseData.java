public class ResponseData implements IResponseData {
    private String content;


    public ResponseData(String content) {
        this.content = content; 
    }
    
 
    public ResponseData() {
        
    }

    
    @Override
    public String getContent() {
        return content;
    }

   
    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
