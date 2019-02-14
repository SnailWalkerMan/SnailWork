package snailx.common.encapsulateRecyclerview.constract;

import android.support.annotation.IntDef;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static snailx.common.encapsulateRecyclerview.constract.RVVisibility.GONE;
import static snailx.common.encapsulateRecyclerview.constract.RVVisibility.INVISIBLE;
import static snailx.common.encapsulateRecyclerview.constract.RVVisibility.VISIBLE;

/**
 * <des>
 *
 * @author Jir
 * @date 2018/10/11
 */
@IntDef({VISIBLE, INVISIBLE, GONE})
@Retention(RetentionPolicy.SOURCE)
public @interface RVVisibility {
    int VISIBLE = View.VISIBLE;
    int INVISIBLE = View.INVISIBLE;
    int GONE = View.GONE;
}
