import java.util.Random;

public class Main{
    
    public static void main(String[] args){

        Random rng = new Random();
        int[] test1 = new int[100];
        for(int i = 0; i < test1.length; i++){
            test1[i] = rng.nextInt(10000);
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

    }

}

