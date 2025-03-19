package BFSDireita;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BFSdireita {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");

        BST bst = new BST();
        for(int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.bfsDireita());
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

    public String bfsDireita() {
        Deque<Node> queue = new LinkedList<Node>();
        String out = "";
        queue.addLast(this.root);
        while(!queue.isEmpty()) {
            Node aux = queue.removeFirst();
            out += aux.value + " ";
            if (aux.right != null)
                queue.addLast(aux.right);
            if (aux.left != null)
                queue.addLast(aux.left);
        }
        return out.trim();
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
