package SelectionSort;

import java.util.Arrays;
import java.util.Scanner;

public class Ssort {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        int[] val = new int[st.length];
        for(int i = 0; i < st.length; i++){
            val[i] = Integer.parseInt(st[i]);
        }

        selectionSort(val);

    }

    public static void selectionSort(int[] v){
        for(int i = 0; i < v.length-1; i++){
            int menorIndice = i;
            for(int j = i + 1; j < v.length; j++){
                if(v[j] < v[menorIndice])
                    menorIndice = j;
            }
            int aux = v[menorIndice];
            v[menorIndice] = v[i];
            v[i] = aux;
            
            if(menorIndice != i)
                System.out.println(Arrays.toString(v));
            
        }
    }
}
