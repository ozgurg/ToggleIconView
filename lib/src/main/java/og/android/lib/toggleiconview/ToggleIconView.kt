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
    private lateinit var checkedDrawable: AnimatedVectorDrawableCompat
    private lateinit var uncheckedDrawable: AnimatedVectorDrawableCompat

    private var isChecked: Boolean = false
    private var onCheckedChangeListener: ((toggleIconView: ToggleIconView, isChecked: Boolean) -> Unit)? = null

    init {
        setCheckedDrawable(checkedDrawableResId)
        setUncheckedDrawable(uncheckedDrawableResId)
        handleAttributes(attrs, defStyleAttr)
    }

    private fun setCheckedDrawable(@DrawableRes drawableResId: Int) {
        checkedDrawable = AnimatedVectorDrawableCompat.create(context, drawableResId)!!
    }

    private fun setUncheckedDrawable(@DrawableRes drawableResId: Int) {
        uncheckedDrawable = AnimatedVectorDrawableCompat.create(context, drawableResId)!!
    }

    private fun setAndAnimateCheckedDrawable() {
        setImageDrawable(checkedDrawable)
        checkedDrawable.start()
    }

    private fun setAndAnimateUncheckedDrawable() {
        setImageDrawable(uncheckedDrawable)
        uncheckedDrawable.start()
    }

    private fun setAndAnimateDrawableByCheckState(checked: Boolean) {
        if (checked) {
            setAndAnimateCheckedDrawable()
        } else {
            setAndAnimateUncheckedDrawable()
        }
    }

    private fun handleCheckState(checked: Boolean) {
        setAndAnimateDrawableByCheckState(checked)
        isChecked = checked
    }

    private fun handleAttributes(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ToggleIconView, defStyleAttr, 0)

        try {
            // app:checked
            val checked = typedArray.getBoolean(R.styleable.ToggleIconView_checked, isChecked)

            handleCheckState(checked)
        } finally {
            typedArray.recycle()
        }
    }

    fun toggle() {
        setChecked(!isChecked)
    }

    fun isChecked(): Boolean {
        return isChecked
    }

    fun setChecked(checked: Boolean) {
        // We won't update the status if the status is the same as the current status
        // This is to prevent the animation from restarting when the state is set again
        if (checked == isChecked) {
            return
        }

        handleCheckState(checked)
        onCheckedChangeListener?.invoke(this, checked)
    }

    open fun setOnCheckedChangeListener(listener: (toggleIconView: ToggleIconView, isChecked: Boolean) -> Unit) {
        onCheckedChangeListener = listener
    }
}