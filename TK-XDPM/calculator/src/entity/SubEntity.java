package entity;

import dtos.IRequestData;

public class SubEntity
{
   public double sub(IRequestData requestData) {
        double number1 = Double.parseDouble(requestData.getNumber1());
        double number2 = Double.parseDouble(requestData.getNumber2());
        return number1 - number2;
    }
}
