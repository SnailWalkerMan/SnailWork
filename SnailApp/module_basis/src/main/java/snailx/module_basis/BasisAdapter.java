package snailx.module_basis;

import android.view.View;
import android.widget.Toast;

import snailx.common.encapsulateRecyclerview.AbsRVAdapter;
import snailx.common.encapsulateRecyclerview.RVHolder;
import snailx.module_basis.view.SwipeDeleteItem;
import snailx.module_basis.view.SwipeDeleteManager;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/31
 */
public class BasisAdapter extends AbsRVAdapter<BasisBean> {

    private SwipeDeleteItem mDeleteItem;

    @Override
    protected int inflateLayout(int viewType) {
        return R.layout.item_basis;
    }

    @Override
    protected void bindRVHolder(final RVHolder rvHolder, BasisBean e, final int position) {
        mDeleteItem = rvHolder.getRVViewByID(R.id.slide_delete);
        rvHolder.setRVText(R.id.tvItem, e.getName())
                .setRVViewClickListener(R.id.layout_content, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(rvHolder.itemView.getContext(), "Content at " + position, Toast.LENGTH_SHORT).show();
                    }
                })
                .setRVViewClickListener(R.id.layout_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(rvHolder.itemView.getContext(), "Delete at " + position, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void closeFromOut() {
        SwipeDeleteManager.newSingleton().close();
    }
}
