package snailx.common.utils;

import snailx.common.BuildConfig;

/**
 * <des>
 *
 * @author YangGang
 * @date 2018/12/27
 */
public class AppUtils {

    public static boolean isAppDebug() {
        return BuildConfig.DEBUG;
    }
}
