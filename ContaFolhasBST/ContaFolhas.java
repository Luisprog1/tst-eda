package ContaFolhasBST;

import java.util.Scanner;

public class ContaFolhas {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] strTree = sc.nextLine().split(" ");
        BST bst = new BST();
        for(int i = 0; i < strTree.length; i++){
            bst.add(Integer.parseInt(strTree[i]));
        }
        System.out.println(bst.CountLeaf());

    }
}

class BST{
    Node root;

    public void add(int value){
        if(this.root == null)
            this.root = new Node(value);
        else{
            Node aux = this.root;
            while(aux != null){
                if(value < aux.value){
                    if(aux.left == null){
                        Node newNode = new Node(value);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }else if(value > aux.value){
                    if(aux.right == null){
                        Node newNode = new Node(value);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public boolean isLeaf(Node node){
        return (node.left == null && node.right == null);
    }

    public int CountLeaf(){
        return reCount(this.root);
    }

    private int reCount(Node current){
        if(current == null)
            return 0;
        else if(!isLeaf(current))
            return reCount(current.left) + reCount(current.right);
        return current.value;
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
