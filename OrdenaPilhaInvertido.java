import java.util.Scanner;
import java.util.Stack;

public class OrdenaPilhaInvertido {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] vStr = sc.nextLine().split(" ");
        int[] v = new int[vStr.length];
        for(int i = 0; i < vStr.length; i++)
            v[i] = Integer.parseInt(vStr[i]);
        ordenaPilha(size, v);
    }

    public static void ordenaPilha(int size, int[] values){
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < size; i++)
            s.push(values[i]);
        for(int i = 0; i < size ; i++){
            int v = getMax(s, i);
            inverte(s, v, i);
        }
        System.out.println("-");
        while(!s.isEmpty())
            System.out.println(s.pop());
    }

    public static int getMax(Stack<Integer> s, int index){
        Stack<Integer> aux = new Stack<>();
        int max = s.peek();
        while(index < s.size()) {
            if (max < s.peek())
                max = s.peek();
            aux.push(s.pop());
        }
        while(!aux.isEmpty())
            s.push(aux.pop());
        return max;
    }

    public static void inverte(Stack<Integer> s, int max, int index){
        Stack<Integer> aux = new Stack<>();
        int count = 0;
        while(index < s.size()) {
            if (max == s.peek()){
                s.pop();
                count++;
            }else
                aux.push(s.pop());
        }
        while(count > 0){
            s.push(max);
            count--;
        }
        while(!aux.isEmpty())
            s.push(aux.pop());
    }
}
