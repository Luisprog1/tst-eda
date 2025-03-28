import java.util.ArrayList;
import java.util.Scanner;

public class RemoveBst {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tree = sc.nextLine().split(" ");
        String[] toRemove = sc.nextLine().split(" ");
        BST bst = new BST();
        for(int i = 0; i < tree.length; i++)
            bst.add(Integer.parseInt(tree[i]));
        for(int i = 0; i < toRemove.length; i++) {
            Node rem = bst.search(Integer.parseInt(toRemove[i]));
            if(rem != null)
                bst.remove(rem);
            System.out.println(bst.preOrder(bst.root));
        }
    }
}
class BST{
    public Node root;
    private int size;

    public boolean isEmpty(){return this.root == null;}

    public boolean isLeaf(Node node){
        return (node.left == null && node.right == null);
    }

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

    public void remove(Node rm){
        if (isLeaf(rm)) {
            if (rm == this.root)
                this.root = null;
            else {
                if (rm.value < rm.parent.value)
                    rm.parent.left = null;
                else
                    rm.parent.right = null;
            }
        }
        else if(onlyLeftChild(rm)){
            if(rm == this.root) {
                this.root = rm.left;
                this.root.parent = null;
            }
            else {
                rm.left.parent = rm.parent;
                if (rm.value > rm.parent.value)
                    rm.parent.right = rm.left;
                else
                    rm.parent.left = rm.left;
            }
        }
        else if(onlyRightChild(rm)){
            if(rm == this.root) {
                this.root = rm.right;
                this.root.parent = null;
            }
            else {
                rm.right.parent = rm.parent;
                if (rm.value > rm.parent.value)
                    rm.parent.right = rm.right;
                else
                    rm.parent.left = rm.right;
            }
        }
        else{
            Node sucessor = sucessor(rm);
            rm.value = sucessor.value;
            remove(sucessor);
        }
    }

    public boolean onlyLeftChild(Node node){
        return (node.left != null && node.right == null);
    }
    public boolean onlyRightChild(Node node){
        return (node.left == null && node.right != null);
    }

    public Node sucessor(Node node){
        if (node == null) return null;
        if (node.right != null){
            node = node.right;
            while(node.left != null)
                node = node.left;
            return node;
        }
        else{
            Node aux = node.parent;
            while(aux != null && aux.value < node.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    public ArrayList<Integer> preOrder(Node current){
        if(this.root == null)
            return null;
        if(current == null)
            return new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        out.add(current.value);
        out.addAll(preOrder(current.left));
        out.addAll(preOrder(current.right));
        return out;
    }

    public Node search(int element){
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