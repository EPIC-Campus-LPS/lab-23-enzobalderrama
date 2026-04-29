import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;


    @org.junit.jupiter.api.Test
    void add() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(bst.add(5), 5);
    }

    @org.junit.jupiter.api.Test
    void contains() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(bst.contains(3), true);
    }

    @org.junit.jupiter.api.Test
    void countNodes() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(bst.countNodes(), 10);
    }

    @org.junit.jupiter.api.Test
    void countLeafNodes() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(bst.countLeafNodes(), 4);
    }

    @org.junit.jupiter.api.Test
    void getHeight() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(bst.getHeight(), 5);
    }

    @org.junit.jupiter.api.Test
    void delete() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(2, bst.delete(5));
    }

    @org.junit.jupiter.api.Test
    void clearTree() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        bst.clearTree();
        assertEquals(bst.contains(5), false);
    }

    @org.junit.jupiter.api.Test
    void makeTree() throws FileNotFoundException {
        ArrayList<Integer> fillIn = new ArrayList<>();
        File file = new File("fileBST.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            fillIn.add(scan.nextInt());
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.makeTree(fillIn);
        assertEquals(bst.contains(5), true);
    }
}