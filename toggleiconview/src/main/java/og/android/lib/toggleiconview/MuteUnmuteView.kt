package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet

class MuteUnmuteView : ToggleIconView {
    constructor(context: Context?) : super(context) {
        setDrawables()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setDrawables()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setDrawables()
    }

    private fun setDrawables() {
        setCheckedDrawable(R.drawable.unmute_to_mute)
        setUncheckedDrawable(R.drawable.mute_to_unmute)
    }
}