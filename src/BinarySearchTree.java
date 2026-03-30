public class BinarySearchTree<E extends Comparable<E>>{
    private TreeNode<E> root;
    private int count;
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
    public int extraNodes(TreeNode<E> temp){
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
}
