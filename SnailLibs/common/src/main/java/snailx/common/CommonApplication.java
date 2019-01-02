package snailx.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * <des>
 *
 * @author YangGang
 * @date 2018/12/27
 */
public class CommonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
