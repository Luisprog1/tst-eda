import java.util.Arrays;
import java.util.Scanner;

public class SsortRecursivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");

        int[] val = new int[st.length];
        for(int i = 0; i < st.length; i++){
            val[i] = Integer.parseInt(st[i]);
        }

        selectionSortRecursivo(val, 0);

    }

    public static void selectionSortRecursivo(int[] v, int index){
        int menorIndex = index;
        for(int i = index+1; i < v.length; i++){
            if(v[i] < v[menorIndex])
                menorIndex = i;
        }

        int aux = v[menorIndex];
        v[menorIndex] = v[index];
        v[index] = aux;


        if(index+1 < v.length){    
            System.out.println(Arrays.toString(v));
            selectionSortRecursivo(v, index + 1);
        }
    }
}
