package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

abstract class ToggleIconView : AppCompatImageView {
    private var checked: Boolean = false

    private lateinit var uncheckedDrawable: AnimatedVectorDrawableCompat
    private lateinit var checkedDrawable: AnimatedVectorDrawableCompat

    constructor(context: Context, uncheckedDrawableRes: Int, checkedDrawableRes: Int) : super(
        context
    ) {
        init(uncheckedDrawableRes, checkedDrawableRes)
    }

    constructor(
        context: Context,
        attrs: AttributeSet,
        uncheckedDrawableRes: Int,
        checkedDrawableRes: Int
    ) : super(context, attrs) {
        init(uncheckedDrawableRes, checkedDrawableRes)
    }

    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        uncheckedDrawableRes: Int,
        checkedDrawableRes: Int
    ) : super(context, attrs, defStyleAttr) {
        init(uncheckedDrawableRes, checkedDrawableRes)
    }

    private fun init(uncheckedDrawableRes: Int, checkedDrawableRes: Int) {
        uncheckedDrawable = AnimatedVectorDrawableCompat.create(context, uncheckedDrawableRes)!!
        checkedDrawable = AnimatedVectorDrawableCompat.create(context, checkedDrawableRes)!!
        toggleDrawable(checked)
    }

    private fun toggleDrawable(isChecked: Boolean) {
        if (isChecked) {
            handleCheckedState()
        } else {
            handleUncheckedState()
        }
    }

    private fun handleCheckedState() {
        setImageDrawable(checkedDrawable)
        checkedDrawable.start()
    }

    private fun handleUncheckedState() {
        setImageDrawable(uncheckedDrawable)
        uncheckedDrawable.start()
    }

    fun setChecked(isChecked: Boolean) {
        toggleDrawable(isChecked)
        checked = isChecked
    }

    fun toggle() {
        setChecked(!checked)
    }

    fun isChecked(): Boolean = checked
}