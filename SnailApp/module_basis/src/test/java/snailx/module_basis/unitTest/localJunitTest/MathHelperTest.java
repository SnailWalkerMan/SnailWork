package snailx.module_basis.unitTest.localJunitTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/4
 */
public class MathHelperTest {

    private MathHelper mMathHelper;

    @Before
    public void setUp() throws Exception {
        mMathHelper = new MathHelper();
    }

    @Test
    public void minus() {
        assertEquals("minus", mMathHelper.minus(10, 4), 6);
    }

    @Test
    public void multipy() {
        assertEquals("multipy", mMathHelper.multipy(2, 3), 6);
    }
}