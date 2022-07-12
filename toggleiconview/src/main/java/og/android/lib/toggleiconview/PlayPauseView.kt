package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet

class PlayPauseView : ToggleIconView {
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
        setCheckedDrawable(R.drawable.play_to_pause)
        setUncheckedDrawable(R.drawable.pause_to_play)
    }
}