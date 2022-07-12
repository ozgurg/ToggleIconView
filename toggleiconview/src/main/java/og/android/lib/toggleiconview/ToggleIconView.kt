package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

abstract class ToggleIconView : AppCompatImageView {
    private var checkedDrawable: AnimatedVectorDrawableCompat? = null
    private var uncheckedDrawable: AnimatedVectorDrawableCompat? = null
    private var isChecked = false

    constructor(context: Context?) : super(context!!, null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    )

    fun toggle() {
        setChecked(!isChecked)
    }

    fun isChecked(): Boolean {
        return isChecked
    }

    fun setChecked(checked: Boolean) {
        setDrawable(checked)
        isChecked = checked
    }

    private fun handleCheckedState() {
        setImageDrawable(checkedDrawable)
        checkedDrawable!!.start()
    }

    private fun handleUncheckedState() {
        setImageDrawable(uncheckedDrawable)
        uncheckedDrawable!!.start()
    }

    private fun setDrawable(isChecked: Boolean) {
        if (isChecked) {
            handleCheckedState()
        } else {
            handleUncheckedState()
        }
    }

    protected fun setCheckedDrawable(checkedDrawableRes: Int) {
        checkedDrawable = AnimatedVectorDrawableCompat.create(context, checkedDrawableRes)
        setImageDrawable(checkedDrawable)
    }

    protected fun setUncheckedDrawable(uncheckedDrawableRes: Int) {
        uncheckedDrawable = AnimatedVectorDrawableCompat.create(context, uncheckedDrawableRes)
    }
}