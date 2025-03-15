import java.util.Arrays;
import java.util.Scanner;

public class InserePrimeiro {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strV = sc.nextLine().split(" ");
        int[] v = new int[strV.length];

        for(int i = 0; i < strV.length; i++){
            v[i] = Integer.parseInt(strV[i]);
        }
        insereUltimo(v);
        System.out.println(Arrays.toString(v));
    }

    public static void insereUltimo(int[] v){
        int index = 0;
        while(index < v.length-1 && v[index] > v[index+1]){
            int aux = v[index];
            v[index] = v[index+1];
            v[index+1] = aux;
            index++;
        }
    }
}