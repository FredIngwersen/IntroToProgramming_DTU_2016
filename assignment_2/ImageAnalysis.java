package assignment_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class ImageAnalysis {
    private Scanner scanner;
     
    public ImageAnalysis(String filename) throws FileNotFoundException {
        File imagefile = new File(filename);
        scanner = new Scanner(imagefile);
         
    }
     
    public double[][] runFilter(String filterfilename) throws FileNotFoundException {
        int irows = scanner.nextInt();
        int icols = scanner.nextInt();
        double[][] image = generateImage(irows, icols);
         
        File filterfile = new File(filterfilename);
        scanner = new Scanner(filterfile);
        int k = scanner.nextInt();
        double[][] filter = generateFilter(k);
         
        double[][] filteredimg = new double[irows-2*k][icols-2*k];
         
        for (int a = k; a <= irows - k - 1; a++) {
            for (int b = k; b <= icols - k - 1; b++) {
                 
                for (int i = -k; i <= k; i++) {
                    for (int j = -k; j <= k; j++) {
                        filteredimg[a - k][b - k] += filter[i + k][j + k] * image[a + i][b + j];
                    }
                }
            }
        }
        return filteredimg;
    }
     
    private double[][] generateImage(int irows, int icols) {
        double[][] image = new double[irows][icols];
         
        while (scanner.hasNext()) {
            for (int i = 0; i < irows; i++) {
                for (int j = 0; j < icols; j++) {
                    image[i][j] = Double.parseDouble(scanner.next());
                }
            }
        }
        return image;
    }
     
    private double[][] generateFilter(int k) {
        double[][] filter = new double[2*k+1][2*k+1];
         
        while (scanner.hasNext()) {
            for (int i = 0; i < 2*k+1; i++) {
                for (int j = 0; j < 2*k+1; j++) {
                    filter[i][j] = Double.parseDouble(scanner.next());
                }
            }
        }
        return filter;
    }
     
}