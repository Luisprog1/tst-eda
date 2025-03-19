package BuscaBinaria;

import java.util.Scanner;

class BuscaBinaria {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int chave = sc.nextInt();
        System.out.println(buscaBinaria(seq, 0, seq.length-1, chave));
    }
    public static int buscaBinaria(String[] seq, int ini, int fim, int key){
        while(ini <= fim){
            int meio = (ini+fim) / 2;
            if(Integer.parseInt(seq[meio]) == key ){
                return meio;
            }

            else if(Integer.parseInt(seq[meio]) > key){
                System.out.println(meio);
                fim = meio -1;
            }

            else{
                System.out.println(meio);
                ini = meio + 1;
            }
        }

        return -1;
    }
}
