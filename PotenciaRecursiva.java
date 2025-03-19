import java.util.Scanner;

public class PotenciaRecursiva {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        System.out.println(potenciaRecursiva(i,j,0));

    }

    public static int potenciaRecursiva(int i, int j, int index){
        if(j > index){
            return i * potenciaRecursiva(i, j, index+1);
        }
        return 1;
    }

}
