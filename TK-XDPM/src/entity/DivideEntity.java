class DivideEntity implements MathOperation {
    @Override
    public double operate(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return number1 / number2;
    }
}