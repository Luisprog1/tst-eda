import java.util.Scanner;
import java.util.Stack;

public class MaxPilhasIndex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] valuesStr = sc.nextLine().split(" ");
        int index = sc.nextInt();
        int[] values = new int [valuesStr.length];
        for(int i = 0; i < values.length; i++)
            values[i] = Integer.parseInt(valuesStr[i]);
        System.out.println(maxPilha(values.length,values,index));
    }
    public static int maxPilha(int size, int[] values, int index){
        Stack<Integer> p = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        for(int i = 0; i < size; i ++)
            p.push(values[i]);
        int max = p.peek();
        for(int i = 0; i <= index; i++) {
            if (max < p.peek())
                max = p.peek();
            aux.push(p.pop());
        }
        while(!aux.isEmpty())
            p.push(aux.pop());
        return max;
    }
}
