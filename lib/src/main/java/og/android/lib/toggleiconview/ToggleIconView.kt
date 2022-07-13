package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

abstract class ToggleIconView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
    checkedDrawableRes: Int,
    uncheckedDrawableRes: Int,
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private var onCheckedChangeListener: ((toggleIconView: ToggleIconView, isChecked: Boolean) -> Unit)? =
        null

    private lateinit var checkedDrawable: AnimatedVectorDrawableCompat
    private lateinit var uncheckedDrawable: AnimatedVectorDrawableCompat

    private var isChecked = false

    init {
        setCheckedDrawable(checkedDrawableRes)
        setUncheckedDrawable(uncheckedDrawableRes)
        handleAttributes(attrs, defStyleAttr)
    }

    fun toggle() {
        setChecked(!isChecked)
    }

    fun isChecked(): Boolean {
        return isChecked
    }

    fun setChecked(checked: Boolean) {
        handleCheckState(checked)
        isChecked = checked

        onCheckedChangeListener?.invoke(this, checked)
    }

    private fun handleCheckedState() {
        setImageDrawable(checkedDrawable)
        checkedDrawable.start()
    }

    private fun handleUncheckedState() {
        setImageDrawable(uncheckedDrawable)
        uncheckedDrawable.start()
    }

    private fun handleCheckState(checked: Boolean) {
        if (checked) {
            handleCheckedState()
        } else {
            handleUncheckedState()
        }
    }

    private fun handleAttributes(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.ToggleIconView, defStyleAttr, 0)

        try {
            // app:checked
            val checked = typedArray.getBoolean(R.styleable.ToggleIconView_checked, isChecked)
            setChecked(checked)
        } finally {
            typedArray.recycle()
        }
    }

    private fun setCheckedDrawable(checkedDrawableRes: Int) {
        checkedDrawable = AnimatedVectorDrawableCompat.create(context, checkedDrawableRes)!!
    }

    private fun setUncheckedDrawable(uncheckedDrawableRes: Int) {
        uncheckedDrawable = AnimatedVectorDrawableCompat.create(context, uncheckedDrawableRes)!!
    }

    open fun setOnCheckedChangeListener(listener: (toggleIconView: ToggleIconView, isChecked: Boolean) -> Unit) {
        onCheckedChangeListener = listener
    }
}