package assignment_3.Exercise_1;

import java.util.Scanner;

public class FunctionPlotter {

    /**
     * Default Constructor.
     */
    
    FunctionPlotter() {

    }

    /**
     * This methods plots a function.
     * 
     * @param f The function to plot.
     * @param xMin The minimal x-coordinate.
     * @param xMax The maximal x-coordinate.
     * @param ticks THE number of ticks in the plot.
     * 
     */
    public void plotGraph(Function f, double xMin, double xMax, int noOfTicks) {
        
        // do some plausibility checks
        if (xMax <= xMin) {
            System.out.println("Error: xMax <= xMin");
            System.exit(0);
        }
        if (noOfTicks <= 0) {
            System.out.println("Error: number of ticks is <= 0");
            System.exit(0);
        }

        // arrays for the x- and y-values
        double[] xVal = new double[noOfTicks];
        double[] yVal = new double[noOfTicks];  

        // set parameters
        int noOfIncrements = noOfTicks - 1;
        double increment = (xMax - xMin) / noOfIncrements;

        // compute all x- and y-values
        double x = xMin;
        for (int i = 0; i < xVal.length; i++) {
            xVal[i] = x;
            yVal[i] = f.evaluate(x);
            x += increment;
        }
        
        // set the scale
        setScale(xMin,xMax,yVal);
        
        // draw the grah            
        drawGraph(xVal,yVal);
    }
    
    
    /** Sets the scale such that the graphic fits the canvas.
     * 
     * @param xMin The minimal x-coordinate.
     * @param xMax The maximal x-coordinate.
     * @param yVal The array of the y-coordinates.
     */
    private void setScale (double xMin, double xMax, double[] yVal){
        // determine the extrem y-coordinates
        double yMin = Double.POSITIVE_INFINITY;
        double yMax = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < yVal.length; i++) {
            yMin = Math.min(yMin, yVal[i]);
            yMax = Math.max(yMax, yVal[i]);
        }

        // set the scale
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);
    }
    

    /** 
     * Does as the name says.
     * @param xVal The x-coordinates.
     * @param yVal The y-coordinates.
     */
    private void drawGraph(double[] xVal, double[] yVal) {
        StdDraw.clear();
        for (int i = 1; i < xVal.length; i++) {
            StdDraw.line(xVal[i - 1], yVal[i - 1], xVal[i], yVal[i]);
        }       
    }

}
