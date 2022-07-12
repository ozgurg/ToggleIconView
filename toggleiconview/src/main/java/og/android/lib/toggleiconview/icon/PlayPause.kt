package og.android.lib.toggleiconview.icon

import android.content.Context
import android.util.AttributeSet
import og.android.lib.toggleiconview.R
import og.android.lib.toggleiconview.ToggleIconView

class PlayPause @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ToggleIconView(
        context, attrs, defStyleAttr,
        R.drawable.play_to_pause,
        R.drawable.pause_to_play
    )