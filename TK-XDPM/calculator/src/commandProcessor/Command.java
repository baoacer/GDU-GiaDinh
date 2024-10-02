package commandProcessor;

public abstract class Command
{
    protected double result;
    
    public abstract void execute();
    
    public double getResult(){
        return this.result;
    }
}
