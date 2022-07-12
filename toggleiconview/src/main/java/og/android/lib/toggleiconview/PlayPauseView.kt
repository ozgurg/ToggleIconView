package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet

class PlayPauseView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ToggleIconView(
        context, attrs, defStyleAttr,
        R.drawable.play_to_pause,
        R.drawable.pause_to_play
    )