package src;
import java.io.IOException;
import java.util.Random;

public class Main{
    
    public static void main(String[] args){
        
        if(args.length != 0){
            
            if(args[0].equals("generate")){
                try {
                    new PairwiseTestCaseGenerator();
                    new RandomTestCaseGenerator();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }else{
                System.err.println("Write generate to generate new test cases");
            }
        }
        
        try {
            new TestRunner();
        } catch (IOException e) {
            System.err.println("IO exception");
            e.printStackTrace();
        }


    
    }

    

}

