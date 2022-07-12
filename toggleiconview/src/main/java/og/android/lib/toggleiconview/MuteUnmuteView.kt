package og.android.lib.toggleiconview

import android.content.Context
import android.util.AttributeSet

class MuteUnmuteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ToggleIconView(
        context, attrs, defStyleAttr,
        R.drawable.unmute_to_mute,
        R.drawable.mute_to_unmute
    )