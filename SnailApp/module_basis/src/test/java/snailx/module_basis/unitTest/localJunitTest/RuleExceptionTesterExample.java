package snailx.module_basis.unitTest.localJunitTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/4
 */
public class RuleExceptionTesterExample {

    @Rule
    public ExpectedException mException=ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionIfIconIsNull() {
        mException.expect(IllegalArgumentException.class);
        mException.expectMessage("Negative value not allowed");
        ClassToBeTested t = new ClassToBeTested();
        t.methodToBeTest(-1);
    }

    class ClassToBeTested{
        void methodToBeTest(int value) {
            if (value == -1) {
                throw new IllegalArgumentException("Negative value not allowed");
            }
        }
    }
}
