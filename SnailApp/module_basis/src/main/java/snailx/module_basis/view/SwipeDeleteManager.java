package snailx.module_basis.view;

import android.util.Log;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/31
 */
public class SwipeDeleteManager {

    private boolean mHasClosed = true;
    private SwipeDeleteItem mSwipeDeleteItem;

    interface Holder {
        SwipeDeleteManager sINSTANCE = new SwipeDeleteManager();
    }

    private SwipeDeleteManager() {
    }

    public static SwipeDeleteManager newSingleton() {
        return Holder.sINSTANCE;
    }

    public void updateCurSwipeItem(SwipeDeleteItem item) {
        if (mSwipeDeleteItem != item) {
            close();
            mSwipeDeleteItem = item;
        }
    }

    public boolean retainSwipeItemOpen() {
        return mSwipeDeleteItem != null && !mHasClosed;
    }

    public void updateCloseState(boolean hasClosed) {
        mHasClosed = hasClosed;
    }

    public boolean retainThisSwipeItemOpen(SwipeDeleteItem item) {
        return retainSwipeItemOpen() && mSwipeDeleteItem == item;
    }


    public void close() {
        Log.d("Jir", "close: " + mSwipeDeleteItem);
        if (retainSwipeItemOpen()) {
            mSwipeDeleteItem.close();
        }
    }
}
