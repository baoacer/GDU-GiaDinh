public class RequestData implements IRequestData{
    private String number1;
    private String number2;
    private String operation;
    
    @Override
    public void setNumber1(String number1) {
        this.number1 = number1; 
    }
    
    @Override
    public void setNumber2(String number2) {
        this.number2 = number2;
    }
    
    @Override
    public String getNumber1(){
        return number1;
    }
    
    @Override
    public String getNumber2(){
        return number2;
    }
    
    @Override
    public String getOperation(){
        return this.operation;
    }
    
    @Override
    public void setOperation(String operation){
        this.operation = operation;
    }
}