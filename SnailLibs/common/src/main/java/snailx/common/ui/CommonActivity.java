package snailx.common.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * <des>
 *
 * @author YangGang
 * @date 2018/12/27
 */
public abstract class CommonActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        init();
    }

    protected abstract int getLayoutRes();

    protected abstract void init();
}
