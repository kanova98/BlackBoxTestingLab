package src;
import java.util.Arrays;

public class Mergesort{
    
    //@ requires A != null && A.length >= 1
    //@ ensures (\forall int i; 0 <= i < A.length-1; A[i+1] > A[i]) 
    public int[] sort(int[] A){
        if(A.length == 1){
            return A; // An array with one element is by default sorted
        }
        int mid = A.length / 2;
        int[] first = Arrays.copyOfRange(A, 0, mid);
        int[] second = Arrays.copyOfRange(A, mid, A.length);

        return merge(first,second);
    }

    private int[] merge(int[] lower, int[] upper){

        if(lower.length != 1){
            
            int[] lower1 = Arrays.copyOfRange(lower, 0, lower.length / 2);
            int[] lower2 = Arrays.copyOfRange(lower, lower.length / 2, lower.length);
            lower = merge(lower1, lower2);
        }
        if(upper.length != 1){

            int[] upper1 = Arrays.copyOfRange(upper, 0, upper.length / 2);
            int[] upper2 = Arrays.copyOfRange(upper, upper.length / 2, upper.length);
            upper = merge(upper1, upper2);
        }

        int lowptr = 0;
        int highptr = 0;
        int[] toReturn = new int[lower.length + upper.length];


        
        while(lowptr < lower.length && highptr < upper.length){
            if(lower[lowptr] <= upper[highptr]){
                toReturn[lowptr + highptr] = lower[lowptr];
                lowptr++;
            }
            else{
                toReturn[lowptr + highptr] = upper[highptr];
                highptr++;
            }
        }
        if(lowptr < lower.length){
            while(lowptr < lower.length){
                toReturn[lowptr + highptr] = lower[lowptr];
                lowptr++;
            }
        }
        else if(highptr < upper.length){
            while(highptr < upper.length){
                toReturn[lowptr + highptr] = upper[highptr];
                highptr++;
            }
        }
        

        return toReturn;
    }
        

}
