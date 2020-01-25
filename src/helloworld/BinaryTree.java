package helloworld;

public class BinaryTree {

    //preOrder
    public void preOder(TreeNode root){
        //base case
        if(root == null){
            return;
        }
        //print root, go left, go right
        System.out.println(root.value);
        preOder(root.left);
        preOder(root.right);
    }

    //inOrder
    public void inOder(TreeNode root){
        //base case
        if(root == null){
            return;
        }
        //go left, print root, go right
        inOder(root.left);
        System.out.println(root.value);
        inOder(root.right);
    }

    //postOrder
    public void postOrder(TreeNode root){
        //base case
        if(root == null){
            return;
        }
        //go left, go right, print root
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    //Height of binary tree: The distance between the root with the deepest leaf node.

    //Balanced binary tree: is commonly defined as a binary tree in which the height of the left and right subtrees of every node differ by 1 or less:
    //1. for each of the nodes in this binary tree.    2. satisfy: the height of leftsubtree, rightsubtree at most differ by 1.

    //Complete binary tree: is a binary tree in which every level, except possibly the last , is completely filled, and  all nodes are as far left as possible.

    //Full binary tree: A full binary tree( sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves has 2 children.

    //Binary Search Tree (BST) : for every single node in the tree, the values in its left subtree are all smaller than (or equal to its value), and the values in its right subtree are all larger than(or equal to) its value.


    //Get Height
    // Time Complexity: O(n)  each node func call consume 1, total: n nodes. so, 1 *n = n.
    // Space Complexity: O(h)   average: O(logn)   worst: O(n)
    public int getHeight(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        int h = Math.max(lH,rH) + 1;
        return h;
    }

    public int countNodes(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        int total = 1+l+r;
        return total;
    }

    //Check If Binary Tree Is Balanced
    // 1. 非优化做法
    public boolean isB(TreeNode root){
        if(root == null){
            return true;
        }
        boolean l = isB(root.left);
        boolean r = isB(root.right);
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        return l && r && Math.abs(lH - rH) <= 1;
    }

    // 2. 优化做法
    // Time Complexity: O(n)
    // Space Complexity: O(h) average: O(logn) worst: O(n)
    public boolean isBalanced(TreeNode root){
        return getHeightOrUnbalanced(root) >= 0;
    }
    public int getHeightOrUnbalanced(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }
        int l = getHeightOrUnbalanced(root.left);
        int r = getHeightOrUnbalanced(root.right);
        if(l < 0 || r < 0){
            return -1;
        }
        if(Math.abs(l-r) > 1){
            return -1;
        }
        return (Math.max(l,r) + 1);
    }











}
