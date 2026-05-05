# Binary Search Tree
------------------------------
### Overview
A BinarySearchTree is a Java program that uses nodes to store and get data. It's organized in a sorted manner where each element is compared to others to find its location. It starts out with one root that will be the base of the tree. The root can have no more than two children, which is the maximum all children have. The next node inserted that is less than or equal to the root according to the `compareTo()` method is on its left, and the next one to be greater than the root is on its right.

<img width="800" height="400" alt="image" src="https://github.com/user-attachments/assets/4068145c-5757-4108-863c-dae4bc50bfef" />

From there, the tree uses compareTo to organize the tree when adding. When adding, all nodes start at the root and are compared to it. After being compared, they go to the next level down. If the child of the node that was compared to doesn't exist (if the next spot is empty), the new node being added goes into that slot. Otherwise, it keeps going down the tree and being compared to others until it finds a free space.

### Methods
* Adding and Building the Tree
  
There are several methods in the BinarySearchTree. The `add(E value)` method adds a new element based on the instructions above. The `makeTree(ArrayList<Integer> parts)` method creates a binary search tree using an integer ArrayList of values. This uses addition and recursion. Another option is the `clearTree()` method to delete the entire binary search tree. The `contains(E value)` method takes a value an input and searches for it using `compareTo()` and `equals()`. It returns true if it is somewhere in the tree and false otherwise.

* Deleting a Value

The `delete(E value)` method takes one value as input and searches for it similare to the `contains(E value)` method. If at some point it does find the value in the tree, it deletes the value from the tree and returns that same value. This one likewise uses recursion for help. If the value has any children, the recursion is used to look through the tree again and add the children back into the correct spot in accordance with the rules.

<img width="277" height="182" alt="image" src="https://github.com/user-attachments/assets/bce7e0f9-f5fc-4882-aa3e-fcb2a4af9831" />


* Counting Nodes

The node counting methods are intended to help gain understanding of the tree. The `countNodes()` method counts every single node in the tree to find the total amount and return it. The `countLeafNodes()` method does the same but only counts the nodes that are leaf nodes. Leaf nodes are all of the nodes that don't have any children on their left or right. Just like `countNodes()`, `countLeafNodes()` returns the number of leaf nodes. The `getHeight()` method calculates and returns the height of the tree. Each new level adds to the height. For example, the root level is always at zero height and its children are at one height and the grandchildren are at two height. The biggest height is returned. All three of these methods use recursion.


<img width="800" height="400" alt="image" src="https://github.com/user-attachments/assets/dcd73d3f-5871-4a9d-897a-c9054de44823" />


* Printing out the tree

The final methods are the ones that print out the tree. These methods don't return a value but instead print out the tree in a specific order. The `printPreOrder()` traverses through the tree and prints the root node first. It then recursively prints the left children first going all the way down the tree. After fully going down and left, it starts climbing back up the tree and printing the right children (it will still go left first if there's an unprinted left child). It does this until it reaches the right branch of the root where the process repeats.

The `printInOrder()` method goes from the left to the root to the right. Instead of starting at the root, it starts at the leftmost point of the tree and prints it. It then slowly goes up through the tree, printing the parent of the children and then the right child of the parent. Since it starts at the leftmost value and ends at the rightmost value, this prints the tree in a sorted manner from the smallest to greatest value. 

Lastly, the `printPostOrder()` prints the tree from the left subtree to the right subtree to the root. It starts at the leftmost point like `printinOrder()` but after printing that value, it goes to the right child of the parent instead of the parent. It repeats this throughout the method until it reaches the root which it prints after going through the entire right tree in the same manner.

All of these methods can be accesssed in the main. The tree is fully functional and operational.
