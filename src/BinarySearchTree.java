import com.sun.source.tree.Tree;

import java.util.ArrayList;

/**
 * Binary search tree for this lab
 */
public class BinarySearchTree<E extends Comparable<E>>{
    private TreeNode<E> root;

    /**
     * Initializes new root for tree with full null values
     *uses private var root
     */
    public BinarySearchTree(){
        root = new TreeNode(null, null, null);
    }

    /**
     * @param value to add
     * Go left if value less than, right if greater than
     * @return void after adding value to tree
     */
    public E add(E value){
        if (root.getValue() == null){
            root.setValue(value);
            return value;
        }
        TreeNode<E> newFocus = root;
        while (true){
            if (newFocus.getValue().compareTo(value) > 0){
                if (newFocus.getLeftChild() == null){
                    newFocus.setLeftChild(new TreeNode(value, null, null));
                    return value;
                }
                newFocus = newFocus.getLeftChild();
            }
            else{
                if (newFocus.getRightChild() == null){
                    newFocus.setRightChild(new TreeNode(value, null, null));
                    return value;
                }
                newFocus = newFocus.getRightChild();
            }
        }
    }

    /**
     * @param value to check if in tree
     * Iterates with compareTo, looks for value
     * @return true if value in tree, false if not
     */
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

    /**
     * Counts up all nodes in tree
     * @return int # of nodes in tree, 0 if root is null
     */
    public int countNodes(){
        if (root.getValue() == null){
            return 0;
        }
        return extraNodes(root);
    }

    /**
     * @param temp is root, changes between recursions
     * Private recursive helper method to use count and add up nodes across tree
     * @return # of nodes in the tree
     */
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

    /**
     * Counts all the leaf nodes (nodes without children) in the tree
     * @return # of leaf nodes
     */
    public int countLeafNodes(){
        if (root.getValue() == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        return extraLeafNodes(newFocus);
    }

    /**
     * @param temp is root, changes between recursions
     * Private recursive helper method to use count and add up leaf nodes across tree
     * @return # of leaf nodes in the tree
     */
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

    /**
     * Calculates the total height of tree
     * @return int of height, root lvl 0, kids lvl 1, grandkids lvl 2, etc.
     */
    public int getHeight(){
        if (root.getValue() == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        return totalHeight(newFocus);
    }

    /**
     * @param temp is root, changes between recursions
     * Private recursive helper method to calculate total height
     * @return int total height
     */
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

    /**
     * Prints the BST values in pre-order (root-left-right)
     * Prints "nothing to print" if root is null
     */
    public void printPreOrder(){
        System.out.println("Preorder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        preOrder(root);
    }

    /**
     * @param temp is root, changes
     * Private helper recursion method to print out the post-order
     */
    private void preOrder(TreeNode<E> temp){
        System.out.println(temp.getValue());
        if (temp.getLeftChild() != null){
            preOrder(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            preOrder(temp.getRightChild());
        }
    }

    /**
     * Prints the BST values in post-order (left-right-root)
     * Prints "nothing to print" if root is null
     */
    public void printPostOrder(){
        System.out.println("PostOrder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        postOrder(root);
    }

    /**
     * @param temp is root, changes
     * Private helper recursion method to print out the post-order
     */
    private void postOrder(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            postOrder(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            postOrder(temp.getRightChild());
        }
        System.out.println(temp.getValue());
    }

    /**
     * Prints the BST values in pre-order (left-root-right)
     * Prints "nothing to print" if root is null
     */
    public void printInOrder(){
        System.out.println("InOrder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        inOrder(root);
    }

    /**
     * @param temp is root, changes
     * Private helper recursion method to print out the in-order
     */
    private void inOrder(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            inOrder(temp.getLeftChild());
        }
        System.out.println(temp.getValue());
        if (temp.getRightChild() != null) {
            inOrder(temp.getRightChild());
        }
    }

    /**
     * @param value to find in tree and delete
     * Finds the value in tree using == and deletes if it's there
     * @return the value if it's deleted, null otherwise
     */
    public E delete(E value){
        if (root.getValue() == null){
            return null;
        }
        TreeNode<E> val = remover(root, value);
        return val.getValue();
    }


    /**
     * @param temp is root, changes
     * @param value to look for using ==
     * Private recursive helper method for delete
     * @return the value if deleted, null otherwise
     */
    private TreeNode<E> remover(TreeNode<E> temp, E value) {
        if (temp == null) {
            return null;
        }
        E search = temp.getValue();
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
            E left = temp.getLeftChild().getValue();
            temp.setLeftChild(remover(temp.getLeftChild(), left));
            temp.setValue(left);
            return temp;
        }
        if (temp.getValue().compareTo(value) > 0) {
            temp.setLeftChild(remover(temp.getLeftChild(), value));
        } else {
            temp.setRightChild(remover(temp.getRightChild(), value));
        }
        return temp;
    }

    /**
     * Clears the root to make it a new null TreeNode (constructor does the same)
     */
    public void clearTree(){
        root = new TreeNode<>(null, null,null);
    }

    /**
     * @param parts list of int values
     * Clears old tree and builds tree off of an ArrayList integer values that is made from a file
     */
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

    /**
     * @param temp is root, can change
     * @param parts the ArrayList to add the int values in
     * @param placement is the i value for which value of parts the code is at
     * Private recursive helper method for makeTree() to build it out
     */
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
