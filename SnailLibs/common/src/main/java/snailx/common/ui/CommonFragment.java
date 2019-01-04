package snailx.common.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <des>
 *
 * @author YangGang
 * @date 2018/12/27
 */
public abstract class CommonFragment extends Fragment {

    public static final String TAG="Fragment";

    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindRootView(view);
        init(view);
    }

    private void bindRootView(View view) {
        this.mRootView = view;
    }

    protected <T extends View> T getViewById(@IdRes int viewId) {
        if (mRootView == null) throw new NullPointerException();
        return mRootView.findViewById(viewId);
    }

    protected abstract int getLayoutRes();

    protected abstract void init(View view);
}
