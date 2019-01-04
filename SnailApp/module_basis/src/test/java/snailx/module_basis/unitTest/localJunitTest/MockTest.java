package snailx.module_basis.unitTest.localJunitTest;

import android.test.mock.MockContentProvider;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

/**
 * <des>
 *https://www.cnblogs.com/Ming8006/p/6297333.html
 * @author YangGang
 * @date 2019/1/4
 */
public class MockTest {

    /**
     * 验证行为
     */
    @Test
    public void verifyList() {
        //模拟创建一个List对象
        List mock = Mockito.mock(List.class);
        //使用mock对象
        mock.add(1);
        mock.clear();
        //验证add / clear 是否发生
        Mockito.verify(mock).add(2);
        Mockito.verify(mock).clear();
    }

    /**
     * 模拟行为
     */
    @Test
    public void mockOurExpectedResult() {
        Iterator mock = Mockito.mock(Iterator.class);
        Mockito.when(mock.next()).thenReturn("hello").thenReturn("world");

        String result = mock.next()+" "+mock.next()+" "+mock.next();

        Assert.assertEquals("hello world world",result);
    }

    @Test(expected = IOException.class)
    public void mockException() throws IOException {
        OutputStream mock = Mockito.mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(mock);
        //预设关闭流的时候抛出异常
        Mockito.doThrow(new IOException()).when(mock).close();
        writer.close();
    }
}
