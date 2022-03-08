package src;

import java.io.*;
import java.util.*;

public class PairwiseTestCaseGenerator extends TestCaseGenerator{
    
    private ArrayList<int[]> typicalValues = new ArrayList<>();
    
    private int[] defaultValues = new int[arraySize + 1];

    private static final int arraySize = 100;

    // Not including default
    private static final int numberOfTypical = 2;

    public static final File testCaseFile = new File("tests/pairwise_test_cases.txt");

    public PairwiseTestCaseGenerator() throws IOException{
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
            currentTypical[0] = 0;
            currentTypical[1] = -1 *  (rng.nextInt(100) + 1);  
            defaultValues[i] = rng.nextInt(100) + 1;
            typicalValues.add(currentTypical);
        }

        
        int[] keyValues = new int[arraySize+1];

       
        keyValues[arraySize] = -101;

        for(int i = 0; i < arraySize; i++){
            keyValues[i] = defaultValues[i];
        }
        typicalValues.add(keyValues);
        defaultValues[arraySize] = defaultValues[2];

    }
    /**
     * Creates and writes the test cases to file, based on the typical creates 
     */
    private void writePairwiseToFile() throws IOException {

        FileWriter writer = new FileWriter(testCaseFile);

        System.err.println("Writing pairwise to file");;
        // 0-wise testing;
        writer.write(arrayRepresentation(defaultValues));
        writer.write("\n");

        // 1-wise testing
        for(int i = 0; i < arraySize + 1; i++){

            for(int j : typicalValues.get(i)){
                int[] toWrite = Arrays.copyOf(defaultValues, defaultValues.length);
                toWrite[i] = j;
                writer.write(arrayRepresentation(toWrite));
                writer.write("\n");
            }
        }
       
        // 2-wise testing
        for(int i = 0; i < arraySize + 1; i++){ // Go through every input value;

            for(int val : typicalValues.get(i)){ // Go through every typical value for current input i

                for(int j = i + 1; j < arraySize + 1; j++){ // Create pair with all the remaining input valsee
                    
                    for(int val2 : typicalValues.get(j)){
                        int[] toWrite = Arrays.copyOf(defaultValues, defaultValues.length);
                        toWrite[i] = val;
                        toWrite[j] = val2;
                        writer.write(arrayRepresentation(toWrite));
                        writer.write("\n");
                    }
                }
            }
        }


        writer.close();
        





    }

}
