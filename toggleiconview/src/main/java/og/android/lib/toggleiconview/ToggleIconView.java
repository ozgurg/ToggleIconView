package og.android.lib.toggleiconview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public abstract class ToggleIconView extends AppCompatImageView {
    private AnimatedVectorDrawableCompat mCheckedDrawable, mUncheckedDrawable;
    private boolean mIsChecked;

    public ToggleIconView(Context context) {
        super(context, null);
    }

    public ToggleIconView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ToggleIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setChecked(boolean isChecked) {
        setDrawable(isChecked);
        mIsChecked = isChecked;
    }

    public void toggle() {
        setChecked(!mIsChecked);
    }

    public boolean isChecked() {
        return mIsChecked;
    }

    private void handleCheckedState() {
        setImageDrawable(mCheckedDrawable);
        mCheckedDrawable.start();
    }

    private void handleUncheckedState() {
        setImageDrawable(mUncheckedDrawable);
        mUncheckedDrawable.start();
    }

    private void setDrawable(boolean isChecked) {
        if (isChecked) {
            handleCheckedState();
        } else {
            handleUncheckedState();
        }
    }

    protected void setCheckedDrawable(int checkedDrawableRes) {
        mCheckedDrawable = AnimatedVectorDrawableCompat.create(getContext(), checkedDrawableRes);
        setImageDrawable(mCheckedDrawable);
    }

    protected void setUncheckedDrawable(int uncheckedDrawableRes) {
        mUncheckedDrawable = AnimatedVectorDrawableCompat.create(getContext(), uncheckedDrawableRes);
    }
}