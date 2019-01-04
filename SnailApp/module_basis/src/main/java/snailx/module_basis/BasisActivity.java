package snailx.module_basis;

import android.view.View;

import snailx.common.ui.CommonActivity;
import snailx.module_basis.refresh.ui.RefreshFragment;

public class BasisActivity extends CommonActivity implements View.OnClickListener {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_basis;
    }

    @Override
    protected void init() {
        findViewById(R.id.btnRefresh).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if (vId == R.id.btnRefresh) {
            replaceFragment();
        }
    }

    private void replaceFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, RefreshFragment.newInstance())
                .commitAllowingStateLoss();
    }
}
