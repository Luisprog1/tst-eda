package MoveImpostor;

import java.util.Arrays;
import java.util.Scanner;

public class MoveImpostor {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] list = sc.nextLine().split(" ");
        int[] in = new int[list.length];
        for(int i = 0; i < list.length; i++){
            in[i] = Integer.parseInt(list[i]);
        }
        System.out.println(Arrays.toString(moveImpostor(in)));
    }
    public static int[] moveImpostor(int[] in) {

        int index = 0;
        for(int i = 0; i < in.length-1; i++)
            if(in[i] > in[i+1]){
                index = i+1;
                break;
            }
        while(index > 0 && in[index] < in[index-1]) {
            int aux = in[index];
            in[index] = in[index-1];
            in[index-1] = aux;
            index -= 1;

        }
        return in;
    }
}
