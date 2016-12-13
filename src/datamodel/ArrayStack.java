package datamodel;

import java.util.Iterator;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 数组实现的下压栈
 */
public class ArrayStack<Item> {
    private Item[] a = (Item[]) new Object[1];//栈元素
    private int N = 0;

    private void resizeArray(int max) {
        Item[] tmp = (Item[]) new Object[1];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public void push(Item value) {
        //将元素添加到栈顶
        if (N == a.length)
            resizeArray(2 * N);
        a[N++] = value;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;//在数组中删除这个对象,避免对象游离
        if (N > 0 && N < a.length / 4)
            resizeArray(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        //后进先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
