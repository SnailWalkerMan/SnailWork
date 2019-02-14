package snailx.common.encapsulateRecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import snailx.common.encapsulateRecyclerview.constract.OnRVClickListener;
import snailx.common.encapsulateRecyclerview.constract.RVException;
import snailx.common.encapsulateRecyclerview.constract.RVExceptionRule;
import snailx.common.encapsulateRecyclerview.constract.RVViewType;

/**
 * <des>
 *
 * @author Jir
 * @date 2018/10/11
 */
public abstract class AbsRVAdapter<T> extends RecyclerView.Adapter<RVHolder> {

    protected List<T> mTList = new ArrayList<>();
    protected OnRVClickListener<T> mOnRvClickListener;

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        isValidViewType(viewType);
        return RVHolder.newHolder(parent, inflateLayout(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder rvHolder, int position) {
        bindRVHolder(rvHolder, mTList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mTList.size();
    }

    /**
     * update recyclerview must call this method again
     *
     * @param list
     */
    public void inflateDataSource(List<T> list) {
        if (list != null) {
            clearOldData();
            addNewData(list);
        }
    }

    /**
     * update recyclerview can call {@link #notifyItemRangeChanged(int, int)}
     *
     * @param list
     */
    public void inflateReference(List<T> list) {
        if (list != null) {
            clearOldData();
            updateDataReference(list);
        }
    }

    protected void removeItemAtIndex(int pos) {
        if (mTList != null) {
            mTList.remove(pos);
            notifyItemRemoved(pos);
        }
    }

    public List<T> getDataSource() {
        return mTList;
    }

    private void clearOldData() {
        if (getItemCount() != 0) {
            int preSize = getItemCount();
            mTList.clear();
            notifyItemRangeRemoved(0, preSize);
        }
    }

    private void addNewData(List<T> list) {
        mTList.addAll(list);
        notifyItemRangeChanged(0, getItemCount());
    }

    private void updateDataReference(List<T> list) {
        mTList = list;
        notifyItemRangeChanged(0, getItemCount());
    }

    public void setOnRvClickListener(OnRVClickListener<T> listener) {
        this.mOnRvClickListener = listener;
    }

    private void isValidViewType(int viewType) {
        if (viewType >= RVViewType.EMPTY && viewType <= RVViewType.OTHER) {
            throw new RVException(RVExceptionRule.VIEW_TYPE_CONFLICT + " Your view Type is " + viewType);
        }
    }

    protected abstract int inflateLayout(int viewType);

    protected abstract void bindRVHolder(RVHolder rvHolder, T e, int position);

}