package snailx.module_basis.unitTest.localJunitTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

/**
 * <des>
 * 这个测试有误
 *
 * @author YangGang
 * @date 2019/1/4
 */
@RunWith(Parameterized.class)
public class ParameterizedTestFields {
    @Parameter(1) //这个annotation有问题
    public int m1;
    @Parameter(0)
    public int m2;
    @Parameter(2)
    public int result;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.asList(data);
    }

    @Test
    public void testMultiplyException() {
        MyClass tester = new MyClass();
        System.out.println(m1 + " / " + m2 + " / " + result);
        assertEquals("Result", result, tester.multiply(m1, m2));
    }


    // class to be tested
    class MyClass {
        public int multiply(int i, int j) {
            return i * j;
        }
    }
}