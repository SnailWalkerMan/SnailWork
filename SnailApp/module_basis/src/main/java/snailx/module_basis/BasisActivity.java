package snailx.module_basis;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import snailx.common.ui.CommonActivity;
import snailx.common.ui.CommonFragment;
import snailx.module_basis.recyclerView.SlideDeleteFragment;
import snailx.module_basis.refresh.ui.RefreshFragment;
import snailx.module_basis.selfView.chart.AutoChartFragment;

public class BasisActivity extends CommonActivity implements View.OnClickListener {

    private RecyclerView mRv;
    private BasisAdapter mBasisAdapter;

    private List<BasisBean> mockBasis() {
        List<BasisBean> basisBeanList = new ArrayList<>();

        BasisBean bean;
        for (int i = 0; i < 100; i++) {
            bean = new BasisBean();
            bean.setName("index is " + i);
            basisBeanList.add(bean);
        }
        return basisBeanList;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_basis;
    }

    @Override
    protected void init() {
        mRv = findViewById(R.id.rv);
        mBasisAdapter = new BasisAdapter();
        GridLayoutManager gridLayout = new GridLayoutManager(this, 2);
        mRv.setLayoutManager(gridLayout);
        mRv.setAdapter(mBasisAdapter);
        mBasisAdapter.inflateDataSource(mockBasis());
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mBasisAdapter.closeFromOut();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }

}
