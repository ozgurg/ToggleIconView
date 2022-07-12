package og.android.lib.toggleiconview;

import android.content.Context;
import android.util.AttributeSet;

public class MuteUnmuteView extends ToggleIconView {
    public MuteUnmuteView(Context context) {
        super(context);
        setDrawables();
    }

    public MuteUnmuteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawables();
    }

    public MuteUnmuteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDrawables();
    }

    private void setDrawables() {
        setCheckedDrawable(R.drawable.unmute_to_mute);
        setUncheckedDrawable(R.drawable.mute_to_unmute);
    }
}