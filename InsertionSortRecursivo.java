import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strV = sc.nextLine().split(" ");
        int[] v = new int[strV.length];

        for(int i = 0; i < strV.length; i++){
            v[i] = Integer.parseInt(strV[i]);
        }
        insertionSort(v, 1);
    }

    public static void insertionSort(int[] v, int swap){
        if(swap < v.length){
            int index = swap;
            while(index > 0 && v[index] < v[index-1]){
                int aux = v[index];
                v[index] = v[index-1];
                v[index-1] = aux;
                index--;
            }
            System.out.println(Arrays.toString(v));
            insertionSort(v, swap+1);
        }
    }
}