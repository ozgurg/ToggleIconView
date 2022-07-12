package og.android.lib.toggleiconview

import android.content.Context

class MuteUnmuteView : ToggleIconView {
    constructor(context: Context) : super(
        context,
        R.drawable.mute_to_unmute, R.drawable.unmute_to_mute
    )

    constructor(context: Context, attrs: android.util.AttributeSet) : super(
        context, attrs,
        R.drawable.mute_to_unmute, R.drawable.unmute_to_mute
    )

    constructor(context: Context, attrs: android.util.AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr,
        R.drawable.mute_to_unmute, R.drawable.unmute_to_mute
    )
}