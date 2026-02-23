package lab_1;

public class Differentiator {
    public static double derivative(Function f, double x, double h){
        return (f.val(x + h) - f.val(x - h)) / (2 * h);
    }
}
