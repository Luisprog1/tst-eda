import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EncaminhamentosBst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");
        BST bst = new BST();
        for (int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.encaminhamento());
    }

}
class BST{
    public Node root;
    private int size;

    public boolean isEmpty(){return this.root == null;}

    public void add(int element){
        this.size += 1;
        if(isEmpty())
            this.root = new Node(element);
        else{
            Node aux = this.root;
            while(aux != null){
                if(element < aux.value){
                    if(aux.left == null){
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if(aux.right == null){
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    public String encaminhamento(){
        ArrayList preorder = preOrder(this.root);
        ArrayList order = order(this.root);
        ArrayList posOrder = posOrder(this.root);
        return preorder.toString() + "\n" + order.toString() + "\n" + posOrder.toString();
    }

    private ArrayList<Integer> preOrder(Node current){
        if(current == null)
            return new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        out.add(current.value);
        out.addAll(preOrder(current.left));
        out.addAll(preOrder(current.right));
        return out;
    }
    private ArrayList<Integer> order(Node current) {
        if(current == null)
            return new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        out.addAll(order(current.left));
        out.add(current.value);
        out.addAll(order(current.right));
        return out;

    }
    private ArrayList<Integer> posOrder(Node current) {
        if(current == null)
            return new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        out.addAll(posOrder(current.left));
        out.addAll(posOrder(current.right));
        out.add(current.value);
        return out;
    }
}

class Node{
    Node left;
    Node right;
    Node parent;
    int value;

    public Node(int value){
        this.value = value;
    }
}
