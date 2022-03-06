package src;
import java.io.IOException;
import java.util.Random;

public class Main{
    
    public static void main(String[] args){
        
        try {
            RandomTestCaseGenerator gen = new RandomTestCaseGenerator();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public static boolean member(int[] A, int key){
        Mergesort sorter = new Mergesort();
        A = sorter.sort(A);
        Binarysearch searcher = new Binarysearch();
        int index = searcher.search(A, key);

        if(index == -1){
            return false;
        }
        else{
            return true;
        }
    }

}

