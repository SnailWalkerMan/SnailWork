package snailx.module_basis.recyclerView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import snailx.common.ui.CommonFragment;
import snailx.module_basis.R;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/17
 */
public class SlideDeleteFragment extends CommonFragment {

    public static SlideDeleteFragment newInstance() {
        return new SlideDeleteFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_slide_delete;
    }

    private List<String> getMockStr() {
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            strs.add("Flag is -> " + i);
        }

        return strs;
    }

    @Override
    protected void init(View view) {
        //先实例化Callback
        SlideDeleteAdapter slideDeleteAdapter = new SlideDeleteAdapter();
        RecyclerView rv = getViewById(R.id.rv);
        rv.setAdapter(slideDeleteAdapter);

        slideDeleteAdapter.inflateDataSource(getMockStr());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallBack(slideDeleteAdapter);
//        //用Callback构造ItemtouchHelper
//        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
//        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
//        touchHelper.attachToRecyclerView(rv);
    }
}
