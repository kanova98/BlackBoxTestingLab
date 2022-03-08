package src;

import java.util.Arrays;

public class Membership {
    
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
