package snailx.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import snailx.ui.R;


/**
 * <pre>
 *  author : Jir
 *  date : 2018/7/3
 *  description : webchat bottom
 * </pre>
 */
public class TabLayout extends LinearLayout implements View.OnClickListener {

    private OnTabClickListener mOnTabClickListener;
    private View lastSelectView = null;
    private ViewPager mViewPager;
    private int mSelectIndex;
    private boolean mVPScrollableTF = false;

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    private void initView(Context context) {
        setOrientation(HORIZONTAL);
    }

    private void setSelectIndex(int selectIndex) {
        if (selectIndex < 0 || selectIndex >= getChildCount()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(selectIndex));
        }
        this.mSelectIndex = selectIndex;
        View childAt = getChildAt(selectIndex);
        if (childAt != null) {
            changeTabState(childAt);
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + getChildCount();
    }

    public void showTabView(SparseArray<TabItem> tabItemSparseArray) {
        showTabView(tabItemSparseArray, 0);
    }

    public void showTabView(SparseArray<TabItem> tabItemSparseArray, int selectIndex) {
        if (tabItemSparseArray == null || tabItemSparseArray.size() <= 0) {
            throw new IllegalArgumentException("tabItem should not be empty");
        }
        LayoutParams layoutParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        TabView tabView = null;
        TabItem tabItem = null;
        for (int i = 0, n = tabItemSparseArray.size(); i < n; i++) {
            tabView = new TabView(getContext());
            tabItem = tabItemSparseArray.get(i);
            tabView.setTag(tabItem);
            tabView.setId(i);
            tabView.initData(tabItem);
            tabView.setOnClickListener(this);

            attachViewToParent(tabView, i, layoutParams);
//            addView(tabView, layoutParams);
        }

        setSelectIndex(selectIndex);
    }

    public void setupWithViewPage(ViewPager viewPager, boolean vpScrollable) {
        this.mViewPager = viewPager;
        if (vpScrollable) {
            this.mVPScrollableTF = vpScrollable;
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    setSelectIndex(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
        mViewPager.setCurrentItem(mSelectIndex);
    }

    public void setOnTabClickListener(OnTabClickListener listener) {
        this.mOnTabClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        changeTabState(v);
        if (mOnTabClickListener != null) {
            mOnTabClickListener.onTabClick((TabItem) v.getTag(), v.getId());
        }
    }

    private void changeTabState(View v) {
        if (v == lastSelectView) {
            return;
        }
        if (lastSelectView != null) {
            lastSelectView.setSelected(false);
        }
        v.setSelected(true);
        lastSelectView = v;
        if (mViewPager != null) {
            mViewPager.setCurrentItem(v.getId(), false);
        }
    }

    public class TabView extends LinearLayout {
        private ImageView mTabIconIV;
        private TextView mTabLableTV;

        public TabView(Context context) {
            this(context, null);
        }

        public TabView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);

            initView(context);
        }

        private void initView(Context context) {
            setOrientation(VERTICAL);
            setGravity(Gravity.CENTER);

            LayoutInflater.from(context).inflate(R.layout.widget_tab_view, this);

            mTabIconIV = findViewById(R.id.ivTabIcon);
            mTabLableTV = findViewById(R.id.tvTabLable);
        }

        public void initData(TabItem tabItem) {
            mTabIconIV.setImageResource(tabItem.iconResId);
            mTabLableTV.setText(tabItem.lableResId);
        }
    }

    public static class TabItem {

        public int iconResId;
        public int lableResId;

        public TabItem(int iconResId, int lableResId) {
            this.iconResId = iconResId;
            this.lableResId = lableResId;
        }
    }

    public interface OnTabClickListener {

        void onTabClick(TabItem tabItem, int position);
    }
}
