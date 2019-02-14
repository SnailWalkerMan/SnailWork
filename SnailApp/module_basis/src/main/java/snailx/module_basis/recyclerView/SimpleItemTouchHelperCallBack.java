package snailx.module_basis.recyclerView;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import snailx.common.encapsulateRecyclerview.RVHolder;
import snailx.module_basis.R;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/17
 */
public class SimpleItemTouchHelperCallBack extends ItemTouchHelper.Callback {

    private SlideDeleteAdapter mSlideDeleteAdapter;
    private int fixWidth = 150;
    private double ICON_MAX_SIZE = 50;
    public static final String TAG = "Jir";

    public SimpleItemTouchHelperCallBack(SlideDeleteAdapter adapter) {
        this.mSlideDeleteAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Log.d(TAG, "getMovementFlags: ");
        int drawgFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(drawgFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Log.d(TAG, "onMove: ");
        mSlideDeleteAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
        Log.d(TAG, "onSwiped: ");
//
//        ((RVHolder)viewHolder).getRVViewByID(R.id.tvDelete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        mSlideDeleteAdapter.onItemDissmiss(viewHolder.getAdapterPosition());
//            }
//        });
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        Log.d(TAG, "onSelectedChanged: "+actionState);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        Log.d(TAG, "clearView: ");
        
        viewHolder.itemView.setScrollX(0);
//        TextView deleteView = ((RVHolder) viewHolder).getRVViewByID(R.id.tvDelete);
//        deleteView.setText("左右删除");
//        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) deleteView.getLayoutParams();
//        params.width = 150;
//        params.height = 150;
//        ImageView deleteIV = ((RVHolder) viewHolder).getRVViewByID(R.id.ivDelete);
//        deleteIV.setLayoutParams(params);
//        deleteIV.setVisibility(View.INVISIBLE);

    }

//    @Override
//    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        //仅对侧滑状态下的效果做出改变
//        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//            //如果dX小于等于删除方块的宽度，那么我们把该方块滑出来
//            if (Math.abs(dX) <= getSlideLimitation(viewHolder)) {
//                viewHolder.itemView.scrollTo(-(int) dX, 0);
//            }
//            //如果dX还未达到能删除的距离，此时慢慢增加“眼睛”的大小，增加的最大值为ICON_MAX_SIZE
//            else if (Math.abs(dX) <= recyclerView.getWidth() / 2) {
//                double distance = (recyclerView.getWidth() / 2 - getSlideLimitation(viewHolder));
//                double factor = ICON_MAX_SIZE / distance;
//                double diff = (Math.abs(dX) - getSlideLimitation(viewHolder)) * factor;
//                if (diff >= ICON_MAX_SIZE)
//                    diff = ICON_MAX_SIZE;
//                ((RVHolder) viewHolder).setRVText(R.id.tvDelete, "---delete----");   //把文字去掉
//                ImageView deleteIV = ((RVHolder) viewHolder).getRVViewByID(R.id.ivDelete);
//                deleteIV.setVisibility(View.VISIBLE);  //显示眼睛
//                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) deleteIV.getLayoutParams();
//                params.width = (int) (fixWidth + diff);
//                params.height = (int) (fixWidth + diff);
//                deleteIV.setLayoutParams(params);
//            }
//        } else {
//            //拖拽状态下不做改变，需要调用父类的方法
//            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//        }
//
//    }

    /**
     * 获取删除方块的宽度
     */
    public int getSlideLimitation(RecyclerView.ViewHolder viewHolder) {
        ViewGroup viewGroup = (ViewGroup) viewHolder.itemView;
        return viewGroup.getChildAt(1).getLayoutParams().width;
    }

}
