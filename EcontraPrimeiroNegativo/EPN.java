package EcontraPrimeiroNegativo;

import java.util.Scanner;

public class EPN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        String primeiro = epn(seq, 0);
        System.out.println(primeiro);
    }

    public static String epn(String[] seq, int index){
        if(index < seq.length){

            if(Integer.parseInt(seq[index]) < 0){
                return seq[index];

            }

            return epn(seq, index+1);
        }
        return "-";
    }
}