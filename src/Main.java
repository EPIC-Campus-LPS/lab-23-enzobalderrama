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

        System.out.println("Hello world!");
    }
}