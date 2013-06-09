package test;
import util.MaxHeap;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxHeapTest {
    @Test
    public void testSetup()
    {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.push(10);
        maxHeap.push(20);
        maxHeap.push(100);
        maxHeap.push(40);
        System.out.println(maxHeap);
    }
}
