package src;

import java.io.*;
import java.util.*;

public class PairwiseTestCaseGenerator {
    
    private ArrayList<int[]> typicalValues = new ArrayList<>();
    
    private int[] defaultValues = new int[arraySize + 1];

    private static final int arraySize = 10;

    private static final int numberOfTypical = 3;

    File testCaseFile = new File("pairwise_test_cases.txt");

    public PairwiseTestCaseGenerator(){
        createTypicalValues();
        writePairwiseToFile();

    }
    /*
     * Creates typical values for the inputs of all the arrays
    */
    private void createTypicalValues(){
        // Create typical values for the inputs to the array
        Random rng = new Random();
        for(int i = 0; i < arraySize; i++){
            int[] currentTypical = new int[numberOfTypical];
            currentTypical[0] = rng.nextInt(100) + 1;
            currentTypical[0] = 0;
            currentTypical[0] = -1 *  (rng.nextInt(100) + 1);  
            defaultValues[i] = currentTypical[0];
            typicalValues.add(currentTypical);
        }

        int[] keyValues = new int[2];

        keyValues[0] = defaultValues[4];
        keyValues[1] = -101;
        typicalValues.add(keyValues);
        defaultValues[arraySize] = defaultValues[4];

    }

    private void writePairwiseToFile(){

        FileWriter = new FileWriter(file)

    }

}
