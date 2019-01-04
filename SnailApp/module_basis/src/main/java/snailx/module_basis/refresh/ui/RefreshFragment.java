package snailx.module_basis.refresh.ui;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import snailx.common.ui.CommonFragment;
import snailx.module_basis.R;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/3
 */
public class RefreshFragment extends CommonFragment implements OnRefreshLoadMoreListener {

    private int toValue = 10;
    private int fromValue = 0;
    private int vaiantValue = 10;
    private ArrayAdapter<String> mStringArrayAdapter;
    private List<String> mMockList = new ArrayList<>();
    private SmartRefreshLayout mRefreshLayout;
    private boolean mRefreshState;
    private boolean mLoadMoreState;

    public static RefreshFragment newInstance() {
        return new RefreshFragment();
    }

    private List<String> mockUpdate() {
        Log.d(TAG, "mockUpdate: ");
        ArrayList strings = new ArrayList<>();
        for (; fromValue < toValue; fromValue++) {
            strings.add("up toValue -> " + fromValue);
        }
        toValue += 10;
        if (mRefreshState) {
            mRefreshLayout.finishRefresh();

            mMockList.addAll(0, strings);
            mStringArrayAdapter.notifyDataSetInvalidated();
            mStringArrayAdapter.notifyDataSetChanged();
        } else if (mLoadMoreState) {
            if (toValue > 30) {
                mRefreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                mRefreshLayout.finishLoadMore();
            }
            mMockList.addAll(strings);
            mStringArrayAdapter.notifyDataSetChanged();
        }
        return strings;
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_refresh;
    }

    @Override
    protected void init(View view) {
        mRefreshState = false;
        mLoadMoreState = false;
        mRefreshLayout = getViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshLoadMoreListener(this);
        ListView lv = getViewById(R.id.lv);
        mMockList.addAll(mockUpdate());
        mStringArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mMockList);
        lv.setAdapter(mStringArrayAdapter);

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        Log.d(TAG, "onRefresh: ");
        setRefresh(true);
        mockUpdate();

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        setRefresh(false);
        mockUpdate();
    }

    private void setRefresh(boolean refresh) {
        mLoadMoreState = !refresh;
        mRefreshState = refresh;

//        mRefreshLayout.setEnableLoadMore(!refresh);
//        mRefreshLayout.setEnableRefresh(refresh);
    }
}
