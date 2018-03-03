total : scores: 10 / 10

public class Calculator {
    public double Add(double i, double j){
        return i + j;
    }
    public double Sub(double i, double j){
        return i - j;
    }
    public double Mul(double i, double j){
        return i * j;
    }
    public double Div(double i, double j){
        return i / j;
    }
    public double SquareRoot(double i){
        return Math.sqrt(i);
    }
    public double Square(double i){
        return i * i;
    }
    public double Cube(double i){
        return i * i * i;
    }
    public double Fahrenheit2Celsius(double i){
        i = (i - 32) / 1.8f;
        return i;
    }
    public double Feet2Inches(double i){
        return i*12;
    }
}
