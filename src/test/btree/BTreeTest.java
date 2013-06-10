package test.btree;

import util.Costable;
import util.btree.TreeNode;
import util.btree.TreeObject;

import java.util.Random;


public class BTreeTest {
    @org.junit.Test
    public void TestBTree() {

        for(int i = 0; i < 100; i++){
            TreeNode.root.treeInsert(new TreeObject( (new Random()).nextInt() ));
        }
        //root.treeInsert(new TreeObject(10));
        System.out.println("Nodes: " + TreeNode.countNodes(TreeNode.root));
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
