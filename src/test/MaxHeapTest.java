package test;

import org.junit.Test;
import util.Costable;
import util.MaxHeap;

import static org.junit.Assert.assertEquals;

public class MaxHeapTest {
    @Test
    public void testSetup() {
        //Node n = new Node(10);
        MaxHeap<Node> maxHeap = new MaxHeap<Node>(Node.class, 10);
        maxHeap.add(new Node(10));
        maxHeap.add(new Node(20));
        maxHeap.add(new Node(100));
        maxHeap.add(new Node(40));

        assertEquals(maxHeap.pop().getCost(), 100);
        assertEquals(maxHeap.pop().getCost(), 40);
        assertEquals(maxHeap.pop().getCost(), 20);
        assertEquals(maxHeap.pop().getCost(), 10);


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
