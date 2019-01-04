package snailx.module_basis.unitTest.localJunitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/4
 */
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        printInfo("Set Up is Called");
        mCalculator = new Calculator();
    }

    @Test
    public void add() {
        printInfo("add");
        assertEquals("add answer ",mCalculator.add(1,1),3);
    }

    @Test
    public void divider() {
        printInfo("divider");
        assertEquals("divider answer ",mCalculator.divider(8,2),5);
    }

    private void printInfo(String info) {
        System.out.println(info);
    }
}