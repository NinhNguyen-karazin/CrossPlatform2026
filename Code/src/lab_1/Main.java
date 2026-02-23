package lab_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double start = 1.5;
        double end = 6.5;
        double step = 0.05;
        double h = 1e-5;

        // func 1
        Function f1 = new AnalyticalFunction(1);
        ToFileWriter.writeResults(f1, start, end, step, h, "lab1First.txt");

        // func 2
        double[] aValues = {0.5, 1.0, 1.5};

        for (double a : aValues) {
            Function f2 = new AnalyticalFunction(a);
            ToFileWriter.writeResults(f2, start, end, step, h,
                    "lab1Second.txt");
        }

        // func 3
        Function f3 = new TabulatedFunction(
                "lab1TestVals.txt"
        );
        ToFileWriter.writeResults(f3, start, end, step, h, "lab1Third.txt");

        System.out.println("Ura");
    }
}