package og.android.lib.toggleiconview;

import android.content.Context;
import android.util.AttributeSet;

public class PlayPauseView extends ToggleIconView {
    public PlayPauseView(Context context) {
        super(context);
        setDrawables();
    }

    public PlayPauseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawables();
    }

    public PlayPauseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDrawables();
    }

    private void setDrawables() {
        setCheckedDrawable(R.drawable.play_to_pause);
        setUncheckedDrawable(R.drawable.pause_to_play);
    }
}