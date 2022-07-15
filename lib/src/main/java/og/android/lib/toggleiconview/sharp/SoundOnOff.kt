package og.android.lib.toggleiconview.sharp

import android.content.Context
import android.util.AttributeSet
import og.android.lib.toggleiconview.R
import og.android.lib.toggleiconview.ToggleIconView

class SoundOnOff @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ToggleIconView(
        context, attrs, defStyleAttr,
        R.drawable.sharp_sound_on_to_off,
        R.drawable.sharp_sound_off_to_on
    )