package snailx.common.ui;

import android.os.Bundle;
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
public abstract class CommonLazyFragment extends Fragment {
    protected View rootView;
    protected boolean hasFetchDataTF = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            preFetchData();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayouResId(), container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onBindView(view);
        preFetchData();
    }

    private void preFetchData() {
        if (rootView != null && getUserVisibleHint() && !hasFetchDataTF) {
            fetchData();
            hasFetchDataTF = true;
        }
    }

    @Override
    public void onDestroy() {
        recycle();
        hasFetchDataTF = false;
        super.onDestroy();
        rootView = null;
    }

    protected <T extends View> T getViewById(int resId) {
        return (T) rootView.findViewById(resId);
    }

    protected void onBindView(View view) {
    }

    protected abstract int getLayouResId();

    protected abstract void fetchData();

    protected abstract void recycle();
}
