package util;

import sun.print.SunPrinterJobService;

import java.util.Arrays;
public class MaxHeap<T extends Comparable<T> & Costable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int heapSize = 0;
    private T[] maxHeap = null;
    private int currentIndex = 0;
    @SuppressWarnings("unchecked")
    public MaxHeap(int heapSize) {
        this.heapSize = heapSize;
        // cast generic Object to Template type
        maxHeap = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return currentIndex - 1;
    }

    public T pop() {
        if(maxHeap[0] == null){
            System.err.println("Empty heap");
            return null;
        }

        T max = maxHeap[0];
        currentIndex--;
        maxHeap[0] = maxHeap[currentIndex];
        maxHeap[currentIndex] = null;
        heapifyDown(0);
        System.err.println("Popped: " + max);
        return max;
    }

    public T top() {
        return maxHeap[0];
    }

    public void add(T node) {
        if(currentIndex == heapSize){
            pop();
            add(node);
        }else{
            maxHeap[currentIndex] = node;
            heapifyUp(currentIndex++);
        }
    }

    // Compare node value to parent node
    // if node value > parent node, then switch and continue
    // else stop
    // current is the index location we're at
    private void heapifyUp(int current) {
        int parent = (current - 1) / 2;
        if(current < 0)
            return;

        if(maxHeap[current].getCost() > maxHeap[parent].getCost()){
            T tmp = maxHeap[parent];
            maxHeap[parent] = maxHeap[current];
            maxHeap[current] = tmp;
            current = parent;
            heapifyUp(current);
        }

    }

    // Compare node value with two children value
    // if the node is greater than both the children, it stays
    // else if it is less than or both of its children, then switch
    // with the lowest value, making the new parent node is highest
    // repeat until the node is greater than both of children
    private void heapifyDown(int current) {
        int left = 2 * current + 1;
        int right = left + 1;

        if(current > currentIndex / 2) // exit
            return;

        int biggerChild = 0;

        if(maxHeap[left] == null && maxHeap[right] != null){
            biggerChild = right;
        }else if(maxHeap[right] == null && maxHeap[left] != null){
            biggerChild = left;
        }else if(maxHeap[left] == null && maxHeap[right] == null){
            return;
        }else{
            biggerChild = maxHeap[left].getCost() > maxHeap[right].getCost() ? left : right;
        }

        if(biggerChild == left && maxHeap[left].getCost() > maxHeap[current].getCost()){
            T tmp = maxHeap[left];
            maxHeap[left] = maxHeap[current];
            maxHeap[current] = tmp;
            heapifyDown(left);
        }else if(biggerChild == right && maxHeap[right].getCost() > maxHeap[current].getCost()){
            T tmp = maxHeap[right];
            maxHeap[right] = maxHeap[current];
            maxHeap[current] = tmp;
            heapifyDown(right);
        }else{
            return;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Heap [util.MaxHeap=");
        builder.append(Arrays.toString(maxHeap));
        builder.append("]");
        return builder.toString();
    }

}
