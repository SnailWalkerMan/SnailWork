package snailx.common.encapsulateRecyclerview.constract;

/**
 * <des>
 * ViewType规定
 * head-->0
 * foot-->1
 * 其它ViewType必须从5开始定义
 * </des>
 *
 * @author Jir
 * @date 2018/10/12
 */
public interface RVViewType {
    int DEFAULT = 0;
    int EMPTY = 1;
    int HEAD = 2;
    int FOOT = 3;
    int LOAD_MORE = 4;
    int UP_FETCH = 5;
    int OTHER = 6;
}
