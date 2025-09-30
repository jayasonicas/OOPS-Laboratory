package exercise;

//Program Title: Generic Binary Tree with Traversals

import java.util.*;

//Step 1: Define a generic TreeNode class
class TreeNode<T extends Comparable<T>> {
 T data;
 TreeNode<T> left, right;

 TreeNode(T data) {
     this.data = data;
     left = right = null;
 }
}

//Step 2: Implement Generic BinaryTree class
class BinaryTree<T extends Comparable<T>> {
 TreeNode<T> root;

 // Insert method (BST style)
 public void insert(T value) {
     root = insertRec(root, value);
 }

 private TreeNode<T> insertRec(TreeNode<T> node, T value) {
     if (node == null) {
         return new TreeNode<>(value);
     }
     if (value.compareTo(node.data) < 0) {
         node.left = insertRec(node.left, value);
     } else {
         node.right = insertRec(node.right, value);
     }
     return node;
 }

 // Step 3: DFS Traversals
 public void inOrder(TreeNode<T> node) {
     if (node != null) {
         inOrder(node.left);
         System.out.print(node.data + " ");
         inOrder(node.right);
     }
 }

 public void preOrder(TreeNode<T> node) {
     if (node != null) {
         System.out.print(node.data + " ");
         preOrder(node.left);
         preOrder(node.right);
     }
 }

 public void postOrder(TreeNode<T> node) {
     if (node != null) {
         postOrder(node.left);
         postOrder(node.right);
         System.out.print(node.data + " ");
     }
 }

 // Step 4: BFS Traversal (Level Order)
 public void levelOrder(TreeNode<T> node) {
     if (node == null) return;

     Queue<TreeNode<T>> queue = new LinkedList<>();
     queue.add(node);

     while (!queue.isEmpty()) {
         TreeNode<T> current = queue.poll();
         System.out.print(current.data + " ");

         if (current.left != null) queue.add(current.left);
         if (current.right != null) queue.add(current.right);
     }
 }
}

//Step 5: Test Program
public class GenericBinaryTreeDemo {
 public static void main(String[] args) {
     BinaryTree<Integer> tree = new BinaryTree<>();

     // Test Case 1: Insert 10, 5, 20
     tree.insert(10);
     tree.insert(5);
     tree.insert(20);

     System.out.print("Level Order (BFS): ");
     tree.levelOrder(tree.root); // Expected: 10 5 20
     System.out.println();

     System.out.print("In-order (DFS): ");
     tree.inOrder(tree.root);    // Expected: 5 10 20
     System.out.println();

     System.out.print("Pre-order (DFS): ");
     tree.preOrder(tree.root);   // Expected: 10 5 20
     System.out.println();

     System.out.print("Post-order (DFS): ");
     tree.postOrder(tree.root);  // Expected: 5 20 10
     System.out.println();
 }
}
6
