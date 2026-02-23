package lab_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ToFileWriter {
    public static void writeResults(Function f,
                                    double start,
                                    double end,
                                    double step,
                                    double h,
                                    String filename) throws IOException{
        PrintWriter w = new PrintWriter((new FileWriter(filename)));

        for(double x = start; x <= end; x += step){
            double fx = f.val(x);

            try {
                double dfx = Differentiator.derivative(f, x, h);
                w.println(x + " " + fx + " " + dfx);
            } catch (IllegalArgumentException e) {
                // skip if out of range
                w.println(x + " " + fx + " " + "N/A");
            }
        }
        w.close();
    }
}
