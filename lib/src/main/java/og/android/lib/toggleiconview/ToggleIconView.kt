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
        setCheckedDrawable(checkedDrawableResId)
        setUncheckedDrawable(uncheckedDrawableResId)
        handleAttributes(attrs, defStyleAttr)
    }

    private fun setCheckedDrawable(@DrawableRes checkedDrawableResId: Int) {
        mCheckedDrawable = AnimatedVectorDrawableCompat.create(context, checkedDrawableResId)!!
    }

    private fun setUncheckedDrawable(@DrawableRes uncheckedDrawableResId: Int) {
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

    fun toggle() {
        isChecked = !isChecked
    }

    var isChecked: Boolean
        get() = mIsChecked
        set(isChecked) {
            // We will not update the state if the state is the same as the current state
            // This is to prevent the animation from restarting when the state is set again
            if (isChecked == mIsChecked) {
                return
            }

            handleCheckState(isChecked)
            mOnCheckedChangeListener?.invoke(this, isChecked)
        }

    open fun setOnCheckedChangeListener(listener: (view: ToggleIconView, isChecked: Boolean) -> Unit) {
        mOnCheckedChangeListener = listener
    }
}