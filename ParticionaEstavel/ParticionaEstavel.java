package ParticionaEstavel;

import java.util.Arrays;
import java.util.Scanner;

public class ParticionaEstavel {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int[] seqInt = new int[seq.length];
        for(int i = 0; i < seq.length; i++){
            seqInt[i] = Integer.parseInt(seq[i]);
        }
        int i = 0;
        for(int j = 1; j < seqInt.length; j++){
            if(seqInt[j] <= seqInt[0]){
                i++;
                troca(seqInt,i,j);
            }
        }
        for(int j = 0; j < i; j++){
            int aux = seqInt[j];
            seqInt[j] = seqInt[j+1];
            seqInt[j+1] = aux;
        }
        System.out.println(Arrays.toString(seqInt));
    }
    public static void troca(int[] v, int i, int j){
        while(i < j){
            int aux = v[j];
            v[j] = v[j-1];
            v[j-1] = aux;
            j--;
        }
    }
}
