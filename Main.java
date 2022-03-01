import java.util.Random;

public class Main{
    
    public static void main(String[] args){

        Random rng = new Random();
        int[] test1 = new int[100];

        for(int i = 0; i < test1.length; i++){
            test1[i] = rng.nextInt(100);
        }
        
        System.out.println("Unsorted:");
        for (int i : test1) {
            System.out.print(i);
            System.out.print(" ");
        }

        Mergesort test = new Mergesort();
        test1 = test.sort(test1);

        System.out.println("Sorted:");
        for (int i : test1) {
            System.out.print(i);
            System.out.print(" ");
        }

        Binarysearch sorter = new Binarysearch();

        int[] test2 = new int[3];
        test2[0] = 1;
        test2[1] = 3;
        test2[2] = 5;
        int foundindex = sorter.search(test2, 3);
        
        if(foundindex != -1){
            System.out.println("Found");
        }
        else{
            System.out.println("Did not find");
        }

    }

}

