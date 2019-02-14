package snailx.common.encapsulateRecyclerview.constract;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <des>
 *
 * @author Jir
 * @date 2018/10/11
 */

@Retention(RetentionPolicy.SOURCE)
@StringDef({RVExceptionRule.NULL_VIEWHOLDER, RVExceptionRule.EMPTY,
        RVExceptionRule.FOOT_HEAD, RVExceptionRule.EMPTY_VIEW,
        RVExceptionRule.CLASS_ERROR, RVExceptionRule.VIEW_TYPE_CONFLICT})
public @interface RVExceptionRule {

    String NULL_VIEWHOLDER = "Null ViewHolder : ";
    String EMPTY = "Empty ViewType : ";
    String FOOT_HEAD = "Your viewType is duplicate with 0 or 1,pls redefine your viewType";
    String EMPTY_VIEW = "you should set view first";
    String CLASS_ERROR = "class type error";
    String VIEW_TYPE_CONFLICT = "View Type Conflict: view type should between "
            + RVViewType.EMPTY + " ~ " + RVViewType.OTHER;
}
