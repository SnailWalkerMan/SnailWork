package snailx.module_basis.unitTest.localJunitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * <des>
 * 用于同时执行多个单元测试类
 * @author YangGang
 * @date 2019/1/4
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, MathHelperTest.class})
public class AllTest {
}
