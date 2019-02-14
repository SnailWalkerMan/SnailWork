package snailx.common.encapsulateRecyclerview.constract;

import android.view.View;

/**
 * <des>
 *
 * @author Jir
 * @date 2018/10/11
 */
public interface OnRVClickListener<E> {

    void onRVClick(View v, E e, int position);
}
