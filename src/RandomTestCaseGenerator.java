package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/*
 * Class to generate random test cases and write them to file
*/
public class RandomTestCaseGenerator extends TestCaseGenerator{

    private static final int numberOfTestCases = 500;

    private static final int arraySize = 100;

    public static final File testCaseFile = new File("tests/random_test_cases.txt");

    public RandomTestCaseGenerator() throws IOException{

        FileWriter writer = new FileWriter(testCaseFile);
        //System.err.println("Writing random test cases to file");
        
        /*
        *  Generate random testCases 
        */
        Random rng = new Random();
        for(int i = 0; i < numberOfTestCases; i++ ){
            int[] arr = new int[arraySize + 1];

            int checkValue;
            for(int j = 0; j < arraySize; j++){
                arr[j] = rng.nextInt(101);
                checkValue =  rng.nextInt(2);
                if(checkValue == 1){
                    arr[j] = arr[j] * -1;
                }
                
            }
            
            
            checkValue = rng.nextInt(2);
            if(checkValue == 1){
                arr[arr.length-1] = 101;
            }
            else{
                arr[arr.length-1] = arr[rng.nextInt(arraySize)];
            }

            

            writer.write(arrayRepresentation(arr));
            writer.write("\n");
            
        }
        writer.close();
    }
}