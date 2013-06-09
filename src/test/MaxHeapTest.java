package test;

import util.Costable;
import util.MaxHeap;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxHeapTest {
    @Test
    public void testSetup() {
        MaxHeap<Node> maxHeap = new MaxHeap<Node>(10);
//        maxHeap.add(10);
//        maxHeap.add(20);
//        maxHeap.add(100);
//        maxHeap.add(40);
//
//        System.out.println(maxHeap);
//
//        assertEquals(maxHeap.pop(), Integer.valueOf(100));
//        assertEquals(maxHeap.pop(), Integer.valueOf(40));
//        assertEquals(maxHeap.pop(), Integer.valueOf(20));
//        assertEquals(maxHeap.pop(), Integer.valueOf(10));


    }

    public class Node implements Comparable, Costable {
        private int cost;

        public Node(int cost) {
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public boolean equals(Object o) {
            return this.cost == ((Node) o).getCost() ? true : false;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Node)) {
                throw new ClassCastException("A node object expected.");
            }

            int other_cost = ((Node) o).getCost();

            return this.cost - other_cost;
        }
    }


}
