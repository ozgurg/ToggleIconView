package og.android.lib.toggleiconview

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

abstract class ToggleIconView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
    @DrawableRes checkedDrawableResId: Int,
    @DrawableRes uncheckedDrawableResId: Int,
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private lateinit var mCheckedDrawable: AnimatedVectorDrawableCompat
    private lateinit var mUncheckedDrawable: AnimatedVectorDrawableCompat

    private var mCheckedContentDescription: String? = null
    private var mUncheckedContentDescription: String? = null

    private var mCheckedTooltipText: String? = null
    private var mUncheckedTooltipText: String? = null

    private var mIsChecked: Boolean = false

    private var mOnCheckedChangeListener: ((view: ToggleIconView, isChecked: Boolean) -> Unit)? = null

    init {
        createAndSetCheckedDrawable(checkedDrawableResId)
        createAndSetUncheckedDrawable(uncheckedDrawableResId)
        handleAttributes(attrs, defStyleAttr)
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

    private fun setCheckStateAndAnimateDrawable(isChecked: Boolean) {
        setAndAnimateDrawableByCheckState(isChecked)
        mIsChecked = isChecked
    }

    private fun setAndAnimateDrawableByCheckState(isChecked: Boolean) {
        if (isChecked) {
            setAndAnimateCheckedDrawable()
        } else {
            setAndAnimateUncheckedDrawable()
        }
    }

    private fun setContentDescriptionByCheckState(isChecked: Boolean) {
        contentDescription = if (isChecked) {
            mCheckedContentDescription
        } else {
            mUncheckedContentDescription
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setTooltipTextByCheckState(isChecked: Boolean) {
        tooltipText = if (isChecked) {
            mCheckedTooltipText
        } else {
            mUncheckedTooltipText
        }
    }

    private fun handleAttributes(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ToggleIconView,
            defStyleAttr,
            0
        )

        try {
            // app:checked
            val checked = typedArray.getBoolean(R.styleable.ToggleIconView_checked, mIsChecked)

            // app:checkedContentDescription
            val checkedContentDescription = typedArray.getString(R.styleable.ToggleIconView_checkedContentDescription)
            mCheckedContentDescription = checkedContentDescription

            // app:uncheckedContentDescription
            val uncheckedContentDescription = typedArray.getString(R.styleable.ToggleIconView_uncheckedContentDescription)
            mUncheckedContentDescription = uncheckedContentDescription

            // app:checkedTooltipText
            val checkedTooltipText = typedArray.getString(R.styleable.ToggleIconView_checkedTooltipText)
            mCheckedTooltipText = checkedTooltipText

            // app:uncheckedTooltipText
            val uncheckedTooltipText = typedArray.getString(R.styleable.ToggleIconView_uncheckedTooltipText)
            mUncheckedTooltipText = uncheckedTooltipText

            handleCheckStateChange(checked)
        } finally {
            typedArray.recycle()
        }
    }

    private fun handleCheckStateChange(isChecked: Boolean) {
        setCheckStateAndAnimateDrawable(isChecked)
        setContentDescriptionByCheckState(isChecked)
        setTooltipTextByCheckState(isChecked)
    }

    private fun invokeOnCheckedChangeListener(isChecked: Boolean) {
        mOnCheckedChangeListener?.invoke(this, isChecked)
    }

    private fun isStateSame(previousState: Boolean, currentState: Boolean): Boolean {
        return previousState == currentState
    }

    fun toggle() {
        isChecked = !isChecked
    }

    var checkedContentDescription: String?
        get() = mCheckedContentDescription
        set(value) {
            mCheckedContentDescription = value
        }

    var uncheckedContentDescription: String?
        get() = mUncheckedContentDescription
        set(value) {
            mUncheckedContentDescription = value
        }

    var checkedTooltipText: String?
        get() = mCheckedTooltipText
        set(value) {
            mCheckedTooltipText = value
        }

    var uncheckedTooltipText: String?
        get() = mUncheckedTooltipText
        set(value) {
            mUncheckedTooltipText = value
        }

    var isChecked: Boolean
        get() = mIsChecked
        set(isChecked) {
            // We do not update the state if the state is the same as the current state
            // to prevent the animation from restarting when the state is set again
            if (isStateSame(isChecked, mIsChecked)) {
                return
            }

            handleCheckStateChange(isChecked)

            invokeOnCheckedChangeListener(isChecked)
        }

    open fun setOnCheckedChangeListener(listener: (view: ToggleIconView, isChecked: Boolean) -> Unit) {
        mOnCheckedChangeListener = listener
    }
}