package snailx.app;

import com.alibaba.android.arouter.launcher.ARouter;

import snailx.common.CommonApplication;
import snailx.common.utils.AppUtils;

/**
 * <des>
 *
 * @author YangGang
 * @date 2018/12/27
 */
public class SnailApplication extends CommonApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (AppUtils.isAppDebug()) {
            ARouter.openDebug();
            ARouter.openLog();
            ARouter.printStackTrace();
        }

        ARouter.init(this);
    }

}
