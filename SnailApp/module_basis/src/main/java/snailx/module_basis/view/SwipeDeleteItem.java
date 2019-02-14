package snailx.module_basis.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import snailx.module_basis.R;

/**
 * <des>
 *
 * @author https://blog.csdn.net/REIGE/article/details/70194228
 * @date 2019/1/31
 */
public class SwipeDeleteItem extends FrameLayout {

    private boolean mIsCloseT = true;
    private ViewDragHelper mViewDragHelper;
    private int mSwipeShowFrom;

    @IntDef({SwipeShowFrom.LEFT, SwipeShowFrom.RIGHT})
    @Retention(RetentionPolicy.SOURCE)
    @interface SwipeShowFrom {
        int LEFT = 0;
        int RIGHT = 1;
    }

    private ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            Log.d("Jir", "tryCaptureView: ");
            return child == mContentView || child == mSwipeView;
        }

        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);

            Log.d("Jir", "onViewDragStateChanged: " + state);
        }

        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
            if (changedView == mContentView) {
                Log.d("Jir", "onViewPositionChanged: ContentView");
                mSwipeView.layout(mSwipeView.getLeft() + dx, mSwipeView.getTop() + dy, mSwipeView.getRight() + dx, mSwipeView.getBottom() + dy);
            } else if (changedView == mSwipeView) {
                Log.d("Jir", "onViewPositionChanged: SwipeView");
                mContentView.layout(mContentView.getLeft() + dx, mContentView.getTop() + dy, mContentView.getRight() + dx, mContentView.getBottom() + dy);
            }
        }

        @Override
        public int getViewHorizontalDragRange(@NonNull View child) {
            Log.d("Jir", "getViewHorizontalDragRange: ");
            return mSwipeViewWidth;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            Log.d("Jir", "clampViewPositionHorizontal: " + child);
            if (mSwipeShowFrom == SwipeShowFrom.RIGHT) {
                if (child == mContentView) {
                    if (left > 0) left = 0;
                    if (left < -mSwipeViewWidth) left = -mSwipeViewWidth;
                } else if (child == mSwipeView) {
                    if (left > mContentViewWidth) left = mContentViewWidth;
                    if (left < mContentViewWidth - mSwipeViewWidth)
                        left = mContentViewWidth - mSwipeViewWidth;
                }
            } else {
                if (child == mContentView) {
                    if (left < 0) left = 0;
                    if (left > mSwipeViewWidth) left = mSwipeViewWidth;
                } else if (child == mSwipeView) {
                    if (left > 0) left = 0;
                    if (left < -mSwipeViewWidth)
                        left = -mSwipeViewWidth;
                }
            }
            return left;
        }

        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            Log.d("Jir", "onViewReleased: " + xvel);
            if (releasedChild == mContentView) {
                if (mSwipeShowFrom == SwipeShowFrom.LEFT) {
                    if (releasedChild.getLeft() >= (mSwipeViewWidth >> 1)) {
                        open();
                    } else {
                        close();
                    }
                } else {
                    if (releasedChild.getLeft() > -(mSwipeViewWidth >> 1)) {
                        close();
                    } else {
                        open();
                    }
                }
            }
        }
    };

    private View mContentView, mSwipeView;
    private float mDownX, mDownY, mMoveX, mMoveY;
    private int mContentViewWidth, mContentViewHeight, mSwipeViewWidth, mSwipeViewHeight;

    public SwipeDeleteItem(@NonNull Context context) {
        this(context, null);
    }

    public SwipeDeleteItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeDeleteItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SwipeDeleteItem);
        mSwipeShowFrom = ta.getInt(R.styleable.SwipeDeleteItem_SwipeFrom, 0);
        ta.recycle();
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, mDragCallback);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        assertChildCount();
        mContentView = getChildAt(0);
        mSwipeView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mSwipeViewWidth = mSwipeView.getMeasuredWidth();
        mSwipeViewHeight = mSwipeView.getMeasuredHeight();
        mContentViewWidth = mContentView.getMeasuredWidth();
        mContentViewHeight = mContentView.getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mContentView.layout(0, 0, mContentViewWidth, mContentViewHeight);
        if (mSwipeShowFrom == SwipeShowFrom.LEFT) {
            mSwipeView.layout(-mSwipeViewWidth, 0, 0, mSwipeViewHeight);
        } else if (mSwipeShowFrom == SwipeShowFrom.RIGHT) {
            mSwipeView.layout(mContentViewWidth, 0, mContentViewWidth + mSwipeViewWidth, mSwipeViewHeight);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (SwipeDeleteManager.newSingleton().retainSwipeItemOpen() && !mIsCloseT) {
            SwipeDeleteManager.newSingleton().close();
        }
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    //
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Jir", "onTouchEvent: ");
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    private void assertChildCount() {
        if (getChildCount() != 2) {
            throw new RuntimeException("child count should be 2");
        }
    }

    public void open() {
        Log.d("Jir", "open: ");
        if (mSwipeShowFrom == SwipeShowFrom.RIGHT) {
            mViewDragHelper.smoothSlideViewTo(mContentView, -mSwipeViewWidth, mContentView.getTop());
        } else {
            mViewDragHelper.smoothSlideViewTo(this, mSwipeViewWidth, mContentView.getTop());
        }
        mIsCloseT = false;
        SwipeDeleteManager.newSingleton().updateCloseState(false);
        SwipeDeleteManager.newSingleton().updateCurSwipeItem(this);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void close() {
        Log.d("Jir", "close: " + Log.getStackTraceString(new Throwable()));
        if (mIsCloseT) {
            Log.d("Jir", "close: Already");
            return;
        }
        mIsCloseT = true;
        SwipeDeleteManager.newSingleton().updateCloseState(true);
        mViewDragHelper.smoothSlideViewTo(mContentView, 0, mContentView.getTop());
//        SwipeDeleteManager.newSingleton().updateCurSwipeItem(null);
        ViewCompat.postInvalidateOnAnimation(this);
    }


    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }


}
