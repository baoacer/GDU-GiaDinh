package dtos.impl;

import dtos.IResponseData;

public class ResponseDataImpl implements IResponseData {
    private String content;


    public ResponseDataImpl(String content) {
        this.content = content; 
    }
    
 
    public ResponseDataImpl() {
        
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
