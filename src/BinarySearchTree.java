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
        count = 0;
        return extraLeafNodes(newFocus);
    }
    private int extraLeafNodes(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            count += extraLeafNodes(temp.getLeftChild());
        }
        if (temp.getRightChild() != null){
            count += extraLeafNodes(temp.getLeftChild());
        }
        if (temp.getLeftChild() == null && temp.getRightChild() == null){
            count++;
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
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        TreeNode<E> inFocus = root;
        System.out.println(inFocus);
        if (inFocus.getLeftChild() != null){
            inFocus = inFocus.getLeftChild();
            System.out.println(inFocus);
            preOrder(inFocus);
        }
        if (inFocus.getRightChild() != null){
            inFocus = inFocus.getRightChild();
            System.out.println(inFocus);
            preOrder(inFocus);
        }
    }

    private void preOrder(TreeNode<E> temp){
        System.out.println("Preorder:");
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            System.out.println(temp);
            preOrder(temp);
        }
        if (temp.getRightChild() != null){
            temp = temp.getRightChild();
            System.out.println(temp);
            preOrder(temp);
        }
    }

    public void printPostOrder(){
        System.out.println("PostOrder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        TreeNode<E> inFocus = root;
        if (inFocus.getLeftChild() != null){
            inFocus = inFocus.getLeftChild();
            postOrder(inFocus);
        }
        if (inFocus.getRightChild() != null){
            inFocus = inFocus.getRightChild();
            postOrder(inFocus);
        }
        System.out.println(inFocus);
    }

    private void postOrder(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            postOrder(temp);
        }
        if (temp.getRightChild() != null){
            temp = temp.getRightChild();
            postOrder(temp);
        }
        System.out.println(temp);
    }

    public void printInOrder(){
        System.out.println("InOrder:");
        if (root.getValue() == null){
            System.out.println("Nothing to print.");
            return;
        }
        TreeNode<E> inFocus = root;
        if (inFocus.getLeftChild() != null){
            inFocus = inFocus.getLeftChild();
            inOrder(inFocus);
        }
        System.out.println(inFocus);
        if (inFocus.getRightChild() != null){
            inFocus = inFocus.getRightChild();
            inOrder(inFocus);
        }
    }

    private void inOrder(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            inOrder(temp);
        }
        System.out.println(temp);
        if (temp.getRightChild() != null) {
            temp = temp.getRightChild();
            inOrder(temp);
        }
    }

    public E delete(E value){
        E tempEl = null;
        if (root.getValue() == null){
            throw new NoSuchElementException();
        }
        TreeNode<E> target = root;
        if (target.getValue().equals(value)){
            tempEl = target.getValue();
            target.setValue(null);
            systemDeleter(target);
            return tempEl;
        }
        if (target.getLeftChild() != null){
            target = target.getLeftChild();
            if (target.getValue().equals(value)){
                tempEl = target.getValue();
                target.setValue(null);
                systemDeleter(target);
                return tempEl;
            }
            else{
                remover(target, value);
            }
        }
        if (target.getRightChild() != null){
            target = target.getRightChild();
            if (target.getValue().equals(value)){
                tempEl = target.getValue();
                target.setValue(null);
                systemDeleter(target);
                return tempEl;
            }
            else{
                remover(target, value);
            }
        }
        return null;
    }
    private E remover(TreeNode<E> temp, E value){
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            if (temp.getValue().equals(value)){
                E tempEl = temp.getValue();
                temp.setValue(null);
                systemDeleter(temp);
                return tempEl;
            }
            else{
                remover(temp, value);
            }
        }
        if (temp.getRightChild() != null){
            temp = temp.getRightChild();
            if (temp.getValue().equals(value)){
                E tempEl = temp.getValue();
                temp.setValue(null);
                systemDeleter(temp);
                return tempEl;
            }
            else{
                remover(temp, value);
            }
        }
        return null;
    }
    private void systemDeleter(TreeNode<E> temp){
        if (temp.getLeftChild() == null && temp.getRightChild() == null){
            return;
        }
        if (temp.getLeftChild() == null && temp.getRightChild() != null){
            temp.setValue(temp.getRightChild().getValue());
            temp = temp.getRightChild();
            temp.setValue(null);
            systemDeleter(temp);
            return;
        }
        else{
            temp.setValue(temp.getLeftChild().getValue());
            temp = temp.getLeftChild();
            temp.setValue(null);
            systemDeleter(temp);
            return;
        }
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
        TreeNode<E> temp = root;
        for (int i = 1; i < parts.size(); i++){
            if (parts.get(i).compareTo((Integer)temp.getValue()) > 0){
                if (temp.getLeftChild() == null){
                    temp.setLeftChild(new TreeNode<>((E)parts.get(i), null, null));
                }
                else{
                    temp = temp.getLeftChild();
                    lastRecur(temp, parts, i);
                }
            }
            else{
                if (temp.getRightChild() == null){
                    temp.setRightChild(new TreeNode<>((E)parts.get(i), null, null));
                }
                else{
                    temp = temp.getRightChild();
                    lastRecur(temp, parts, i);
                }
            }
        }
    }
    private void lastRecur(TreeNode<E> temp, ArrayList<Integer> parts, int placement){
        if (parts.get(placement).compareTo((Integer)temp.getValue()) > 0){
            if (temp.getLeftChild() == null){
                temp.setLeftChild(new TreeNode<>((E)parts.get(placement), null, null));
                return;
            }
            else{
                temp = temp.getLeftChild();
                lastRecur(temp, parts, placement);
            }
        }
        else{
            if (temp.getRightChild() == null){
                temp.setRightChild(new TreeNode<>((E)parts.get(placement), null, null));
                return;
            }
            else{
                temp = temp.getRightChild();
                lastRecur(temp, parts, placement);
            }
        }
    }

}
