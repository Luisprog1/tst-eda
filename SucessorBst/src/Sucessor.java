import java.util.ArrayList;
import java.util.Scanner;

public class Sucessor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");
        int sucessor = sc.nextInt();

        BST bst = new BST();
        for(int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.sucessorPath(sucessor).toString());
    }
}
class BST{
    public Node root;
    public int size;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int value){
        Node newNode = new Node(value);
        this.size++;
        if(isEmpty())
            this.root = newNode;
        else {
            Node aux = this.root;
            while (aux != null) {
                if (newNode.value > aux.value) {
                    if (aux.right == null) {
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
                else{
                    if(aux.left == null) {
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
            }
        }
    }
    public ArrayList<Integer> sucessorPath(int value){
        Node aux = search(value);
        ArrayList<Integer> path = new ArrayList<>();
        path.add(aux.value);
        if(aux.right != null){
            aux = aux.right;
            path.add(aux.value);
            while(aux.left != null){
                aux = aux.left;
                path.add(aux.value);
            }
        }
        else{
            Node parent = aux.parent;
            while(parent != null && parent.value < aux.value){
                path.add(parent.value);
                parent = parent.parent;
            }
            if(parent != null)
                path.add(parent.value);
        }
        return path;
    }

    private Node search(int element){
        Node aux = this.root;
        while(aux != null){
            if(element == aux.value) return aux;
            if(element < aux.value) aux = aux.left;
            if(element > aux.value) aux = aux.right;
        }
        return null;
    }
}

class Node{
    Node left;
    Node right;
    Node parent;
    int value;

    Node(int value){
        this.value = value;
    }
}
