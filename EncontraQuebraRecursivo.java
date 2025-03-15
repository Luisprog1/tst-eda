import java.util.Scanner;

public class EncontraQuebraRecursivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        System.out.println(encontraQuebra(seq, 1));

    }

    public static int encontraQuebra(String[] seq, int index){
        if(index < seq.length){
            if(Integer.parseInt(seq[index-1]) < Integer.parseInt(seq[index])){
                return encontraQuebra(seq, index+1);
            }
            else return index;
        }
        return -1;
    }
}
