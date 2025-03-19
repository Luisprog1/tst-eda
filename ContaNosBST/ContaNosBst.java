package a;

import java.util.Scanner;


public class ContaNosBst {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");

        BST bst = new BST();
        for(int i = 0; i < strTree.length; i++)
            bst.add(Integer.parseInt(strTree[i]));
        System.out.println(bst.countInternalNodes());
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

    public int countInternalNodes(){
        return reCount(this.root);
    }

    public int reCount(Node node){
        if(node == null || isLeaf(node)) return 0;
        else if(!isLeaf(node)) return reCount(node.left) + reCount(node.right) + 1;
        return 0;
    }

    public boolean isLeaf(Node current){
        if(current.left == null && current.right == null)
            return true;
        return false;
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
