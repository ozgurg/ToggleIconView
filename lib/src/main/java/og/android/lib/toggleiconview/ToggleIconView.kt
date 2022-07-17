package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

abstract class ToggleIconView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
    @DrawableRes checkedDrawableResId: Int,
    @DrawableRes uncheckedDrawableResId: Int,
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private lateinit var mCheckedDrawable: AnimatedVectorDrawableCompat
    private lateinit var mUncheckedDrawable: AnimatedVectorDrawableCompat

    private var mIsChecked: Boolean = false
    private var mOnCheckedChangeListener: ((view: ToggleIconView, isChecked: Boolean) -> Unit)? = null

    init {
        createAndSetCheckedDrawable(checkedDrawableResId)
        createAndSetUncheckedDrawable(uncheckedDrawableResId)
        handleAttributes(attrs, defStyleAttr)
    }

    open fun setOnCheckedChangeListener(listener: (view: ToggleIconView, isChecked: Boolean) -> Unit) {
        mOnCheckedChangeListener = listener
    }

    private fun createAndSetCheckedDrawable(@DrawableRes checkedDrawableResId: Int) {
        mCheckedDrawable = AnimatedVectorDrawableCompat.create(context, checkedDrawableResId)!!
    }

    private fun createAndSetUncheckedDrawable(@DrawableRes uncheckedDrawableResId: Int) {
        mUncheckedDrawable = AnimatedVectorDrawableCompat.create(context, uncheckedDrawableResId)!!
    }

    private fun setAndAnimateCheckedDrawable() {
        setImageDrawable(mCheckedDrawable)
        mCheckedDrawable.start()
    }

    private fun setAndAnimateUncheckedDrawable() {
        setImageDrawable(mUncheckedDrawable)
        mUncheckedDrawable.start()
    }

    private fun setAndAnimateDrawableByCheckState(isChecked: Boolean) {
        if (isChecked) {
            setAndAnimateCheckedDrawable()
        } else {
            setAndAnimateUncheckedDrawable()
        }
    }

    private fun handleCheckState(isChecked: Boolean) {
        setAndAnimateDrawableByCheckState(isChecked)
        mIsChecked = isChecked
    }

    private fun handleAttributes(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ToggleIconView, defStyleAttr, 0)

        try {
            // app:checked
            val checked = typedArray.getBoolean(R.styleable.ToggleIconView_checked, mIsChecked)


            handleCheckState(checked)
        } finally {
            typedArray.recycle()
        }
    }

    private fun invokeOnCheckedChangeListener(isChecked: Boolean) {
        mOnCheckedChangeListener?.invoke(this, isChecked)
    }

    private fun isStateSame(previous: Boolean, current: Boolean): Boolean {
        return previous == current
    }

    fun toggle() {
        isChecked = !isChecked
    }

    var isChecked: Boolean
        get() = mIsChecked
        set(isChecked) {
            // We do not update the state if the state is the same as the current state
            // to prevent the animation from restarting when the state is set again
            if (isStateSame(isChecked, mIsChecked)) {
                return
            }

            handleCheckState(isChecked)
            invokeOnCheckedChangeListener(isChecked)
        }
}