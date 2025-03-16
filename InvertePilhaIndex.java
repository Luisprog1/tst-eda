import java.util.Scanner;

public class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] values = sc.nextLine().split(" ");
        int index = sc.nextInt();
        invertePilha(size, values, index);
    }

    public static void invertePilha(int size, String[] values, int index){
        Pilha p = new Pilha(size);
        for (int i = 0; i < size; i++){
            p.push(values[i]);
        }
        String[] v = new String[size];
        for(int i = 0; i <= index; i++)
            v[i] = p.pop();
        for(int i = 0; i <= index; i++)
            p.push(v[i]);
        System.out.println("-");
        for(int i = 0; i < size; i++)
            System.out.println(p.pop());
    }
}

class Pilha {
    public int size;
    public int top;
    public String[] stack;

    Pilha(int size) {
        this.size = size;
        this.top = -1;
        this.stack = new String[size];
    }
    public boolean isFull() {
        return this.top == this.stack.length - 1;
    }
    public boolean isEmpty() {
        return this.top == -1;
    }
    public void push(String v) {
        if(isFull())
            throw new RuntimeException("Pilha cheia");
        this.stack[++top] = v;
    }
    public String pop() {
        if (isEmpty())
            throw new RuntimeException("Pilha vazia");
        return this.stack[top--];
    }
}