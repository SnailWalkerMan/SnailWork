package snailx.javalibs.dataStruct;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/21
 */
public class PrintHelper {

    public static void printArray(Object[] obj) {
        System.out.println("Array Value List is : ");
        for (int i = 0, n = obj.length; i < n; i++) {
            System.out.print(obj[i] + "  ");
        }
        System.out.println();
    }
}
