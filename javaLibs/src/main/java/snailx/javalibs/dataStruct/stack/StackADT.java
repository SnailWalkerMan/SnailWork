package snailx.javalibs.dataStruct.stack;

import snailx.javalibs.dataStruct.PrintHelper;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/21
 */
public class StackADT {

    public static void main(String[] args) {
        testArrayStack();
    }

    private static void testArrayStack() {
        ArrayStack arrayStack = StackMock.mockArrayStack(10);
        PrintHelper.printArray(arrayStack.getObjLists());

        Object pop = arrayStack.pop();
        PrintHelper.printArray(arrayStack.getObjLists());
        arrayStack.pop();
        PrintHelper.printArray(arrayStack.getObjLists());
    }

}
