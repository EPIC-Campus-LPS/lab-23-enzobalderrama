import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>>{
    private TreeNode<E> root;
    private int count;
    private int max;
    private ArrayList<Integer> someOrder;
    public BinarySearchTree(){
        root = new TreeNode(null, null, null);
    }

    public void add(E value){
        if (root == null){
            root.setValue(value);
            return;
        }
        TreeNode<E> newFocus = root;
        while (true){
            if (newFocus.getValue().compareTo(value) <= 0){
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
        if (root == null){
            return false;
        }
        TreeNode<E> newFocus = root;
        while (true){
            if (newFocus.equals(value)){
                return true;
            }
            if (newFocus.getValue().compareTo(value) <= 0){
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
        if (root == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        count = 1;
        return extraNodes(newFocus);
    }
    private int extraNodes(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            count++;
            return (extraNodes(temp));
        }
        if (temp.getRightChild() != null){
            temp = temp.getRightChild();
            count++;
            return (extraNodes(temp));
        }
        return count;
    }

    public int countLeafNodes(){
        if (root == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        count = 0;
        return extraLeafNodes(newFocus);
    }
    private int extraLeafNodes(TreeNode<E> temp){
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            return (extraLeafNodes(temp));
        }
        if (temp.getRightChild() != null){
            temp = temp.getRightChild();
            return (extraLeafNodes(temp));
        }
        if (temp.getLeftChild() == null && temp.getRightChild() == null){
            count++;
        }
        return count;
    }

    public int getHeight(){
        if (root == null){
            return 0;
        }
        TreeNode<E> newFocus = root;
        max = 1;
        int tempMax = max;
        return totalHeight(newFocus, max, tempMax);
    }
    private int totalHeight(TreeNode<E> temp, int maxi, int tem){
        if (temp.getLeftChild() != null){
            temp = temp.getLeftChild();
            tem++;
            return (totalHeight(temp, maxi, tem));
        }
        if (temp.getRightChild() != null){
            temp = temp.getRightChild();
            tem++;
            return (totalHeight(temp, maxi, tem));
        }
        if (tem > maxi && tem > max){
            max = tem;
            maxi = tem;
        }
        tem = 1;
        return max;
    }

    public void printPreOrder(){
        someOrder = new ArrayList<>();
        if (root == null){
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
}
