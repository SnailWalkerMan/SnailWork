package snailx.module_basis.recyclerView;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/17
 */
public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition, int toPosition);

    //数据删除
    void onItemDissmiss(int position);
}
