package entity;

import dtos.RequestData;

public class DivEntity implements MathOperation
{
    @Override
    public Double operator(RequestData requestData) {
        double number1 = Double.parseDouble(requestData.getNumber1());
        double number2 = Double.parseDouble(requestData.getNumber2());
        if (number2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return number1 / number2;
    }
}
