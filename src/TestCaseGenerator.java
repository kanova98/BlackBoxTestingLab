package src;

public class TestCaseGenerator {

    // turns an array into string
    public String arrayRepresentation(int[] arr){

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]);
        for(int i = 1; i < arr.length; i++){
            sb.append(',');
            sb.append(arr[i]);
        }
        

        return sb.toString();
        
    }
    
}
