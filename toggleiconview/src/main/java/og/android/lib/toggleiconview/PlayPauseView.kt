package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet

class PlayPauseView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ToggleIconView(
        context, attrs,
        R.drawable.play_to_pause,
        R.drawable.pause_to_play
    )