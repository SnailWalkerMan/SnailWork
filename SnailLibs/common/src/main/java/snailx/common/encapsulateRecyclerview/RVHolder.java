package snailx.common.encapsulateRecyclerview;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import snailx.common.encapsulateRecyclerview.constract.RVVisibility;

/**
 * <pre>
 *  author : Jir
 *  date : 2018/8/9
 *  description :
 * </pre>
 */
public class RVHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViewContainer;
    private Context mContext;

    public RVHolder(View itemView) {
        super(itemView);
        this.mContext = itemView.getContext();
        mViewContainer = new SparseArray<>();
    }

    public static RVHolder newHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
        return new RVHolder(rootView);
    }

    public <T extends View> T getRVViewByID(@IdRes int id) {
        View view = mViewContainer.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mViewContainer.put(id, view);
        }
        return (T) view;
    }

    public RVHolder setRVText(@IdRes int resId, String text) {
        TextView view = getRVViewByID(resId);
        view.setText(text);
        return this;
    }

    public RVHolder setRVText(@IdRes int resId, String text, @ColorInt int color) {
        TextView view = getRVViewByID(resId);
        view.setTextColor(color);
        view.setText(text);
        return this;
    }

    public RVHolder setRVImage(@IdRes int viewId, @DrawableRes Integer imageId) {
        ImageView view = getRVViewByID(viewId);
        view.setImageResource(imageId);
        return this;
    }

//    public RVHolder setRVImageWithLoader(@IdRes int viewId, @DrawableRes Integer imgId) {
//        ImageLoader.with(mContext)
//                .loadImgInto(imgId, (ImageView) getRVViewByID(viewId));
//        return this;
//    }
//
//    public RVHolder setRVImageWithLoader(@IdRes int viewId, String imagUrl) {
//        ImageLoader.with(mContext)
//                .loadImgInto(imagUrl, (ImageView) getRVViewByID(viewId));
//        return this;
//    }

    public RVHolder setRVViewClickListener(@IdRes int viewId, View.OnClickListener listener) {
        View view = getRVViewByID(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public RVHolder setRVHolderClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
        return this;
    }

    public RVHolder setRVCheck(@IdRes int viewId, boolean isChecked) {
        this.setRVViewCheckListener(viewId, isChecked, null);
        return this;
    }

    public RVHolder setRVViewCheckListener(@IdRes int viewId, boolean isChecked, CompoundButton.OnCheckedChangeListener listener) {
        CheckBox checkBox = getRVViewByID(viewId);
        checkBox.setChecked(isChecked);
        if (listener != null) {
            checkBox.setOnCheckedChangeListener(listener);
        }
        return this;
    }

    public RVHolder setRVRadioButton(@IdRes int viewId, boolean isChecked, boolean isClickable) {
        RadioButton view = getRVViewByID(viewId);
        view.setClickable(isClickable);
        view.setChecked(isChecked);
        return this;
    }

    public RVHolder setRVViewVisibility(@IdRes int viewId, @RVVisibility int visibility) {
        View view = getRVViewByID(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public RVHolder setRVViewVisibility(@IdRes int viewId, boolean visibleTF) {
        setRVViewVisibility(viewId, visibleTF ? RVVisibility.VISIBLE : RVVisibility.GONE);
        return this;
    }
}
