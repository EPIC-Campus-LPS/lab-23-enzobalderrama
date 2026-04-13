import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        System.out.println("Tree has been made");
        bst.add(5);
        System.out.println("5 has been added");
        bst.delete(8);
        System.out.println("8 had been deleted(if it existed)");
        System.out.println("Does BST contain 17? " + bst.contains(17));
        bst.printInOrder();
        bst.printPostOrder();
        bst.printPreOrder();
        System.out.println("Total # of nodes: " + bst.countNodes());
        System.out.println("Total # of leaf nodes: " + bst.countLeafNodes());
        System.out.println("Height of tree: " + bst.getHeight());
        bst.clearTree();
        System.out.println("Tree cleared");
    }
}