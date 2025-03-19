package BuscaLinearRecursiva;

import java.util.Scanner;

public class BuscaLinearRecursiva {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int chave = sc.nextInt();
        System.out.println(buscaLinearRecursiva(seq, chave, 0));
    }
    public static int buscaLinearRecursiva(String[] seq, int key, int index){
        if(index < seq.length){
            if(Integer.parseInt(seq[index]) == key)
                return index;
            else
                return buscaLinearRecursiva(seq, key, index + 1);
        }
        return -1;

    }
}