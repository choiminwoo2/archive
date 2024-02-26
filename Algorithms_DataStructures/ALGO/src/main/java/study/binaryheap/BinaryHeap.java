package study.binaryheap;

import java.util.ArrayList;

public class BinaryHeap<E extends Number> {

    ArrayList<E> list;

    public BinaryHeap() {

        list = new ArrayList<E>();
    }

    public void insert(E value) {

        list.add(value);
        bubleUp();

    }

    private void bubleUp() {

        int idx = list.size() - 1;
        final E element = list.get(idx);
        while (idx > 0) {
            int parentIdx = (int) Math.floor((idx - 1) / 2);
            E parent = list.get(parentIdx);
            if (element.doubleValue() <= parent.doubleValue()) {
                break;
            }
            list.set(parentIdx, element);
            list.set(idx, parent);
            idx = parentIdx;
        }
    }
}
