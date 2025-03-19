import java.util.Scanner;

public class TeoremaMestre {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ord = sc.nextInt();
        System.out.println(teoremaMestre(a,b,ord));

    }

    public static String teoremaMestre(int a, int b, int ord){
        double log = Math.log(a) / Math.log(b);
        String out = "T(n) = theta(n**";

        if(log < ord) {
            return out + ord + ")";

        }

        else if(log == ord){
            return out + ord + " * log n)";

        }

        else{
            return out + log + ")";
            
        }
    }
}
