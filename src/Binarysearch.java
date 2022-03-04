package src;
public class Binarysearch {
    
    /*
    */
    public int search(int[] A, int key){
        
        int l = 0;
        int r = A.length;
        int x;
        do{
            
            x = (l + r) / 2;
            
            if( key < A[x]){
                r = x;
            }
            else{
                l = x + 1;
            }

        }while(key != A[x] && l < r);

        if(key == A[x]){
            return x;
        }
        else{
            return -1;
        }
    }
}
