package src;
import java.util.Random;

public class Main{
    
    public static void main(String[] args){

        Random rng = new Random();
        int[] testarray = new int[40];
        for(int i = 0; i < 40; i++){
            testarray[i] = rng.nextInt(100);
        }
        System.out.println(member(testarray, 3));
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

