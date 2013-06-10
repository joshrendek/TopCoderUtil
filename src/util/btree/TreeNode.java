package util.btree;

import util.Costable;

public class TreeNode {
    TreeObject item;
    TreeNode left;
    TreeNode right;
    private static TreeNode root;

    public TreeNode(TreeObject item) {
        this.item = item;
    }

    public TreeNode() { }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(root.left);
            count += countNodes(root.right);

            return count;
        }
    }

    public void treeInsert(TreeObject newTreeObject) {
        if (root == null) {
            // Empty tree, set root to point to this tree node
            root = new TreeNode(newTreeObject);
            return;
        }

        TreeNode iterator;
        iterator = root;
        while (true) {
            if (newTreeObject.getCost() < 0) {
                // belongs to left
                if (iterator.left == null) {
                    iterator.left = new TreeNode(newTreeObject);
                    return;
                } else {
                    iterator = iterator.left;
                }

            } else {
                // greater than
                if (iterator.right == null) {
                    iterator.right = new TreeNode(newTreeObject);
                    return;
                } else {
                    iterator = iterator.right;
                }
            }
        }
    }
}
