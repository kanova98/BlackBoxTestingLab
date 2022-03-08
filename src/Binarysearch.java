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
            //x = l + r / 2; // MUTATION 2
            
            if( key < A[x]){
                r = x;
            }
            else{
                
                l = x + 1;
            }

        }while(key != A[x] && l < r); 
        // while(key >= A[x] && l < r) MUTATION 3

        if(key == A[x]){
            return x;
            //return key; // MUTATION 1
        }
        else{
            return -1;
        }
    }
}
