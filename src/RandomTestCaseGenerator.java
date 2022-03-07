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
public class RandomTestCaseGenerator{

    private static final int numberOfTestCases = 100;

    private static final int arraySize = 10;

    File testCaseFile = new File("random_test_cases.txt");

    public RandomTestCaseGenerator() throws IOException{

        FileWriter writer = new FileWriter(testCaseFile);

        int testsWritten = 0;

        /*
        *  Generate random testCases 
        */
        Random rng = new Random();
        for(int i = 0; i < numberOfTestCases; i++ ){
            int[] arr = new int[arraySize];

            IntStream asStream = rng.ints(-1000,1000);
            arr = asStream.toArray();

            writer.write(Arrays.toString(arr));
            writer.write("\n");
            
        }
        writer.close();
    }
}