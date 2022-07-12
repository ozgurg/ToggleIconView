package og.android.lib.toggleiconview

import android.content.Context

class PlayPauseView : ToggleIconView {
    constructor(context: Context) : super(
        context,
        R.drawable.pause_to_play, R.drawable.play_to_pause
    )

    constructor(context: Context, attrs: android.util.AttributeSet) : super(
        context, attrs,
        R.drawable.pause_to_play, R.drawable.play_to_pause
    )

    constructor(context: Context, attrs: android.util.AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr,
        R.drawable.pause_to_play, R.drawable.play_to_pause
    )
}