package lab_1;
import java.io.*;
import java.util.*;

public class TabulatedFunction implements Function{
    private final ArrayList<Double> xVals = new ArrayList<>();
    private final ArrayList<Double> yVals = new ArrayList<>();

    public TabulatedFunction(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        boolean firstLine = true;
        while((line = br.readLine()) != null){

            if (firstLine) { firstLine = false; continue; }

            String[] parts = line.split("\\s+"); // splitting
            xVals.add(Double.parseDouble(parts[0])); // convert a line to num
            yVals.add(Double.parseDouble(parts[1]));
        }
        br.close();
    }

    @Override
    public double val(double x) {

        if (x < xVals.getFirst() || x > xVals.getLast()) {
            throw new IllegalArgumentException(
                    "x=" + x + " out of range [" +
                            xVals.getFirst() + ", " + xVals.getLast() + "]"
            );
        }

        for(int i = 0; i < xVals.size() - 1; i++){
            if(x >= xVals.get(i) && x <= xVals.get(i+1)){

                double x1 = xVals.get(i);
                double x2 = xVals.get(i + 1);
                double y1 = yVals.get(i);
                double y2 = yVals.get(i + 1);

                return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
            }
        }
        return 0;
    }
}
