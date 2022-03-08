package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestRunner {
    
    File pairwiseTests = PairwiseTestCaseGenerator.testCaseFile;
    File randomTestFile = RandomTestCaseGenerator.testCaseFile;

    public TestRunner() throws IOException{

        System.err.println("Running Pairwise testSuite");
        runTests(pairwiseTests);
        
        System.err.println("Running Random testSuite");
        int failSum = 0;
        for(int i = 0; i < 100; i++){
            new RandomTestCaseGenerator();
            int failed = runTests(randomTestFile);
            if(failed != -1){
                failSum += failed;
            }
            else{
                failSum += 500;
            }
        }
        double average = failSum / 100.0;
        System.err.println("Average til error found: " + average);

        
        
        
        
            
    }

    private int runTests(File f) throws IOException{


        BufferedReader reader = new BufferedReader(new FileReader(f));

        int firstTestToFail = -1;

        String line;
        int testCounter = 0;
        int testsPassed = 0;
        int testsFailed = 0;
        while((line = reader.readLine()) != null){
            String[] linecontents = line.split(",");
            int[] arr = new int[linecontents.length - 1];
            for(int i = 0; i < linecontents.length - 1; i++){
                arr[i] = Integer.parseInt(linecontents[i]);
            }
            int key = Integer.parseInt(linecontents[linecontents.length-1]);

            try{
                Oracle.judgeTest(arr, key);
                
                testsPassed++;

            }catch(AssertionError e){
                if(firstTestToFail == -1){
                    firstTestToFail = testCounter;
                }
                System.err.println("Test number: "+ testCounter+ " Failed");
                testsFailed++;
            }
            
            testCounter++;
        }
        
        System.err.println("In total: "+ testsPassed + " Tests passed");
        System.err.println("In total: "+ testsFailed + " Tests failed");
        
        return firstTestToFail;

    }
}
