package test.btree;

import util.Costable;
import util.btree.TreeNode;
import util.btree.TreeObject;


public class BTreeTest {
    @org.junit.Test
    public void TestBTree() {
        TreeNode root = new TreeNode();
        root.treeInsert(new TreeObject(10));
        System.out.println("Nodes: " + TreeNode.countNodes(root));
        return;
    }


    public class Node implements Costable {
        private int cost;

        public Node() {
            cost = 0;
        }

        public Node(int cost) {
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }


    }
}
