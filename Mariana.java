import java.util.Scanner;

public class Mariana {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] books = sc.nextLine().split(",");

        printf(books);
        bookSort(books, 1);

    }

    public static void bookSort(String[] v, int index){

        while(index < v.length){
            
            if(v[index].compareTo(v[index - 1]) < 0){
                swap(v, index);
            }

            printf(v);
            index++;
        }
    }

    public static void swap(String[] v, int index){

        while(index > 0 && v[index].compareTo(v[index-1]) < 0){
            String aux = v[index];
            v[index] = v[index-1];
            v[index-1] = aux;
            index--;
        }
    }

    public static void printf(String[] v){
        String out = "";

        for(int i = 0; i < v.length-1; i++){
            out += v[i] + ", ";
        }

        out += v[v.length-1];

        System.out.println(out);
    }
}
