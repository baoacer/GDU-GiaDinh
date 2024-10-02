public class CommandFactory {
    private AddEntity addEntity;
    private SubEntity subEntity;  
    private MulEntity mulEntity;
    private DivEntity divEntity;

    public CommandFactory(AddEntity addEntity, SubEntity subEntity, MulEntity mulEntity, DivEntity divEntity) {
        this.addEntity = addEntity;
        this.subEntity = subEntity;
        this.mulEntity = mulEntity;
        this.divEntity = divEntity;
    }

    public Command createCommand(String commandType, IRequestData request) {
        switch (commandType) {
            case "+":
                return new AddCommand(request, addEntity);
            case "-":
                return new SubCommand(request, subEntity);
            case "*":
                return new MulCommand(request, mulEntity);
            case "/":
                return new DivCommand(request, divEntity);
            default:
                throw new IllegalArgumentException("Unknown command type: " + commandType);
        }
    }
}
