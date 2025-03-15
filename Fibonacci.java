import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(0,1,n));
    }

    public static int fibonacci(int f0, int f1, int n){
        int fn = 1;
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1; 
        while(n > 1){
            fn = f1 + f0;
            f0 = f1;
            f1 = fn;
            n -=1;
        }
        return fn;
    }
}