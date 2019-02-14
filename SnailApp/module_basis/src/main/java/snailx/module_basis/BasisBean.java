package snailx.module_basis;

import android.support.annotation.IdRes;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/31
 */
public class BasisBean {

    private @IdRes
    int resId;
    private String name;

    public BasisBean() {
        name = "N/A";
        resId = R.drawable.ic_stars_black_24dp;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
