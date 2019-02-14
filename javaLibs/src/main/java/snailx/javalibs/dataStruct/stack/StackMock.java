package snailx.javalibs.dataStruct.stack;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/21
 */
public class StackMock {

    public static ArrayStack mockArrayStack(int capacity) {
        ArrayStack<Integer> stackArray = new ArrayStack<>(capacity);
        for (int i = 0; i < capacity; i++) {
            stackArray.push(i);
        }
        return stackArray;
    }
}
