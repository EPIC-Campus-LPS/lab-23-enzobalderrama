import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>>{
    private TreeNode<E> root;
    private int count;
    private int max;
    public BinarySearchTree(){
        root = new TreeNode(null, null, null);
    }

    public void add(E value){
        if (root.getValue() == null){
            root.setValue(value);
            return;
        }
        TreeNode<E> newFocus = root;
        while (true){
            if (newFocus.getValue().compareTo(value) > 0){
                if (newFocus.getLeftChild() == null){
                    newFocus.setLeftChild(new TreeNode(value, null, null));
                    return;
                }
                newFocus = newFocus.getLeftChild();
            }
            else{
                if (newFocus.getRightChild() == null){
                    newFocus.setRightChild(new TreeNode(value, null, null));
                    return;
                }
                newFocus = newFocus.getRightChild();
            }
        }
    }

    public boolean contains(E value){
        if (root.getValue() == null){
            return false;
        }
        TreeNode<E> newFocus = root;
        while (true){
            if (newFocus.getValue().equals(value)){
                return true;
            }
            if (newFocus.getValue().compareTo(value) > 0){
                if (newFocus.getLeftChild() == null){
                    return false;
                }
                newFocus = newFocus.getLeftChild();
            }
            else{
                if (newFocus.getRightChild() == null){
                    return false;
                }
                newFocus = newFocus.getRightChild();
            }
        }
    }
    public int countNodes(){
        if (root.getValue() == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        return extraNodes(newFocus);
    }
    private int extraNodes(TreeNode<E> temp){
        int count = 1;
        if (temp.getLeftChild() != null){
            count += extraNodes(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            count += extraNodes(temp.getRightChild());
        }
        return count;
    }

    public int countLeafNodes(){
        if (root.getValue() == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        return extraLeafNodes(newFocus);
    }
    private int extraLeafNodes(TreeNode<E> temp){
        int count = 0;
        if (temp.getLeftChild() == null && temp.getRightChild() == null){
            return 1;
        }
        if (temp.getLeftChild() != null){
            count += extraLeafNodes(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            count += extraLeafNodes(temp.getRightChild());
        }
        return count;
    }

    public int getHeight(){
        if (root.getValue() == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        return totalHeight(newFocus);
    }
    private int totalHeight(TreeNode<E> temp){
        int left = 0;
        int right = 0;
        if (temp.getLeftChild() != null){
            left = totalHeight(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            right = totalHeight(temp.getRightChild());
        }
        if (left > right){
            return left+1;
        }
        return right+1;
    }

    public void printPreOrder(){
        System.out.println("Preorder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        preOrder(root);
    }

    private void preOrder(TreeNode<E> temp){
        System.out.println(temp.getValue());
        if (temp.getLeftChild() != null){
            preOrder(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            preOrder(temp.getRightChild());
        }
    }

    public void printPostOrder(){
        System.out.println("PostOrder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        postOrder(root);
    }

    private void postOrder(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            postOrder(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            postOrder(temp.getRightChild());
        }
        System.out.println(temp.getValue());
    }

    public void printInOrder(){
        System.out.println("InOrder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        inOrder(root);
    }

    private void inOrder(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            inOrder(temp.getLeftChild());
        }
        System.out.println(temp.getValue());
        if (temp.getRightChild() != null) {
            inOrder(temp.getRightChild());
        }
    }

    public E delete(E value){
        if (root.getValue() == null){
            return null;
        }
        return remover(root, null, value).getValue();
    }
    private TreeNode<E> remover(TreeNode<E> temp, E parent, E value) {
        if (temp == null) {
            return null;
        }
        if (temp.getValue().equals(value)) {
            if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                return null;
            }
            if (temp.getRightChild() == null) {
                return temp.getLeftChild();
            }
            if (temp.getLeftChild() == null) {
                return temp.getRightChild();
            }
            temp.setValue(temp.getLeftChild().getValue());
            temp.setLeftChild(remover(temp.getLeftChild(), temp.getLeftChild().getValue(), value));
            temp.setValue(temp.getLeftChild().getValue());
            return temp;
        }
        if (temp.getValue().compareTo(value) > 0) {
            temp.setLeftChild(remover(temp.getLeftChild(), temp.getValue(), value));
        } else {
            temp.setRightChild(remover(temp.getRightChild(), temp.getValue(), value));
        }
        return temp;
    }

    public void clearTree(){
        root = new TreeNode<>(null, null,null);
    }

    public void makeTree(ArrayList<Integer> parts){
        clearTree();
        if (parts.get(0) == null){
            return;
        }
        root.setValue((E) parts.get(0));
        for (int i = 1; i < parts.size(); i++){
            lastRecur(root, parts, i);
        }
    }
    private void lastRecur(TreeNode<E> temp, ArrayList<Integer> parts, int placement){
        if (parts.get(placement).compareTo((Integer)temp.getValue()) < 0){
            if (temp.getLeftChild() == null){
                temp.setLeftChild(new TreeNode<>((E)parts.get(placement), null, null));
                return;
            }
            else{
                lastRecur(temp.getLeftChild(), parts, placement);
            }
        }
        else{
            if (temp.getRightChild() == null){
                temp.setRightChild(new TreeNode<>((E)parts.get(placement), null, null));
                return;
            }
            else{
                lastRecur(temp.getRightChild(), parts, placement);
            }
        }
    }

}
