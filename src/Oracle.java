package src;

import java.util.Arrays;

public class Oracle {
    
    public static void judgeTest(int[] arr, int key) throws AssertionError{
        Boolean inArray = false;
        for(int val : arr){
            if(val == key){
                inArray = true;
                break;
            }
        }

        Boolean memberTest;
        memberTest = Membership.member(arr, key);

        if(inArray.equals(memberTest)){
            
        }
        else{
            
            throw new AssertionError("Test failed");
        }

        

    }
}
