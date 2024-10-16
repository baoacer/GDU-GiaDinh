package entity;

import dtos.RequestData;

public class AddEntity implements MathOperation{
    @Override
    public Double operator(RequestData requestData) {
        double number1 = Double.parseDouble(requestData.getNumber1());
        double number2 = Double.parseDouble(requestData.getNumber2());
        return number1 + number2;
    }
}
