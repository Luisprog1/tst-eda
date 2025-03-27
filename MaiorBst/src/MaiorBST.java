import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaiorBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tree = sc.nextLine().split(" ");
        int value = sc.nextInt();
        BST bst = new BST();
        for(int i = 0; i < tree.length; i++)
            bst.add(Integer.parseInt(tree[i]));
        System.out.println(bst.preOrder());
        System.out.println(bst.maiores(value));
    }
}

class BST {
    public Node root;
    public int size;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (isEmpty())
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
                } else {
                    if (aux.left == null) {
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
            }
        }
    }

    public ArrayList<Integer> preOrder(){
        return recursivePreOrder(this.root);
    }

    private ArrayList<Integer> recursivePreOrder(Node current){
        if(current == null)
            return new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        out.add(current.value);
        out.addAll(recursivePreOrder(current.left));
        out.addAll(recursivePreOrder(current.right));
        return out;
    }
    public int maiores(int value){
        return contaNos(this.root, value);
    }

    public int contaNos(Node current, int value){
        if(current == null) return 0;
        if(current.value > value)
            return contaNos(current.left, value) + contaNos(current.right, value) + 1;
        return contaNos(current.left, value) + contaNos(current.right, value);
    }

    public Node search(int element) {
        Node aux = this.root;
        while(aux != null){
            if(aux.value == element) return aux;
            if(element < aux.value)
                aux = aux.left;
            if(element > aux.value)
                aux = aux.right;
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
