
public abstract class Command
{
    protected double result;
    
    abstract void execute(); 
    
    public double getResult(){
        return this.result;
    }
}
