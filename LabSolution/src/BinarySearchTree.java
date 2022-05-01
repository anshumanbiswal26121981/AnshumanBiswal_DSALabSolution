import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {

   // Root of BST
   Node root;

   // Constructor
   BinarySearchTree() {
      root = null;
   }

   void insert(int key) {
      root = insertNodeRecursively(root, key);
   }

   Node insertNodeRecursively(Node root, int data) {

      if (root == null) {
         root = new Node(data);
         return root;
      }

      if (data < root.data)
         root.left = insertNodeRecursively(root.left, data);
      else if (data > root.data)
         root.right = insertNodeRecursively(root.right, data);

      return root;
   }

   // Method that adds values of given BST into ArrayList
   void convertBSTToList(Node node, ArrayList<Integer> list) {
      // Base Case
      if (node == null)
         return;

      convertBSTToList(node.left, list);
      list.add(node.data);
      convertBSTToList(node.right, list);
   }

   // method that checks if there is a pair present
   boolean isPairPresent(Node node, int target) {
      ArrayList<Integer> a2 = new ArrayList<>();
      // create a2 arraylist from the BSt values
      convertBSTToList(node, a2);
      int start = 0; // Starting index of a2

      int end = a2.size() - 1; // Ending index of a2

      while (start < end) {
         int startVal = a2.get(start);
         int endVal = a2.get(end);

         if (startVal + endVal == target) {
            //target found
            System.out.println("Pair is: (" + startVal + "," + endVal + ")");
            return true;
         }

         //since the list is sorted because it is a bst , so we can either increment start or decrement end to
         // compare the sum with the targe
         if (startVal + endVal > target) {
            //decrement end
            end--;
         }

         if (startVal + endVal < target) {
            //increment start
            start++;
         }
      }

      System.out.println("nodes are not found");
      return false;
   }

   // method that checks if there is a pair present
   boolean isPairPresentOptimized(Node node, int target, Set<Integer> a2) {
      if (node == null) {
         return false;
      }
      if (isPairPresentOptimized(node.left, target, a2)) {
         return true;
      }

      if (a2.contains(target - node.data)) {
         System.out.println("Pair is: (" + (target - node.data) + "," + node.data + ")");
      } else {
         a2.add(node.data);
      }
      return isPairPresentOptimized(node.right, target, a2);
   }
}
