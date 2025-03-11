import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    private int capacity = 10;
    private int size = 0;

    int[] heap = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getLeftChild (int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int getRightChild (int index) {
        return heap[getRightChildIndex(index)];
    }

    private int getParent(int index) {
        return heap[getParentIndex(index)];
    }

    private void swap(int one, int two) {
        int temp = heap[one];
        heap[one] = heap[two];
        heap[two] = temp;
    }

    private void checkCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Your heap is empty.");
        }
        return heap[0];
    }

    public int poll() {
        if (size ==0) {
            throw new NoSuchElementException("Your heap is empty.");
        }
            int head = heap[0];
            heap[0] = heap[size -1];
            size--;
            heapifyDown();
            return head;
        }

    public void add(int val) {
        checkCapacity();
        heap[size] = val;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChild = getLeftChild(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChild = getRightChild(index);
            }
            if (heap[index] < smallerChild) {
                break;
            } else {
                swap(index, smallerChild);
            }
            index = smallerChild;
        }
    }
}