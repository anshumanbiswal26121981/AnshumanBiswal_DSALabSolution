import java.util.HashSet;

public class FindPairInBst {

      public static void main(String[] args)
      {
         BinarySearchTree tree = new BinarySearchTree();
         tree.insert(40);
         tree.insert(20);
         tree.insert(60);
         tree.insert(10);
         tree.insert(30);
         tree.insert(50);
         tree.insert(70);
         //Method 1
         tree.isPairPresent(tree.root, 130);

         //Method 2: Optimized way
         if (!tree.isPairPresentOptimized(tree.root, 130, new HashSet<>())) {
            System.out.println("nodes are not found");
         }
      }
   }
