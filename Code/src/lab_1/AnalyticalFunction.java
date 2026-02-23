package lab_1;

public class AnalyticalFunction implements Function{

    private final double a;

    public AnalyticalFunction(double a){
        this.a = a;
    }

    @Override
    public double val(double x) {
        return Math.exp(-a * x * x) * Math.sin(x);
    }
}