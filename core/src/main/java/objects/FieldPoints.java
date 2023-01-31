package objects;

import java.util.ArrayList;
import java.util.Arrays;

public class FieldPoints {
    private FieldPoints() { throw new IllegalStateException(); }
    public static ArrayList<ArrayList<Double>> pawnPoints()
    {
        ArrayList<Double> y1 = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0, 0.0,0.0,0.0,0.0));
        ArrayList<Double> y2 = new ArrayList<>(Arrays.asList(5.0,5.0,5.0,5.0, 5.0,5.0,5.0,5.0));
        ArrayList<Double> y3 = new ArrayList<>(Arrays.asList(1.0,1.0,2.0,3.0, 3.0,2.0,1.0,1.0));
        ArrayList<Double> y4 = new ArrayList<>(Arrays.asList(0.5,0.5,1.0,2.5, 2.5,1.0,0.5,0.5));
        ArrayList<Double> y5 = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,2.0, 2.0,0.0,0.0,0.0));
        ArrayList<Double> y6 = new ArrayList<>(Arrays.asList(0.5,-0.5,-1.0,0.0, 0.0,-1.0,-0.5,0.5));
        ArrayList<Double> y7 = new ArrayList<>(Arrays.asList(0.5,1.0,1.0,-2.0, -2.0,1.0,1.0,0.5));
        ArrayList<Double> y8 = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0, 0.0,0.0,0.0,0.0));
        ArrayList<ArrayList<Double>> fieldPoints = new ArrayList<>();
        fieldPoints.add(y1); fieldPoints.add(y2); fieldPoints.add(y3); fieldPoints.add(y4);
        fieldPoints.add(y5); fieldPoints.add(y6); fieldPoints.add(y7); fieldPoints.add(y8);
        return fieldPoints;
    }
    public static ArrayList<ArrayList<Double>> bishopPoints()
    {
        ArrayList<Double> y1 = new ArrayList<>(Arrays.asList(-2.0,-1.0,-1.0,-1.0, -1.0,-1.0,-1.0,-2.0));
        ArrayList<Double> y2 = new ArrayList<>(Arrays.asList(-1.0,0.0,0.0,0.0, 0.0,0.0,0.0,-1.0));
        ArrayList<Double> y3 = new ArrayList<>(Arrays.asList(-1.0,0.0,0.5,1.0, 1.0,0.5,1.0,-1.0));
        ArrayList<Double> y4 = new ArrayList<>(Arrays.asList(-1.0,0.5,0.5,1.0, 1.0,0.5,0.5,-1.0));
        ArrayList<Double> y5 = new ArrayList<>(Arrays.asList(-1.0,0.0,1.0,1.0, 1.0,1.0,0.0,-1.0));
        ArrayList<Double> y6 = new ArrayList<>(Arrays.asList(-1.0,1.0,1.0,1.0, 1.0,1.0,1.0,-1.0));
        ArrayList<Double> y7 = new ArrayList<>(Arrays.asList(-1.0,0.5,0.0,0.0, 0.0,0.0,0.5,-1.0));
        ArrayList<Double> y8 = new ArrayList<>(Arrays.asList(-2.0,-1.0,-1.0,-1.0, -1.0,-1.0,-1.0,-2.0));
        ArrayList<ArrayList<Double>> fieldPoints = new ArrayList<>();
        fieldPoints.add(y1); fieldPoints.add(y2); fieldPoints.add(y3); fieldPoints.add(y4);
        fieldPoints.add(y5); fieldPoints.add(y6); fieldPoints.add(y7); fieldPoints.add(y8);
        return fieldPoints;
    }
    public static ArrayList<ArrayList<Double>> kingPoints()
    {
        ArrayList<Double> y1 = new ArrayList<>(Arrays.asList(-3.0,-4.0,-4.0,-5.0, -5.0,-4.0,-4.0,-3.0));
        ArrayList<Double> y2 = new ArrayList<>(Arrays.asList(-3.0,-4.0,-4.0,-5.0, -5.0,-4.0,-4.0,-3.0));
        ArrayList<Double> y3 = new ArrayList<>(Arrays.asList(-3.0,-4.0,-4.0,-5.0, -5.0,-4.0,-4.0,-3.0));
        ArrayList<Double> y4 = new ArrayList<>(Arrays.asList(-3.0,-4.0,-4.0,-5.0, -5.0,-4.0,-4.0,-3.0));
        ArrayList<Double> y5 = new ArrayList<>(Arrays.asList(-2.0,-3.0,-3.0,-4.0, -4.0,-3.0,-3.0,-2.0));
        ArrayList<Double> y6 = new ArrayList<>(Arrays.asList(-1.0,-2.0,-2.0,-2.0, -2.0,-2.0,-2.0,-1.0));
        ArrayList<Double> y7 = new ArrayList<>(Arrays.asList(2.0,2.0,0.0,0.0, 0.0,0.0,2.0,2.0));
        ArrayList<Double> y8 = new ArrayList<>(Arrays.asList(2.0,3.0,1.0,0.0, 0.0,1.0,3.0,2.0));
        ArrayList<ArrayList<Double>> fieldPoints = new ArrayList<>();
        fieldPoints.add(y1); fieldPoints.add(y2); fieldPoints.add(y3); fieldPoints.add(y4);
        fieldPoints.add(y5); fieldPoints.add(y6); fieldPoints.add(y7); fieldPoints.add(y8);
        return fieldPoints;
    }
    public static ArrayList<ArrayList<Double>> queenPoints()
    {
        ArrayList<Double> y1 = new ArrayList<>(Arrays.asList(-2.0,-1.0,-1.0,-0.5, -0.5,-1.0,-1.0,-2.0));
        ArrayList<Double> y2 = new ArrayList<>(Arrays.asList(-1.0,0.0,0.0,0.0, 0.0,0.0,0.0,-1.0));
        ArrayList<Double> y3 = new ArrayList<>(Arrays.asList(-1.0,0.0,0.5,0.5, 0.5,0.5,0.0,-1.0));
        ArrayList<Double> y4 = new ArrayList<>(Arrays.asList(-0.5,0.0,0.5,0.5, 0.5,0.5,0.0,-0.5));
        ArrayList<Double> y5 = new ArrayList<>(Arrays.asList(0.0,0.0,0.5,0.5, 0.5,0.5,0.0,-0.5));
        ArrayList<Double> y6 = new ArrayList<>(Arrays.asList(-1.0,0.5,0.5,0.5, 0.5,0.5,0.0,-1.0));
        ArrayList<Double> y7 = new ArrayList<>(Arrays.asList(-1.0,0.0,0.5,0.0, 0.0,0.0,0.0,-1.0));
        ArrayList<Double> y8 = new ArrayList<>(Arrays.asList(-2.0,-1.0,-1.0,-0.5, -0.5,-1.0,-1.0,-2.0));
        ArrayList<ArrayList<Double>> fieldPoints = new ArrayList<>();
        fieldPoints.add(y1); fieldPoints.add(y2); fieldPoints.add(y3); fieldPoints.add(y4);
        fieldPoints.add(y5); fieldPoints.add(y6); fieldPoints.add(y7); fieldPoints.add(y8);
        return fieldPoints;
    }
    public static ArrayList<ArrayList<Double>> rookPoints()
    {
        ArrayList<Double> y1 = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0, 0.0,0.0,0.0,0.0));
        ArrayList<Double> y2 = new ArrayList<>(Arrays.asList(0.5,1.0,1.0,1.0, 1.0,1.0,1.0,0.5));
        ArrayList<Double> y3 = new ArrayList<>(Arrays.asList(-0.5,0.0,0.0,0.0, 0.0,0.0,0.0,-0.5));
        ArrayList<Double> y4 = new ArrayList<>(Arrays.asList(-0.5,0.0,0.0,0.0, 0.0,0.0,0.0,-0.5));
        ArrayList<Double> y5 = new ArrayList<>(Arrays.asList(-0.5,0.0,0.0,0.0, 0.0,0.0,0.0,-0.5));
        ArrayList<Double> y6 = new ArrayList<>(Arrays.asList(0.5,-0.5,-1.0,0.0, 0.0,-1.0,-0.5,0.5));
        ArrayList<Double> y7 = new ArrayList<>(Arrays.asList(-0.5,0.0,0.0,0.0, 0.0,0.0,0.0,-0.5));
        ArrayList<Double> y8 = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.5, 0.5,0.0,0.0,0.0));
        ArrayList<ArrayList<Double>> fieldPoints = new ArrayList<>();
        fieldPoints.add(y1); fieldPoints.add(y2); fieldPoints.add(y3); fieldPoints.add(y4);
        fieldPoints.add(y5); fieldPoints.add(y6); fieldPoints.add(y7); fieldPoints.add(y8);
        return fieldPoints;
    }
    public static ArrayList<ArrayList<Double>> knightPoints()
    {
        ArrayList<Double> y1 = new ArrayList<>(Arrays.asList(-5.0,-4.0,-3.0,-3.0, -3.0,-3.0,-4.0,-5.0));
        ArrayList<Double> y2 = new ArrayList<>(Arrays.asList(-4.0,-2.0,0.0,0.0, 0.0,0.0,-2.0,-4.0));
        ArrayList<Double> y3 = new ArrayList<>(Arrays.asList(-3.0,0.0,1.0,1.5, 1.5,1.0,0.0,-3.0));
        ArrayList<Double> y4 = new ArrayList<>(Arrays.asList(-3.0,0.5,1.5,2.0, 2.0,1.5,0.5,-3.0));
        ArrayList<Double> y5 = new ArrayList<>(Arrays.asList(-3.0,0.0,1.5,2.0, 2.0,1.5,0.0,-3.0));
        ArrayList<Double> y6 = new ArrayList<>(Arrays.asList(-3.0,0.5,4.0,4.5, 4.5,4.0,0.5,-3.0));
        ArrayList<Double> y7 = new ArrayList<>(Arrays.asList(-4.0,-2.0,0.0,0.5, 0.5,0.0,-2.0,-4.0));
        ArrayList<Double> y8 = new ArrayList<>(Arrays.asList(-5.0,-4.0,-3.0,-3.0, -3.0,-3.0,-4.0,-5.0));
        ArrayList<ArrayList<Double>> fieldPoints = new ArrayList<>();
        fieldPoints.add(y1); fieldPoints.add(y2); fieldPoints.add(y3); fieldPoints.add(y4);
        fieldPoints.add(y5); fieldPoints.add(y6); fieldPoints.add(y7); fieldPoints.add(y8);
        return fieldPoints;
    }
}
