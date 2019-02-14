package snailx.javalibs.dataStruct.stack;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/21
 */
public class ArrayStack<E> {

    private Object[] objLists;
    private int count;
    private int capacity;

    public ArrayStack(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.objLists = new Object[capacity];
    }

    public boolean push(E e) {
        if (checkCapacity()) return false;
        objLists[count] = e;
        count++;
        return true;
    }

    public E pop() {
        if (checkEmpty()) return null;
        E e = (E) objLists[count - 1];
        objLists[count - 1] = null;
        --count;
        return e;
    }

    private boolean checkCapacity() {
        return count == capacity;
    }

    private boolean checkEmpty() {
        return count == 0;
    }

    public Object[] getObjLists() {
        return objLists;
    }
}
