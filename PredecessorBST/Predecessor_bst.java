package PredecessorBST;

import java.util.ArrayList;
import java.util.Scanner;

public class Predecessor_bst {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");
        int predecessor = sc.nextInt();

        BST bst = new BST();
        for(int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.predecessorPath(predecessor).toString());
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

    public ArrayList<Integer> predecessorPath(int element){
        ArrayList<Integer> path = new ArrayList<>();
        Node node = search(element);
        path.add(node.value);
        if(node.left != null){
            node = node.left;
            path.add(node.value);
            while(node.right != null){
                node = node.right;
                path.add(node.value);
            }
        } else {
            Node parent = node.parent;
            while (parent != null && parent.value > node.value) {
                path.add(parent.value);
                parent = parent.parent;
            }
            if (parent != null)
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

    public Node(int value){
        this.value = value;
    }
}

