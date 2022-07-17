package og.android.sample.toggleiconview

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import og.android.lib.toggleiconview.ToggleIconView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDemo()
    }

    private fun initDemo() {
        val toggleIconViews = arrayListOf<ToggleIconView>()

        // Yeah, looks fragile but we're in the demo
        val depth0 = findViewById<LinearLayout>(R.id.root)
        for (i0 in 0 until depth0.childCount) {
            val depth1 = depth0.getChildAt(i0)
            if (depth1 !is LinearLayout) continue

            for (i1 in 0 until depth1.childCount) {
                val depth2 = depth1.getChildAt(i1)
                if (depth2 !is LinearLayout) continue

                for (i2 in 0 until depth2.childCount) {
                    val depth3 = depth2.getChildAt(i2)
                    if (depth3 !is LinearLayout) continue

                    for (i3 in 0 until depth3.childCount) {
                        val depth4 = depth3.getChildAt(i3)
                        if (depth4 !is ToggleIconView) continue

                        // We finally found ToggleIconView! (https://youtu.be/f_EiqPp-vBM)
                        toggleIconViews.add(depth4)
                    }
                }
            }
        }

        toggleIconViews.forEach { toggleIconView ->
            toggleIconView.setOnClickListener {
                toggleIconView.toggle()
            }

            toggleIconView.setOnCheckedChangeListener { view: ToggleIconView, _: Boolean ->
                val value = "[${view::class.qualifiedName.toString()}:onCheckedChanged] isChecked: ${toggleIconView.isChecked()}"
                Log.d("TOGGLEICONVIEW_SAMPLE", value)
            }
        }
    }
}