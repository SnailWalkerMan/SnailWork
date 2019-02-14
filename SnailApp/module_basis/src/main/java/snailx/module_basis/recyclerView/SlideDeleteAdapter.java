package snailx.module_basis.recyclerView;


import java.util.Collections;

import snailx.common.encapsulateRecyclerview.AbsRVAdapter;
import snailx.common.encapsulateRecyclerview.RVHolder;
import snailx.module_basis.R;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/17
 */
public class SlideDeleteAdapter extends AbsRVAdapter<String> implements ItemTouchHelperAdapter {


    @Override
    protected int inflateLayout(int viewType) {
        return R.layout.item_text;
    }

    @Override
    protected void bindRVHolder(RVHolder rvHolder, String e, int position) {
//        rvHolder.setRVText(R.id.tvName, e);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(getDataSource(), fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDissmiss(int position) {
        removeItemAtIndex(position);
    }
}
