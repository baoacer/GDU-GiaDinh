public class AddEntity {
    public double add(IRequestData requestData) {
        double number1 = Double.parseDouble(requestData.getNumber1());
        double number2 = Double.parseDouble(requestData.getNumber2()); 
        return number1 + number2;
    }
}
