package ContingPassoPasso;

import java.util.Scanner;

public class CountingPassoPasso {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int k = sc.nextInt();
        int[] seqInt = new int[seq.length];
        for(int i = 0; i < seq.length; i++){
            seqInt[i] = Integer.parseInt(seq[i]);
        }
        System.out.println(countingSort(seqInt, k));
    }
    public static String countingSort(int[] v, int k){
        int[] c = new int[k+1];
        for(int i = 0; i < v.length; i++){
            c[v[i]]++;
            System.out.println(fazString(c));
        }
        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + fazString(c));
        int[] b = new int[v.length];
        for(int i = 0; i < v.length; i++){
            b[c[v[i]]-1] = v[i];
            c[v[i]]--;
        }
        System.out.println(fazString(c));
        return fazString(b);
    }

    public static String fazString(int v[]){
        String s = "";
        for(int i = 0; i < v.length-1; i++){
            s += v[i] + " ";
        }
        s += v[v.length-1];
        return s;
    }
}
