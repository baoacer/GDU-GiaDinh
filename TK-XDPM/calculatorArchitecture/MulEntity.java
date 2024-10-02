
/**
 * Write a description of class MulEntity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MulEntity
{
   public double mul(IRequestData requestData) {
        double number1 = Double.parseDouble(requestData.getNumber1());
        double number2 = Double.parseDouble(requestData.getNumber2());
        return number1 * number2;
    }
}
