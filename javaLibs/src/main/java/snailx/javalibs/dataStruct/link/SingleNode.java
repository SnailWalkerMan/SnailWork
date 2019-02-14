package snailx.javalibs.dataStruct.link;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/18
 */
public class SingleNode<T> {

    public T t;
    public SingleNode<T> mNextNode;

    public SingleNode(T t) {
        this.t = t;
    }
}
