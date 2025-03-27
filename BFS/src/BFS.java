package BFS.src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] list = sc.nextLine().split(" ");
        BST bst = new BST();
        for(int i = 0; i < list.length; i++)
            bst.add(Integer.parseInt(list[i]));
        System.out.println(bst.Bfs());
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

    public String Bfs(){
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(this.root);
        String out = "";
        while(!queue.isEmpty()){
            Node aux = queue.removeFirst();
            out += aux.value + " ";
            if(aux.left != null)
                queue.addLast(aux.left);
            if(aux.right != null)
                queue.addLast(aux.right);
        }
        return out.trim();
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
